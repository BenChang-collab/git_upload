package com.cathaybk.practice.nt50354.b;

import java.time.LocalDate;
import java.util.Scanner;

public class CalendarPrinter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int month = 0;
		/*
		 * 使用hasNextInt()方法段輸入的是否為整數，如為整數回傳true，反之，如果為整數進一步判斷是否介於1~12之間，介於1~12之間跳出迴圈，
		 * 否則迴圈至符合條件為止
		 */
		while (true) {
			System.out.print("輸入介於1~12間的整數m: ");
			if (scanner.hasNextInt()) {
				month = scanner.nextInt();
				if (month >= 1 && month <= 12) {
					break;
				} else {
					System.out.println("請輸入介於1到12之間的整數。");
				}
			} else {
				System.out.println("輸入的不是整數。請重新輸入。");
				scanner.next();
			}
		}
		printCalendar(month);
	}

	public static void printCalendar(int month) {
		int year = LocalDate.now().getYear();

		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		int lengthOfMonth = firstDayOfMonth.lengthOfMonth();

		int firstDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();
		firstDayOfWeek = (firstDayOfWeek % 7);

		String header = String.format("%d年 %d月", year, month);
		System.out.printf("%" + (10 + header.length() / 2) + "s%n", header); // 10+length
		System.out.println("---------------------");
		System.out.println("日  一  二  三 四  五  六");

		System.out.println("=====================");

		for (int i = 0; i < firstDayOfWeek; i++) {
			System.out.print("   ");
		}

		for (int day = 1; day <= lengthOfMonth; day++) {

			System.out.printf("%2d ", day);

			if ((day + firstDayOfWeek) % 7 == 0) {
				System.out.println();
			}
		}
	}

}
