package com.test.StringPrograms;

import java.util.regex.Pattern;

import com.google.common.base.CharMatcher;

public class FindNumbersFromString {

	public static void main(String[] args) {
		
		String s="Jayesh Hinge 123 Flat 401";
		// using CharMatcher
		System.out.println(CharMatcher.digit().retainFrom(s));
		
		// using replaceAll
		System.out.println(s.replaceAll("[^0-9]", ""));
	
		System.out.println(s.indexOf("esh"));
		
	}

}
