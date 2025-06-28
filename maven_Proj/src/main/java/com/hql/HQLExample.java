package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mavenProj.maven_Proj.Student;

public class HQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		// <--- Hibernate Query Language (HQL) ---->
		// syntax of hibernate query language

		// first we have to create a string which contains query

		// we using aliasing, and s is simply an alias for the Student entity.
		String query = "from Student as s where s.city =:x and s.name=:n";
		// when the name and city both conditions are true then we get results

		// we can set where values by using parameters by using city =:x;
		// then we can set the x parameter by the Query obj
		// and we can get that parameter by the user also

		// then session has a method of create query and then it returns the query type
		// object
		Query q = session.createQuery(query);

		// like this
		q.setParameter("x", "pune");
		q.setParameter("n", "shubham");

		// if from the query we want a single result then it called as unique result
		// we can get it by q.uniqueResult();

		// and if we want multiple results then we can get them as list

		List<Student> list = q.getResultList();

		// now all student info will be in the list

		for (Student std : list) {
			System.out.println(std.getName());
		}

		System.out.println("__________________________________________");

		Transaction tx = session.beginTransaction();

		// <--- delete opeartion query ---->

//		Query query2 = session.createQuery("delete from Student as s where s.city=:c");
//		
//		query2.setParameter("c", "pune");
//		
//		int r = query2.executeUpdate();
//		
//		System.out.println("Deleted:" + r);

//		update query
//		Query q3 = session.createQuery("update Student set city=:c where name=:n");
//		q3.setParameter("c", "Mumbai");
//		q3.setParameter("n", "Mohit");
//	
//		int res = q3.executeUpdate();
//		
//		System.out.println("updated query :" + res);

		// <--- executing joint query ---->

		Query que3 = session
				.createQuery("select q.question, q.qId, a.answer from Question as q INNER JOIN q.answers as a");

		List<Object[]> liArr = que3.getResultList();
		
		for( Object[] arr : liArr) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		tx.commit();
		session.close();
		factory.close();

	}

}
