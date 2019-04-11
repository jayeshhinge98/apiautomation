package com.test;

import java.util.Scanner;

public class demo4 {
	// It means the given Method or variable is not instance related but Class
	// related
	// can accessible without creating object of class
	public static void demo4() {
		System.out.println("Static method");
	}

	public static void main(String...arg) {
		System.out.println("under main method");
		Scanner in=new Scanner(System.in);
		System.out.println("Enter any number::");
		int i=in.nextInt();
		System.out.println("Number is:=>"+i);
	}
}