package a5;

public class SeaweedPortion extends IngredientPortionImpl {
	
	static Seaweed seaweed = new Seaweed();
	private double amount;
	
	public SeaweedPortion (double amount) {
		super(seaweed, amount);
		this.amount = amount;
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			SeaweedPortion result1 = new SeaweedPortion(amount);
			return result1;
		} else {
			if (seaweed.getName().equals(other.getName())) {
				double newAmt = this.amount + other.getAmount();
				SeaweedPortion result2 = new SeaweedPortion(newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
