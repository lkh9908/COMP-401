package a2;

import java.util.Scanner;

public class A2Jedi {

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
		
		// Find the number of food in the menu
		int menuNum = scan.nextInt();
		
		// Keep track of ounces of ingredient in each food
		// [number of food][number of ingredient]
		double[][] calMaster = new double[menuNum][numIngre];
		double[] result = new double[numIngre];
		String[] foodName = new String[menuNum];
		
		// Scan the order and calculate ounces spent
		for (int i = 0; i < menuNum; i++) {
			foodName[i] = scan.next();
			int ingre = scan.nextInt();
			
			for (int j = 0; j < ingre; j++) {
				String ingreX = scan.next();
				double calX = scan.nextDouble();
				for (int k = 0; k < numIngre; k++) {
					if (name[k].equals(ingreX)) {
						calMaster[i][k] += calX;
					}
				}
			}
		}
		
		String order = "";
		
		while(!order.contentEquals("EndOrder")) {
			order = scan.next();
			for (int i = 0; i < menuNum; i++) {
				if (order.contentEquals(foodName[i])) {
					for (int j = 0; j < numIngre; j++) {
						result[j] += calMaster[i][j];
					}
				}
			}
		}
		
		System.out.println("The order will require:");
		for (int i = 0; i < numIngre; i++) {
			System.out.println(String.format("%.2f", result[i]) + " ounces of " + name[i]);
		}
		scan.close();
	}
}
