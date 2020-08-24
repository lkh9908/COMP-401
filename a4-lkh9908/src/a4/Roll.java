package a4;

public class Roll implements Sushi{
	private String name;
	private IngredientPortion[] roll_ingredients;

	public Roll(String name, IngredientPortion[] roll_ingredients) {
		if(roll_ingredients == null) {
			throw new RuntimeException("The ingredeints for the roll is null");
		}
		for (int i = 0; i < roll_ingredients.length; i++){
			if(roll_ingredients[i] == null) {
				throw new RuntimeException("One of the ingredeints for the roll is null");
			}
		}
		this.name = name;
		
		boolean flag = false; 
		boolean enough = false;
		int length = 0;
		
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].getName().equals("seaweed")) {
					flag = true;
				}
		}
		
		for (int i = 0; i < roll_ingredients.length - 1; i++) {
			for (int j = i + 1; j < roll_ingredients.length; j++)
				if (roll_ingredients[i] != null && roll_ingredients[j] != null &&
					roll_ingredients[i].getName().equals(roll_ingredients[j].getName())) {
					roll_ingredients[i] = roll_ingredients[i].combine(roll_ingredients[j]);
					roll_ingredients[j] = null;
				}
		}
		
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i] != null) {
				length++;
			}
		}
	
		
		if (!flag) {
			length++;
		}
		
		IngredientPortion[] result = new IngredientPortion[length];
		
		int cur = 0;
		for (int i = 0; i < roll_ingredients.length; i++)
			if (roll_ingredients[i] != null) {
				result[cur] = roll_ingredients[i];
				cur++;
		}
		
		for (int i = 0; i < result.length; i++) {
			if (result[i] != null &&
					result[i].getIngredient().equals(new Seaweed()) &&
					result[i].getAmount() - 0.000 >= 0.100) {
				enough = true;
			}
		}
		
		if (!flag) {
			result[cur ++] = new SeaweedPortion(0.1);
		} else if (!enough) {
			for (int i = 0; i < result.length; i++)
				if (result[i].getIngredient().equals(new Seaweed())) {
					result[i] = new SeaweedPortion(0.1);
				}
		}

		
		this.roll_ingredients = result.clone();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return roll_ingredients.clone();
	}

	@Override
	public int getCalories() {
		double result = 0;
		for (int i = 0; i < roll_ingredients.length; i++) {
			result += roll_ingredients[i].getCalories();
		}
		return (int) (result + 0.5);
	}

	@Override
	public double getCost() {
		double result = 0;
		for (int i = 0; i < roll_ingredients.length; i++) {
			result += roll_ingredients[i].getCost();
		}
		return Math.round(result * 100.0) / 100.0;
	}

	@Override
	public boolean getHasRice() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if(roll_ingredients[i] != null && roll_ingredients[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getHasShellfish() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if(roll_ingredients[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if(roll_ingredients[i].getIsVegetarian()) {
				return true;
			}
		}
		return false;
	}

}
