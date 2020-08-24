package a5;

public class BluePlate extends PlateImpl{
	private static double price = 4.00;

	public BluePlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.BLUE, price, contents);
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public Color getColor() {
		return Plate.Color.BLUE;
	}

	@Override
	public double getProfit() {
		if (this.contents == null) {
			return 0.000;
		} else {
			return Math.round((price - contents.getCost()) * 100.0) / 100.0;	
		}
	}

}