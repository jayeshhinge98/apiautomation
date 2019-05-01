package com.test.CollectionPrograms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.sun.org.apache.bcel.internal.generic.L2D;
import com.test.demo4;

public class ListTesting extends demo4 {

	public static void main(String[] args) {

		// List Interface is the subinterface of Collection. It contains index-based
		// methods to insert and delete elements. It is a factory of ListIterator
		// interface.
		// Methods- add(int index, E element), remove(int index), clear()
		// Iterator- ListIterator, listIterator()
		
		
		List<String> l1=new ArrayList<String>();
		l1.add("Test");
		l1.add("Test2");
		System.out.println(l1);
		l1.add(1, "Test3");
		System.out.println(l1);
		
		ListIterator<String> it=l1.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		
		//Array List
		ArrayList<Integer> l4=new ArrayList<>();
		l4.add(5);
		l4.add(6);
		System.out.println("ArrayList:"+l4);
		
		//Linked list
		
		List<String> l2=new LinkedList<String>();
		l2.add("LinkedList1");
		l2.add("LinkedList2");
		l2.add("LinkedList3");
		ListIterator<String> llit=l2.listIterator();
		System.out.println("Linked list data using List object:"+l2);
		while(llit.hasNext()) {
			System.out.println(llit.next());
		}
		LinkedList<String> l3=new LinkedList<String>();
		l3.addAll(l2);
		System.out.println("Linked List data:"+l3);
		
		
		
	}
	
/*	ArrayList VS LinkedList
	1) ArrayList internally uses a dynamic array to store the elements.	
	   LinkedList internally uses a doubly linked list to store the elements.
	2) Manipulation with ArrayList is slow because it internally uses an array. If any element is removed from the array, all the bits are shifted in memory.	
	   Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, so no bit shifting is required in memory.
	3) An ArrayList class can act as a list only because it implements List only.	
	   LinkedList class can act as a list and queue both because it implements List and Deque interfaces.
	4) ArrayList is better for storing and accessing data.	
	   LinkedList is better for manipulating data.
*/	
	
	
	

}
