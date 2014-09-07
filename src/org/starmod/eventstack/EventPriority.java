package org.starmod.eventstack;

/**
 * The priority of execution of any given {@link EventHandler}
 *
 */
public enum EventPriority implements Comparable<EventPriority> {
	/**
	 * The fist to receive events. Will likely be called the most
	 */
	HIGH,
	/**
	 * The normal {@link EventPriority} that should be used by default
	 */
	NORMAL,
	/**
	 * The last {@link EventPriority} that you are allowed to cancel the {@link Event}s from
	 */
	LOW,
	/**
	 * Used to monitor the state of {@link Event}s
	 */
	MONITOR;
}
