package a1;

import java.util.Scanner;

public class A1Novice {
	
	// This class takes in a list of customers, their names, and goods they bought
	// This class will then calculate the money spent by each customer and print out the result

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int customersNum = scan.nextInt();
		String result;
		
		// Make a new line 
		System.out.println(" ");
		
		// Loop each customer, record their name, and put them into proper format
		for (int i = 0; i < customersNum; i++) {
			String fName = scan.next();
			char F = fName.charAt(0);
			String lName = scan.next();
			
			// Scan the number of items each customer bought
			int items = scan.nextInt();
			double totalP = 0;
			
			// Loop each item and count the money spent on them
			for (int j = 0; j < items; j++) {
				int qty = scan.nextInt();
				scan.next();
				double price = scan.nextDouble();
				totalP += qty * price;
			}
			
			// Formulate output 
			result = F + ". " + lName + ": " + String.format("%.2f", totalP) + "\n";	
			System.out.print(result);
		}
		scan.close();
	}
}
