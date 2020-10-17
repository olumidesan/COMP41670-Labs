package events.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import lab2.items.Wine;
import lab2.people.Gender;
import lab2.items.WineType;
import events.event.Picnic;
import events.utils.Utilities;
import events.drinker.Drinker;
import events.event.SpeedDating;
import events.drinker.NonDrinker;


// Basic testing of the Event features
class TestEvent {

	@Test
	void testWaitingQueue() {
		Picnic picnic = new Picnic("Family Lunch", 6);
		// Add 20 people to waiting queue
		picnic.setParticipants(Utilities.createParticipants(20, 0.3, 0.4));
		assertEquals(picnic.getWaitingQueue().size(), 20);
	}
	
	@Test
	void testOpenGate() {
		SpeedDating tinder = new SpeedDating("Tinder Get-Together", 6);
		// Add 20 people to waiting queue
		tinder.setParticipants(Utilities.createParticipants(20, 0.3, 0.4));
		// Only 6 people are allowed, leaving 14 in waiting queue
		tinder.openGate();
		assertEquals(tinder.getWaitingQueue().size(), 14);
	}
	
	
	@Test
	void testHeavyDrinkerIsDrunk() {
		Drinker heavyDrinker = new Drinker("Sharon", "Stone", 65, Gender.FEMALE);
		
		// heavy drinker drinks 10 Rosays, making her drunk
		for (int i=0; i < 10; i++) {
			heavyDrinker.drink(new Wine(1.6, 150, 14, WineType.ROSE, "Rosay"));
		}
		
		assertTrue(heavyDrinker.isDrunk());
	}
	
	@Test
	void testDrinker() {
		Drinker drinker = new Drinker("Jack", "Jones", 95, Gender.MALE);
		boolean didDrink = drinker.drink(new Wine(1.9, 300, 45, WineType.RED, "Pinot Noir"));
		assertTrue(didDrink);
	}
	
	@Test
	void testNonDrinker() {
		NonDrinker nonDrinker = new NonDrinker("Jake", "Jones", 85, Gender.MALE);
		boolean didDrink = nonDrinker.drink(new Wine(0.9, 300, 25, WineType.WHITE, "Ciroc"));
		assertFalse(didDrink);
	}

}
