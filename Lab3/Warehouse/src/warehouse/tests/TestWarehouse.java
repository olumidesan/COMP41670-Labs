package warehouse.tests;

import org.junit.jupiter.api.Test;

import warehouse.items.WarehouseItem;
import warehouse.consumables.Drink;
import warehouse.consumables.Food;
import warehouse.demo.Warehouse;
import warehouse.weapons.Bomb;
import warehouse.weapons.Gun;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

// Basic testing of the Warehouse features
class TestWarehouse {

	private Food yam;
	private Food bread;
	
	private Gun rifle;
	private Gun pistol;

	private Drink beer;
	private Drink wine;

	private Bomb grenade;
	
	private Warehouse warehouse;
	
	@BeforeEach
	void setUp() throws Exception {
		// Set up test objects
		rifle = new Gun(2.5, "Rifle");
		pistol = new Gun(1.7, "Pistol");
		
		grenade = new Bomb(1.2, "Grenade");
		
		beer = new Drink(0.06, "Beer", "12/10/2021");
		wine = new Drink(0.08, "Wine", "02/01/2022");
			
		yam = new Food(0.1, "Yam", "11/09/2021");
		bread = new Food(0.05, "Bread", "10/12/2021");
		
		WarehouseItem[] warehouseItems = {yam, bread, beer, wine, grenade, rifle, pistol};
		warehouse = new Warehouse(warehouseItems);
		
	}
	
	// `Weapon` Tests
	@Test
	public void testBombUse() {
		grenade.use();
		assertTrue(grenade.isUsed());
	}
	
	
	@Test
	public void testGunUse() {
		rifle.setNumberOfBullets(1);
		rifle.use();
		assertTrue(rifle.isUsed());
	}
	
	// `Consumable` Tests
	// -----------------
	@Test
	public void testConsumableIsConsumed() {
		bread.eat();
		assertTrue(bread.isConsumed());
	}
	
	@Test
	public void testConsumableIsExpired() {
		yam.setExpirationDate("21/03/2003");
		assertTrue(yam.isExpired());
	}
	
	// `Warehouse` Tests
	// -----------------
	@Test
	public void testGetTotalInventory() {
		assertEquals(warehouse.getTotalInventory(), 7);
	}
	
	@Test
	public void testBubbleSortLastElement() {
		warehouse.sortItems(); // Sort items
		int totalNumberOfItems = warehouse.getTotalInventory();
		
		WarehouseItem heaviestItem = warehouse.getItems()[totalNumberOfItems - 1]; // Get the heaviest item
		assertEquals(heaviestItem, rifle);
	}
	
	@Test
	public void testBubbleSortFirstElement() {
		warehouse.sortItems(); // Sort items
	
		WarehouseItem lightestItem = warehouse.getItems()[0]; // Get the heaviest item
		assertEquals(lightestItem, bread);
	}
}
