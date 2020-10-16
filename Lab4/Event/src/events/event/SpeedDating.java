package events.event;

import lab2.people.Person;
import lab2.people.Gender;


public class SpeedDating extends Event {
	
	// Constructor
	public SpeedDating (String name, int maxNumOfParticipants) {
		super(name, maxNumOfParticipants);
	}
	
	// Fulfil abstract contract
	public boolean isSuccessful() {
		int numOfMales = 0;
		boolean result = true; // Temp
		double successThreshold = 40.0; // 40%
		
		// Use males to check percentage threshold
		// as there are only two genders. Any of
		// male or female will suffice.
		for (Person participant : participants) {
			if (participant.getGender() == Gender.MALE) {
				numOfMales += 1;
			}
		}
		
		// If male percentage is less than 40%, then female
		// percentage is greater than 60%. Essentially, this 
		// ensures neither genders have a percentage less than 40%. 
		double perc = ((double) numOfMales / participants.size() * 100.0);
		if (perc < successThreshold) result = false;
		
		return result;
	}
}
