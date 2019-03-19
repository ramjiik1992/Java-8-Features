package com.javaLamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
	String name;
	int eno;

	public Employee(String name, int eno) {
		super();
		this.name = name;
		this.eno = eno;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", eno=" + eno + "]";
	}

}

public class Comparator1 {

	public static void main(String[] args) {

		ArrayList<Employee> e = new ArrayList<Employee>();
		e.add(new Employee("aam", 2));
		e.add(new Employee("bam", 5));
		e.add(new Employee("cam", 3));
		e.add(new Employee("ram", 7));
		e.add(new Employee("ram", 1));

		// ordering based on employee no
		Comparator<Employee> c = (e1, e2) -> e1.eno < e2.eno ? -1 : (e1.eno > e2.eno) ? 1 : 0;
		// ordering based on employee name
		Comparator<Employee> c1 = (e1, e2) -> e1.name.compareTo(e2.name);
		Collections.sort(e, c1);
		System.out.println(e);
	}
}
