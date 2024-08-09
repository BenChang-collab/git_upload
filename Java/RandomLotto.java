package com.cathaybk.practice.nt50354.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {

	public static void main(String[] args) {

		List<Integer> Lottolist = new ArrayList<>();
		int i = 0;
		while (i < 6) {
			int num = 0;
			num = (int) (Math.random() * (49) + 1);
			if (Lottolist.contains(num)) {
				continue;
			}
			Lottolist.add(num);
			i++;
		}
		System.out.print("排序前:");
		for (int num : Lottolist) {
			System.out.print(num + " ");
		}
		Collections.sort(Lottolist);
		System.out.print("\n排序後:");
		for (int num : Lottolist) {
			System.out.print(num + " ");
		}
	}
}
