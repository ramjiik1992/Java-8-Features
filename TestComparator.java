package com.javaLamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestComparator {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(3);
		list.add(5);
		list.add(1);

		Collections.sort(list);
		System.out.println(list);

		Comparator<Integer> comp = (i1, i2) -> (i1 < i2) ? 1 : (i1 > i2) ? -1 : 0;

		Collections.sort(list, comp);
		// Collections.reverseOrder();
		System.out.println("after comparator.." + list);

	}
}
