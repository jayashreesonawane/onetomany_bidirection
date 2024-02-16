package onetomany_bidirection.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany_bidirection.dto.Company;
import onetomany_bidirection.dto.Employee;

public class MainController {
	public static void main(String[] args) {
		Company company = new Company();
		company.setName("TechM");
		company.setLocation("Pune");
		company.setGst("TechM123");

		Employee employee = new Employee();
		employee.setName("Jay");
		employee.setPhone(8317252991l);
		employee.setAddress("Pune");

		Employee employee1 = new Employee();
		employee1.setName("Shree");
		employee1.setPhone(7447626525l);
		employee1.setAddress("Pune");

		Employee employee2 = new Employee();
		employee2.setName("AK");
		employee2.setPhone(9876543210l);
		employee2.setAddress("Pune");

		employee.setCompany(company);

		List<Employee> list = new ArrayList<Employee>();
		list.add(employee);
		list.add(employee1);
		list.add(employee2);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
//		entityTransaction.begin();
//		for (Employee employee3 : list) {
//			entityManager.persist(employee3);
//		}
//		entityManager.persist(company);
//		entityTransaction.commit();
		
		Employee emp = entityManager.find(Employee.class, 3);
		System.out.println(emp);
		emp.setName("JAYA");
		entityTransaction.begin();
		entityManager.merge(emp);
//		entityManager.remove(employee2);
		entityTransaction.commit();

	}
}
