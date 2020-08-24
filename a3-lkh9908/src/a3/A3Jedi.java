package a3;

import java.util.Scanner;

public class A3Jedi {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Scan the ingredients list and create an array of "Ingredient" object
		
		int numIngre = scan.nextInt();
		Ingredient[] ingredients = new IngredientImpl[numIngre];
		
		for (int i = 0; i < numIngre; i++) {
			String name = scan.next();
			double price = scan.nextDouble();
			boolean vege;

			String vegeStr = scan.next();
			if (vegeStr.equals("true")) {
				vege = true;
			} else {
				vege = false;
			}

			int cal = scan.nextInt();
			
			ingredients[i] = new IngredientImpl(name, price, cal, vege);
		}
		
		/* for (int i = 0; i < ingredients.length; i++) {
			System.out.println(ingredients[i].getName());
			System.out.println(ingredients[i].getIsVegetarian());
			System.out.println(ingredients[i].getCaloriesPerDollar());
			System.out.println(ingredients[i].getCaloriesPerOunce());
		} */
		
		// Scan the menu list and create an array of MenuItem
		
		int menuNum = scan.nextInt();
		MenuItem[] menu = new MenuItemImpl[menuNum];
		
		for (int i = 0; i < menuNum; i++) {
			String itemName = scan.next();
			
			// Scan the portion of each item in the menu
			
			int portionNum = scan.nextInt();
			IngredientPortion[] portions = new IngredientPortionImpl[portionNum];
			for (int j = 0; j < portionNum; j++) {
				String portionName = scan.next();
				double portionAmt = scan.nextDouble();
				
				for (int k = 0; k < ingredients.length; k++) {
					if (portionName.equals(ingredients[k].getName())){
						portions[j] = new IngredientPortionImpl(ingredients[k], portionAmt);
					}
				}
			}
			
			menu[i] = new MenuItemImpl(itemName, portions);
		}
		
		String order = scan.next();
		IngredientPortion[] finalResult = new IngredientPortionImpl[ingredients.length];
		for (int i = 0; i < ingredients.length; i++) {
			finalResult[i] = new IngredientPortionImpl(ingredients[i], 0);
		}
		
		while(!order.equals("EndOrder")) {
			for (int i = 0; i < menu.length; i++) {
				if (order.equals(menu[i].getName())) {
					IngredientPortion[] ing = menu[i].getIngredients();
					for (int j = 0; j < ing.length; j++) {
						for (int k = 0; k < ingredients.length; k++) {
							if(ing[j].getName().equals(ingredients[k].getName())){
								finalResult[k] = finalResult[k].combine(ing[j]);
							}
						}
					}
				}
			}
			order = scan.next();
		}
		
		System.out.println("The order will require: ");
		for (int i = 0; i < finalResult.length; i++) {
			System.out.println(String.format("%.2f", finalResult[i].getAmount()) + " ounces of " + finalResult[i].getName());
		}
		scan.close();
	}

}
