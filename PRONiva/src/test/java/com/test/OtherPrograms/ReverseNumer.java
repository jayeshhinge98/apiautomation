package com.test.OtherPrograms;

public class ReverseNumer {

	public static void main(String[] args) {
		
		int i=234;
		int reverseNumber = 0;
		while(i!=0){
			reverseNumber=reverseNumber*10+i%10;
			i=i/10;
		}
		System.out.println(reverseNumber);
	}

}
