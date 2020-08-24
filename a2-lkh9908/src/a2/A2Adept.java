package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Create arrays to hold information in the input
		int numIngre = scan.nextInt();
		String[] name = new String[numIngre];
		double[] price = new double[numIngre];
		boolean[] vege = new boolean[numIngre];
		double[] cal = new double[numIngre];

		// Import information provided in the input
		// Which is same as in A2Novice
		
		for (int i = 0; i < numIngre; i++) {
			name[i] = scan.next();
			price[i] = scan.nextDouble();

			String vegeStr = scan.next();
			if (vegeStr.equals("true")) {
				vege[i] = true;
			}

			cal[i] = scan.nextDouble();
		}
		
		// Import additional information
		// And generate result
		int numFood = scan.nextInt();
		
		// Loop for each food on the menu
		for (int i = 0; i < numFood; i++) {
			System.out.println(scan.next() + ":");
			int numIngreFood = scan.nextInt();
			
			double priceX = 0;
			double calX = 0;
			boolean vegeX = true;
			
			// Loop for each ingredient in each food
			for (int j = 0; j < numIngreFood; j++) {
				String ingre = scan.next();
				int ingreXIndex = 0;
				
				double ounce = scan.nextDouble();
				
				// Find the ingredient's corresponding calories and price
				for (int k = 0; k < numIngre; k++) {
					if (name[k].equals(ingre)) {
						ingreXIndex = k;
					}
				}
			
				priceX += ounce * price[ingreXIndex];
				calX += ounce * cal[ingreXIndex];
				
				// Check if the ingredient is vegetarian
				// A food is vegetarian if all of its ingredients are vegetarian
				if (vege[ingreXIndex] == false) {
					vegeX = false; 
				}
			}
			
			// Print the calories, price, and vegetarian of each food
			System.out.println("  " + ((int) (calX + 0.5)) + " calories");
			System.out.println("  " + "$" + String.format("%.2f", priceX));

			if (vegeX) {
				System.out.println("  Vegetarian");
			} else {
				System.out.println("  Non-Vegetarian");
			}	
		}
	scan.close();
	}
}
