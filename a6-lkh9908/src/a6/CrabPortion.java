package a6;

public class CrabPortion extends IngredientPortionImpl {
	
	static Crab crab = new Crab();
	private double amount;
	
	public CrabPortion (double amount) {
		super(crab, amount);
		this.amount = amount;
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			CrabPortion result1 = new CrabPortion(amount);
			return result1;
		} else {
			if (crab.getName().equals(other.getName())) {
				double newAmt = this.amount + other.getAmount();
				CrabPortion result2 = new CrabPortion(newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
