package com.test.OtherPrograms;

import java.util.Scanner;

public class PatternPyramidPrograms {

	public static void main(String[] args) {
		
		System.out.println("Enter number of levels for pyramid..");
		Scanner sc=new Scanner(System.in);
		int level=sc.nextInt();
		System.out.println("=============================");
		for (int i = 0; i <= level; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=============================");
		for (int i = level; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=============================");
		for (int i = 0; i <= level; i++) {
			for (int j = level; j>=i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
	}

}
