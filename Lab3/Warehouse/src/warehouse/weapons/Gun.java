package warehouse.weapons;

import warehouse.utils.Utilities;

public class Gun extends Weapon {
	
	// Class attribute
	private int numberOfBullets;
	
	// Constructor
	public Gun(double weight, String name) {
		super(weight, name);
	}
	
	// Fulfil abstract class contract
	public void use() {
		
		// Use only if not already used
		if (!isUsed()) {
			
			Utilities.logger("Bang!"); // Gun sound
			numberOfBullets -= 1; // Decrement number of bullets
			
			// Check if bullets have been exhausted
			// and, if yes, set the gun to used.
			if (numberOfBullets < 1) setUsed(true);
		}
	}
	

	@Override
	public String toString() {
		return String.format("Gun [numberOfBullets=%s, isUsed=%s, weight=%skg, name=%s]", numberOfBullets, isUsed, weight,
				name);
	}
	
	// Accessors and Modifiers
	// -----------------------

	public int getNumberOfBullets() {
		return numberOfBullets;
	}

	public void setNumberOfBullets(int numberOfBullets) {
		// Prevent setting a negative number of bullets
		this.numberOfBullets = numberOfBullets >= 0 ? numberOfBullets : 0;
		
		if (this.numberOfBullets == 0) setUsed(true);
		else setUsed(false);
	}
	
}
