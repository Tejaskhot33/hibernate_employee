package hibernate_employee;

import java.util.Scanner;

public class EmployeeController {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Employee employee = new Employee();
		Employee_Dao dao = new Employee_Dao();

		System.out.println(
				" 1.save the employee \n2.update the employee \n3.delete the  employee \n4.find employee by id \n5.find by phone \n6.Update emplopyee  phone \n7.update employee address \n8.update employee name \n.9 delete phone");
		int choice = (scanner.nextInt());

		switch (choice) {

		case 1: {
			System.out.println("Enter the id");
			employee.setId(scanner.nextInt());

			System.out.println("Enter the name");
			employee.setName(scanner.next());

			System.out.println("Enter the salary");
			employee.setSalary(scanner.nextDouble());

			System.out.println("Enter the phone");
			employee.setPhone(scanner.nextLong());

			System.out.println("Enter the address");
			employee.setAddress(scanner.next());

			dao.createUser(employee);
			break;
		}
		case 2: {
			System.out.println("Enter the id");
			employee.setId(scanner.nextInt());

			System.out.println("Enter the update name");
			employee.setName(scanner.next());

			System.out.println("Enter the update salary");
			employee.setSalary(scanner.nextDouble());

			System.out.println("Enter the update phone");
			employee.setPhone(scanner.nextLong());

			System.out.println("Enter the update address");
			employee.setAddress(scanner.next());

			dao.updateEmployee(employee, employee.getId());
			break;
		}
		case 3: {
			System.out.println("Enter the id to deleted");
			employee.setId(scanner.nextInt());

			dao.deleteAddress(employee, employee.getId());
			break;
		}
		case 4: {
			System.out.println("Enter the id ");
			employee.setId(scanner.nextInt());

			dao.findById(employee.getId());
			break;
		}
		case 5: {
			System.out.println("Enter the phone");
			employee.setPhone(scanner.nextLong());

			dao.findByPhone(employee.getPhone());
			break;
		}
		case 6: {
			System.out.println("Enter the id");
			employee.setId(scanner.nextInt());

			System.out.println("enter the phone");
			employee.setPhone(scanner.nextLong());

			dao.updatePhone(employee.getId(), employee.getPhone());
			break;
		}
		case 7: {
			System.out.println("Enter the id");
			employee.setId(scanner.nextInt());

			System.out.println("enter the address");
			employee.setAddress(scanner.next());

			dao.updateAddress(employee.getId(), employee.getAddress());
			break;

		}
		case 8: {
			System.out.println("Enter the id");
			employee.setId(scanner.nextInt());

			System.out.println("Enter the name");
			employee.setName(scanner.next());

			dao.updateName(employee.getId(), employee.getName());
			break;
		}
		case 9: {
			System.out.println("Enter the phone");
			employee.setPhone(scanner.nextLong());

			dao.deletePhone(employee.getPhone());
			break;
		}
		case 10: {
			System.out.println("Enter the address");
			employee.setAddress(scanner.next());
			
			dao.deleteAddress(employee.getAddress());
			break;
		}
		}

	}
}
