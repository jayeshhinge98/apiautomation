package com.test.oopsPrograms;

public class Overriding extends Bank {
	/*
	 * public float getRateOfInterest() { // TODO Auto-generated method stub
	 * return 11; } // not allowed as return type should be same
	 */

	public static void main(String[] args) {
		// Method overriding is used for runtime polymorphism
		// Method overriding is nothing but a declaration of same method in
		// child and parent class with same parameter with same return type

		// Overriding is required when we want different implementation than
		// parent method
		// Rules for Java Method Overriding
		// The method must have the same name as in the parent class
		// The method must have the same parameter as in the parent class.
		// There must be an IS-A relationship (inheritance).

		// IMPORTANT
		// Can we override static method?
		// No, a static method cannot be overridden. It can be proved by runtime
		// polymorphism, so we will learn it later.
		//
		// Why can we not override static method?
		// It is because the static method is bound with class whereas instance
		// method is bound with an object. Static belongs to the class area, and
		// an instance belongs to the heap area.
		//
		// Can we override java main method?
		// No, because the main is a static method.

		SBI s = new SBI();
		ICICI i = new ICICI();
		AXIS a = new AXIS();
		System.out.println("SBI Rate of Interest: " + s.getRateOfInterest());
		System.out.println("ICICI Rate of Interest: " + i.getRateOfInterest());
		System.out.println("AXIS Rate of Interest: " + a.getRateOfInterest());
	}

}
