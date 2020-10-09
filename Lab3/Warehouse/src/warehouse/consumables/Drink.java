package warehouse.consumables;

import warehouse.utils.Utilities;

public class Drink extends Consumable {
	
	// Constructor
	public Drink(double weight, String name, String expirationDate) {
		super(weight, name, expirationDate);
	}
	
	public void drink() {
		
		// Can drink only if it's not expired 
		// and it's not already consumed.
		if (!isConsumed() && !isExpired()) {
			
			Utilities.logger("Drinking " + name + "...");	
			setConsumed(true); // Confirm consumption
		}
	}

	@Override
	public String toString() {
		return String.format("Drink [isConsumed=%s, expirationDate=%s, weight=%skg, name=%s]", isConsumed, expirationDate,
				weight, name);
	}		
}
