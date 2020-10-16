package events.demo;

import java.util.Set;
import java.util.Random;
import java.util.HashSet;

import lab2.items.Wine;
import lab2.people.Gender;
import lab2.people.Person;
import lab2.items.WineType;

import events.event.Picnic;
import events.drinker.Drinker;
import events.event.SpeedDating;
import events.drinker.NonDrinker;


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
		Set<Person> meetNewPeopleParticipants = createParticipants(22, 0.3, 0.5);
		
		// Implicitly add participants to waiting queue
		meetNewPeople.setParticipants(meetNewPeopleParticipants);
		
		// Allow participants into event
		meetNewPeople.openGate();
		
		// Print out event details
		System.out.println(meetNewPeople.toString());
	}
	
	public static void simulateUnsuccessfulSpeedDating() {
		/* 
		 * Unsuccessful speed dating event. 
		 * Male-Female ratio is 20-80%. i.e 20% are males and 80% are females.
		 */		
		
		// Create speed dating event for at most 40 `Person`s
		SpeedDating singleMingle = new SpeedDating("Single and Ready to Mingle", 40);
		
		// Create people for the singleMingle event. 10% Drinkers. Unbalanced Gender
		Set<Person> singleMingleParticipants = createParticipants(50, 0.1, 0.2);
		
		// Implicitly add participants to waiting queue
		singleMingle.setParticipants(singleMingleParticipants);
		
		// Allow participants into event
		singleMingle.openGate();
		
		// Print out event details
		System.out.println(singleMingle.toString());
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
		Set<Person> birthdayParticipants = createParticipants(30, 0.4, 0.5);
		
		// Implicitly add participants to waiting queue
		birthday.setParticipants(birthdayParticipants);
		
		// Allow participants into event
		birthday.openGate();
		
		// Print out event details
		System.out.println(birthday.toString());
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
		Set<Person> anniversaryParticipants = createParticipants(9, 0.8, 0.3);
		
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
		System.out.println(anniversary.toString());		
	}
		
	
	// Helper method to create a number of participants, along
	// with a `dndRatio` and `genderRatio`, which is used to divide
	// the returned participants into their respective categories.
	// `dndRatio` => drinker-non-drinker ratio
	// `genderRatio` => male-female ratio
	public static Set<Person> createParticipants(int num, double dndRatio, double genderRatio) {
		
		Random randomizer = new Random(); // Random object
		Set<Person> participants = new HashSet<Person>(); // Storage
		double[] weights = {60.5, 76.8, 88.2, 90, 55.2, 72, 76, 98.6, 77.3}; // Weights of people (in kg)
		
		for (int i=0; i < num; i++) {
			int index = i + 1;
			Person participant;
			double ratio = (double) i/num;
			
			// Constructor variables
			Gender gender;
			String lastName = "MyLastName__" + index; // Dynamic last name
			String firstName = "MyFirstName__" + index; // Dynamic first name
			double weight = weights[randomizer.nextInt(weights.length)]; // Get random weight
			
			// Create gender based on ratio required
			if (ratio <= genderRatio) gender = Gender.MALE; 
			else gender = Gender.FEMALE;
			
			// Create either a drinker or non-drinker
			if (ratio <= dndRatio) participant = new Drinker(firstName, lastName, weight, gender);
			else participant = new NonDrinker(firstName, lastName, weight, gender);
			
			// Add to set of participants
			participants.add(participant);
		}
		
		return participants;
	}
}
