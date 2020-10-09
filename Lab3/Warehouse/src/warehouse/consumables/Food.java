package warehouse.consumables;

import warehouse.utils.Utilities;

public class Food extends Consumable {
	
	// Constructor
	public Food(double weight, String name, String expirationDate) {
		super(weight, name, expirationDate);
	}
	
	public void eat() {
		
		// Can eat only if it's not expired 
		// and it's not already consumed.
		if (!isConsumed() && !isExpired()) {
			
			Utilities.logger("Eating " + name + "...");	
			setConsumed(true); // Confirm consumption
		}
	}

	@Override
	public String toString() {
		return String.format("Food [isConsumed=%s, expirationDate=%s, weight=%skg, name=%s]", isConsumed, expirationDate,
				weight, name);
	}	
}
