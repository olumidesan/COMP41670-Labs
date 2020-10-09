package students_registration.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import students_registration.module.Module;
import students_registration.student.Student;
import students_registration.lecturer.Lecturer;
import students_registration.student.WorkingStudent;

// Basic testing of the StudentRegistration features
class TestStudentRegistration {
	
	private Module module1;
	private Lecturer lecturer1;

	private Student student1;
	private Student student2;

	private WorkingStudent workingStudent1;
	private WorkingStudent workingStudent2;

	
	@BeforeEach
	void setUp() throws Exception {
		// Set up test objects
		student1 = new Student("Tom Ford", "Lagos, Portugal", "24/08/1985", 4, true);
		student2 = new Student("Winona Ryder", "Woodstown, Berlin", "22/01/1989", 5, false); 

		workingStudent1 = new WorkingStudent("Remi Malek", "Ballycullen, Dublin", "12/11/1996", 4, true, 70000);
		workingStudent2 = new WorkingStudent("Joshua King", "Ringsend, Limerick", "02/11/1995", 5, false, 170000); 
		
		module1 = new Module("Software Engineering", "SOF41670", "Spring", 4);
		lecturer1 = new Lecturer("Liliana", "Belfield, Dublin", "11/11/1990", "Computer Science");

	}

	// `Module` Tests
	// --------------
	@Test
	public void testSetSemester() {
		module1.setSemester("Autumn");
		assertEquals(module1.getSemester(), "AUTUMN");
	}
	
	@Test
	public void testSetModuleCoordinator() {
		module1.setModuleCoordinator(lecturer1);
		assertEquals(module1.getModuleCoordinator(), lecturer1);
	}
	
	@Test
	public void testRegisterStudentFail() {
		// Student1 hasn't paid fees
		module1.registerStudent(student1);
		assertTrue(Module.getRegisteredStudents() == 0);
	}
	
	@Test
	public void testRegisterStudentSuccess() {
		student2.payFees(100000); // Pay student's fees
		student2.setYearOfStudy(4); // Set year of study
		
		// New dummy module
		Module newModule = new Module("Finance in Art", "FIA42008", "Summer", 4);
		
		newModule.registerStudent(student2);
		assertTrue(Module.getRegisteredStudents() > 0);
	}
	
	@Test
	public void testMaximum50Students() {
		
		int numOfStudentsToRegister = 100;
		
		student2.payFees(100000); // Pay student's fees
		student2.setYearOfStudy(4); // Set year of study
		module1.setYear(4); // Set year module is taught
		
		// Register 100 students (using the same `student`
		// for brievity).
		for (int i=0; i <= numOfStudentsToRegister; i++) {
			module1.registerStudent(student2); 
		}
		
		// Only 50 are registered. (Class is full)
		assertEquals(Module.getRegisteredStudents(), 50);
	}
	
	// `Lecturer` Tests
	// ----------------
	@Test
	public void testGetSchool() {
		assertNotNull(lecturer1.getSchool());
	}
	
	
	// `WorkingStudent` Tests
	// ----------------------
	@Test
	public void testWorkingStudentSalary() {
		assertEquals(workingStudent1.getSalary(),70000);
	}

	@Test
	public void testEUWorkingStudentCalculateFees() {
		// (EU student fees) + 1000
		assertEquals(workingStudent1.getFees(), 4000);
	}

	@Test
	public void testNonEUWorkingStudentCalculateFees() {
		// (NonEU student fees) + 2000
		assertEquals(workingStudent2.getFees(), 8000);
	}

	
	// `Student` Tests
	// ---------------
	@Test
	public void testStudentYearOfStudy() {
		assertNotNull(student1.getYearOfStudy());
	}

	@Test
	public void testStudentPayFees() {
		student1.payFees(100000);
		assertTrue(student1.isFeesPaid());
	}

	@Test
	public void testStudentCalculateFees() {
		assertNotNull(student1.getFees());
	}

	@Test
	public void testSystemNonEUFees() {
		assertEquals(student2.getFees(), 6000);
	}

	@Test
	public void testSystemEUFees() {
		assertEquals(student1.getFees(), 3000);
	}

}
