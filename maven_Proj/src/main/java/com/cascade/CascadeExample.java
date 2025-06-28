package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping_tables.Answer;
import com.mapping_tables.Question;

public class CascadeExample {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();

		Question q1 = new Question();
		q1.setqId(64848);
		q1.setQuestion("spring framework");

		Answer a1 = new Answer(62235, "fa");
		Answer a2 = new Answer(646, "sa");
		Answer a3 = new Answer(9748, " ta");

		List<Answer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswers(list);

		s.save(q1);

		// here we have to save answers manually but if the question has multiple
		// answers then we can not do it manually

		// that's why we use cascading :- cascade means if we did save action on
		// question then the related entities to the question get automatically save
		
		// in short if we perform action on a entity then the same action get performed
		// by the related entities to it

//		s.save(a1);
//		s.save(a2);
//		s.save(a3);

		Transaction tx = s.beginTransaction();

		tx.commit();

		s.close();
		factory.close();

	}
}
