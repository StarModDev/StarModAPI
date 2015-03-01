package org.starmod.api.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allow methods to handle events
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface EventHandler {

	/**
	 * Handle events that have been canceled already.
	 * True means that this event handler WILL recive them
	 */
	boolean onCanceled() default true;

	/**
	 * What priority of execution should this event handler have?
	 *
	 * <pre>
	 * MONITOR - Do not cancel on monitor. This handler is for OBSERVATIONS only
	 * LOW - Happens before MONITOR. Use this if you do not plan to cancel events.
	 * NORMAL - Happens at a normal time after HIGH and before LOW
	 * HIGH - Happens first
	 * </pre>
	 *
	 *
	 *
	 */
	EventPriority priority() default EventPriority.NORMAL;

}
