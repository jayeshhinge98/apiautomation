package com.test.CollectionPrograms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConvertHashMapToArray {

	public static void main(String[] args) {
		HashMap<Integer, String> mp = new HashMap<Integer, String>();
		mp.put(3, "Three");
		mp.put(1, "One");
		mp.put(-5, null);
		mp.put(null, null);
		mp.put(null, "Six");
		mp.put(4, "Four");
		mp.put(2, "Two");
		System.out
				.println("============Print hash map using advance for loop=================");
		for (Map.Entry<Integer, String> s : mp.entrySet()) {
			System.out.println("Key:" + s.getKey() + "\t Value:" + s.getValue()
					+ "\t");
		}
		// System.out.println("HashMap: "+mp);

		// One way to store hashmap to array using for loop
		Integer key[] = new Integer[mp.size()];
		Object value[] = new Object[mp.size()];
		int count = 0;
		for (Map.Entry<Integer, String> s : mp.entrySet()) {

			key[count] = s.getKey();
			value[count] = s.getValue();
			count++;
		}
		System.out
				.println("============Using iterate over keys and values=================");
		for (int i = 0; i < value.length; i++) {
			System.out.println("Key:" + key[i] + "\t Value:" + value[i] + "\t");
		}

		// another way using toArray() function
		Integer it[] = new Integer[mp.size()];
		Object ob[] = new Object[mp.size()];
		// it=mp.keySet();
		it = mp.keySet().toArray(new Integer[mp.size()]);
		ob = mp.values().toArray(new Object[mp.size()]);
		System.out
				.println("============Using toArray(obj) function=================");
		for (int i = 0; i < ob.length; i++) {
			System.out.println("Key:" + it[i] + "\t Value:" + ob[i] + "\t");
		}

		System.out
		.println("============Using iterator function=================");
		Integer it2[] = new Integer[mp.size()];
		Object ob2[] = new Object[mp.size()];
		int count2=0;
		Iterator<Map.Entry<Integer,String>> it1=mp.entrySet().iterator();
		while(it1.hasNext()){
			 Map.Entry mapping = (Map.Entry) it1.next();

				it2[count2]=(Integer) mapping.getKey();
				ob2[count2]=mapping.getValue();
				count2++;
		}
		for (int i = 0; i < ob.length; i++) {
			System.out.println("Key:" + it2[i] + "\t Value:" + ob2[i] + "\t");
		}

		
		
		
	}

}
