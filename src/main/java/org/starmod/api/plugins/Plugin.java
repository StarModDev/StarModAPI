package org.starmod.api.plugins;

import java.io.File;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.starmod.api.event.EventHandler;
import org.starmod.api.event.EventManager;
import org.starmod.api.event.EventRegister;

public abstract class Plugin {

	private final Set<EventRegister> registeredEvents = new ConcurrentSkipListSet<EventRegister>();
	private String pluginName;
	private File pluginsFolder;

	/**
	 * Fired when this {@link Plugin} is loaded by the server.
	 */
	public abstract void onEnabled();

	/**
	 * Fired when this {@link Plugin} is unloaded by the server.
	 * All of your {@link EventHandler}s will have already been unregistered
	 */
	public abstract void onDisabled();

	/**
	 * Run any "secret" code here that needs to happen before a plugin is enabled
	 */
	protected final void helpEnable(String pluginName, File pluginsFolder) {

		this.pluginName = pluginName;
		this.pluginsFolder = pluginsFolder;

		onEnabled();
	}

	/**
	 * Run any "secret" code here that needs to happen before a plugin is disabled
	 */
	protected final void helpDisable() {

		unregisterEvents();
		onDisabled();
	}

	/**
	 * Register an event listener for this plugin
	 * @param eventListener - The object that contains {@link EventHandler}
	 */
	public synchronized void registerEvent(Object eventListener) {

		registeredEvents.addAll(EventManager.register(eventListener));
	}

	/**
	 * Unregister all of the events linked to this plugin
	 */
	public synchronized void unregisterEvents() {

		EventManager.unregister(registeredEvents);
		registeredEvents.clear();
	}

	/**
	 * Get the name of this {@link Plugin}
	 * @return
	 */
	public String getPluginName() {

		return pluginName;
	}

	/**
	 * Get a directory for this {@link Plugin} to store files in.
	 * Recommended for configs and simple flat files
	 * @return
	 */
	public File getDataDir() {

		File dataDir = new File(getPluginsFolder(), getPluginName());
		if (!dataDir.exists()) {
			dataDir.mkdirs();
		}
		return dataDir;
	}

	/**
	 * Get the directory where all {@link Plugin} jar files are stored
	 * @return
	 */
	public File getPluginsFolder() {

		return pluginsFolder;
	}
}
