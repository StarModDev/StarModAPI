package com.gravypod.starmadeapi.entity;

import java.util.UUID;

import com.gravypod.starmadeapi.world.Location;
import com.gravypod.starmadeapi.world.Universe;

public abstract class Entity {

	public abstract UUID getUUID();
	
	public abstract String getName();
	
	public abstract Location getLocation();
	
	public abstract Universe getUniverse();
	
}
