package events.event;

import lab2.people.*;
import java.util.Set;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;


public abstract class Event {
	
	// Class attributes
	protected String name;
	protected int maxNumOfParticipants;
	
	// No duplicate participant -- hence, a `Set`
	protected Set<Person> participants = new HashSet<Person>();
	
	// First come first serve (FIFO) for waiting queue
	protected Queue<Person> waitingQueue = new LinkedList<Person>();
	
	
	// Constructor
	public Event (String name, int maxNumOfParticipants) {
		setName(name);
		setMaxNumOfParticipants(maxNumOfParticipants);
	}
	
	// Adds a participant (`Person`) to the waiting queue
	public void addParticipant (Person participant) {
		waitingQueue.add(participant);
	}
	
	// Allows people in the waiting queue to join the `Event`
	// up to the maximum capacity
	public void openGate() {
		while (participants.size() < maxNumOfParticipants) {
			// Exit if queue is empty
			if (waitingQueue.size() == 0) break;
			
			// Allow into event the next in line
			participants.add(waitingQueue.remove());
		}
	}
	
	// Abstract method to be implemented
	public abstract boolean isSuccessful();
	
	// Print event details
	@Override
	public String toString() {
		// Dynamically get the name of the class. e.g `Event`
		// `Picnic` or `SpeedDating`.
		String eventType = this.getClass().getSimpleName();
		
		// Details to print out
		String eventName = name + " " + eventType + " Event:";
		String maxAttendees = "\n\tMaximum Attendees: " + maxNumOfParticipants;
		String attendees = "\n\tAttendees (" + participants.size() + "): " + participants.toString();
		String queue = "\n\tWaiting Queue (" + waitingQueue.size() + "): " + waitingQueue.toString();
		String successful = "\n\tIs " + eventType + " event successful? " + (isSuccessful() ? "Yes" : "No");
		
		return eventName + maxAttendees + attendees + queue + successful;
	}
	
	
	// Accessors and Modifiers
	// -----------------------
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMaxNumOfParticipants() {
		return maxNumOfParticipants;
	}


	public void setMaxNumOfParticipants(int maxNumOfParticipants) {
		this.maxNumOfParticipants = maxNumOfParticipants;
	}


	public Set<Person> getParticipants() {
		return participants;
	}
	

	public Queue<Person> getWaitingQueue() {
		return waitingQueue;
	}
	
	
	// Setting participants adds the passed people to the 
	// waiting queue. When the gate is then opened, they
	// are allowed into the `Event`.
	public void setParticipants(Set<Person> participants) {
		for (Person participant : participants) {
			addParticipant(participant);
		}
	}
	
}
