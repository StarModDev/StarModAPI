package org.starmod.api.network;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

import org.starmod.api.entity.Entity;
import org.starmod.api.entity.Player;
import org.starmod.api.world.Universe;

/**
 * Created when a new socket is accepted into the network.
 */
public abstract class NetworkManager implements Runnable {

	private final AtomicBoolean connected = new AtomicBoolean(false);
	private final Socket socket;
	private final Universe universe;
	private Player player;

	public NetworkManager(Socket socket, Universe universe) {
		this.socket = socket;
		this.universe = universe;
	}

	@Override
	public void run() {
		Player p = onConnect(socket);

		if (p == null || !connected.get()) {
			return;
		}

		player = p;

		universe.addPlayer(getPlayer());

		while (connected.get()) {

			StarmadePacket packet;
			try {
				packet = readPacket();
			} catch (IOException e) {
				packet = null;
				universe.getLogger().log(Level.SEVERE, "Error reading packet from " + player.toString(), e);
			}

			if (packet == null) {
				continue;
			}

			getPlayer().handlePacket(packet);

		}

	}

	/**
	 * Read a {@link StarmadePacket} from the client.
	 * 
	 * @return
	 * @throws IOException
	 */
	public abstract StarmadePacket readPacket() throws IOException;

	/**
	 * Send a {@link StarmadePacket} to the client.
	 * 
	 * @param packet
	 */
	public abstract void sendPacket(StarmadePacket packet);

	/**
	 * Run when the {@link NetworkManager} is initialized.
	 * 
	 * @param connection
	 * @return
	 */
	public abstract Player onConnect(Socket connection);

	/**
	 * Add an {@link Entity} to the entity tracker of the {@link NetworkManager}
	 * , this will send possition updates to this entity.
	 */
	public abstract void track(Entity t);

	/**
	 * Send a message send by a player
	 */
	public abstract void sendMessage(Player sender, String message);

	/**
	 * Send a server message to a player.
	 */
	public abstract void sendMessage(String message);

	/**
	 * The socket the {@link NetworkManager} is connected to.
	 * 
	 * @return
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * Check if the player is connected.
	 * 
	 * @return
	 */
	public AtomicBoolean isConnected() {
		return connected;
	}

	/**
	 * Get the {@link Player} controlled by this {@link NetworkManager}
	 * 
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	public Universe getUniverse() {
		return universe;
	}

	public AtomicBoolean getConnected() {
		return connected;
	}

}
