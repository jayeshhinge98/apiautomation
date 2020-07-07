package com.test.CollectionPrograms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetProgram {

	public static void main(String[] args) {

		// Java HashSet class is used to create a collection that uses a hash
		// table for storage. It inherits the AbstractSet class and implements
		// Set interface.
		// The important points about Java HashSet class are:
		// HashSet stores the elements by using a mechanism called hashing.
		// HashSet contains unique elements only.
		// HashSet allows null value.
		// HashSet class is non synchronized.
		// IMP: HashSet doesn't maintain the insertion order. Here, elements are
		// inserted on the basis of their hashcode.
		// HashSet is the best approach for search operations.
		

		/*
		 * Difference between List and Set A list can contain duplicate elements
		 * whereas Set contains unique elements only.
		 */

		Set<String> s = new HashSet<String>();
		s.add("one");
		s.add("two");
		s.add("six");
		s.add("three");
		s.add("four");
		s.add("four");// contains unique elements
		s.add(null);// allows null value
		s.add(null);// no duplication allowed, if tries to add then it will not
					// give exception
		System.out.println("Set: " + s); // doesn't maintain insertion order
		System.out.println("======Print set using forEach=====");
		s.forEach(string -> {
			System.out.print(string + "\t");
		});
		System.out.println();
		System.out.println("======Print set using Iterator=====");
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "\t");
		}
		System.out.println();
		// Remove element from set
		s.remove("one");
		System.out.println("=====Set after removing element====");
		System.out.println("Set: " + s);

		// contains method
		System.out.println("Element present or not using Contains() method: "
				+ s.contains("two"));
		System.out.println("Element present or not using Contains() method: "
				+ s.contains("one"));

		// Convert set to array
		Object[] arr = s.toArray();
		System.out.println("====Convert set to Array====");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		System.out.println("====Convert set to list====");
		List<String> l = new LinkedList<String>();
		s.forEach(string -> {
			l.add(string);
		});
		l.forEach(list -> {
			System.out.print(list + "\t");
		});
		
	}
}