package org.starmod.api.item;

public enum ItemType {
	; // TODO: Add item types

	private short typeId;

	private ItemType(short typeId) {
		this.typeId = typeId;
	}

	public short getTypeId() {
		return typeId;
	}
}
