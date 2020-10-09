package warehouse.demo;

import warehouse.weapons.Weapon;
import warehouse.utils.Utilities;
import warehouse.consumables.Food;
import warehouse.consumables.Drink;
import warehouse.items.WarehouseItem;

public class Warehouse {
	
	// Class attribute
	private WarehouseItem items[];
	
	// Constructor
	public Warehouse(WarehouseItem[] items) {
		setItems(items);
	}
 
	// [Bubble] Sort in ascending order
	public void sortItems() {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - 1; j++) {
				if (items[j].compareTo(items[j + 1]) > 0) {
					WarehouseItem tempItem = items[j + 1];
					items[j + 1] = items[j];
					items[j] = tempItem;
				}
			}
		}
	}
	
	// Polymorphically print out warehouse items' attributes
	public void printItems() {
		for (WarehouseItem item : items) {
			Utilities.logger(item.toString());
			if (item instanceof Food) ((Food)item).eat();
			if (item instanceof Drink) ((Drink)item).drink();
			if (item instanceof Weapon) ((Weapon)item).use();
		}
	}

	
	// Accessors and Modifiers
	// -----------------------
	
	public WarehouseItem[] getItems() {
		return items;
	}

	public void setItems(WarehouseItem[] items) {
		this.items = items;
	}

}
