package org.starmod.api.entity;

import com.flowpowered.math.vector.Vector3f;
import org.starmod.api.world.Location;

/**
 * Represents a in-game entity
 */
public interface Entity {

	/**
	 * Gets the name of the entity
	 *
	 * @return name of entity
	 */
	public String getName();

	/**
	 * Sets a new name for the entity
	 *
	 * @param name the new name
	 */
	public void setName(String name);

	/**
	 * Gets the current location of the entity
	 *
	 * @return entity's location
	 */
	public Location getLocation();

	/**
	 * Sets a new location of the entity
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location);

	/**
	 * Returns the current rotation of the entity.
	 *
	 * @return the current rotation
	 */
	public Vector3f getRotation();

	/**
	 * Sets a new rotation of the entity
	 *
	 * @param rotation the new rotation
	 */
	public void setRotation(Vector3f rotation);

	/**
	 * Gets the currently targeted entity, otherwise null
	 * 
	 * @return targeted entity
	 */
	public Entity getTarget();
	
}
