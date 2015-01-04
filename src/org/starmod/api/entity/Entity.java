package org.starmod.api.entity;

import org.starmod.api.world.Location;

/**
 * Represents a in-game entity
 */
public interface Entity {

	/**
	 * Gets the name of the entity
	 * @return name of entity
	 */
	public String getName();

	/**
	 * Gets the current location of the entity
	 * @return entity's location
	 */
	public Location getLocation();
	
}
