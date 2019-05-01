package com.test.OtherPrograms;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {

		int arr1[] = { 23, 43, 763, 75, 22, 55, 44 };
		int arr[] = { 23, 43, 763, 75, 22, 55, 44, 1 };
		// With using Arrays.sort() function
		Arrays.sort(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + ":");
		}

		// Without using sort function
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ":");
		}

	}

}
