package com.gravypod.starmadeapi.world;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;

import com.gravypod.starmadeapi.entity.Player;

public class Universe {
	
	private final AtomicBoolean running = new AtomicBoolean(true);
	
	private final List<Player> players;
	
	private final Logger logger;
	
	public Universe(Logger logger, int maxPlayers) {
		this.players = new ArrayList<Player>(maxPlayers);
		this.logger = logger;
	}

	public Player getPlayer(String name) {
		return getPlayer(p -> p.getName().equalsIgnoreCase(name));
	}

	public Player getPlayer(Predicate<? super Player> consumer) {
		return players.parallelStream().filter(consumer).findFirst().get();
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void broadcastMessage(String message) {
		broadcast(p -> p.getNetworkManager().sendMessage(message));
	}

	/**
	 * Broadcast information to the server.
	 * @param consumer
	 */
	public void broadcast(Consumer<? super Player> consumer) {
		players.parallelStream().forEach(consumer);
	}

	/**
	 * Send a message to players on the server
	 * @param sender - {@link Player} who sent the message
	 * @param message - Message the {@link Player} sent.
	 */
	public void sendMessage(Player sender, String message) {
		send(sender, p -> p.getNetworkManager().sendMessage(sender, message));
	}

	/**
	 * 
	 * Send all the players on the server except the sender something.
	 * 
	 * Consumer should look as follows
	 * 
	 * <pre>
	 * <code>p -> p.some().method().calls()</code>
	 * </pre>
	 * 
	 * @param sender
	 *            - {@link Player} who is sending data
	 * @param consumer
	 *            - {@link Consumer} that will send data to players
	 * 
	 */
	public void send(Player sender, Consumer<? super Player> consumer) {
		players.parallelStream().filter(p -> !p.equals(sender)).forEach(consumer);
	}

	public AtomicBoolean getRunning() {
		return running;
	}
	
	public Logger getLogger() {
		return logger;
	}
	
}
