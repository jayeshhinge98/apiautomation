package com.test.OtherPrograms;

public class SwapNumbers {

	public static void main(String[] args) {
	
		// with temp variable
		int a=10;
		int b=20;
		int temp=0;
		System.out.println("Numbers before swapping are: a= "+a+"\tb= "+b);
		temp=a;
		a=b;
		b=temp;
		System.out.println("Numbers after swapping are: a= "+a+"\tb= "+b);
		
		//without temp variable
		int a1=10;
		int b1=20;
		System.out.println("Numbers before swapping are: a= "+a1+"\tb= "+b1);
		a1=a1+b1;
		b1=a1-b1;
		a1=a1-b1;
		System.out.println("Numbers after swapping are: a= "+a1+"\tb= "+b1);
		
	}

}
