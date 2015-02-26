package org.starmod.api;

import org.starmod.api.entity.Player;
import org.starmod.api.util.Identifiable;

/**
 * Represents a Player, online or offline
 */
public interface Client extends Identifiable {

	/**
	 * Gets the name of the player in-game, or if online last known name
	 * @return current name of player, or last known name
	 */
	String getName();

	/**
	 * Gets the amount of credits the Player has
	 * @return amount of credits
	 */
	int getCredits();

	/**
	 * Gets the UNIX timestamp of the first time the player logged in
	 * @return timestamp of first log in, otherwise 0
	 */
	long getFirstPlayed();

	/**
	 * Gets the UNIX timestamp of the last time the player logged in
	 * @return timestamp of last login
	 */
	long getLastOnline();

	/**
	 * Gets whether the player is online, or not
	 * @return true if player is online
	 */
	boolean isOnline();

	/**
	 * Gets the object of the online player, if offline null
	 * @return player object, otherwise null
	 */
	Player getPlayer();

}
