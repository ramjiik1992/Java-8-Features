package com.javaLamda;

import java.util.function.Predicate;

public class PredicateJoin {
	public static void main(String[] args) {

		int[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Predicate<Integer> p = i -> i % 2 == 0;

		Predicate<Integer> p1 = j -> j > 3;

		for (Integer x1 : x) {

			
			if (p.negate().and(p1).test(x1)) {
				System.out.println("both contdions satisfied.." + x1);
			}
		}
	}
}
