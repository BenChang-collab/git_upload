package com.cathaybk.practice.nt50354.b;

public class NineNineTable {

	public static void main(String[] args) {
		for (int num2 = 1; num2 < 10; num2++) {
			for (int num1 = 2; num1 < 10; num1++) {
				int ans = num2 * num1;
				System.out.printf("%d*%d=%2d  ", num1, num2, ans);
			}
			System.out.print("\n");
		}
	}
}
