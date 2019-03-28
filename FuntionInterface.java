package com.javaLamda;

import java.util.function.Function;
import java.util.function.Predicate;

//import java.util.function.Predicate;

public class FuntionInterface {
	public static void main(String[] args) {

		// used to specify return type or predicate is fixed return type(boolean) to
		// change return type
		Function<String, Integer> f = i -> i.length();

		System.out.println(f.apply("Hello world"));

		Function<String, String> f1 = i -> i.toUpperCase();

		System.out.println(f1.apply("Hello world"));

		Predicate<Student> sTest = st -> st.marks > 50;

		// defining function custom
		Function<Student, String> stuFun = s -> {
			int marks = s.marks;
			String grade = "";

			if (marks >= 80)
				grade = "A";
			else if (marks >= 50)
				grade = "B";
			return grade;
		};

		Student[] s = { new Student("ram", 80), new Student("ramji", 50) };

		for (Student student : s) {

			if (sTest.test(student))
				System.out.println(stuFun.apply(student));
		}

	}
}

class Student {

	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}
