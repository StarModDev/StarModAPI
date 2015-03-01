package org.starmod.api.event;

/**
 * An event object is passed to {@link EventHandler}s whenever a corresponding action takes place
 *
 */
public abstract class Event {

	private boolean canceled = false;

	/**
	 * Has the event been canceled?
	 * @return True if it has
	 */
	public boolean isCanceled() {

		return canceled;
	}

	/**
	 * Cancel this event
	 */
	public void cancel() { 
		canceled = true; // Prevent people from re-activating an event 
	}

}
