package com.starmod.api.plugins;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {

	public PluginClassLoader() {

		super(new URL[0], PluginClassLoader.class.getClassLoader()); // Use the main class loader as the parrent
	}

	@Override
	public void addURL(URL url) { // Allow anyone to load this URLs into the class loader

		super.addURL(url);
	}
}
