package lab_one;

public class Employee {

	private int year;
	private String name;
	private String address;

	public Employee(String name, int year, String address) {
		setYear(year);
		setName(name);
		setAddress(address);
	}

	public String toString() {
		return this.name + ", joined " + this.year + ", and lives in " + this.address;
	}

	public void setYear(int year) {
		// Perform validation
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public void setName(String name) {
		// Perform validation
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAddress(String address) {
		// Perform validation
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		
		// Ensure object of of type `Employee`
		if (o instanceof Employee) {
			Employee emp = (Employee) o;
			// Check attributes are the same
			return this.address == emp.getAddress() && this.year == emp.getYear() && this.name == emp.getName(); 
		}
		// If not an `Employee`
		return false;
	}

}
