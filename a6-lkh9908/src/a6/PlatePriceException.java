package a6;

public class PlatePriceException extends Exception {

	public PlatePriceException() {
		super("Illegal plate price");
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
