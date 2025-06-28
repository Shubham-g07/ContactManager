package com.mavenProj.maven_Proj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch_details {
	public static void main(String args[]) {

	 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	 
	 Session session = factory.openSession();
	 
	 Student student = (Student) session.load(Student.class, 2);
	 
	 System.out.println(student);
	 
	 
	 session.close();
	 
	 factory.close();
}
}