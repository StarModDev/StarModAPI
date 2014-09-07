package com.starmod.api.plugins;

import java.io.File;
import java.io.FilenameFilter;


public class PluginFileNameFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".jar");
	}

}
