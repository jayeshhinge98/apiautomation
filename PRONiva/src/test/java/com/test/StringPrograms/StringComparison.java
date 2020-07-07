package com.test.StringPrograms;

public class StringComparison {

	public static void main(String[] args) {

		String s = "Jayesh";
		String s1 = "Jayesh";
		String s2 = new String("Jayesh");
		String s3 = "Vijaya";
		String s4 = "JAYESH";
		
		// 1. Compare using equals() method
		System.out.println("Result using equals() method:" + s.equals(s1));// true
		System.out.println("Result using equals() method:" + s.equals(s2));// true
		System.out.println("Result using equals() method:" + s.equals(s3));// false
		System.out.println("Result using equals() method:" + s.equals(s4));// false

		// 2. Compare using equalsIgnoreCase() method
		System.out.println("Result using equalsIgnoreCase() method:"
				+ s.equalsIgnoreCase(s1));// true
		System.out.println("Result using equalsIgnoreCase() method:"
				+ s.equalsIgnoreCase(s2));// true
		System.out.println("Result using equalsIgnoreCase() method:"
				+ s.equalsIgnoreCase(s3));// false
		System.out.println("Result using equalsIgnoreCase() method:"
				+ s.equalsIgnoreCase(s4));// true

		// 3. Compare using == operator, it compare the reference/address of the
		// string
		System.out.print("Result using == operator:");
		System.out.println(s == (s1));// true
		System.out.print("Result using == operator:");
		System.out.println(s == (s2));// false
		System.out.print("Result using == operator:");
		System.out.println(s == (s3));// false
		System.out.print("Result using == operator:");
		System.out.println(s == (s4));// false

		// 4. Compare using compareTo() function : compares using >,<,== symbols
		// and returns number
		// It uses ASCII value of character for Example A:65 a:97 so when we
		// compare then it returns -32
		System.out.print("Result using compareTo() :");
		System.out.println(s.compareTo(s1));// 0
		System.out.print("Result using compareTo() :");
		System.out.println(s.compareTo(s2));// 0
		System.out.print("Result using compareTo() :");
		System.out.println(s.compareTo(s3));//
		System.out.print("Result using compareTo() :");
		System.out.println(s.compareTo(s4));// false
		System.out.print("Result using compareTo() :");
		System.out.println("A".compareTo("a"));// -32

	}
}
