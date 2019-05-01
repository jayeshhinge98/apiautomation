package com.test.OtherPrograms;

import java.util.Scanner;

public class PrintFibonacciSeries {

	// Fibonacci Series, next number is the sum of previous two numbers
	public static void main(String[] args) {
		System.out
				.println("Enter number upto which need to show fibonacci series=>");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		// int fib[] = new int[100];
		int prev2 = 0;
		int prev1 = 1;
		System.out.print(prev2 + "\t");
		System.out.print(prev1 + "\t");
		for (int num = 0; num < number;) {
			num = prev2 + prev1;
			System.out.print(num + "\t");
			prev2 = prev1;
			prev1 = num;
		}
	}

}
