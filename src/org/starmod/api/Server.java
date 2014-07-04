package org.starmod.api;

import java.net.InetSocketAddress;

import org.starmod.api.world.Universe;

public abstract class Server {
	
	/**
	 * Get the {@link Universe} for the server.
	 * @return
	 */
	public abstract Universe getUniverse();
	
	/**
	 * Get the address the server is running on.
	 * @return
	 */
	public abstract InetSocketAddress getServerAddress();
	
}
