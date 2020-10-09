package students_registration.student;

public class WorkingStudent extends Student {

	// Class attributes
	private double salary;

	// Salary upper and lower limits. Doesn't change
	public static final double SALARY_LOWER_LIMIT = 50000;
	public static final double SALARY_UPPER_LIMIT = 100000;

	// Constructor
	public WorkingStudent(String name, String address, String dateOfBirth, int yearOfStudy, boolean isEU,
			double salary) {
		super(name, address, dateOfBirth, yearOfStudy, isEU);
		setSalary(salary);

		// Calculate fees after instantiation
		calculateFees();
	}

	@Override
	public void calculateFees() {
		double feesToPay = isEU ? 3000 : 6000;
		double workingTax = (SALARY_LOWER_LIMIT <= salary && salary <= SALARY_UPPER_LIMIT) ? 1000 : 2000;

		// Add working tax to fees
		feesToPay += workingTax;

		setFees(feesToPay);
	}

	// String representation of class
	@Override
	public String toString() {
		return String.format(
				"WorkingStudent [salary=%s, fees=%s, isEU=%s, yearOfStudy=%s, feesPaid=%s, name=%s, address=%s, dateOfBirth=%s]",
				salary, fees, isEU, yearOfStudy, feesPaid, name, address, dateOfBirth);
	}

	// Accessors and Modifiers
	// -----------------------

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
