package com.mycompany.hibernatecrudedemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import javax.persistence.Query;
import org.modelmapper.ModelMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernatecrudedemo.factory.MyHibernateFactory;
import com.mycompany.hibernatecrudedemo.model.Employee;
import com.mycompany.hibernatecrudedemo.shared.SharedEmployee;

public class EmployeeDAOImpl implements EmployeeDAO {
	private Session session = null;
	private SessionFactory sessionFactory = null;

	public EmployeeDAOImpl() {
		super();

		sessionFactory = MyHibernateFactory.getMySession();
	}

	public void createEmployee(SharedEmployee sEmployee) {
		// TODO Auto-generated method stub
		ModelMapper mapper = new ModelMapper();
		Employee employee = mapper.map(sEmployee, Employee.class);
		UUID uUid = UUID.randomUUID();
		employee.setGeneratedId(uUid.toString());
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();

	}

	public List<SharedEmployee> getAllEmployee() {
		// TODO Auto-generated method stub
		ModelMapper mapper = new ModelMapper();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Employee");
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<Employee> list1 = query.getResultList();
		List<SharedEmployee> sList = new ArrayList<SharedEmployee>();
		for (Employee e : list1) {
			SharedEmployee se = mapper.map(e, SharedEmployee.class);
			sList.add(se);
		}

		return sList;
	}

	public SharedEmployee findbyid(int id) {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Employee employee = session.get(Employee.class, new Integer(id));
		session.getTransaction().commit();
		SharedEmployee sEmployee = null;
		if (employee != null) {
			ModelMapper mapper = new ModelMapper();
			sEmployee = mapper.map(employee, SharedEmployee.class);
			return sEmployee;
		} else {
			return null;
		}
	}

	public void findbyCustomid(String customid) {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Employee e where e.generatedId=:cId").setParameter("cId", customid);
		@SuppressWarnings("unchecked")
		List<Employee> l = query.getResultList();

		session.getTransaction().commit();
		ModelMapper mapper = new ModelMapper();
		List<SharedEmployee> sList = new ArrayList<SharedEmployee>();
		for (Employee e : l) {
			SharedEmployee se = mapper.map(e, SharedEmployee.class);
			sList.add(se);
		}

		if (!sList.isEmpty()) {
			for (SharedEmployee se : sList) {
				System.out.println(se);
			}
		} else {
			System.out.println("no such custom id found.");
		}
	}

	public void deleteEmployee(int id) {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Employee e = session.get(Employee.class, id);
		if (e != null) {
			session.delete(e);
			System.out.println("deleted successfully");
			session.getTransaction().commit();
		} else {
			System.out.println("no deletion occured");
		}

	}

	public void updateEmployee(int idd) {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Scanner sc = new Scanner(System.in);
		System.out.println("Updated fname: ");
		String fname = sc.next();
		System.out.println("Updated fname: ");
		String lname = sc.next();
		System.out.println("Updated email: ");
		String email = sc.next();
		Employee e = session.get(Employee.class, idd);

		if (e != null) {
			e.setFirstName(fname);
			e.setLastName(lname);
			e.setEmail(email);

			System.out.println("deleted successfully");
			session.getTransaction().commit();
		} else {
			System.out.println("no deletion occured");
		}

		/*
		 * Query query = session.createQuery("update  Employee e " +
		 * "set e.first_name=:fname, e.last_name=:lname, e.email=:email " +
		 * "where e.id=:idd").setParameter("idd" , idd); query.setParameter("fname",
		 * fname); query.setParameter("lname", lname); query.setParameter("email",
		 * email);
		 * 
		 * List<Employee> l = query.getResultList();
		 * 
		 * session.getTransaction().commit(); ModelMapper mapper = new ModelMapper();
		 * List<SharedEmployee> sList = new ArrayList<SharedEmployee>(); for (Employee e
		 * : l) { SharedEmployee se = mapper.map(e, SharedEmployee.class);
		 * sList.add(se); }
		 * 
		 * if (!sList.isEmpty()) { for (SharedEmployee se : sList) {
		 * System.out.println("updated"); } } else {
		 * System.out.println("no such custom id found."); }
		 */
	}
}
