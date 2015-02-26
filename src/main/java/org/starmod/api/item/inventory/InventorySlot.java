package org.starmod.api.item.inventory;

import org.starmod.api.item.ItemType;

/**
 * Represents a slot in an {@link org.starmod.api.item.inventory.Inventory}.
 */
public interface InventorySlot {

	/**
	 * Returns the index of this slot in an {@link org.starmod.api.item.inventory.Inventory}.
	 *
	 * @return the index of this slot
	 */
	int getIndex();

	/**
	 * Sets the index of this slot in an {@link org.starmod.api.item.inventory.Inventory}.
	 *
	 * @param i index of this slot
	 */
	void setIndex(int i);

	/**
	 * Returns the item type at this slot.
	 *
	 * @return the item type at this slot
	 */
	ItemType getItem();

	/**
	 * Returns the amount of items at this slot.
	 *
	 * @return amount of items
	 */
	int getQuantity();

	/**
	 * Sets the amount of items at this slot.
	 *
	 * @param quantity quantity of items
	 */
	void setQuantity(int quantity);

	/**
	 * Returns the maximum amount of items at this slot.
	 *
	 * @return the maximum allowed quantity of items
	 */
	int getMaxQuantity();

	/**
	 * Sets the maximum amount of items that can be in this slot
	 *
 	 * @param maxQuantity the maximum amount of items
	 */
	void setMaxQuantity(int maxQuantity);
}
