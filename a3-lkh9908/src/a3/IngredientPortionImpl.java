package a3;

public class IngredientPortionImpl implements IngredientPortion{

	private Ingredient ing;
	private double amount;
	
	// "ing" should not be null and amount should be positive

	public IngredientPortionImpl(Ingredient ing, double amount) {
		if (ing == null) {
			throw new RuntimeException("The ingredient cannot be null");
		}
		if (amount < 0) {
			throw new RuntimeException("The amount of the ingredient cannot be negative");
		}

		this.ing = ing;
		this.amount = amount;
	}

	@Override
	public Ingredient getIngredient() {
		return ing;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public String getName() {
		return ing.getName();
	}

	@Override
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

	@Override
	public double getCalories() {
		return ing.getCaloriesPerOunce() * amount;
	}

	@Override
	public double getCost() {
		return ing.getPricePerOunce() * amount;
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		// This method accepts an "IngredientPortion" parameter named *other*. 
		// The result of the method should be a new "IngredientPortion" object 
		// The new object should have the combined weight of the current object and *other*. 
		// If *other* is null, then the method should just return the current object. 
		// If *other* is a portion of a different ingredient, then a "RuntimeException" should be thrown.

		if (other == null) {
			IngredientPortion result1 = new IngredientPortionImpl(ing, amount);
			return result1;
		} else {
			String ingName = ing.getName();
			String otherName = other.getName();

			if (ingName.equals(otherName)) {
				double newAmt = this.amount + other.getAmount();
				IngredientPortion result2 = new IngredientPortionImpl(ing, newAmt);
				return result2;
			} else {
				throw new RuntimeException("The two portions should be from the same ingredient");
			}
		}
	}
}
