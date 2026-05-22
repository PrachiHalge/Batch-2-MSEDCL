package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.TransactionManager;

public class EmployeeCRUDMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee");
			System.out.println("2. Search Employee By EmployeeId");
			System.out.println("3. Delete Employee By EmployeeId");
			System.out.println("4. Update Name of Existing Employee");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				addNewEmployee(employee);
				break;
			case 2:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				getEmployeeByEmployeeId(employeeId);
				break;
			case 3:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				deleteEmployeeByEmployeeId(employeeId);
				break;
			case 4:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				System.out.println("Enter New Name");
				name = scanner.next();
//				System.out.println("Enter New Salary");
//				salary = scanner.nextDouble();
				employee = new Employee(employeeId, name, 0);
				//updateEmployee(employee);
				mergeEmployee(employee);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}

	public static void deleteEmployeeByEmployeeId(int employeeId) {
		// 1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, employeeId);

		if (existingEmployee != null) {

			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			entityTransaction.commit();
			System.out.println("Employee deleted successfully!");
		} else {
			System.out.println("Invalid EmployeeId");
		}
		entityManager.close();
		// 6. Close EntityManager
	}

	public static void updateEmployee(Employee employee) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, employee.getEmployeeId());
		if (existingEmployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			existingEmployee.setName(employee.getName()); // update
			existingEmployee.setSalary(employee.getSalary()); // update
			entityTransaction.commit();
			System.out.println("Employee updated successfully");
		} else
			System.out.println("Invalid EmployeeId");
		entityManager.close();

	}

	public static void mergeEmployee(Employee employee) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, employee.getEmployeeId());
		employee.setSalary(existingEmployee.getSalary());
		if (existingEmployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			System.out.println("Employee updated successfully");
		} else
			System.out.println("Invalid EmployeeId");
		entityManager.close();

	}

	public static void getEmployeeByEmployeeId(int employeeId) {
		// 1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. Get employee from database
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null)
			System.out.println(employee);
		else
			System.out.println("Invalid EmployeeId");

		// 3. Close EntityManager object
		entityManager.close();
	}

	public static void addNewEmployee(Employee employee) {

		// Entity States : 1. Transient , 2. Persistent 3. Detached 4. Removed

		// employee - Transient

		// 1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. Create Transaction object
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// 3. Start Transaction
		entityTransaction.begin(); // start

		// 4. Save employee object into database
		entityManager.persist(employee); // Persistent
//		employee.setName("New Name"); // Invalid State exception
		// 5. Commit Transaction
		entityTransaction.commit(); // commited
		entityTransaction.commit(); //??
		employee.setName("Updated Name"); // Detached
		// 6. Close EntityManager
		entityManager.close(); 

		System.out.println("Employee Created, with employeeId = " + employee.getEmployeeId());
		System.out.println("Name :: " + employee.getName());
	}
}
