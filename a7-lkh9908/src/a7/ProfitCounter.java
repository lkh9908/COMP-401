package a7;

import a7.PlateEvent.EventType;

public class ProfitCounter implements BeltObserver {
	private double profit = 0.00;
	private int plates = 0;

	public ProfitCounter(Belt b) {
		// initialize PlateCounte
		// initialize counts of profit 
		// according to the current contents of the belt
		if (b == null) {
			throw new IllegalArgumentException();
		}

		b.addBeltObserver(this);
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) != null) {
				profit += b.getPlateAtPosition(i).getProfit();
				plates++;
			}
		};
	}

	@Override
	public void handlePlateEvent(PlateEvent e) {
		// update profit counts
		EventType event = e.getType();
		double profitHandeled = e.getPlate().getProfit();

		switch(event) {
		case PLATE_PLACED:
			profit += profitHandeled;
			plates++; break;
		case PLATE_REMOVED:
			profit -= profitHandeled;
			plates--; break;
		}
	}

	public double getTotalBeltProfit() {
		return profit;
	}

	public double getAverageBeltProfit() {
		if (plates == 0) {
			return 0;
		} else {
			return profit / plates;
		}
	}
}

