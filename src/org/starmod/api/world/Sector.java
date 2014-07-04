package org.starmod.api.world;

public class Sector {

	private static final String SECTOR_FORMAT = "(%d, %d, %d)";
	private int x, y, z;

	public Sector() {
		this(2, 2, 2);
	}

	public Sector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return String.format(SECTOR_FORMAT, getX(), getY(), getZ());
	}
	
}
