package a6;

public class YellowtailPortion extends IngredientPortionImpl {
	
	static Yellowtail yellowtail = new Yellowtail();
	private double amount;
	
	public YellowtailPortion (double amount) {
		super(yellowtail, amount);
		this.amount = amount;
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			YellowtailPortion result1 = new YellowtailPortion(amount);
			return result1;
		} else {
			if (yellowtail.getName().equals(other.getName())) {
				double newAmt = this.amount + other.getAmount();
				YellowtailPortion result2 = new YellowtailPortion(newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
