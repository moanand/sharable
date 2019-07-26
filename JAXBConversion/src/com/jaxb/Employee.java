package com.jaxb;

/*import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
*/

public class Employee {

	private int Id;
	private String Name;
	private String Department;
	private String Salary;

	public Employee() {
	}

	public Employee(int Id, String Name, String Department, String Salary) {
		this.Id = Id;
		this.Name = Name;
		this.Department = Department;
		this.Salary = Salary;
	}


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	
	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	
	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public String toString() {
		return this.Id + "\t" + this.Name + "\t\t" + this.Department + "\t\t\t"
				+ this.Salary;
	}

}
