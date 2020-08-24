package a5;

public class ShrimpPortion extends IngredientPortionImpl {
	
	static Shrimp shrimp = new Shrimp();
	private double amount;
	
	public ShrimpPortion (double amount) {
		super(shrimp, amount);
		this.amount = amount;
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			ShrimpPortion result1 = new ShrimpPortion(amount);
			return result1;
		} else {
			if (shrimp.getName().equals(other.getName())) {
				double newAmt = this.amount + other.getAmount();
				ShrimpPortion result2 = new ShrimpPortion(newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
