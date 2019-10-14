package org.customer.app;

import java.util.List;
import java.util.Scanner;

import org.customer.app.factory.CustomerFactory;
import org.customer.app.factory.CustomerFactoryImpl;
import org.customer.app.model.Customer;

public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {

			CustomerFactory imp1 = new CustomerFactoryImpl();
			int choice;

			do {
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("ID: ");
					int id1 = scanner.nextInt();
					System.out.print("NAME: ");
					String name = scanner.next();
					System.out.print("EMAIL: ");
					String email = scanner.next();

					Customer customer = imp1.createCustomer(id1, name, email);
					System.out.println(customer.toString());
					break;
				case 2:
					List<Customer> list = imp1.getAllCustomer();
					for (Customer c : list) {
						System.out.println(c);
					}
					break;
				case 3:
					
					System.out.print("enter id to search: ");
					int id = scanner.nextInt();
					imp1.findById(id);
					break;
				case 4:
					System.out.println("Enter id to update");
					int id2=scanner.nextInt();
					imp1.updateCustomer(id2);
					break;
				case 5:
					System.out.println("Enter id to delete");
					int id3=scanner.nextInt();
					imp1.deleteCustomer(id3);
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