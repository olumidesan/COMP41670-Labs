package students_registration.student;

import students_registration.person.Person;

public class Student extends Person {
	
	// Class attributes
	protected double fees;
	protected boolean isEU;
	protected int yearOfStudy;
	
	// Initially no student has paid fees
	protected boolean feesPaid = false;
	
	
	// Constructor
	public Student(String name, String address, String dateOfBirth, int yearOfStudy, boolean isEU) {
		super(name, address, dateOfBirth);
		setEU(isEU);
		setYearOfStudy(yearOfStudy);
		
		// Calculate fees after instantiation
		calculateFees();
	}
	
	protected void calculateFees() {
		double feesToPay = isEU ? 3000 : 6000;
		setFees(feesToPay);
	}
	
	public void payFees(double feeDeposit) {
		// Fees is paid if deposit is greater than
		// or equal to the fees required -- `fees`.
		boolean feesIsPaid = feeDeposit >= fees;
		setFeesPaid(feesIsPaid);
	}
	
	// String representation of class
	@Override
	public String toString() {
		return String.format(
				"Student [fees=%s, isEU=%s, yearOfStudy=%s, feesPaid=%s, name=%s, address=%s, dateOfBirth=%s]", fees,
				isEU, yearOfStudy, feesPaid, name, address, dateOfBirth);
	}
	
	
	// Accessors and Modifiers
	// -----------------------
	
	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public boolean isEU() {
		return isEU;
	}

	public void setEU(boolean isEU) {
		this.isEU = isEU;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public boolean isFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(boolean feesPaid) {
		this.feesPaid = feesPaid;
	}

}
