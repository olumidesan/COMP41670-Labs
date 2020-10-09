package students_registration.module;

import java.util.Arrays;
import java.util.ArrayList;

import students_registration.utils.Utils;
import students_registration.student.Student;
import students_registration.lecturer.Lecturer;

public class Module {

	// Class attributes
	private int year;
	private String name;
	private String code;
	private String semester;
	private Lecturer moduleCoordinator;
	
	// Number of registered students in the module
	private static int registeredStudents;

	// Array of registered students
	private ArrayList<Student> studentsRegistered = new ArrayList<Student>();

	// Array representing semesters the module is taught. Doesn't change.
	public static final ArrayList<String> SEMESTERS = new ArrayList<String>(
			Arrays.asList("AUT", "AUTUMN", "SPR", "SPRING", "SUM", "SUMMER"));

	// Constructor
	public Module(String name, String code, String semester, int year) {
		setYear(year);
		setName(name);
		setCode(code);
		setSemester(semester);
	}

	public void registerStudent(Student student) {
		boolean classNotFull = registeredStudents < 50;
		boolean canRegister = student.isFeesPaid() && (student.getYearOfStudy() == year);

		// If module isn't full and student can register,
		// register student and increment registered students.
		if (classNotFull && canRegister) {
			studentsRegistered.add(student);
			registeredStudents += 1;
		}
	}

	public void printRegisteredStudents() {
		// For each student, print out his/her information
		for (Student student : studentsRegistered) {
			System.out.print('\t');
			Utils.logger(student.toString());
		}
	}

	// String representation of class
	public String toString() {
		return String.format("Module [year=%s, name=%s, code=%s, semester=%s, moduleCoordinator=%s]", year, name, code,
				semester, moduleCoordinator);
	}
	

	// Accessors and Modifiers
	// -----------------------

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSemester() {
		return semester;
	}

	public void setModuleCoordinator(Lecturer moduleCoordinator) {
		this.moduleCoordinator = moduleCoordinator;
	}
	
	public Lecturer getModuleCoordinator() {
		return moduleCoordinator;
	}

	public static int getRegisteredStudents() {
		return registeredStudents;
	}
	
	public void setSemester(String semester) {
		// `semester` passed must be in array of `SEMESTERS`
		if (SEMESTERS.contains(semester.toUpperCase())) {
			this.semester = semester.toUpperCase();
		} else {
			Utils.logger("Semester is invalid. Semester must be one of Spring, Summer, or Autumn");
			throw new IllegalArgumentException();
		}
	}

}
