package a1;

import java.util.Scanner;

/* 
 * This class takes in a list of goods, their prices, customers, and their purchasing lists
 * This class will then calculate how much money each customer spent
 * This class will return the highest and the lowest spender 
 * And the average money spent from all customers
 */
public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Create two arrays, one for the names of commodities, one for their prices
		int goodsNum = scan.nextInt();
		
		String[] goods = new String[goodsNum];
		double[] prices = new double[goodsNum];
		
		// Fill the arrays
		// Commodities and their correspondent prices have same indexes
		for (int i = 0; i < goodsNum; i++) {
			goods[i] = scan.next();
			prices[i] = scan.nextDouble();
		}
		
		// Create two arrays, one for customers' names, one for their purchasing lists
		int customers = scan.nextInt();
		double[] priceLists = new double[customers];
		String[] cNames = new String[customers];
		double masterTotal = 0;
		
		// Record customers' names and their purchasing list
		for (int j = 0; j < customers; j++) {
			String name = scan.next() + " " + scan.next();
			int gPurchased = scan.nextInt();
			
			double tPrice = 0;
			
			// Loop goods and quantity bought
			for (int k = 0; k < gPurchased; k++) {
				int qtyX = scan.nextInt();
				String goodX = scan.next();
				
				// Find the corresponding price of each good
				// And calculate money payed
				for (int x = 0; x < goods.length; x++) {
					if (goodX.equals(goods[x])) {
						tPrice += prices[x] * qtyX; 
					}
				}
			}
			
			priceLists[j] = tPrice;
			cNames[j] = name;
			masterTotal += tPrice;
		}
		
		// Compare money spent by each customer
		int maxI = max(priceLists);
		System.out.println("Biggest: " + cNames[maxI] + " " + "(" + String.format("%.2f", priceLists[maxI]) + ")");
		int minI = min(priceLists);
		System.out.println("Smallest: " + cNames[minI] + " " + "(" + String.format("%.2f", priceLists[minI]) + ")");
		
		// Calculate average money spent
		double avr = masterTotal / customers;
		System.out.println("Average: " + String.format("%.2f", avr));
		scan.close();
	} 
	
	/* Find the biggest number out of a number array
	 * Input: an array of doubles
	 * Output: the biggest number
	 */
	public static int max(double[] prices) {
		int maxI = 0;
		double max = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (max < prices[i]) {
				max = prices[i];
				maxI = i;
			} else {
			}
		}
		return maxI;
	}
	
	/* Find the smallest number out of a number array
	 * Input: an array of doubles
	 * Output: the index of the smallest number
	 */
	public static int min(double[] prices) {
		int minIndex = 0;
		double min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
				minIndex = i;
			} 
		}
		return minIndex;
	}
}
