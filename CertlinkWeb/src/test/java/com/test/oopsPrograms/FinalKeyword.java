package com.test.oopsPrograms;

public class FinalKeyword {

	static final int k = 30;

	static final String s(){
		return "Test";
		
	}
	
	// A static final variable that is not initialized at the time of
	// declaration is known as static blank final variable. It can be
	// initialized only in static block.

	public static void main(String[] args) {
		final int i = 10;
		System.out.println("Final value: " + i);
		// i=i+10; not allowed, it cannot be changed
		final int j;// can be assign value later
		j = 20;
		System.out.println("Final value: " + j);
		System.out.println("Final value with static keyword: " + k);
		System.out.println("Static final method result: " + s());
	}
}
