package com.cathaybk.practice.nt50354.b;

public class Supervisor extends Employee {
	private int payment;

	public Supervisor(String name, String department, int payment) {
		super(name, department);
		this.payment = payment;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println("月薪:" + payment + "\n" + "總計:" + payment);
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
}
