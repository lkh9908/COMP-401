package a6;

public class BeltFullException extends Exception{
	
	private Belt belt;
	
	public BeltFullException(Belt belt) {
		super("BeltFullException caused by plate being set at a belt which is already full");
		this.belt = belt;
	}
	
	public Belt getBelt() {
		return belt;
	}
}
