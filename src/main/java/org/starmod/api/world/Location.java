package org.starmod.api.world;

import com.flowpowered.math.vector.Vector3f;

/**
 * Represents a 3-dimensional position in a sector
 */
public class Location extends Vector3f {

	private final Sector sector;
	private final Vector3f position;

	/**
	 * Constructs a location with given coordinates.
	 *
	 * @param sector the world in which the location is in
	 * @param x x-coordinate of the new location
	 * @param y x-coordinate of the new location
	 * @param z x-coordinate of the new location
	 */
	public Location(Sector sector, float x, float y, float z) {
		this(sector, new Vector3f(x, y, z));
	}

	/**
	 * Constructs a location with given coordinates and direction.
	 *
	 * @param sector the world in which the location is in
	 * @param position the vector position of the location
	 */
	public Location(Sector sector, Vector3f position) {
		this.sector = sector;
		this.position = position;
	}

	/**
	 * Get the sector that the location is in.
	 *
	 * @return sector that contains this location
	 */
	public Sector getSector() {
		return sector;
	}

	/**
	 * Create a new instance with a new sector.
	 *
	 * @param sector the new sector
	 * @return a new instance
	 */
	public Location setSector(Sector sector) {
		return new Location(sector, position);
	}

	/**
	 * Gets the x-coordinate of this location.
	 *
	 * @return location's x-coordinate
	 */
	public float getX() {
		return position.getX();
	}

	/**
	 * Create a new instance with a new x-coordinate.
	 *
	 * @param x the new x-coordinate
	 * @return a new instance
	 */
	public Location setX(float x) {
		return setPosition(new Vector3f(x, getY(), getZ()));
	}

	/**
	 * Gets the y-coordinate of this location.
	 *
	 * @return location's x-coordinate
	 */
	public float getY() {
		return position.getY();
	}

	/**
	 * Create a new instance with a new y-coordinate.
	 *
	 * @param y the new y-coordinate
	 * @return a new instance
	 */
	public Location setY(float y) {
		return setPosition(new Vector3f(getX(), y, getZ()));
	}

	/**
	 * Gets the z-coordinate of this location.
	 *
	 * @return location's x-coordinate
	 */
	public float getZ() {
		return position.getZ();
	}

	/**
	 * Create a new instance with a new z-coordinate.
	 *
	 * @param z the new z-coordinate
	 * @return a new instance
	 */
	public Location setZ(float z) {
		return setPosition(new Vector3f(getX(), getY(), z));
	}

	/**
	 * Returns the underlying vector position.
	 *
	 * @return the underlying vector
	 */
	public Vector3f getPosition() {
		return position;
	}

	/**
	 * Create a new instance with a new position.
	 * 
	 * @param position the new position
	 * @return a new instance
	 */
	public Location setPosition(Vector3f position) {
		if (this.position == position)
			return this;
		return new Location(sector, position);
	}

	@Override
	public String toString() {
		return "Location{" +
			"sector=" + sector +
			", position=" + position.toString() +
			'}';
	}

}
