package a6;
/*
 * this interface is used to create a ingredient with its proper values
 * such as name, price, and calories
 */

public interface Ingredient {
	String getName();
	double getCaloriesPerDollar();
	int getCaloriesPerOunce();
	double getPricePerOunce();
	boolean equals(Ingredient other);
	boolean getIsVegetarian();
	boolean getIsRice();
	boolean getIsShellfish();
}
