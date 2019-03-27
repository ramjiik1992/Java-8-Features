package com.javaLamda;

import java.util.function.Predicate;

public class PredicateJava {

	public static void main(String[] args) {

		int j = 10;

		Predicate<Integer> pre = i -> i % 2 == 0;

		System.out.println(pre.test(11));

		Predicate<Employee1> emp = e -> e.getSalary() > 10000 && e.isHavingGirlFriend() == true;

		System.out.println("given employee  " + emp.test(new Employee1(110000, true)));

	}
}

class Employee1 {
	int salary;
	boolean isHavingGirlFriend;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isHavingGirlFriend() {
		return isHavingGirlFriend;
	}

	public void setHavingGirlFriend(boolean isHavingGirlFriend) {
		this.isHavingGirlFriend = isHavingGirlFriend;
	}

	public Employee1(int salary, boolean isHavingGirlFriend) {
		super();
		this.salary = salary;
		this.isHavingGirlFriend = isHavingGirlFriend;
	}

}
