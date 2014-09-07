package org.starmod.eventstack;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Manages a collection of {@link EventRegister}s and forwards {@link Event}s to them.
 *
 */
public class HandlerList extends ReentrantReadWriteLock {

	private static final long serialVersionUID = 1221403070683890849L;
	private final Set<EventRegister> handlers = new TreeSet<EventRegister>();
	
	/**
	 * Register an {@link EventRegister} with this {@link HandlerList}
	 * @param register
	 */
	public void register(EventRegister register) {

		writeLock().lock();
		handlers.add(register);
		writeLock().lock();
	}

	/**
	 * Fire the {@link EventRegister}s in the {@link EventHandler}
	 * @param event
	 */
	public void fire(Event event) {

		readLock().lock();
		for (EventRegister register : handlers) {
			boolean isCanceled = event.isCanceled();
			register.fire(event);
			
			if (isCanceled != event.isCanceled() && register.getPriority() == EventPriority.MONITOR) {
				throw new IllegalStateException("Error! EventRegister " + register + " canceled an event on EventPriority.MONITOR.");
			}
			
		}
		readLock().unlock();
	}

	/**
	 * Unregister the {@link EventRegister} from this {@link EventHandler}
	 * @param register
	 */
	public void unregister(EventRegister register) {

		writeLock().lock();
		handlers.remove(register);
		writeLock().unlock();
	}

	/**
	 * Is the {@link HandlerList} empty?
	 * @return
	 */
	public boolean isEmpty() {

		readLock().lock();
		boolean empty = handlers.isEmpty();
		readLock().unlock();

		return empty;
	}

}
