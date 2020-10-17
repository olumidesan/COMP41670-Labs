package events.demo;

/**
 * @author Olumide Akinremi
 * @module COMP41670 Software Engineering
 * @date   16/10/2020.
 *
 */

import java.util.Set;

import lab2.items.Wine;
import lab2.people.Gender;
import lab2.people.Person;
import lab2.items.WineType;

import events.event.Picnic;
import events.utils.Utilities;
import events.drinker.Drinker;
import events.event.SpeedDating;


public class EventDemo {
	// Entry
	public static void main(String[] args) {
		
		// Simulate events, as requested
		simulateSuccessfulPicnic();
		System.out.println();
		simulateUnsuccessfulPicnic();
		System.out.println();
		simulateSuccessfulSpeedDating();
		System.out.println();
		simulateUnsuccessfulSpeedDating();		
	}
	
	
	public static void simulateSuccessfulSpeedDating() {
		/* 
		 * Successful speed dating event. 
		 * Male-Female ratio is 50% i.e. Males are at least 40% and 
		 * Females are at least 40%.
		*/		
		
		// Create speed dating event for at most 18 `Person`s
		SpeedDating meetNewPeople = new SpeedDating("Meet New People", 18);
		
		// Create people for the meetNewPeople event. 30% Drinkers. Balanced Gender
		Set<Person> meetNewPeopleParticipants = Utilities.createParticipants(22, 0.3, 0.5);
		
		// Implicitly add participants to waiting queue
		meetNewPeople.setParticipants(meetNewPeopleParticipants);
		
		// Allow participants into event
		meetNewPeople.openGate();
		
		// Print out event details
		Utilities.logger(meetNewPeople.toString());
	}
	
	public static void simulateUnsuccessfulSpeedDating() {
		/* 
		 * Unsuccessful speed dating event. 
		 * Male-Female ratio is 20-80%. i.e 20% are males and 80% are females.
		 */		
		
		// Create speed dating event for at most 40 `Person`s
		SpeedDating singleMingle = new SpeedDating("Single and Ready to Mingle", 40);
		
		// Create people for the singleMingle event. 10% Drinkers. Unbalanced Gender
		Set<Person> singleMingleParticipants = Utilities.createParticipants(50, 0.1, 0.2);
		
		// Implicitly add participants to waiting queue
		singleMingle.setParticipants(singleMingleParticipants);
		
		// Allow participants into event
		singleMingle.openGate();
		
		// Print out event details
		Utilities.logger(singleMingle.toString());
	}
	
	
	public static void simulateSuccessfulPicnic() {
		/* 
		 * Successful picnic, with people remaining in the queue and people
		 * inside the event. Here, 30 participants are created for the birthday.
		 * 20 will be allowed in once the gate opens and 10 will remain in the queue 
		 */		
		
		// Create picnic event for at most 20 `Person`s.
		Picnic birthday = new Picnic("My Birthday Celebration", 20);
		
		// Create people for the birthday event. 40% Drinkers, Balanced Gender
		Set<Person> birthdayParticipants = Utilities.createParticipants(30, 0.4, 0.5);
		
		// Implicitly add participants to waiting queue
		birthday.setParticipants(birthdayParticipants);
		
		// Allow participants into event
		birthday.openGate();
		
		// Print out event details
		Utilities.logger(birthday.toString());
	}
	
	public static void simulateUnsuccessfulPicnic() {
		/* 
		 * Unsuccessful picnic, with people remaining in the queue and people
		 * inside the event. Here, 10 participants are created for the anniversary.
		 * All 10 will be admitted.
		 */		
		
		// Create picnic event for at most 20 `Person`s
		Picnic anniversary = new Picnic("My Work Anniversary", 10);		
				
		// Create people for the anniversary event. 80% Drinkers. 30/70 Male-Female ratio
		Set<Person> anniversaryParticipants = Utilities.createParticipants(9, 0.8, 0.3);
		
		// Create a new drinker and add to the participants
		Person heavyDrinker = new Drinker("Napoleon", "Hill", 64, Gender.MALE);
		anniversaryParticipants.add(heavyDrinker);
		
		// Implicitly add participants to waiting queue
		anniversary.setParticipants(anniversaryParticipants);
		
		// Allow participants into event
		anniversary.openGate();
		
		// Drinker drinks 10 Rosays, making him drunk
		for (int i=0; i < 10; i++) {
			heavyDrinker.drink(new Wine(1.6, 150, 14, WineType.ROSE, "Rosay"));
		}
		
		// Print out event details
		Utilities.logger(anniversary.toString());		
	}
}
