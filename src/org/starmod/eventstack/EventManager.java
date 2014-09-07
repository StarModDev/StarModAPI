package org.starmod.eventstack;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * EventManager handles unregistering, registering, and firing events.
 *
 */
public class EventManager {

	private static Map<Class<? extends Event>, HandlerList> eventListenrs;

	static {
		eventListenrs = new ConcurrentHashMap<Class<? extends Event>, HandlerList>(); // All the events we know about
	}

	private EventManager() {
		// No one can construct this, it is static
	}

	/**
	 * Fire an event. The {@link Event} object will be dispatched to all of the listening {@link EventHandler}s
	 * @param event
	 */
	public static void fire(Event event) {

		HandlerList list = eventListenrs.get(event.getClass());

		if (list == null) { // There are no listeners
			return;
		}

		list.fire(event);

	}

	/**
	 * Unregister a set of events.
	 * @param registers - {@link Set}<{@link EventRegister}> of registers you wish to remove
	 */
	public static void unregister(Set<EventRegister> registers) {

		for (EventRegister register : registers) {
			unregister(register);
		}
	}

	/**
	 * Unregister an event, this will remove its ability to receive events
	 * @param register
	 */
	public static void unregister(EventRegister register) {

		Class<? extends Event> event = register.getHandles();

		HandlerList list = eventListenrs.get(event);

		if (list == null) {
			return;
		}

		list.unregister(register);

		if (list.isEmpty()) { // Remove unneeded HandlerLists
			eventListenrs.remove(event);
		}
	}

	/**
	 * Register an event, allow it to start receiving {@link Event} objects
	 * @param instance - An instance of an object with {@link EventHandler}s
	 * @return - The {@link EventRegister}s created by this method. You need these to unregister the events.
	 */
	public static Set<EventRegister> register(Object instance) {

		Class<?> clazz = instance.getClass();

		Set<EventRegister> registers = new HashSet<EventRegister>();

		for (Method m : clazz.getMethods()) {

			if (!m.isAccessible()) { // Get access to the method
				m.setAccessible(true);
			}

			Class<?>[] arguments = m.getParameterTypes();
			EventHandler handler = m.getAnnotation(EventHandler.class);

			if (handler == null) { // If the handler is set to null, the annotation isn't present
				continue; // If this isn't executed, this /should/ be a valid event handler
			}

			if (arguments.length != 1) { // If there are more or less than 1 argument, its not an event
				throw new IllegalStateException("Event handler on method " + m + " has an incorrect number of paramaters");
			}

			if (arguments[0].isAssignableFrom(Event.class)) { // If the first argument isnt assignable from Event, its not an event
				throw new IllegalStateException("Paramater of " + m + " is not an event");
			}

			@SuppressWarnings("unchecked")
			// Checked above at "if (arguments[0].isAssignableFrom(Event.class))"
			Class<? extends Event> event = (Class<? extends Event>) arguments[0]; // The event we are going to listen to
			EventRegister register = new EventRegister(m, instance, handler, event); // The EventRegister object for this method

			if (!eventListenrs.containsKey(event)) { // Creates the HandlerList for this given event if there is none
				eventListenrs.put(event, new HandlerList());
			}

			eventListenrs.get(event).register(register);
			registers.add(register);

		}

		return registers;

	}
}
