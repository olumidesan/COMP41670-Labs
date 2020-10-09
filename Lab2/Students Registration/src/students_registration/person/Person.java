package students_registration.person;

import java.time.LocalDate;
import students_registration.utils.Utils;

public class Person {
	
	// Class attributes
	protected String name;
	protected String address;
	protected LocalDate dateOfBirth;
	
	// Constructor
	public Person(String name, String address, String dateOfBirth) {
		setName(name);
		setAddress(address);
		setDateOfBirth(dateOfBirth);
	}
	
	// Accessors and Modifiers
	// -----------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = Utils.parseDate(dateOfBirth);
	}
}
