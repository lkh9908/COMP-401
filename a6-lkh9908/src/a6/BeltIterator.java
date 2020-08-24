package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator implements Iterator<Plate> {
/*
 * iterate over all of the plates on a belt starting a particular position. 
 * When the end of the belt is reached, the iterator should go back to the beginning of the belt 
 * never stops as long as there is one item on belt
 */
	private Belt belt;
	private int start_position;
	Iterator<Plate> iter;
	private int rotate_start;
	private boolean can_remove;
	private int removeIndex = 0;
	
	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.start_position = start_position;
		rotate_start = start_position;
		can_remove = false;
	}
	
	// returns a boolean
	// loop the whole array to check if there is plate
	// false when the belt is empty
	public boolean hasNext() {
		boolean flag = false;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				flag = true;
			}
		}
		if (belt == null) {
			return false;
		} else if (flag == false) {
			return false;
		} else {
			return true;
		}
}
	
	/*
	 * Retrieve the next plate from the belt. 
	 * should not remove the plate from the belt. 
	 * If next is called on an empty belt, throw a java.util.NoSuchElementException.
	 * Once find an element, change can_remove to true
	 */
	public Plate next() {
		if (hasNext() == false) {
			throw new NoSuchElementException();
		} else {
			int index = (((rotate_start) % belt.getSize()) + belt.getSize()) % belt.getSize();
			if(belt.getPlateAtPosition(index) != null) {
				can_remove = true;
				removeIndex = index;
				rotate_start++;
				return belt.getPlateAtPosition(index);
			} else {
				rotate_start++;
				return this.next();
			}
		}
	}
	
	/*
	 * Remove the plate last retrieved by the last call to 'next()'
	 * Calling remove() before next() has ever been called or 
	 * calling remove() a second time before calling next() again 
	 * result in throwing an IllegalStateException.
	 */
	public void remove() {
		if (can_remove == true) {
			belt.removePlateAtPosition(removeIndex);
			can_remove = false;
		} else {
			throw new IllegalStateException();
		}
	}
}
