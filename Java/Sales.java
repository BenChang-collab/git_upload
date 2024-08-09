package com.cathaybk.practice.nt50354.b;

public class Sales extends Employee {
	private int payment;
	private int bouns;
	private int percent = 5;// 業務獎金%數

	public Sales(String name, String department, int salary, int bouns) {
		super(name, department, salary);
		this.bouns = bouns / 100 * percent;
		this.payment = (salary + this.bouns);
		
	}

	public void printInfo() {
		super.printInfo();
		StringBuilder str = new StringBuilder();
		str.append("月薪:").append(getSalary()).append("\n").append("業績獎金:").append(bouns).append("\n").append("總計:").append(payment);
		System.out.println(str.toString());
		str.setLength(0);
	}

	public int getBouns() {
		return bouns;
	}

	public void setBouns(int bouns) {
		this.bouns = bouns;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	};
}
