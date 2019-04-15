package com.test.StringPrograms;

import java.util.Arrays;

public class StringFunctions {

	public static void main(String[] args) {
		String s1 = "Jayesh Hinge";
		System.out.println("CharAt: " + s1.charAt(3));// e
		System.out.println("Concat: " + s1.concat(" Test"));//
		System.out.println(s1);// s1
		System.out.println("Index of: " + s1.indexOf("e")); // 3
		System.out.println("Last Index of: " + s1.lastIndexOf("e"));// 11
		System.out.println("Last Index of: " + s1.lastIndexOf(74));// 0
		// Add ASCII value for it, if not present it returns -1
		System.out.println("Length: " + s1.length());// 12
		System.out.println("Replace: " + s1.replace("esh", ""));// Jay Hinge
		System.out.println(s1);// s1
		System.out.println("Replace char seq: " + "aaanand".replace("aa", "b"));// banand
		System.out.println("Replace: " + "Jayesh91".replaceAll("[0-9]", "A"));// JayeshAA
		System.out.println("Replace: "
				+ "JayeSh91 HinGe".replaceAll("[A-Z]", "A")); // AayeAh91 AinAe
		System.out.println("Replace: "
				+ "JayeSh91 HinGe".replaceFirst("[A-Z]", "*"));// *ayeSh91 Hinge
		System.out.println("Substring :" + s1.substring(2));// esh Hinge
		System.out.println("Substring :" + s1.substring(2, 8));// esh Hi
		System.out.println("Split :" + Arrays.toString(s1.split("h")));// Jayes
																		// Hinge
		System.out.println("Split :" + Arrays.toString(s1.split("\\s")));// Jayesh
																			// Hinge
		String ar[] = "Jayesh, Kopargaon, Ahamednagar".split(",", 2);
		System.out.println("Split with limit :" + ar[0]);// Jayesh
		System.out.println("Split with limit :" + ar[1]);// Kopargaon,
															// Ahamednagar
		System.out.println("Trim :" + " Jay Hinge ".trim());// Jay Hinge
		System.out.println("Join :"
				+ String.join(",", s1, "Kopargaon", "Ahmednagar"));
		System.out.println("Join :" + String.valueOf(10.12).concat(" Hinge"));
		String str = "Javatpoint";
		System.out.println(str.startsWith("J")); // True
		System.out.println(str.startsWith("a")); // False
		System.out.println(str.startsWith("a", 1)); // True

	}

}
