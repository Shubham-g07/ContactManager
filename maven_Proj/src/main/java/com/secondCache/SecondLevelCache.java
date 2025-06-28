package com.secondCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mavenProj.maven_Proj.Student;

public class SecondLevelCache {
public static void main(String[] args) {
	
	
	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session s1 = sf.openSession();
	//first session
	
	Student student1 = s1.get(Student.class, 93);
	System.out.println(student1);
	s1.close();
	
	Session s2 = sf.openSession();
	//second session
	
	Student student2 = s2.get(Student.class, 93);
	System.out.println(student2);
	s2.close();
	
	sf.close();
}
}
