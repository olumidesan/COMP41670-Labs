package events.drinker;

import lab2.items.Food;
import lab2.people.Gender;
import lab2.people.Person;
import lab2.items.Beverage;
import lab2.items.AlcoholicBeverage;


public class NonDrinker extends Person {
		
	public NonDrinker(String firstName, String lastName, double weight, Gender gender) {
		super(firstName, lastName, gender, weight);
	}
	
	public boolean eat(Food food) {
		// Yum Yum
		return true;
	}
	
	public boolean drink(Beverage beverage) {
		// Will drink only if beverage is non-alcoholic
		return !(beverage instanceof AlcoholicBeverage);
	}
	
}
