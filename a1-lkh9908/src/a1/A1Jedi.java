package a1;

import java.util.Scanner;

public class A1Jedi {

	/* 
	 * This class takes in a list of goods, their prices, customers, and their purchasing lists
	 * This class will then record the quantity and name of the commodities each customer purchased
	 * This class will calculate the quantity sold for each good and return the values 
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int goodsNum = scan.nextInt();

		// Create four arrays
		// One for goods
		// One for their corresponding prices
		// One for quantity sold for each good 

		String[] goods = new String[goodsNum];
		double[] prices = new double[goodsNum];
		int[] sales = new int[goodsNum];
		int[] buyPpl = new int[goodsNum];

		// Record each good's name and price 
		for (int i = 0; i < goodsNum; i++) {
			goods[i] = scan.next();
			prices[i] = scan.nextDouble();
		}

		int customers = scan.nextInt();

		// record how many goods each customer has purchased
		// boolean "repeat" is used to 
		// avoid repeats when one customer buys the same commodity more than one time
		for(int j = 0; j < customers; j++) {
			scan.next();
			scan.next();
			int goodsQty = scan.nextInt();
			boolean[] repeat = new boolean[goods.length];
			
			for (int boo = 0; boo < goods.length; boo++) {
				repeat[boo] = false;
			}

			// Record the name and quantity of each good
			// Within each customer's purchasing history
			for (int k = 0; k < goodsQty; k++) {
				int xQty = scan.nextInt();
				String xName = scan.next();

				// Put the numbers into arrays
				for (int x = 0; x < goods.length; x++) {
					if (xName.equals(goods[x])){
						sales[x] += xQty;
						if (repeat[x] == false) {
							repeat[x] = true;
							buyPpl[x]++;
						}
					}
				}
			}
		}

		// Print out results
		// "how many customers bought how much quantity for a good"
		for (int y = 0; y < goodsNum; y++) {
			if(sales[y] == 0) {
				System.out.print("\nNo customers bought " + goods[y]);
			} else {
				System.out.print("\n" + buyPpl[y] + " customers bought " + sales[y] + " " + goods[y]);
			}
		}
		scan.close();
	}
}
