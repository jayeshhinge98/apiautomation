package com.test.OtherPrograms;

import java.util.Scanner;

public class CheckPrimeNumber {

	// Number which is divided by 1 or itself is prime number

	public static void main(String[] args) {

		boolean b = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out
					.println("Enter number to check whether it is prime or not:");
			int number = sc.nextInt();
			checkprime(number);
			System.out.print("Do you want to continue..y/n=>");
			String s = sc.next();
			if (s.equals("y")) {
				b = false;
			} else {
				b = true;
			}
		} while (!b);
	}

	public static void checkprime(int number) {
		int count = 0;
		for (int i = 1; i <= number; i++) {
			if (number / i == number || number % i == 0)
				count++;
		}
		if (count == 2) {
			System.out.println("Number is prime number.....!");
		} else {
			System.out.println("Number is not prime number...!");
		}

	}

}
