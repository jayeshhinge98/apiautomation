package com.test.StringPrograms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CountOfEachWordInString {

	public static void main(String[] args) {
		String s = "This is the text used to find the number of words in the String, which means it used to find count.";
		String[] arr = s.split(" ");
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (m.containsKey(arr[i])) {
				m.put(arr[i], m.get(arr[i].trim()) + 1);
			} else {
				m.put(arr[i].trim(), 1);
			}

		}
	
		// print only non-duplicate words 
		Iterator<Map.Entry<String, Integer>> it=m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String , Integer> ent=it.next();
			if(ent.getValue()<2){
				System.out.print(ent.getKey()+"\t");
			}
			
		}
		System.out.println("");
		
		System.out.println(m);
		System.out.println("Enter word to find count of it:=> ");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		if (m.get(input) == null) {
			System.out.println("Entered word is not found in Sentense..");
		} else {
			System.out.println("Value for \"" + input + "\" is:="
					+ m.get(input));
		}

	}

}
