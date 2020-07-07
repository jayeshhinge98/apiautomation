package com.test.OtherPrograms;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

	public static void main(String[] args) {
		Integer [] arr = {10, 20, 30, 40, 50}; 
		
		Collections.reverse(Arrays.asList(arr));
		System.out.println(Arrays.asList(arr));
		
		Collections.reverse(Arrays.asList(arr));
		System.out.println(Arrays.asList(arr));

		// or
		int j[]=new int[arr.length];
		int len=arr.length;
		for (int i = 0; i < arr.length; i++) {
			j[i]=arr[len-1];
			len=len-1;
		}
		for (int i = 0; i < j.length; i++) {
			System.out.print(j[i]+"\t");
		}
		//System.out.println("Another way.."+Arrays.asList(j));
	}

}
