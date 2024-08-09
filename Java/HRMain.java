package com.cathaybk.practice.nt50354.b;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class HRMain {

	public static void main(String[] args) {
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employeesList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeesList.add(new Supervisor("李中白", "資訊部", 65000));
		employeesList.add(new Supervisor("林小中", "理財部", 80000));
		for (Employee employee : employeesList) {
			employee.printInfo();
		}
		try {
			OutputStreamWriter output = new OutputStreamWriter(
					new FileOutputStream("C:/Users/Admin/Desktop/Java班/git_upload/Java/output.csv"), "UTF-8");
			for (Employee listEmployee : employeesList) {
				if (listEmployee instanceof Supervisor) {
					output.write(listEmployee.getName() + "," + (((Supervisor) listEmployee).getPayment()) + "\n");
				} else {
					output.write(listEmployee.getName() + ","
							+ (((Sales) listEmployee).getPayment() + ((Sales) listEmployee).getBouns()) + "\n");
				}
			}
			output.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
