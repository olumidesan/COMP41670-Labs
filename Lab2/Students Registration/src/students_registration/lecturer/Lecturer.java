package students_registration.lecturer;

import students_registration.person.Person;

public class Lecturer extends Person {
	
	// Class attribute
	private String school;
	
	// Constructor
	public Lecturer(String name, String address, String dateOfBirth, String school) {
		super(name, address, dateOfBirth);
		setSchool(school);
	}
	
	// String representation of class
	@Override
	public String toString() {
		return String.format("Lecturer [school=%s, name=%s, address=%s, dateOfBirth=%s]", school, name, address,
				dateOfBirth);
	}
	
	// Accessors and Modifiers
	// -----------------------
	
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
