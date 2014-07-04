package com.gravypod.starmadeapi.world;

public class Location {
	private static final String RELATIVE_FORMAT = "(%d, %d, %d)";
	private Sector sector;
	private double relativeX, relativeY, relativeZ;

	public Location(int rX, int rY, int rZ) {
		this((double) rX, (double) rY, (double) rZ);
	}

	public Location(double rX, double rY, double rZ) {
		this(new Sector(), rX, rY, rZ);
	}

	public Location(Sector sector, double rX, double rY, double rZ) {
		this.sector = sector;
		this.relativeX = rX;
		this.relativeY = rY;
		this.relativeZ = rZ;
	}

	public double getRelativeX() {
		return relativeX;
	}

	public void setRelativeX(double relativeX) {
		this.relativeX = relativeX;
	}

	public double getRelativeY() {
		return relativeY;
	}

	public void setRelativeY(double relativeY) {
		this.relativeY = relativeY;
	}

	public double getRelativeZ() {
		return relativeZ;
	}

	public void setRelativeZ(double relativeZ) {
		this.relativeZ = relativeZ;
	}

	public Sector getSector() {
		return sector;
	}

	@Override
	public String toString() {
		return getSector().toString() + " @ " + String.format(RELATIVE_FORMAT, getRelativeX(), getRelativeY(), getRelativeZ());
	}
}
