package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

import a6.Plate.Color;

public class BeltImpl implements Belt {
	/* 
	 * this class is an implementation of the Belt interface
	 */
	private int belt_size;
	private Plate[] belt = new Plate[belt_size];
	
	public BeltImpl(int belt_size) {
		if (belt_size < 0) {
			throw new IllegalArgumentException();
		}
		this.belt_size = belt_size;
		Plate[] belt = new Plate[belt_size];
		this.belt = belt;
	}
	
	/* A getter for the size of the belt. */
	@Override
	public int getSize() {
		return belt_size;
	}

	/* 	Returns the plate at the specified position on the belt 
	 *  or null if there is no Plate object there. */
	@Override
	public Plate getPlateAtPosition(int position) {
		int normalized_position = ((position % belt_size) + belt_size) % belt_size;
		if (belt[normalized_position] != null) {
			return belt[normalized_position];
		} else {
			return null;
		}
	}

	/* 	Sets a plate at the specified position on the belt. If the provided plate is null, 
	 *  throws an IllegalArgumentException. 
	 *  If there is already a plate at that position, throws a BeltPlateException.
	 */
	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		int normalized_position = ((position % belt_size) + belt_size) % belt_size;
		if (plate == null) {
			throw new IllegalArgumentException();
		} else if (belt[normalized_position] != null) {
			throw new BeltPlateException(normalized_position, plate, this);
		} else {
			belt[normalized_position] = plate;
		}
	}

	/* 	Clears the specified position on the belt to null. */
	@Override
	public void clearPlateAtPosition(int position) {
		int normalized_position = ((position % belt_size) + belt_size) % belt_size;
		belt[normalized_position] = null;
	}

	/* Removes the plate at the specified position off the belt and returns it. 
	 * If there is no plate at the specified position, throws a java.util.NoSuchElementException. 
	 */
	@Override
	public Plate removePlateAtPosition(int position) {
		int normalized_position = ((position % belt_size) + belt_size) % belt_size;
		if (getPlateAtPosition(normalized_position) == null) {
			throw new NoSuchElementException();
		} else {
			Plate removed;
			removed = getPlateAtPosition(normalized_position);
			clearPlateAtPosition(normalized_position);
			return removed;
		}
	}

	/*
	 * set the plate to the nearest position
	 * input: plate, position
	 * output: final position of the plate
	 * this method will try to find the nearest possible position in the upper direction
	 * if the original position is occupied 
	 */
	@Override
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int normalized_position = (((position) % belt_size) + belt_size) % belt_size;
		if (belt[normalized_position] != null) {
			for (int i = 0; i < belt_size; i++) {
				int normalized_position2 = (((position + i) % belt_size) + belt_size) % belt_size;
				if (belt[normalized_position2] == null) {
					belt[normalized_position2] = plate;
					return normalized_position2;
				}
			}
			throw new BeltFullException(this);
		} else {
			belt[normalized_position] = plate;
			return normalized_position;
		}
	}

	// Returns a BeltIterator object for this belt starting at position 0.
	@Override
	public Iterator<Plate> iterator() {
		return new BeltIterator(this, 0);
	}
	
	// overload method of iterator
	@Override
	public Iterator<Plate> iterator(double max_price) {
		return new PriceThresholdBeltIterator(this, 0, max_price);
	}

	// overload method of iterator
	@Override
	public Iterator<Plate> iterator(Color color) {
		return new ColorFilteredBeltIterator(this, 0, color);
	}

	// Returns a BeltIterator object for this belt starting at the specified position.
	@Override
	public Iterator<Plate> iteratorFromPosition(int position) {
		int normalized_position = (((position) % belt_size) + belt_size) % belt_size;
		return new BeltIterator(this, normalized_position);
	}
	
	// overload method of iteratorFromPosition
	@Override
	public Iterator<Plate> iteratorFromPosition(int position, double max_price) {
		int normalized_position = (((position) % belt_size) + belt_size) % belt_size;
		return new PriceThresholdBeltIterator(this, normalized_position, max_price);
	}

	// overload method of iteratorFromPosition
	@Override
	public Iterator<Plate> iteratorFromPosition(int position, Color color) {
		int normalized_position = (((position) % belt_size) + belt_size) % belt_size;
		return new ColorFilteredBeltIterator(this, normalized_position, color);
	}

	/*
	 * Plate object set at position p 
	 * after rotate
	 * now found at position p+1 
	 */
	@Override
	public void rotate() {
		Plate[] newBelt = new Plate[belt_size];
		for (int i = 1; i < belt_size + 1; i++) {
			int normalized_position = ((i % belt_size) + belt_size) % belt_size;
			newBelt[normalized_position] = belt[i - 1];
		}
		belt = newBelt;
	}
}
