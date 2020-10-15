package events.event;

import lab2.people.Person;
import events.drinker.Drinker;

public class Picnic extends Event {

	public Picnic (String name, int maxNumOfParticipants) {
		super(name, maxNumOfParticipants);
	}
	
	@Override
	public boolean isSuccessful() {
		boolean result = true;
		
		for (Person participant : participants) {
			if (participant instanceof Drinker) {
				if (((Drinker) participant).isDrunk()) {
					result = false;				
				}
			}
		}
		
		return result;
	}
	
}
