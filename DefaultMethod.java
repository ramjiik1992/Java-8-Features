package com.javaLamda;

interface inter {
	public void m1();

	public void m2();

	public default void m3() {
		System.out.println("default method");
	}

}

public class DefaultMethod implements inter {

	@Override
	public void m1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		DefaultMethod dem = new DefaultMethod();
		dem.m3();
	}

}
