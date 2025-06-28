package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mavenProj.maven_Proj.Student;

public class HQLPagination {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s = factory.openSession();
		
		Query query = s.createQuery("from Student");
		
		// implementing pegination using hibernate 
		
		query.setFirstResult(0);
		
		query.setMaxResults(6);
		
		List<Student> list = query.getResultList();
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		
		s.close();
		factory.close();
	}
}
