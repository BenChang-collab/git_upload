package com.cathaybk.practice.nt50354.b;

public class Employee implements IWork {
	private String name;
	private String department;
	private int salary;

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public void printInfo() {
		System.out.print("薪資單" + "\n" + "姓名:" + name + "  工作部門:" + department + "\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	};

}
