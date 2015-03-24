package org.starmod.api.world;

import com.flowpowered.math.vector.Vector3i;
import org.starmod.api.entity.Player;
import org.starmod.api.util.Identifiable;

/**
 * A StarMade universe
 */
public interface Universe extends Identifiable {

    /**
     * Gets the seed used to generate game objects
     *
     * @return seed used to generate
     */
    public long getSeed();

    /**
     * Gets the online players in the Universe
     *
     * @return a set of players currently in the Universe
     */
    public Iterable<Player> getPlayers();

    /**
     * Gets the loaded galaxy at the given location
     *
     * @param location the location of the galaxy
     * @return the galaxy, if loaded, otherwise null
     */
    public Galaxy getGalaxy(Vector3i location);

    /**
     * Returns a Collection of all loaded galaxies
     *
     * @return the loaded galaxies
     */
    public Iterable<Galaxy> getGalaxies();

    /**
     * Gets the loaded star system at the given location
     *
     * @param location the location of the star system
     * @return the star system, if loaded, otherwise null
     */
    public StarSystem getStarSystem(Vector3i location);

    /**
     * Returns a Collection of all loaded star systems
     *
     * @return the loaded star systems
     */
    public Iterable<StarSystem> getStarSystems();

    /**
     * Returns the sector by it's ID
     *
     * @param id id of the sector
     * @return the sector if found, otherwise null
     */
    public Sector getSector(int id);

    /**
     * Gets the loaded sector at the given location
     *
     * @param location the location of the sector
     * @return the sector, if loaded, otherwise null
     */
    public Sector getSector(Vector3i location);

    /**
     * Returns a Collection of all loaded sectors
     *
     * @return the loaded sectors
     */
    public Iterable<Sector> getSectors();

    /**
     * Returns whether the sector is currently loaded
     *
     * @param sector sector to check
     * @return true, if the sector is loaded
     */
    public boolean isSectorLoaded(Sector sector);

    /**
     * Returns whether the sector is currently active with players
     *
     * @param sector sector to check
     * @return true, if the sector is active
     */
    public boolean isSectorActive(Sector sector);

    /**
     * Load a sector based from a location or if
     * {@code generate} is true then then sector is generated
     *
     * @param location the location of the sector to load
     * @param generate True to generate a new sector
     * @return the loaded sector
     */
    public Sector loadSector(Vector3i location, boolean generate);

    /**
     * Unload the given sector. Returns whether the unload was
     * successful
     *
     * @param sector the sector to unload
     * @return true, if the unload was successful
     */
    public boolean unloadSector(Sector sector);

}
