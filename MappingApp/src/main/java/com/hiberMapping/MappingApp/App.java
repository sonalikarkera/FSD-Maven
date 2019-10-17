package com.hiberMapping.MappingApp;


import static java.lang.System.in;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiberMapping.MappingApp.event.Instructor;
import com.hiberMapping.MappingApp.event.InstructorDetails;
import com.hiberMapping.MappingApp.factory.MyHibernateFactory;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
    	try {
    		
    		
    		
    	
/*
    		InstructorDetails id = new InstructorDetails();
    		id.setHobby("Cricket");
    		id.setYoutube_channels("www.youtube.com");
    		
    		session.getTransaction().begin();
    		session.persist(id);
  			session.getTransaction().commit();	
    		
    		Instructor i = new Instructor();    		
    		i.setFirst_name("Sunny");
    		i.setLast_name("Deol");
    		i.setEmail("sunny@i.com");
    		i.setInstructorDetailsId(id);
    		
    		
    		
    		session.getTransaction().begin();
    		session.persist(i);
  			session.getTransaction().commit();	*/
    		

			Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetails tempInstructorDetail =
					new InstructorDetails(
							"http://www.youtube.com",
							"Guitar");		
			
			
			tempInstructor.setInstructorDetailsId(tempInstructorDetail);
			
			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		   
    }
}
