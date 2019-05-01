package com.test.StringPrograms;

public class ReverseString {

	public static void main(String[] args) {

		String s = "Jayesh Hinge";
		// 1. Using CharAt
		String rev = "";
		for (int j = s.length() - 1; j >= 0; j--) {
			rev = rev + s.charAt(j);
		}
		System.out.println("Reverse of string using CharAt:" + rev);

		//2. Using StringBuffer
		StringBuffer sb=new StringBuffer(s);
		System.out.println("Reverse of string using String Buffer:" + sb.reverse());
	
		//3. Using StringBuilder
		StringBuilder sb1=new StringBuilder(s);
		System.out.println("Reverse of string using String Builder:" + sb1.reverse());
		
		//4. Using character array
		String chrarr="";
		char ch[]=s.toCharArray();
		for(int i=ch.length-1;i>=0;i--)
		{
			chrarr+=ch[i];
		}
		System.out.println("Reverse of string using Char Array:" + chrarr);
		
		//
		
	}

}
