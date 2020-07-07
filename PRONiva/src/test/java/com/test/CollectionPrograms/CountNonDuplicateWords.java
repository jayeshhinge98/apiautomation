package com.test.CollectionPrograms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountNonDuplicateWords {

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
		System.out.println("Before removing duplicates, count= " + m.size());
		// print only non-duplicate words
		// Using Iterator

		Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
		int count = 0;
		while (it.hasNext()) {
			Map.Entry<String, Integer> ent = it.next();
			if (ent.getValue() < 2) {
				// System.out.print(ent.getKey() + "\t");
				count++;
			}
		}
	//	System.out.println("");
		System.out.println("After removing duplicates, count= " + count);

		// Using For loop
		int count2=0;
		for(Map.Entry<String, Integer> etr: m.entrySet()){
			//System.out.println("Key: "+etr.getKey()+"\tValue: "+etr.getValue());
			if(etr.getValue()<2)
				count2++;
		} 
		System.out.println("Count is: "+count2);

		// Using ketSet() or values() functions 
        for (String name : m.keySet())  
            System.out.print("key: " + name+" \t"); 
        System.out.println("");
        // using values() for iteration over keys 
        for (Integer url : m.values())  
            System.out.print("value: " + url+" \t");
		
	}

}
