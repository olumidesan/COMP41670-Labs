package events.utils;

import java.util.Set;
import java.util.Random;
import java.util.HashSet;

import lab2.people.Gender;
import lab2.people.Person;
import events.drinker.Drinker;
import events.drinker.NonDrinker;

//Utility class to help with common tasks
public class Utilities {
	
	// Logs message to the console
	public static void logger(String logMessage) {
		System.out.println(logMessage);
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
