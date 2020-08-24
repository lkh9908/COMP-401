package a3;

public class MenuItemImpl implements MenuItem {

	String name;
	IngredientPortion[] ingredients;

	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		
		IngredientPortion[] ingredients1 = ingredients.clone();
		
		// name should not be null, ingredients should not be null and have a length greater than zero.
		if (name.equals(null)){
			throw new RuntimeException("The name of the food is null");
		}
		if (ingredients1.length == 0) {
			throw new RuntimeException("There is not ingredient in the list");
		} else {
			for (int i = 0; i < ingredients1.length; i++) {
				if (ingredients[i] == null) {
					throw new RuntimeException("At least one ingredient is null");
				}
			}
		}
		
		this.name = name;
		this.ingredients = ingredients1;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
	}

	@Override
	public int getCalories() {
		int calories = 0;
		IngredientPortion[] ingredients1 = ingredients.clone();
		
		for (int i = 0; i < ingredients1.length; i++) {
			calories += ingredients1[i].getCalories();
		}
		return calories;
	}

	@Override
	public double getCost() {
		double cost  = 0;
		IngredientPortion[] ingredients1 = ingredients.clone();
		
		for (int i = 0; i < ingredients1.length; i++) {
			cost += ingredients1[i].getCost();
		}
		return cost;
	}

	@Override
	public boolean getIsVegetarian() {
		IngredientPortion[] ingredients1 = ingredients.clone();
		
		// true if all ingredients are vegetarian
		// false if at least one is not 
		
		for (int i = 0; i < ingredients1.length; i++) {
			 if (!ingredients1[i].getIsVegetarian()) {
				 return false;
			 }
		}
		return true;
	}

}
