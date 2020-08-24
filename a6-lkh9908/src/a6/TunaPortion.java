package a6;

public class TunaPortion extends IngredientPortionImpl {
	
	static Tuna tuna = new Tuna();
	private double amount;
	
	public TunaPortion (double amount) {
		super(tuna, amount);
		this.amount = amount;
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			TunaPortion result1 = new TunaPortion(amount);
			return result1;
		} else {
			if (tuna.getName().equals(other.getName())) {
				double newAmt = this.amount + other.getAmount();
				TunaPortion result2 = new TunaPortion(newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
