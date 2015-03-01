package org.starmod.api.entity;

import org.starmod.api.Client;
import org.starmod.api.entity.living.Human;
import org.starmod.api.world.Location;

/**
 * Represents an online player entity
 */
public interface Player extends Human, Client {

	/**
	 * Gets the current spawn point of the player
	 *
	 * @return player's spawn point
	 */
	public Location getSpawnPoint();

	/**
	 * Sets the spawn point of the player
	 *
	 * @param spawnPoint new spawn point of the player
	 */
	public void setSpawnPoint(Location spawnPoint);

	/**
	 * Return the amount of latency in milliseconds.
	 *
	 * @return the ms of latency
	 */
	public int getPing();

	/**
	 * Returns whether the player is in god mode or not.
	 *
	 * @return true if the player is in god mode
	 */
	public boolean isGod();

	/**
	 * Sets the player's god mode status.
	 *
	 * @param god the new god mode status
	 */
	public void setGod(boolean god);
	
}
