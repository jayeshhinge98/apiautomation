package com.test.StringPrograms;

import java.util.HashMap;
import java.util.Map;

public class CountOfWordInString {

	public static void main(String[] args) {

		// 1. Find count of words using string functions
		String s = "This is the text used	I to	 find the number of words in the String 123 345. $";
		//This considers the special characters as well
		String[] arr = s.split(" ");
		System.out.println(arr.length + " words.");
		// This considers the tabs as word
		String[] arr1 = s.split("\\s");
		System.out.println(arr1.length + " words.");
		//This is perfect solution to find exact number of words in sentence ignores special characters
		String[] arr2 = s.split("\\W+");
		System.out.println(arr2.length + " words.");
		
		System.out.println(wordcount("This is it 	to count") + " words.");
	}

	// 2. Find count of words in string using char array.
	static int wordcount(String string) {
		int count = 0;

		char ch[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			ch[i] = string.charAt(i);
			if (((i > 0) && (ch[i] == ' '))
					|| (i == string.length() - 1 && (ch[i] != ' ') && ch[i] != '\t'))
				count++;
		}
		return count;
	}
	
	
}
