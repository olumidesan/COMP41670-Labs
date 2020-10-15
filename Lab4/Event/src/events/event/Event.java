package events.event;


import lab2.people.*;

import java.util.Set;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;


public abstract class Event {
	 
	protected String name;
	protected int maxNumOfParticipants;
	protected Set<Person> participants = new HashSet<Person>();
	protected Queue<Person> waitingQueue = new LinkedList<Person>();
	
	public Event (String name, int maxNumOfParticipants) {
		this.name = name;
		this.maxNumOfParticipants = maxNumOfParticipants;
	}
	
	
	public void addParticipant (Person participant) {
		waitingQueue.add(participant);
	}
	
	public void openGate() {
		while (participants.size() != maxNumOfParticipants) {
			participants.add(waitingQueue.remove());
		}
	}
	
	public abstract boolean isSuccessful();
	
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


	public void setParticipants(Set<Person> participants) {
		for (Person participant : participants) {
			addParticipant(participant);
		}
	}


	public Queue<Person> getWaitingQueue() {
		return waitingQueue;
	}
	
}
