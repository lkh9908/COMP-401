package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Create arrays to hold information in the input
		int numIngre = scan.nextInt();
		String[] name = new String[numIngre];
		double[] price = new double[numIngre];
		boolean[] vege = new boolean[numIngre];
		double[] cal = new double[numIngre];
		
		// Import all information provided in the input
		for (int i = 0; i < numIngre; i++) {
			name[i] = scan.next();
			price[i] = scan.nextDouble();
			
			String vegeStr = scan.next();
			if (vegeStr.equals("true")) {
				vege[i] = true;
			}
			
			cal[i] = scan.nextDouble();
		}
		
		// Count the number of vegetarian ingredients
		int vegeIngre = 0;
		for (int i = 0; i < numIngre; i++) {
			if (vege[i]) {
				vegeIngre++;
			}
		}
		
		// Calculate calories per dollar of each ingredient
		double[] calPerD = new double[numIngre];
		for (int i = 0; i < numIngre; i++) {
			calPerD[i] = cal[i] / price[i];
		}
		
		// Compare highest and lowest calories per dollar 
		int minIndex = 0;
		double min  = calPerD[0];
		
		for (int i = 0; i < numIngre; i++) {
			if (min > calPerD[i]) {
				min = calPerD[i];
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		double max = calPerD[0];
		
		for (int i = 0; i < numIngre; i++) {
			if (max < calPerD[i]) {
				max = calPerD[i];
				maxIndex = i;
			}
		}
		
		// Print the output
		System.out.println("Number of vegetarian ingredients: " + vegeIngre);
		System.out.println("Highest cals/$: " + name[maxIndex]);
		System.out.println("Lowest cals/$: " + name[minIndex]);
		
		scan.close();
	}
}
