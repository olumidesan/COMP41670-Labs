package events.drinker;

import lab2.items.Food;
import lab2.people.Gender;
import lab2.people.Person;
import lab2.items.Beverage;
import lab2.items.AlcoholicBeverage;


public class NonDrinker extends Person {
	
	private int numOfDrinks;
	
	public NonDrinker(String firstName, String lastName, double weight, Gender gender) {
		super(firstName, lastName, gender, weight);
	}
	
	public boolean eat(Food food) {
		// Yum Yum
		return true;
	}
	
	public boolean drink(Beverage beverage) {
		boolean result = false;
		
		if (!(beverage instanceof AlcoholicBeverage)) {
			result = true;
			numOfDrinks += 1;	
		}
		
		return result;
	}
	
}
