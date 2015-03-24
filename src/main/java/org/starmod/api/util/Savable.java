package org.starmod.api.util;

import com.flowpowered.nbt.CompoundTag;

/**
 * An object that can be saved to an NBT tag
 */
public interface Savable {

    /**
     * Save the objects data to a tag.
     *
     * @param tag the tag to save data to
     */
    public void save(CompoundTag tag);

    /**
     * Read the data from a tag
     *
     * @param tag the tag to load data from
     */
    public void load(CompoundTag tag);

}
