package com.sqlqueries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.mavenProj.maven_Proj.Student;

// implementing SQL queries with help of hibernate 
public class SQLQuery {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		String q = "select * from student";
		
		// in session createquery expects HQL query but if we want to fire SQL query then we have to use 
		//creteSQLQuery 
			
		NativeQuery nq = session.createSQLQuery(q);
		
		List<Object[]> list = nq.getResultList();
		
		for (Object[] std : list) {
			System.out.println(std[4] + " : " + std[3]);
		}
		
		
		session.close();
		factory.close();
		
	}
}
