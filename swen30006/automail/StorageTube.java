/*
 * Group number: 17
 * Daniel Porteous (696965), David Stern (585870), Hao Le (695540)
 */

package automail;

import exceptions.TubeFullException;

import java.util.Stack;

/**
 * The storage tube carried by the robot.
 */
public class StorageTube {

	// Public is okay here since this is a constant.
	public final int MAXIMUM_CAPACITY;
	private Stack<MailItem> tube;

	/**
	 * Constructor for the storage tube
	 */
	public StorageTube(int maximum_capacity) {
		this.tube = new Stack<MailItem>();
		this.MAXIMUM_CAPACITY = maximum_capacity;
	}

	/**
	 * @return if the storage tube is full
	 */
	public boolean isFull() {
		return tube.capacity() == MAXIMUM_CAPACITY;
	}

	/**
	 * @return if the storage tube is empty
	 */
	public boolean isEmpty() {
		return tube.isEmpty();
	}

	/**
	 * @return the first item in the storage tube (without removing it)
	 */
	public MailItem peek() {
		return tube.peek();
	}

	/**
	 * Add an item to the tube
	 * 
	 * @param item
	 *            The item being added
	 * @throws TubeFullException
	 *             thrown if an item is added which exceeds the capacity
	 */
	public void addItem(MailItem item) throws TubeFullException {
		int current = getSize();
		if (current + 1 <= MAXIMUM_CAPACITY) {
			tube.add(item);
		} else {
			throw new TubeFullException();
		}
	}

	/** @return the size of the tube **/
	public int getSize() {
		return tube.size();
	}

	/**
	 * @return the first item in the storage tube (after removing it)
	 */
	public MailItem pop() {
		return tube.pop();
	}

	public Stack<MailItem> getTube() {
		return tube;
	}

}
