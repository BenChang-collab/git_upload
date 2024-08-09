package com.cathaybk.practice.nt50354.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

		System.out.print("\n ");

		Set<Integer> Lottolist2 = new TreeSet<>();
		int j = 0;
		while (j < 6) {
			int num2 = 0;
			num2 = (int) (Math.random() * (49) + 1);
			if (Lottolist2.contains(num2)) {
				continue;
			}
			Lottolist2.add(num2);
			j++;
		}
		System.out.println("因使用TreeSet使用自然排序不另外做排序，且set不取到重複的值:");
		for (int num2 : Lottolist2) {
			System.out.print(num2 + " ");
		}
	}
}
