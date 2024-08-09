package com.cathaybk.practice.nt50354.b;

public class Supervisor extends Employee {
	private int payment;

	public Supervisor(String name, String department, int salary) {
		super(name, department, salary);
		this.payment = salary;
	}

	public void printInfo() {
		super.printInfo();
		StringBuilder str = new StringBuilder();
		str.append("月薪:").append(getSalary()).append("\n").append("總計:").append(getSalary());
		System.out.println(str.toString());
		str.setLength(0);
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
}
