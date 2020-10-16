package events.drinker;

import lab2.items.Food;
import lab2.people.Person;
import lab2.people.Gender;
import lab2.items.Beverage;
import lab2.items.AlcoholicBeverage;

public class Drinker extends Person {

	private int numOfAlcoholicDrinks;

	public Drinker(String firstName, String lastName, double weight, Gender gender) {
		super(firstName, lastName, gender, weight);
	}
	
	public boolean eat(Food food) {
		// Yum Yum
		return true;
	}
	
	public boolean drink(Beverage beverage) {
		// Increment number of drinks if beverage is alcoholic
		if (beverage instanceof AlcoholicBeverage) numOfAlcoholicDrinks += 1;
		return true;
	}
	
	public boolean isDrunk() {
		return numOfAlcoholicDrinks > (weight / 10);
	}
}
