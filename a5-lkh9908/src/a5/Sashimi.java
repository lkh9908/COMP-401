package a5;

public class Sashimi implements Sushi{
	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	
	private SashimiType type;
	
	public Sashimi(SashimiType type) {
		this.type = type;
	}

	@Override
	public String getName() {
		switch(type) {
		case TUNA:
			return "tuna sashimi";
		case YELLOWTAIL:
			return "yellowtail sashimi";
		case EEL:
			return "eel sashimi";
		case CRAB:
			return "crab sashimi";
		case SHRIMP:
			return "shrimp sashimi";
		}
		return null;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		switch(type) {
		case TUNA:
			IngredientPortion[] t = new TunaPortion[1];
			t[0] = new TunaPortion(0.75);
			IngredientPortion[] resT = t.clone();
			return resT;
		case YELLOWTAIL:
			IngredientPortion[] y = new YellowtailPortion[1];
			y[0] = new YellowtailPortion(0.75);
			IngredientPortion[] resY = y.clone();
			return resY;
		case EEL:
			IngredientPortion[] e = new EelPortion[1];
			e[0] = new EelPortion(0.75);
			IngredientPortion[] resE = e.clone();
			return resE;
		case CRAB:
			IngredientPortion[] c = new CrabPortion[1];
			c[0] = new CrabPortion(0.75);
			IngredientPortion[] resC = c.clone();
			return resC;
		case SHRIMP:
			IngredientPortion[] s = new ShrimpPortion[1];
			s[0] = new ShrimpPortion(0.75);
			IngredientPortion[] resS = s.clone();
			return resS;
		}
		return null;
	}

	@Override
	public int getCalories() {
		switch(type) {
		case TUNA:
			return (int) Math.round(42 * 0.75);
		case YELLOWTAIL:
			return (int) Math.round(57 * 0.75);
		case EEL:
			return (int) Math.round(82 * 0.75);
		case CRAB:
			return (int) Math.round(37 * 0.75);
		case SHRIMP:
			return (int) Math.round(32 * 0.75);
		}
		return 0;
	}

	@Override
	public double getCost() {
		switch(type) {
		case TUNA:
			return Math.round((1.67 * 0.75) * 100.0) / 100.0;
		case YELLOWTAIL:
			return Math.round((0.74 * 0.75) * 100.0) / 100.0;
		case EEL:
			return Math.round((2.15 * 0.75) * 100.0) / 100.0;
		case CRAB:
			return Math.round((0.72 * 0.75) * 100.0) / 100.0;
		case SHRIMP:
			return Math.round((0.65 * 0.75) * 100.0) / 100.0;
		}
		return 0;
	}

	@Override
	public boolean getHasRice() {
		return false;
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
