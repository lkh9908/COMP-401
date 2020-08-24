package a6;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws PlatePriceException, BeltPlateException, BeltFullException {
		Belt test = new BeltImpl(10);
		GreenPlate green = new GreenPlate(new Nigiri(Nigiri.NigiriType.TUNA));
		RedPlate red = new RedPlate(new Nigiri(Nigiri.NigiriType.CRAB));
		GoldPlate gold = new GoldPlate(new Nigiri(Nigiri.NigiriType.EEL), 20);
		
		// checking basic getter and setter
		System.out.println("checking basic getter and setter");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		test.setPlateAtPosition(green, 20);
		System.out.println(test.getPlateAtPosition(0).getContents().getName());
		System.out.println("should be \"tuna nigiri\"");
		System.out.println("");
		
		test.setPlateAtPosition(red, 1);
		System.out.println(test.getPlateAtPosition(11).getContents().getName());
		System.out.println("should be \"crab nigiri\"");
		System.out.println("");
		
		test.setPlateAtPosition(gold, 2);
		System.out.println(test.getPlateAtPosition(12).getContents().getName());
		System.out.println("should be \"eel nigiri\"");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// checking setPlateNearestToPosition
		System.out.println("checking setPlateNearestToPosition");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println(test.setPlateNearestToPosition(gold, 0));
		System.out.println("should be \"3\"");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// checking clearPlateAtPosition
		System.out.println("checking clearPlateAtPosition");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		test.clearPlateAtPosition(1);
		System.out.println(test.getPlateAtPosition(11));
		System.out.println("should be \"null\"");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// checking getSize
		System.out.println("checking getSize");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println(test.getSize());
		System.out.println("should be \"10\"");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// checking removePlateAtPosition
		System.out.println("checking removePlateAtPosition");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println(test.removePlateAtPosition(0).getContents().getName());
		System.out.println("should be \"tuna nigiri\"");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// checking setPlateNearestToPosition again
		System.out.println("checking setPlateNearestToPosition again");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println(test.setPlateNearestToPosition(green, 0));
		System.out.println("should be \"0\"");
		
		System.out.println(test.setPlateNearestToPosition(green, 0));
		System.out.println("should be \"1\"");
		
		System.out.println(test.setPlateNearestToPosition(green, 0));
		System.out.println("should be \"4\"");
		
		System.out.println(test.setPlateNearestToPosition(green, 0));
		System.out.println("should be \"5\"");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// Checking rotate
		System.out.println("checking rotate");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		for (int i = 0; i < test.getSize(); i++) {
			if (test.getPlateAtPosition(i) != null) {
				System.out.println(test.getPlateAtPosition(i).getContents().getName());
			} else {
				System.out.println("null");
			}
		}
		test.rotate();
		System.out.println("");
		for (int i = 0; i < test.getSize(); i++) {
			if (test.getPlateAtPosition(i) != null) {
				System.out.println(test.getPlateAtPosition(i).getContents().getName());
			} else {
				System.out.println("null");
			}
		}
		System.out.println("");
		System.out.println("should be: ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// checking iterator
		System.out.println("checking iterator");
		System.out.println("checking hasNext()");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		Iterator<Plate> iter = test.iterator();
		System.out.println(iter.hasNext());
		System.out.println("should be: true");
		System.out.println("");
		
		Iterator<Plate> iter2 = test.iteratorFromPosition(3);
		System.out.println(iter2.hasNext());
		System.out.println("should be: true");
		System.out.println("");
		
		Iterator<Plate> iter3 = test.iteratorFromPosition(4);
		System.out.println(iter3.hasNext());
		System.out.println("should be: false");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("checking iterator");
		System.out.println("checking next()");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println(iter.next());
		System.out.println("should be: green");
		System.out.println(iter.next());
		System.out.println("should be: green");
		System.out.println(iter.next());
		System.out.println("should be: gold");
		System.out.println(iter.next());
		System.out.println("should be: gold");
		System.out.println(iter.next());
		System.out.println("should be: green");
		System.out.println("");
		
		System.out.println(iter2.next());
		System.out.println("should be: gold");
		System.out.println(iter2.next());
		System.out.println("should be: green");
		System.out.println(iter2.next());
		System.out.println("should be: green");
		System.out.println("");
		
		System.out.println(iter3.next());
		System.out.println("should be: green");
		System.out.println(iter3.next());
		System.out.println("should be: green");
		System.out.println(iter3.next());
		System.out.println("should be: green");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("checking iterator");
		System.out.println("checking remove()");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("original:");
		System.out.println("remove index start at 5");
		for (int i = 0; i < test.getSize(); i++) {
			if (test.getPlateAtPosition(i) != null) {
				System.out.println(test.getPlateAtPosition(i).getContents().getName());
			} else {
				System.out.println("null");
			}
		}
		System.out.println("");
		System.out.println("");
		
		iter.remove();
		
		for (int i = 0; i < test.getSize(); i++) {
			if (test.getPlateAtPosition(i) != null) {
				System.out.println(test.getPlateAtPosition(i).getContents().getName());
			} else {
				System.out.println("null");
			}
		}
		System.out.println("");
		System.out.println("");
		
		iter.next();
		iter.remove();
		
		for (int i = 0; i < test.getSize(); i++) {
			if (test.getPlateAtPosition(i) != null) {
				System.out.println(test.getPlateAtPosition(i).getContents().getName());
			} else {
				System.out.println("null");
			}
		}
		System.out.println("");
		System.out.println("");
		
		iter.next();
		iter.remove();
		iter.next();
		iter.remove();
		iter.next();
		iter.remove();
		iter.next();
		iter.remove();
		
		for (int i = 0; i < test.getSize(); i++) {
			if (test.getPlateAtPosition(i) != null) {
				System.out.println(test.getPlateAtPosition(i).getContents().getName());
			} else {
				System.out.println("null");
			}
		}

		
		for (int i = 0; i < test.getSize(); i++) {
			test.clearPlateAtPosition(i);
		}
		
		
	}
}

