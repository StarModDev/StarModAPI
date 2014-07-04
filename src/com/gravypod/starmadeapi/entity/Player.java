package com.gravypod.starmadeapi.entity;

import java.util.concurrent.atomic.AtomicBoolean;

import com.gravypod.starmadeapi.network.NetworkManager;
import com.gravypod.starmadeapi.network.StarmadePacket;



public abstract class Player extends Entity {
	
	
	/**
	 * Get the maximum distance the player can see entities from.
	 * @return {@link Integer} defining how far the objects need to be before they fall out of view distance.
	 */
	public abstract int getMaxView();
	
	/**
	 * Get the {@link NetworkManager} that drives this client.
	 * @return
	 */
	public abstract NetworkManager getNetworkManager();
	
	/**
	 * Handle a packet that has been sent by the client.
	 * @param packet
	 */
	public abstract void handlePacket(StarmadePacket packet);

	public AtomicBoolean isConnected() {
		return getNetworkManager().isConnected();
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}
