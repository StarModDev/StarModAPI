package org.starmod.api.world;

public class Sector {

	private StarSystem system;
	private int x, y, z;

	/**
	 * Constructs a sector with given coordinates
	 * @param system StarSystem the sector is in
	 * @param x x-coordinate of the sector
	 * @param y x-coordinate of the sector
	 * @param z x-coordinate of the sector
	 */
	public Sector(StarSystem system, int x, int y, int z) {
		this.system = system;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Gets the star system the sector is in
	 * @return sector's parent star system
	 */
	public StarSystem getSystem() {
		return system;
	}

	/**
	 * Sets the star system the sector is in
	 * @param system sector's parent star system
	 */
	public void setSystem(StarSystem system) {
		this.system = system;
	}

	/**
	 * Gets the x-coordinate of this sector
	 * @return sector's x-coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate of this sector
	 * @param x sector's new x-coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y-coordinate of this sector
	 * @return sector's y-coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y-coordinate of this sector
	 * @param y sector's new y-coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the z-coordinate of this sector
	 * @return sector's z-coordinate
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Sets the z-coordinate of this sector
	 * @param z sector's new z-coordinate
	 */
	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Sector{" +
			"system=" + system +
			", x=" + x +
			", y=" + y +
			", z=" + z +
			'}';
	}

}
