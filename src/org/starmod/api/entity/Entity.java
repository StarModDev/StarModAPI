package org.starmod.api.entity;

import java.util.UUID;

import org.starmod.api.world.Location;
import org.starmod.api.world.Universe;

public abstract class Entity {

	public abstract UUID getUUID();
	
	public abstract String getName();
	
	public abstract Location getLocation();
	
	public abstract Universe getUniverse();
	
}
