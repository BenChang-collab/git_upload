package com.cathaybk.practice.nt50354.b;

public class Sales extends Employee {
	private int payment;
	private int bouns;
	private int percent = 5;// 業務獎金%數

	public Sales(String name, String department, int payment, int bouns) {
		super(name, department);
		this.payment = payment;
		this.bouns = bouns;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println("月薪:" + payment + "\n" + "業績獎金:" + getBouns() + "\n" + "總計:" + (payment + getBouns()));
	}

	public int getBouns() {
		return bouns / 100 * percent;
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
