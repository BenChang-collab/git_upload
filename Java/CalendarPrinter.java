package com.cathaybk.practice.nt50354.b;

import java.time.LocalDate;
import java.util.Scanner;

public class CalendarPrinter {

	private static final int WIDTH = 20; // 定義月曆列寬

	public static void printCalendar(int month) {
		if (month < 1 || month > 12) {
			System.out.println("請輸入介於1到12之間的整數。");
			return;
		}

		int year = LocalDate.now().getYear();

		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		int lengthOfMonth = firstDayOfMonth.lengthOfMonth();

		int firstDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();
		firstDayOfWeek = (firstDayOfWeek % 7);

		String header = String.format("%d年 %d月", year, month);
		System.out.printf("%" + (WIDTH / 2 + header.length() / 2) + "s%n", header);
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

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("輸入介於1~12間的整數m:");
		int month = scanner.nextInt();
		printCalendar(month);
		scanner.close();
	}
}
