package org.starmod.api.world;

import com.flowpowered.math.vector.Vector3i;
import org.starmod.api.util.Identifiable;

/**
 * A StarMade star system
 */
public interface StarSystem extends Identifiable {

    /**
     * Gets the location of the star system
     *
     * @return the location of the star system
     */
    public Vector3i getLocation();

}
