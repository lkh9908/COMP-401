package a5;

public class RedPlate extends PlateImpl{
	private static double price = 1.00;

	public RedPlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.RED, price, contents);
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public Color getColor() {
		return Plate.Color.RED;
	}

	@Override
	public double getProfit() {
		if (contents == null) {
			return 0.00;
		} else {
			return Math.round((price - contents.getCost()) * 100.0) / 100.0;	
		}
	}

}
