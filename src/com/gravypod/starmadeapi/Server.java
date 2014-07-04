package com.gravypod.starmadeapi;

import java.net.InetSocketAddress;

import com.gravypod.starmadeapi.world.Universe;

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
