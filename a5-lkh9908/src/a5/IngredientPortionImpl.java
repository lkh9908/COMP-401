package a5;

public abstract class IngredientPortionImpl implements IngredientPortion {
	
	private Ingredient ingredient = new IngredientImpl(null, 0, 0, false, false, false);
	private String name;
	private double amount;
	private double calories;
	private double cost;
	private boolean isVegetarian;
	private boolean isRice;
	private boolean isShellfish;

	IngredientPortionImpl(Ingredient ingredient, double amount){
		if(!(amount > 0)) {
			throw new RuntimeException("The amount of a ingredient is 0");
		} else {
			this.ingredient = ingredient;
			this.name = ingredient.getName();
			this.amount = amount;
			this.calories = ingredient.getCaloriesPerOunce() * amount;
			this.cost = ingredient.getPricePerOunce() * amount;
			this.isVegetarian = ingredient.getIsVegetarian(); 
			this.isRice = ingredient.getIsRice();
			this.isShellfish = ingredient.getIsShellfish();	
		}
	}
	@Override
	public Ingredient getIngredient() {
		return ingredient;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public double getCalories() {
		return calories;
	}

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public boolean getIsVegetarian() {
		return isVegetarian;
	}

	@Override
	public boolean getIsRice() {
		return isRice;
	}

	@Override
	public boolean getIsShellfish() {
		return isShellfish;
	}

	@Override
	public abstract IngredientPortion combine(IngredientPortion other);

}
