package lab_one;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee = new Employee("Oluchi Umesegha", 2019, "Tallaght, Dublin. D24YY88");
		Employee employee2 = new Employee("Olumide Akinremi", 2019, "Ballycullen, Dublin. D16PP28");
		
		System.out.printf("Employee details: %s.", employee.toString());
		System.out.println();
		System.out.printf("Employees are equal? %s.", employee.equals(employee2));
	}

}
