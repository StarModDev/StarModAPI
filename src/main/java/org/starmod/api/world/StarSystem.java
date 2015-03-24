package org.starmod.api.world;

import com.flowpowered.math.vector.Vector3i;

/**
 * A StarMade star system
 */
public interface StarSystem {

    /**
     * Gets the identifier of the star system
     *
     * @return the star system ID
     */
    public int getId();

    /**
     * Gets the location of the star system
     *
     * @return the location of the star system
     */
    public Vector3i getLocation();

}
