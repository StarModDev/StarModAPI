package org.starmod.api.world;

import com.flowpowered.math.vector.Vector3i;

/**
 * A sector contained in a {@link StarSystem}
 */
public interface Sector {

    /**
     * Gets the identifier of the sector
     *
     * @return the sector ID
     */
    public int getId();

	/**
	 * Gets the star system the sector is in
     * 
	 * @return sector's parent star system
	 */
	public StarSystem getSystem();

    /**
     * Gets the location within a star system
     *
     * @return the location of the sector in a star system
     */
	public Vector3i getLocation();

    /**
     * Returns whether the sector is currently loaded.
     *
     * @return true, if the sector is loaded
     */
    public boolean isLoaded();

    /**
     * Returns whether the sector is active with players
     *
     * @return true, if active with players
     */
    public boolean isActive();

    /**
     * Load this sector, if true is passed a new sector will be generated
     *
     * @param generate whether or not to generate a new sector
     * @return true, if the sector was loaded successfully
     */
    public boolean load(boolean generate);

    /**
     * Unloads this sector
     *
     * @return true, if the sector was successfully unloaded
     */
    public boolean unload();

}
