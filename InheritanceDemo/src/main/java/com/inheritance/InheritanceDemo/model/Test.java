package com.inheritance.InheritanceDemo.model;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(Account.class)
					.addAnnotatedClass(Savings.class)
					.addAnnotatedClass(Current.class).buildSessionFactory();
			Session session = factory.openSession();
			Account ac = new Account("Sonu", "s@gmail.com", new Date());
			Savings s = new Savings("Sonu", "s@gmail.com", new Date(), 9.99);
					
			Current c = new Current("Sonu", "s@gmail.com", new Date(),  11.2, 100.1);
		session.getTransaction().begin();
			session.save(ac);
			session.save(s);
			session.save(c);
			session.getTransaction().commit();
			System.out.println("ok..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}