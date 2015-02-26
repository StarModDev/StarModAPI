package org.starmod.api.util;

import java.util.UUID;

public interface Identifiable {

	/**
	 * Gets the unique identifier of the object.
	 *
	 * @return unique identifier
	 */
	public UUID getUniqueId();

}
