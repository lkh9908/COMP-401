package a6;

public class GreenPlate extends PlateImpl{
	private static double price = 2.00;

	public GreenPlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.GREEN, price, contents);
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public Color getColor() {
		return Plate.Color.GREEN;
	}

	@Override
	public double getProfit() {
		if (contents == null) {
			return 0.000;
		} else {
			return Math.round((price - contents.getCost()) * 100.0) / 100.0;	
		}
	}

}