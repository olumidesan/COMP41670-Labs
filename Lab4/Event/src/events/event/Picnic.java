package events.event;

import lab2.people.Person;
import events.drinker.Drinker;

public class Picnic extends Event {
	
	// Constructor
	public Picnic (String name, int maxNumOfParticipants) {
		super(name, maxNumOfParticipants);
	}
	
	
	// Fulfil abstract contract
	public boolean isSuccessful() {
		boolean result = true; // Temp
		
		// For each participant...
		for (Person participant : participants) {
			// If the participant drinks alcohol
			if (participant instanceof Drinker) {
				// Check if [s]he is drunk
				if (((Drinker) participant).isDrunk()) {
					result = false;		
					break; // No need to continue
				}
			}
		}
		
		return result;
	}
	
}
