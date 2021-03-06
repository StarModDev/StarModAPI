package org.starmod.api;

import org.starmod.api.entity.Player;

import java.net.InetSocketAddress;
import java.util.List;

public interface Server {

	/**
	 * Gets an array of all the online players
	 * @return array of online players
	 */
	public List<Player> getPlayers();

	/**
	 * Get the address the server is running on
	 * @return socket address server is bound to
	 */
	public InetSocketAddress getAddress();

	/**
	 * Sends a message as the server with the prefix [SERVER]
	 * @param message to be sent to all clients
	 */
	public void sendServerMessage(String message);

	/**
	 * Gracefully shutdown down the server and the network server
	 */
	public void shutdown();
	
}
