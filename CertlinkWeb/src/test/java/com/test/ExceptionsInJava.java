package com.test;

public class ExceptionsInJava{
	public static void add() throws java.lang.ArithmeticException{
		try{
		int a=10;
		int b=0;
	//	int i=a/b;
	//	System.out.println("Test result:"+i);
		//throw  new ArithmeticException();
		throw  new NullPointerException();
		}catch(Exception e){
			System.out.println("Exception: "+e);
		}
		}
	public static void main(String str[]){
		add();
	}
	
}