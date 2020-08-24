package a7;

import comp401sushi.Plate;

public class PlateEvent {
	/* Create PlateEvent object
	 * each object contains information about the plate being PLACED or REMOVED
	 * the plate itself
	 * and the position of the plate
	 */
	
	public enum EventType {PLATE_PLACED, PLATE_REMOVED};
	
	private EventType type;
	private Plate plate;
	private int position;
	
	public PlateEvent(EventType type, Plate plate, int position) {
		this.type = type;
		this.plate = plate;
		this.position = position;
	}
	
	public EventType getType() {
		return type;
	}
	
	public  Plate getPlate() {
		return plate;
	}
	
	public int getPosition() {
		return position;
	}
}