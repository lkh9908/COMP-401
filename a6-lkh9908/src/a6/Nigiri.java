package a6;

public class Nigiri implements Sushi{

	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	
	private NigiriType type;
	
	public Nigiri(NigiriType type) {
		this.type = type;
	}
	
	@Override
	public String getName() {
		switch(type) {
		case TUNA:
			return "tuna nigiri";
		case YELLOWTAIL:
			return "yellowtail nigiri";
		case EEL:
			return "eel nigiri";
		case CRAB:
			return "crab nigiri";
		case SHRIMP:
			return "shrimp nigiri";
		}
		return null;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		switch(type) {
		case TUNA:
			IngredientPortion[] t = new IngredientPortion[2];
			t[0] = new TunaPortion(0.75);
			t[1] = new RicePortion(0.5);
			IngredientPortion[] resT = t.clone();
			return resT;
		case YELLOWTAIL:
			IngredientPortion[] y = new IngredientPortion[2];
			y[0] = new YellowtailPortion(0.75);
			y[1] = new RicePortion(0.5);
			IngredientPortion[] resY = y.clone();
			return resY;
		case EEL:
			IngredientPortion[] e = new IngredientPortion[2];
			e[0] = new EelPortion(0.75);
			e[1] = new RicePortion(0.5);
			IngredientPortion[] resE = e.clone();
			return resE;
		case CRAB:
			IngredientPortion[] c = new IngredientPortion[2];
			c[0] = new CrabPortion(0.75);
			c[1] = new RicePortion(0.5);
			IngredientPortion[] resC = c.clone();
			return resC;
		case SHRIMP:
			IngredientPortion[] s = new IngredientPortion[2];
			s[0] = new ShrimpPortion(0.75);
			s[1] = new RicePortion(0.5);
			IngredientPortion[] resS = s.clone();
			return resS;
		}
		return null;
	}

	@Override
	public int getCalories() {
		switch(type) {
		case TUNA:
			return (int) Math.round((42 * 0.75) + (34 * 0.5));
		case YELLOWTAIL:
			return (int) Math.round((57 * 0.75) + (34 * 0.5));
		case EEL:
			return (int) Math.round((82 * 0.75) + (34 * 0.5));
		case CRAB:
			return (int) Math.round((37 * 0.75) + (34 * 0.5));
		case SHRIMP:
			return (int) Math.round((32 * 0.75) + (34 * 0.5));
		}
		return 0;
	}

	@Override
	public double getCost() {
		switch(type) {
		case TUNA:
			return Math.round(((1.67 * 0.75) + (0.13 * 0.5)) * 100.0) / 100.0;
		case YELLOWTAIL:
			return Math.round(((0.74 * 0.75) + (0.13 * 0.5)) * 100.0) / 100.0;
		case EEL:
			return Math.round(((2.15 * 0.75) + (0.13 * 0.5)) * 100.0) / 100.0;
		case CRAB:
			return Math.round(((0.72 * 0.75) + (0.13 * 0.5)) * 100.0) / 100.0;
		case SHRIMP:
			return Math.round(((0.65 * 0.75) + (0.13 * 0.5)) * 100.0) / 100.0;
		}
		return 0;
	}

	@Override
	public boolean getHasRice() {
		return true;
	}

	@Override
	public boolean getHasShellfish() {
		switch(type) {
		case TUNA:
			return false;
		case YELLOWTAIL:
			return false;
		case EEL:
			return false;
		case CRAB:
			return true;
		case SHRIMP:
			return true;
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		return false;
	}
}
