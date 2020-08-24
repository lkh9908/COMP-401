package a3;

public class IngredientImpl implements Ingredient {
	private String name;
	private double price;
	private int calories;
	private boolean is_vegetarian;
	
	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		// name should not be null
		// price and calories should not be negative
		if (name.equals(null)) {
			throw new RuntimeException("The name of the ingredient cannot be null");
		}
		if (price < 0) {
			throw new RuntimeException("The price of the ingredient cannot be 0");
		}
		if (calories < 0) {
			throw new RuntimeException("The calories of the ingredient cannot be 0");
		}
		
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.is_vegetarian = is_vegetarian;
	}
	
	public String getName() {
		return name;
	}
	public boolean getIsVegetarian() {
		return is_vegetarian;
	}
	public double getPricePerOunce() {
		return price;
		
	}
	public int getCaloriesPerOunce() {
		return calories;
	}
	public double getCaloriesPerDollar() {
		return calories / price;
	}

}
