package com.mapping_tables;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapping {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Question q1 = new Question();
		q1.setqId(1217);
		q1.setQuestion("What is java");
		
		Answer ans = new Answer();
		ans.setaId(343);
		ans.setAnswer("Java is a programming language");
		ans.setQuestion(q1);
		
		
		Answer ans2 = new Answer();
		ans2.setaId(345);
		ans2.setAnswer("Java is a OOP language");
		ans2.setQuestion(q1);
		
		
		Answer ans3 = new Answer();
		ans3.setaId(346);
		ans3.setAnswer("Java has multiple frameworks");
		ans3.setQuestion(q1);
		
		ArrayList<Answer> list = new ArrayList<Answer>();
		list.add(ans);
		list.add(ans2);
		list.add(ans3);
		
		q1.setAnswers(list);
		

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(q1);
		session.save(ans);
		session.save(ans2);
		session.save(ans3);
		
		
		Question question = (Question) session.get(Question.class, 1217);
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswers().size());
		
//		for (Answer answer : question.getAnswers()) {
//			System.out.println(answer.getAnswer());
//		}
//		
		tx.commit();
		session.close();
		
		sessionFactory.close();
		
	}
}
