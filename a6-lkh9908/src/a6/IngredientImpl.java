package a6;

public class IngredientImpl implements Ingredient {
	
	private String name;
	private double pricePerOz;
	private int caloriesPerOz;
	private boolean isVegetarian;
	private boolean isRice;
	private boolean isShellfish;

	IngredientImpl(String name, double pricePerOz, int caloriesPerOz, boolean isVegetarian, boolean isRice, boolean isShellfish){
		this.name = name;
		this.pricePerOz = pricePerOz;
		this.caloriesPerOz = caloriesPerOz;
		this.isVegetarian = isVegetarian;
		this.isRice = isRice;
		this.isShellfish = isShellfish;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCaloriesPerDollar() {
		return caloriesPerOz / pricePerOz;
	}

	@Override
	public int getCaloriesPerOunce() {
		return caloriesPerOz;
	}

	@Override
	public double getPricePerOunce() {
		return pricePerOz;
	}

	@Override
	public boolean equals(Ingredient other) {
		if (this.name.equals(other.getName()) && 
				this.caloriesPerOz == other.getCaloriesPerOunce() &&
				Math.abs(this.pricePerOz - other.getPricePerOunce()) < 0.01) {
			return true;
		} else { 
			return false;
		}
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

}
