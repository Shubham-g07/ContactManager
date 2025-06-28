package com.criteriaAPI;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mavenProj.maven_Proj.Student;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class CriteriaExample {
	public static void main(String args[]) {
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = f.openSession();
		Criteria c = s.createCriteria(Student.class);
		
		c.add(Restrictions.eq("name", "Sahil"));
		System.out.println("___________________________________________________");
		c.add(Restrictions.gt("id", 65));
		
		List<Student> list = c.list();
		
		for(Student std : list) {
			System.out.println(std);
		}
		
		s.close();
		f.close();
	}
}
