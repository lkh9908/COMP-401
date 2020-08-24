package a5;

public class GoldPlate extends PlateImpl{

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(Plate.Color.GOLD, price, contents);
		if (price < 5.00) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public Color getColor() {
		return Plate.Color.GOLD;
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
