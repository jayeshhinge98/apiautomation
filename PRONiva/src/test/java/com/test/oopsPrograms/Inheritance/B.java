package com.test.oopsPrograms.Inheritance;

public class B extends A {
	public void displayB() {
		System.out.println("I am in class B");
	}
	protected void displayPrivate(){
		System.out.println("This is private method from Class B");
	}
}
