package org.starmod.api.world;

import com.flowpowered.math.vector.Vector3i;

/**
 * Represents a Galaxy, which contains {@link org.starmod.api.world.Sector}s
 */
public interface Galaxy {

	/**
	 * Size of galaxy in sectors.
	 */
	public static final int SIZE = 128;

    /**
     * Gets the identifier of the galaxy
     *
     * @return the galaxy ID
     */
    public int getId();

    /**
     * Gets the location of the galaxy
     *
     * @return the location of the galaxy
     */
    public Vector3i getLocation();

}
