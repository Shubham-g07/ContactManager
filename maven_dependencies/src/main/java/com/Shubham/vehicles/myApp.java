package com.Shubham.vehicles;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myApp {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "config.xml" )) {
			Vehicle xyz = context.getBean( "idforcar" , Vehicle.class);
			System.out.println(xyz.getMilage());
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
