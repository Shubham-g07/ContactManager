package com.mavenProj.maven_Proj;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {   
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        for(int i = 0; i <= 50; i++) {
        
        Student st1 = new Student();
        st1.setName("Shubham");
        st1.setCity("Mumbai");
        
        
        Student st2 = new Student();
        st2.setName("Sahil");
        st2.setCity("Mumbai");
        
        Certificate certificate = new Certificate();
        certificate.setCourseName("Andriod");
        certificate.setDuration("2 Months");
        
        st2.setCerti(certificate);
        
        
//        Address ad = new Address();
//        ad.setStreet("Street2");
//        ad.setCity("Mumbai");
//        ad.setOpen(true);
//        ad.setX(100.546);
//        ad.setAddedDate(new Date());
        
//        FileInputStream fis;
//		try {
//			fis = new FileInputStream("src/main/java/pic1.jpg");
//			byte[] data = new byte[fis.available()];
//			fis.read(data);
//			ad.setImage(data);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
  
//        session.save(st);      
//        session.save(ad);
        
        
	        session.save(st2);
	        session.save(st1);
        }
        
        tx.commit();        
        session.close();
        System.out.println("Done");
        
    }
}
