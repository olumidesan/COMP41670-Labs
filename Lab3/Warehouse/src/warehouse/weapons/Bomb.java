package warehouse.weapons;

import warehouse.utils.Utilities;

public class Bomb extends Weapon {
	
	// Constructor
	public Bomb(double weight, String name) {
		super(weight, name);
	}
	
	// Fulfil abstract class contract
	public void use() {
		
		// Use only if not already used
		if (!isUsed()) {
			Utilities.logger("Boom!!!"); // Bomb sound			
			setUsed(true); // `Bomb`s can only be used once
		}
	}

	@Override
	public String toString() {
		return String.format("Bomb [isUsed=%s, weight=%s, name=%s]", isUsed, weight, name);
	}
	
}
