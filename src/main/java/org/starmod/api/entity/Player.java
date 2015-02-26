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
	
}
