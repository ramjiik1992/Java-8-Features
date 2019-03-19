package com.javaLamda;

interface interf {
	public void m1();

}

interface interface2 {
	public void add(int a, int b);

	// public void add1(int a, int b);

}
/*
 * class Demo implements interf {
 * 
 * @Override public void m1() { System.out.println("hello");
 * 
 * }
 * 
 * }
 */

public class TestFunctionalInerface {

	public static void main(String[] args) {

		// interf d = new Demo();
//no need of class for implementing interface

		interf dd = () -> System.out.println("hhl");
		dd.m1();
		// d.m1();

		interface2 i2 = (a, b) -> System.out.println(a + b);
		i2.add(3, 4);
	}
}
