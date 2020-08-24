package a6;

public class AvocadoPortion extends IngredientPortionImpl {
	
	static Avocado avocado = new Avocado();
	private double amount;
	
	public AvocadoPortion (double amount) {
		super(avocado, amount);
		this.amount = amount;
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			AvocadoPortion result1 = new AvocadoPortion(amount);
			return result1;
		} else {
			if (avocado.getName().equals(other.getName())) {
				double newAmt = this.amount + other.getAmount();
				AvocadoPortion result2 = new AvocadoPortion(newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
