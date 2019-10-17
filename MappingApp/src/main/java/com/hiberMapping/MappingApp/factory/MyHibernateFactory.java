package com.hiberMapping.MappingApp.factory;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiberMapping.MappingApp.event.Instructor;
import com.hiberMapping.MappingApp.event.InstructorDetails;


public class MyHibernateFactory {
private static SessionFactory factory;
	
	public static SessionFactory getMySession()
	{
		factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		return factory;
				
	}
}
