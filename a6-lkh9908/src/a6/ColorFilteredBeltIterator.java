package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ColorFilteredBeltIterator implements Iterator<Plate>{

	private Belt belt;
	private int start_position;
	Iterator<Plate> iter;
	private int rotate_start;
	private Plate.Color colorfilter;
	
	public ColorFilteredBeltIterator(Belt belt, int startposition, 
			Plate.Color colorfilter){
		this.belt = belt;
		this.start_position = startposition;
		rotate_start = start_position;
		this.colorfilter = colorfilter;
	}
	
	// returns a boolean
	// true if there is plate that matches the specified colorfilter 
	// false other wise
	// false when the belt is empty
	public boolean hasNext() {
		boolean flag = false;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				if (belt.getPlateAtPosition(i).getColor() == colorfilter) {
					flag = true;
				}
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
	 * Retrieve the next plate (color == colorfilter) from the belt. 
	 * should not remove the plate from the belt. 
	 * If next is called on an empty belt:
	 * 	throw a java.util.NoSuchElementException.
	 * Once find an element, change can_remove to true
	 */
	public Plate next() {
		if (hasNext() == false) {
			throw new NoSuchElementException();
		} else {
			int index = 
					(((rotate_start) % belt.getSize()) + belt.getSize())
					% belt.getSize();
			if(belt.getPlateAtPosition(index) != null &&
					belt.getPlateAtPosition(index).getColor() == colorfilter) {
				rotate_start++;
				return belt.getPlateAtPosition(index);
			} else {
				rotate_start++;
				return this.next();
			}
		}
	}

}