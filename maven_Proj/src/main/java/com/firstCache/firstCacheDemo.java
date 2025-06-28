package com.firstCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mavenProj.maven_Proj.Student;

public class firstCacheDemo {
	public static void main(String[] args) {
		
		// first level cache demo
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Student student = s.get(Student.class, 7);
		System.out.println(student);
		
		System.out.println("Doing something....");
		
		//if the object is already present in the session cache then hibernate do not again get it from db
		//it returns the existing object from the cache memory
		Student student1 = s.get(Student.class, 7);
		System.out.println(student);
		
		// session has contains method to check the object is exists in cache or not 
		System.out.println(s.contains(student1));
		
		
		
		s.close();
		factory.close();
	}
}
