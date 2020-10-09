/**
 * 
 */
package warehouse.weapons;

import warehouse.items.WarehouseItem;


public abstract class Weapon extends WarehouseItem {
	
	// Class attribute
	protected boolean isUsed;
	
	// Constructor
	public Weapon(double weight, String name) {
		super(weight, name);
	}
	
	
	public abstract void use();
	
	
	// Accessors and Modifiers
	// -----------------------
	
	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}	

}
