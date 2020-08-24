package a5;

public class Main {
	public static void main(String[] args) throws PlatePriceException {
		GreenPlate r = new GreenPlate(new Nigiri(Nigiri.NigiriType.TUNA));
		System.out.println("profit: " + r.getProfit());
		System.out.println("ans: " + (2.0 - ((1.67 * 0.75) + (0.13 * 0.5))));
		System.out.println(r.hasContents());
		r.removeContents();
		System.out.println(r.hasContents());
		System.out.println(r.getPrice());
		
		System.out.println(" ");

		RedPlate c = new RedPlate(new Nigiri(Nigiri.NigiriType.CRAB));
		System.out.println("profit: " + c.getProfit());
		System.out.println("ans: " + (0.39));
		System.out.println(c.hasContents());
		c.removeContents();
		System.out.println(c.hasContents());
		System.out.println(c.getPrice());
		
		System.out.println(" ");

		GoldPlate g = new GoldPlate(null, 20);
		System.out.println("profit: " + g.getProfit());
		System.out.println(g.hasContents());
		System.out.println(g.getPrice());
		
		g.setContents(new Nigiri(Nigiri.NigiriType.CRAB));
		System.out.println("profit: " + g.getProfit());
		System.out.println(g.hasContents());
		System.out.println(g.getPrice());
		
		System.out.println(" ");
		
		double a = 123.13698;
		double roundOff = Math.round(a * 100.0) / 100.0;
	    System.out.println(roundOff);
	    
	    
	    System.out.println("xxx   " + 1.67 * 0.75);
	    System.out.println("xxxxx  " + Math.round((1.67 * 0.75) * 100.0) / 100.0);
	}}

