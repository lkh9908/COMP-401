package a7;

import a7.PlateEvent.EventType;
import comp401sushi.Plate.Color;

public class PlateCounter implements BeltObserver {

	private int red = 0;
	private int green = 0;
	private int blue = 0;
	private int gold = 0;

	public PlateCounter(Belt b) {
		// initialize PlateCounte
		// initialize counts of red, green, blue, and gold plates 
		// according to the current contents of the belt

		if (b == null) {
			throw new IllegalArgumentException();
		} 
		b.addBeltObserver(this);
		
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) != null) {
				Color color = b.getPlateAtPosition(i).getColor();
				
				switch(color) {
				case RED:
					red++; break;
				case GREEN:
					green++; break;
				case BLUE:
					blue++; break;
				case GOLD:
					gold++; break;
				}
			}
		}
	}

	@Override
	public void handlePlateEvent(PlateEvent e) {
		// update color counts
		EventType event = e.getType();
		Color colorHandeled = e.getPlate().getColor();

		switch(event) {
		case PLATE_PLACED:
			switch(colorHandeled) {
			case RED:
				red++; break;
			case GREEN:
				green++; break;
			case BLUE:
				blue++; break;
			case GOLD:
				gold++; break;
			} break;
		case PLATE_REMOVED:
			switch(colorHandeled) {
			case RED:
				red--; break;
			case GREEN:
				green--; break;
			case BLUE:
				blue--; break;
			case GOLD:
				gold--; break;
			} break;
		}
	}

	public int getRedPlateCount() {
		return red;

	}

	public int getGreenPlateCount() {
		return green;

	}

	public int getBluePlateCount() {
		return blue;

	}

	public int getGoldPlateCount() {
		return gold;

	}




}
