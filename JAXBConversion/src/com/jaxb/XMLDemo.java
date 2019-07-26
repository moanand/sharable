package com.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLDemo {
	public static void main(String args[]) throws JAXBException,
			FileNotFoundException {

		List<Employee> empList = new ArrayList<Employee>();

		System.out.println("Please enter employee details:");
		System.out.println("------------------------------------");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Id : ");
			int id = scanner.nextInt();
			System.out.println("Name : ");
			String name = scanner.next();
			System.out.println("Department : ");
			String department = scanner.next();
			System.out.println("Salary : ");
			String salary = scanner.next();
			System.out
					.println("Do you want to enter more details::: (Yes/No) ");
			System.out.println("------------------------------------");
			String ans = scanner.next();

			Employee emp = new Employee(id, name, department, salary);
			Employees employees = new Employees();

			empList.add(emp);
			employees.add(emp);
			JAXBContext ctx = JAXBContext.newInstance(Employees.class);

			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			if (ans.equalsIgnoreCase("yes")) {
				while (true) {

					System.out
							.println("Please confirm again \"Yes\" or \"No\" if you want to proceed or not respectively");
					System.out
							.println("-----------------------------------------------------------------------------------");
					System.out.println();

					String ans1 = scanner.next();
					if (ans1.equalsIgnoreCase("no")) {
						System.out.println("You have completed the process");
						break;
					} else {
						System.out.println("Id : ");
						id = scanner.nextInt();
						System.out.println("Name : ");
						name = scanner.next();
						System.out.println("Department : ");
						department = scanner.next();
						System.out.println("Salary : ");
						salary = scanner.next();
						Employee emp1 = new Employee(id, name, department,
								salary);
						empList.add(emp1);
						employees.add(emp1);
					}
				}
				FileOutputStream fis = new FileOutputStream("employee.xml");
				marshaller.marshal(employees, fis);

				/*
				 * for (Employee empl : empList) {
				 * System.out.println(empl.getId()); marshaller.marshal(empl,
				 * fis); }
				 */
			} else {
				marshaller.marshal(emp, new FileOutputStream("employee.xml"));
				System.out.println("You have succesfully added the details");
			}
		} catch (Exception ae) {

			System.out.println("Please provide a valid information");

		}
	}
}
