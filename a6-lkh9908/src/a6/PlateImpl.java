package a6;

public abstract class PlateImpl implements Plate {
	
	protected Color color;
	protected double price;
	protected Sushi contents;
	
	// Constructing a plate
	// Input: price, content, color
	// Output: the Plate object
	// Throw PlatePriceException if price is lower than cost
	public PlateImpl (Color color, double price, Sushi contents) throws PlatePriceException{
		if (contents == null) {
			this.contents = null;
			this.price = price;
			this.color = color;
		} else {
			if(price <= contents.getCost()) {
				throw new PlatePriceException();
			} else {
			this.color = color;
			this.price = price;
			this.contents = contents;
			}
		}
	}

	@Override
	// Check if the contents is null
	public Sushi getContents() {
		if (contents == null) {
			return null;
		}
		return contents;
	}

	@Override
	// Return the prior contents when removing
	public Sushi removeContents() {
		if (contents == null) {
			return null;
		} else {
			Sushi prior = contents;
			contents = null;
			return prior;
		}
	}

	@Override
	// Cannot set a "null" content
	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException();
		} else {
			double cost = s.getCost();
			if(price <= cost) {
				throw new PlatePriceException();
			} else {
				this.contents = s;
			}
		}
		
	}

	@Override
	public boolean hasContents() {
		if (this.contents == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public abstract double getPrice();

	@Override
	public abstract Color getColor();

	@Override
	public abstract double getProfit();
}
