package org.starmod.api.plugins;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginManager {

	private final File pluginFolder;

	private final Map<String, Plugin> plugins = new ConcurrentHashMap<String, Plugin>();

	private final Map<File, Properties> pluginPropCache = new ConcurrentHashMap<File, Properties>();

	private final PluginClassLoader classLoader = new PluginClassLoader();

	private final Comparator<File> pluginDependancy = new Comparator<File>() {

		@Override
		public int compare(File plugin1, File plugin2) {

			Properties p1, p2;
			try {
				p1 = getPluginProp(plugin1);
				p2 = getPluginProp(plugin2);
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
			String depends1 = p1.getProperty("depends"); // The dependency tree of plugin 1
			String depends2 = p2.getProperty("depends"); // The dependency tree of plugin 2
			String name1 = p1.getProperty("name"); // The name of plugin 1
			String name2 = p2.getProperty("name"); // The name of plugin 2

			if (depends1 != null) {
				return depends1.contains(name2) ? 1 : -1;
			} else if (depends2 != null) {
				return depends2.contains(name1) ? 1 : -1;
			} else {
				return name1.compareTo(name2);
			}
		}

	};

	public PluginManager(File pluginFolder) {

		this.pluginFolder = pluginFolder;
	}

	private Properties getPluginProp(File pluginFile) throws IOException {

		if (pluginPropCache.containsKey(pluginFile)) {
			return pluginPropCache.get(pluginFile);
		}

		JarFile jarFile = new JarFile(pluginFile);
		JarEntry jarEntry = jarFile.getJarEntry("plugin.prop"); // Find the plugin.prop file
		Properties prop = new Properties();

		prop.load(jarFile.getInputStream(jarEntry));
		jarFile.close();
		pluginPropCache.put(pluginFile, prop);

		return prop;
	}

	public synchronized void enable() {

		if (!pluginFolder.exists()) {
			pluginFolder.mkdirs();
			return;
		}

		if (!pluginFolder.canRead() || !pluginFolder.canWrite()) {
			throw new IllegalStateException("Error! Do not have permissions for the plugins folder. Please check file permissions!");
		}

		File[] plguinFiles = pluginFolder.listFiles(new PluginFileNameFilter());

		Arrays.sort(plguinFiles, pluginDependancy); // Make sure the high priority plugins are loaded first so dependencies will work

		for (File pluginFile : plguinFiles) {

			Properties prop;
			
			try {
				prop = getPluginProp(pluginFile);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Could not open " + pluginFile);
				continue;
			}

			String main = prop.getProperty("main");

			String name = prop.getProperty("name");

			if (main.isEmpty() || name.isEmpty()) {
				throw new IllegalStateException("Your plugin did not contain a name or a main in plugin.prop");
			}

			URL url;

			try {
				url = pluginFile.toURI().toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("Could not create a URL for " + pluginFile);
				continue;
			}

			classLoader.addURL(url);

			Class<?> jarClass;
			
			try {
				jarClass = Class.forName(main, true, classLoader);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Could not find the main class of " + pluginFile);
				continue;
			}

			Class<? extends Plugin> plugin = jarClass.asSubclass(Plugin.class);

			Constructor<? extends Plugin> constructor;
			
			try {
				constructor = plugin.getConstructor();
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				System.out.println("Could not find a constructor of " + pluginFile);
				continue;
			}

			Plugin result;
			
			try {
				result = constructor.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Could not create a new instance of " + pluginFile);
				continue;
			}
			
			result.helpEnable(name, pluginFolder);

			plugins.put(name, result);

		}

	}

	public synchronized void disable() {

		for (String name : plugins.keySet()) {
			plugins.remove(name).helpDisable();
		}
	}

	public synchronized File getPluginFolder() {

		return pluginFolder;
	}

	/**
	 * Returns the requested plugin or null if it could not be found
	 * @param name
	 * @return
	 */
	public synchronized Plugin getPlugin(String name) {

		return plugins.get(name);
	}

}
