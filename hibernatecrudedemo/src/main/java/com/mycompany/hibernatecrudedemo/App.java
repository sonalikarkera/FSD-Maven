package com.mycompany.hibernatecrudedemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernatecrudedemo.dao.EmployeeDAO;
import com.mycompany.hibernatecrudedemo.dao.EmployeeDAOImpl;
import com.mycompany.hibernatecrudedemo.model.Employee;
import com.mycompany.hibernatecrudedemo.shared.SharedEmployee;
import static java.lang.System.in;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner scanner = new Scanner(in);

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			int choice = 0;
			do {
				System.out.println("1 : Create Employee");
				System.out.println("2 : Display all available Employee");
				System.out.println("3 : Find Employee by id");
				System.out.println("4 : Find by custom id");
				System.out.println("5 : Remove by id");
				System.out.println("6 :  Update" );
				System.out.println("Your choice");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("First Name");
					String fname = scanner.next();
					System.out.print("Last Name");
					String lname = scanner.next();
					System.out.print("Email");
					String email = scanner.next();
					dao.createEmployee(new SharedEmployee(fname, lname, email));
					System.out.println("inserted");
					break;
				case 2:
					List<SharedEmployee> se = dao.getAllEmployee();
					for (SharedEmployee see : se) {
						System.out.printf("%s %s %s", see.getFirstName(),
								see.getLastName(), see.getEmail());
					}

					break;
				case 3:System.out.println("enter employyee id");
				int id=scanner.nextInt();
				SharedEmployee sEmployee=dao.findbyid(id);
				if(sEmployee==null) {
					System.out.println("No such recod found");

				}
				else {
					System.out.println(sEmployee);
				}
					break;
				case 4:System.out.println("enter custom id");
				String cid=scanner.next();
				dao.findbyCustomid(cid);
					 break;
				case 5:System.out.println("enter  id");
			int iid=scanner.nextInt();
				dao.deleteEmployee(iid);
					 break;
					 
				case 6:System.out.println("Enter id to update");
				int idd=scanner.nextInt();
				
				dao.updateEmployee(idd);
					 break;
					 
				default:
					break;
				}
			} while (choice != 0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}