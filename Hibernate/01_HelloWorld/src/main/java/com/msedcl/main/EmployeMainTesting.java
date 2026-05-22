package com.msedcl.main;

import java.util.List;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeMainTesting {
	public static void main(String[] args) {

		EntityManager entityManager = HibernateUtil.getEntityManager();
		List<Employee> employeeList = entityManager
				.createQuery("FROM Employee", Employee.class)
				.getResultList();
		
		employeeList.forEach(e -> System.out.println(e));
		
		entityManager.close();
	}

}
