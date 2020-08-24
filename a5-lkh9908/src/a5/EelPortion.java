package a5;

public class EelPortion extends IngredientPortionImpl{
	
	static Eel eel = new Eel();
	private double amount;
	
	public EelPortion (double amount) {
		super(eel, amount);
		this.amount = amount;
	}
	
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			EelPortion result1 = new EelPortion(amount);
			return result1;
		} else {
			if (eel.getName().equals(other.getName())) {
				double newAmt = this.amount + other.getAmount();
				EelPortion result2 = new EelPortion(newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
