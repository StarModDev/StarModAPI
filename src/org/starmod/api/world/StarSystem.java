package org.starmod.api.world;

public class StarSystem {

	private int x, y, z;

	/**
	 * Constructs a star system with given coordinates
	 * @param x x-coordinate of the star system
	 * @param y x-coordinate of the star system
	 * @param z x-coordinate of the star system
	 */
	public StarSystem(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Gets the x-coordinate of this star system
	 * @return star system's x-coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate of this star system
	 * @param x star system's new x-coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y-coordinate of this star system
	 * @return star system's y-coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y-coordinate of this star system
	 * @param y star system's new y-coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the z-coordinate of this star system
	 * @return star system's z-coordinate
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Sets the z-coordinate of this star system
	 * @param z star system's new z-coordinate
	 */
	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "StarSystem{" +
			"x=" + x +
			", y=" + y +
			", z=" + z +
			'}';
	}

}
