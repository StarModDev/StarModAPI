package org.starmod.api.event;

import java.lang.reflect.Method;

/**
 * Allows an {@link EventHandler} to be invoked
 *
 */
public class EventRegister implements Comparable<EventRegister> {

	/**
	 * A {@link Method} that handles events
	 */
	private final Method method;

	/**
	 * The object that owns this {@link EventHandler}
	 */
	private final Object instance;

	/**
	 * Should we pass canceled events to this register?
	 */
	private final boolean onCanceld;

	/**
	 * The {@link EventPriority} of this {@link EventHandler}
	 */
	private final EventPriority priority;

	/**
	 * The {@link Event} that this {@link EventHandler} handles
	 */
	private final Class<? extends Event> handles;

	public EventRegister(Method method, Object instance, boolean onCancled, EventPriority priority, Class<? extends Event> handles) {

		this.method = method;
		this.instance = instance;
		this.onCanceld = onCancled;
		this.priority = priority;
		this.handles = handles;
	}

	public EventRegister(Method method, Object instance, EventHandler handler, Class<? extends Event> handles) {

		this(method, instance, handler.onCanceled(), handler.priority(), handles);
	}

	/**
	 * Pass the {@link Event} object to the {@link EventHandler} if it wants to accept it.
	 * 
	 * @param event
	 */
	public void fire(Event event) {

		if (event.isCanceled() && !onCanceld) {
			return;
		}

		try {
			method.invoke(instance, event);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object getInstance() {

		return instance;
	}

	public Method getMethod() {

		return method;
	}

	public EventPriority getPriority() {

		return priority;
	}

	public Class<? extends Event> getHandles() {

		return handles;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(getMethod()).append(" in ").append(getInstance().getClass().toString()).toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof EventRegister) {
			EventRegister register = (EventRegister) obj;
			return register.getPriority().equals(getPriority()) && register.getInstance().equals(getInstance()) && register.getMethod().equals(getMethod()); // If its from the same instance, and of the same method, its the same EventRegister
		}

		return super.equals(obj);
	}

	@Override
	public int compareTo(EventRegister o) {

		return priority.compareTo(o.priority); // Allow events to execute in order
	}

}
