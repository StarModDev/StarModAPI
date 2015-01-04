package org.starmod.api.world;

/**
 * Represents a 3-dimensional position in a sector
 */
public class Location {

	private Sector sector;
	private float x, y, z, pitch, yaw;

	/**
	 * Constructs a location with given coordinates
	 * @param sector the world in which the location is in
	 * @param x x-coordinate of the new location
	 * @param y x-coordinate of the new location
	 * @param z x-coordinate of the new location
	 */
	public Location(Sector sector, float x, float y, float z) {
		this(sector, x, y, z, 0, 0);
	}

	/**
	 * Constructs a location with given coordinates and direction
	 * @param sector the world in which the location is in
	 * @param x x-coordinate of the new location
	 * @param y x-coordinate of the new location
	 * @param z x-coordinate of the new location
	 * @param pitch rotation on the x-axis of the new location, in degrees
	 * @param yaw rotation on the y-axis of the new location, in degrees
	 */
	public Location(Sector sector, float x, float y, float z, float pitch, float yaw) {
		this.sector = sector;
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.yaw = yaw;
	}

	/**
	 * Get the sector that the location is in
	 * @return sector that contains this location
	 */
	public Sector getSector() {
		return sector;
	}

	/**
	 * Sets the sector that the location is in
	 * @param sector to move location to
	 */
	public void setSector(Sector sector) {
		this.sector = sector;
	}

	/**
	 * Gets the x-coordinate of this location
	 * @return location's x-coordinate
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate of this location
	 * @param x new x-coordinate
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Gets the y-coordinate of this location
	 * @return location's x-coordinate
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the z-coordinate of this location
	 * @param y new x-coordinate
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Gets the z-coordinate of this location
	 * @return location's x-coordinate
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Sets the z-coordinate of this location
	 * @param z new x-coordinate
	 */
	public void setZ(float z) {
		this.z = z;
	}

	/**
	 * Get the pitch of the location in degrees
	 * @return degree of pitch
	 */
	public float getPitch() {
		return pitch;
	}

	/**
	 * Sets the pitch of the location in degrees
	 * @param pitch new pitch
	 */
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	/**
	 * Get the yaw of the location in degrees
	 * @return degree of yaw
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * Sets the yaw of the location in degrees
	 * @param yaw new yaw
	 */
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	@Override
	public String toString() {
		return "Location{" +
			"sector=" + sector +
			", x=" + x +
			", y=" + y +
			", z=" + z +
			", pitch=" + pitch +
			", yaw=" + yaw +
			'}';
	}

}
