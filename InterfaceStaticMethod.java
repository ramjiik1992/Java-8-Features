package com.javaLamda;

interface Ab {
	public static void mat1() {
		System.out.println("hello interface");
	}
}

public class InterfaceStaticMethod implements Ab {

	public static void main(String[] args) {

		Ab.mat1();

	}
}
