package warehouse.demo;

import warehouse.weapons.Gun;
import warehouse.weapons.Bomb;
import warehouse.consumables.Food;
import warehouse.consumables.Drink;
import warehouse.items.WarehouseItem;

public class WarehouseDemo {
	public static void main(String[] args) {
		
		// Initialize objects
		Gun rifle = new Gun(2.5, "Rifle");
		Gun pistol = new Gun(1.7, "Pistol");
		
		Bomb grenade = new Bomb(1.2, "Grenade");
			
		Food yam = new Food(0.1, "Yam", "11/09/2021");
		Food bread = new Food(0.05, "Bread", "10/08/2021");
		
		Drink beer = new Drink(0.06, "Beer", "12/10/2021");
		Drink wine = new Drink(0.08, "Wine", "02/01/2022");
		
		
		// Set constraints
		yam.setExpirationDate("12/02/2019");
		wine.setExpirationDate("05/05/2005");
		
		pistol.setNumberOfBullets(0);
		rifle.setNumberOfBullets(300);
		
		
		// Create warehouse
		WarehouseItem[] warehouseItems = {yam, bread, beer, wine, grenade, rifle, pistol};
		Warehouse warehouse = new Warehouse(warehouseItems);
		
		
		// Sort then print
		warehouse.sortItems();
		warehouse.printItems();
	}
}