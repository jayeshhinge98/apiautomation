package com.test.oopsPrograms.Inheritance;

public class A {
	
	public void displayA(){
		System.out.println("I am in Class A");
	}
	protected void displayPrivate(){
		System.out.println("This is private method from Class A");
	}
public int addition(int A, int B){
	return A+B;
}

public int addition(int A, int B,int C){
	C=A+B;
	return C;
}

	
}
