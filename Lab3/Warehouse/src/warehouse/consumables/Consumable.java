package warehouse.consumables;

import java.time.LocalDate;
import warehouse.utils.Utilities;
import warehouse.items.WarehouseItem;


public abstract class Consumable extends WarehouseItem {
	
	// Class attributes
	protected boolean isConsumed;
	protected LocalDate expirationDate;
	
	// Constructor
	public Consumable(double weight, String name, String expirationDate) {
		super(weight, name);
		setConsumed(false);
		setExpirationDate(expirationDate);		
	}
	
	// Check if consumable has expired
	public boolean isExpired() {
		return Utilities.getTodaysDate().isAfter(expirationDate);
	}
	
	
	// Accessors and Modifiers
	// -----------------------
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = Utilities.parseDate(expirationDate);
	}

	public boolean isConsumed() {
		return isConsumed;
	}

	public void setConsumed(boolean isConsumed) {
		this.isConsumed = isConsumed;
	}
}
