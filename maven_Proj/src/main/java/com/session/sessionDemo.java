package com.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mavenProj.maven_Proj.Certificate;
import com.mavenProj.maven_Proj.Student;

public class sessionDemo {

	public static void main(String[] args) {
		
		// four states are there in the hibernate
		// Transient // Persistant // Detached // Removed 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student student = new Student();
		student.setSId(7);
		student.setName("new student");
		student.setCity("Delhi");
		student.setCerti(new Certificate("Mysql course ", "2 Months"));
		// now the student is in Transient state 
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student);
		//now the student obj is in the persistant state 
		
		// by remove the object is in removed state
		session.remove(student);
		System.out.println(session.get(Student.class, 1));
		tx.commit();
		
		session.close();
		
		// after closing the session you make some changes in the data it dosen't make changes in the DB
		// it is in the detached state 
		student.setName("abc");
		
		factory.close();
	}

}
