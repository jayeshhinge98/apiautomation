package com.test.StringPrograms;

public class LengthOfString {

	public static void main(String[] args) {
		String s = "Jayesh";
		int count = 0;
		
		// 1. WITHOUT USING LENGTH FUNCTION
		for (char c : s.toCharArray()) {
			count++;
		}
		System.out.println("Length of String \"" + s + "\" is=" + count);

		// 2. WITH USING LENGTH FUNCTION
		System.out.println("Length of String \"" + s + "\" is=" + s.length());

		
	}

}
