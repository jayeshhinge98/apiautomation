package com.test.oopsPrograms;

public class Polymorphism {

	static int add(int a, int b) {
		return a + b;
	}

	// static double add(int a, int b) {
	// return a + b;// It is not possible bcz. ambiguity problem occurs by find
	// same method with same arguments
	// }

	static int add(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String[] args) {

		// convert one form into many forms

		// If a class has multiple methods having same name but different in
		// parameters, it is known as Method Overloading.
		// If we have to perform only one operation, having same name of the
		// methods increases the readability of the program.

		// There are two ways of defining overloading
		// 1. By changing number of arguments - this is possible
		// 2. By changing the data types - this is not possible

		System.out.println(Polymorphism.add(11, 11));
		System.out.println(Polymorphism.add(11, 11, 11));

	}
	public static void main(String args) {
		System.out.println("main with String");
	}
	public static void main() {
		System.out.println("main without args");
	}
}