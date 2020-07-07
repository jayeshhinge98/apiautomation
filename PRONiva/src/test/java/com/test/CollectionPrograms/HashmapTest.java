package com.test.CollectionPrograms;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.gargoylesoftware.htmlunit.javascript.host.html.Enumerator;

public class HashmapTest {

	public static void main(String[] args) {

		// A Map contains unique keys.
		// A Map is useful if you have to search, update or delete elements on
		// the basis of a key.
		// 
		//
		// HashMap HashMap is the implementation of Map, but it doesn't maintain
		// any order.
		// LinkedHashMap LinkedHashMap is the implementation of Map. It inherits
		// HashMap class. It maintains insertion order.
		// TreeMap TreeMap is the implementation of Map and SortedMap. It
		// maintains ascending order.

		
		// HashMap Vs Hashtable
		// 1) HashMap is non synchronized. It is not-thread safe and can't be
		// shared between many threads without proper synchronization code.
		// Hashtable is synchronized. It is thread-safe and can be shared with
		// many threads.
		// 2) HashMap allows one null key and multiple null values. Hashtable
		// doesn't allow any null key or value.
		// 4) HashMap is fast. Hashtable is slow.
		// 5) We can make the HashMap as synchronized by calling this code
		// Map m = Collections.synchronizedMap(hashMap); Hashtable is internally
		// synchronized and can't be unsynchronized.
		// 8) HashMap inherits AbstractMap class. Hashtable inherits Dictionary
		// class.
		
		

		HashMap<Integer, String> m = new HashMap<Integer, String>();
		m.put(22, "Test");
		m.put(23, "Test");
		m.put(24, "Test1");
		// m.put(23,"Test2323");
		m.put(25, "Test2323");
		m.put(null, "testpal");// allows only one null key
		m.put(null, "testpal1");// only value replaced here for null key
		m.put(26, null);// multiple null values allowed for different keys
		m.put(27, null);
		System.out.println("Map details:" + m);
		m.remove(22);
		System.out.println("Map details:" + m);

		System.out.println("=================Ways to iterate Map=========");
		System.out.println("==========1. Using Map.entrySet()==============");
		for (Map.Entry<Integer, String> mp : m.entrySet()) {
			System.out.println("Key: " + mp.getKey() + "\tValue: "
					+ mp.getValue());
		}
		System.out.println("==========2. Using iterator==============");
		Iterator<Map.Entry<Integer, String>> it = m.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry mp2 = (Map.Entry) it.next();
			System.out.println("Key: " + mp2.getKey() + "\tValue: "
					+ mp2.getValue());

		}
		
		System.out
				.println("==========3. using forEach(BiConsumer)==============");
		m.forEach((k, v) -> {
			System.out.println("Key: " + k + "\tValue: " + v);
		});

		Hashtable<Integer, String> m1 = new Hashtable<Integer, String>();
		m1.put(22, "Test");
		m1.put(23, "Test");
		m1.put(24, "Test1");

		m1.put(25, "Test2323");
		// m1.put(26,null);
		// m1.put(null,"testpal");
		System.out.println("HashTable details:" + m1);
		m1.remove(22);
		m1.put(23, "Test2323");
		System.out.println("HashTable details:" + m1);

		System.out.println("============Ways to iterate HashTable=========");
		
		System.out
				.println("==========1. using forEach(BiConsumer)==============");
		m1.forEach((k, v) -> {
			System.out.println("Key: " + k + "\tValue: " + v);
		});
		System.out
		.println("==========2. using Enumerations==============");

		Enumeration<Integer> et = m1.keys();
		while (et.hasMoreElements()) {
			Integer key=et.nextElement();
			System.out.println("Key: " + key + "\tValue: " + m1.get(key));
		}
	}
}