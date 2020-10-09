package students_registration.main;

/**
 * @author Olumide Akinremi
 * @module COMP41670 Software Engineering
 * @date   02/10/2020.
 *
 */

import java.util.Arrays;
import java.util.ArrayList;

import students_registration.module.Module;
import students_registration.student.Student;

import students_registration.utils.Utils;
import students_registration.lecturer.Lecturer;
import students_registration.student.WorkingStudent;

public class StudentsRegistrationDemo {

	public static void main(String[] args) {

		// -------------------------------
		// Begin Initialization of objects

		// Create `Student`s
		Student student1 = new Student("Tom Ford", "Lagos, Portugal", "24/08/1985", 4, true); // 4th year EU student
		Student student2 = new Student("Winona Ryder", "Woodstown, Berlin", "22/01/1989", 5, false); // 5th year Non-EU
																								 	 // student

		// Create `WorkingStudent`s
		WorkingStudent workingStudent1 = new WorkingStudent("Remi Malek", "Ballycullen, Dublin", "12/11/1996", 4, true,
				70000); // 4th year EU working student
		WorkingStudent workingStudent2 = new WorkingStudent("Joshua King", "Ringsend, Limerick", "02/11/1995", 5, false,
				170000); // 5th year Non-EU working student

		// Create `Module`s
		Module module1 = new Module("Software Engineering", "SOF41670", "Spring", 4); // 4th year module
		Module module2 = new Module("Optimization Techniques", "OPT51690", "Autumn", 5); // 5th year module

		// Create `Lecturer`s
		Lecturer lecturer1 = new Lecturer("Liliana", "Belfield, Dublin", "11/11/1990", "Computer Science");
		Lecturer lecturer2 = new Lecturer("Hassan", "Sandyford, Dublin", "03/04/1992", "ElectronicEngineering");

		// End initialization of objects
		// -----------------------------

		// Assign [different] `Lecturer`s to [different] `Module`s
		module1.setModuleCoordinator(lecturer1);
		module2.setModuleCoordinator(lecturer2);

		// Array of all `Module`s
		ArrayList<Module> allModules = new ArrayList<Module>(Arrays.asList(module1, module2));

		// Array of all `Student`s
		ArrayList<Student> allStudents = new ArrayList<Student>(
				Arrays.asList(student1, student2, workingStudent1, workingStudent2));

		// Pay fees, register students, print details
		payStudentsFees(allStudents);
		registerStudentsToModules(allStudents, allModules);
		printModuleDetails(allModules);

	}

	public static void payStudentsFees(ArrayList<Student> students) {
		// Sufficient to pay the fees for both EU and Non-EU student
		// regardless of whether or not the student works or not.
		double feesAmount = 10000;

		for (Student student : students) {
			// Polymorphically pay fees
			student.payFees(feesAmount);
		}
	}

	public static void registerStudentsToModules(ArrayList<Student> students, ArrayList<Module> modules) {
		// For each module...
		for (Module module : modules) {
			// For each student...
			for (Student student : students) {
				// Polymorphically register the student to the module
				module.registerStudent(student);
			}
		}
	}

	public static void printModuleDetails(ArrayList<Module> modules) {
		// For each module...
		for (Module module : modules) {

			// Print module Information
			Utils.logger(module.toString());

			// Print registered students' information
			Utils.logger("Students registered to module: ");
			module.printRegisteredStudents();

			// Blank space for aesthetics
			System.out.println();
		}
	}

}
