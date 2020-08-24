package a5;

public class RicePortion extends IngredientPortionImpl {
	
	static Rice rice = new Rice();
	private double amount;
	
	public RicePortion (double amount) {
		super(rice, amount);
		this.amount = amount;
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			RicePortion result1 = new RicePortion(amount);
			return result1;
		} else {
			if (rice.getName().equals(other.getName())) {
				double newAmt = this.amount + other.getAmount();
				RicePortion result2 = new RicePortion(newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
