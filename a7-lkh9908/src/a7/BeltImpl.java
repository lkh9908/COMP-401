package a7;

import java.util.ArrayList;
import java.util.List;

import a7.PlateEvent.EventType;
import comp401sushi.Plate;


public class BeltImpl implements Belt {

	private Plate[] _belt;
	private List<BeltObserver> observers;
	private Customer[] _customers;

	public BeltImpl(int belt_size) {
		if (belt_size < 1) {
			throw new IllegalArgumentException("Illegal belt size");
		}

		_belt = new Plate[belt_size];
		observers = new ArrayList<BeltObserver>();
		_customers = new Customer[belt_size];
	}

	@Override
	public int getSize() {
		return _belt.length;
	}

	@Override
	public Plate getPlateAtPosition(int position) {
		position = normalize_position(position);

		return _belt[normalize_position(position)];
	}

	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}

		_belt[position] = plate;

		// notify observers
		notifyObservers(new PlateEvent(EventType.PLATE_PLACED, plate, position));
	}


	@Override
	public void clearPlateAtPosition(int position) {
		position = normalize_position(position);

		// notify observers
		notifyObservers(new PlateEvent(EventType.PLATE_REMOVED, getPlateAtPosition(position), 
				position));

		_belt[position] = null;		
	}

	private int normalize_position(int position) {
		int size = getSize();
		return (((position % size) + size) % size);
	}


	@Override
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int offset = 0;
		position = normalize_position(position);

		while (offset < getSize()) {
			try {
				setPlateAtPosition(plate, position+offset);

				// notify observers
				notifyObservers(new PlateEvent(EventType.PLATE_PLACED, plate, position+offset));

				return normalize_position(position+offset);
			}
			catch (BeltPlateException e) {
				offset += 1;
			}
		}
		throw new BeltFullException(this);
	}

	@Override
	public void rotate() {
		Plate last_plate = _belt[getSize()-1];

		for (int i=getSize()-1; i>0; i--) {
			_belt[i] = _belt[i-1];
		}
		_belt[0] = last_plate;

		// Notify the customer if
		// There is now a plate at the customer's position
		for(int i = 0; i < _customers.length; i++) {
			if (_belt[i] != null && _customers[i] != null) {
				_customers[i].observePlateOnBelt(this, _belt[i], i);
			}
		}
	}

	@Override
	public void addBeltObserver(BeltObserver o) {
		observers.add(o);
	}

	@Override
	public void removeBeltObserver(BeltObserver o) {
		observers.remove(o);
	}

	public void notifyObservers(PlateEvent e) {
		// Trigger update method on
		// all observers
		for (BeltObserver o : observers) {
			o.handlePlateEvent(e);
		}
	}

	public void registerCustomerAtPosition(Customer c, int position) {
		if (c == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (_customers[position] != null) {
			throw new RuntimeException();
		}

		for (int i = 0; i < _belt.length; i++) {
			if (c == _customers[i]) {
				throw new RuntimeException();
			}
		}
		_customers[position] = c;
	}

	public Customer unregisterCustomerAtPosition(int position) {
		position = normalize_position(position);

		Customer cRemoved = _customers[position];

		_customers[position] = null;

		return cRemoved;
	}
}
