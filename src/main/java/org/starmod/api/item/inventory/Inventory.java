package org.starmod.api.item.inventory;

import org.starmod.api.item.ItemType;
import org.starmod.api.util.Identifiable;

public interface Inventory extends Identifiable {

	/**
	 * Clears an entire inventory.
	 */
	void clear();

	/**
	 * Clears a slot at an index
	 *
	 * @param index index of the slot to clear
	 */
	void clear(int index);

	/**
	 * Checks if the inventory contains the given item type.
	 *
	 * @param itemType type of item to check
	 * @return true if inventory contains item type
	 */
	boolean contains(ItemType itemType);

	/**
	 * Returns the slot corresponding with the given index.
	 *
	 * @param index index of the slot
	 * @return the object at that slot, null if unpopulated
	 */
	InventorySlot get(int index);

	/**
	 * Returns the amount of slots in the inventory.
	 *
	 * @return the amount of slots in inventory
	 */
	int size();

	/**
	 * Returns an array of all the slots in the inventory.
	 *
	 * @return an array of slots
	 */
	InventorySlot[] slots();

}
