package mapping2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class manyToManyMapping {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Employee 1 & Employee 2
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
		
		employee1.setEmp_id(101);
		employee2.setEmp_id(102);
		employee3.setEmp_id(103);
		
		employee1.setName("Shubham");
		employee2.setName("Sahil");
		employee3.setName("Karan");
		
		// Project 1 & Project 2
		Project project1 = new Project();
		Project project2 = new Project();
		
		project1.setProject_id(1111);
		project2.setProject_id(1112);
		
		project1.setName("Library Management");
		project2.setName("Restaurants Management");
		
		
		// Creating list of employees
		List<Employee> p1Employees = new ArrayList<Employee>();
		p1Employees.add(employee1);
		p1Employees.add(employee2);
		
		// assigning employees to project 1
		project1.setEmployees(p1Employees);
		
		
		// second list for project2 employees
		List<Employee> p2Employees = new ArrayList<Employee>();
		p2Employees.add(employee3);
		p2Employees.add(employee2);
		
		// assigning emp for project 2
		project2.setEmployees(p2Employees);
		
		//creating list of projects for emp 1
		List<Project> e1Projects = new ArrayList<Project>();
		e1Projects.add(project1);
		
		// assigning projects to employee 1
		employee1.setProjects(e1Projects);
		
		//creating list of projects for emp 2
		List<Project> e2Projects = new ArrayList<Project>();
		e2Projects.add(project1);
		e2Projects.add(project2);

		// assigning projects to employee 2
		employee2.setProjects(e2Projects);
		
		//creating list of projects for emp 3
		List<Project> e3Projects = new ArrayList<Project>();
		e3Projects.add(project2);		

		// assigning projects to employee 3
		employee3.setProjects(e3Projects);
		
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(project1);
		session.save(project2);
		
		tx.commit();
		
		session.close();
		factory.close();
		
	}
}
