package events.event;

import lab2.people.Person;
import lab2.people.Gender;
import events.drinker.Drinker;


public class SpeedDating extends Event {

	public SpeedDating (String name, int maxNumOfParticipants) {
		super(name, maxNumOfParticipants);
	}
	
	
	
	@Override
	public boolean isSuccessful() {
		int numOfMales = 0;
		boolean result = true;
		
		// Use males to check percentage threshold
		// as there are only two genders. Any one 
		// would suffice.
		for (Person participant : participants) {
			if (participant.getGender() == Gender.MALE) {
				numOfMales += 1;
			}
		}
		
		// If male percentage is less than 40%, then female
		// percentage is greater than 60%. 
		// Essentially, this ensures neither genders have a
		// percentage less than 40%. 
		if (((numOfMales / participants.size()) * 100) < 40) {
			result = false;
		}
		
		return result;
	}
}
