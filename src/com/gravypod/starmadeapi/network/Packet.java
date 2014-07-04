package com.gravypod.starmadeapi.network;

public enum Packet {
	SERVER_INFO((byte) 42, (byte) 0, (byte) 111, Byte.TYPE, Float.TYPE, String.class, String.class, Long.TYPE, Integer.TYPE, Integer.TYPE)
	;
	private final byte type, commandId, commandType;
	private final Class<?>[] params;
	
	private Packet(byte type, byte commandID, byte commandType, Class<?> ... parameters) {
		this.type = type;
		this.commandId = commandID;
		this.commandType = commandType;
		this.params = parameters;
	}
	public StarmadePacket make(short order, Object ... params) throws IllegalArgumentException {
		if (!checkParams(params)) {
			throw new IllegalArgumentException("Incorrect paramaters passed to make for packet " + name());
		}
		
		
		
		return null;
	}
	
	private boolean checkParams(Object[] params) {
		if (params.length != this.params.length) {
			return false;
		}
		
		for (int i = 0; i < params.length; i++) {
			if (!params[i].getClass().equals(this.params[i])) {
				return false;
			}
		}
		return true;
	}
	
}
