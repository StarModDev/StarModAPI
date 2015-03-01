package org.starmod.api.world;

/**
 * Represents a Galaxy, which contains {@link org.starmod.api.world.Sector}s
 */
public interface Galaxy {

	/**
	 * Size of galaxy in sectors.
	 */
	public static final int SIZE = 128;

	/**
	 * Gets the seed used to generate this Galaxy.
	 *
	 * @return the seed used to generate
	 */
	public long getSeed();

	/**
	 * Gets the {@link org.starmod.api.world.Sector} at the given coordinates.
	 *
	 * @param x x-coordinate of the sector
	 * @param y y-coordinate of the sector
	 * @param z z-coordinate of the sector
	 * @return the Sector at the given coordinates
	 */
	public Sector getSectorAt(int x, int y, int z);

}
