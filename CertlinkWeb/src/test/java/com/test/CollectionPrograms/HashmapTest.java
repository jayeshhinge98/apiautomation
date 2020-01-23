package com.test.CollectionPrograms;

import java.util.HashMap;
import java.util.Hashtable;

public class HashmapTest {

	public static void main(String[] args) {
	
		HashMap<Integer, String> m=new HashMap<Integer, String>();
		m.put(22,"Test");
		m.put(23,"Test");
		m.put(24,"Test1");
	//	m.put(23,"Test2323");
		m.put(25,"Test2323");
		m.put(null,"testpal");
		m.put(null,"testpal1");
		m.put(26,null);
		m.put(27,null);
		System.out.println("Map details:"+m);
		m.remove(22);
		System.out.println("Map details:"+m);
		
		Hashtable<Integer, String> m1=new Hashtable<Integer, String>();
		m1.put(22,"Test");
		m1.put(23,"Test");
		m1.put(24,"Test1");
	//	m1.put(23,"Test2323");
		m1.put(25,"Test2323");
	//	m1.put(26,null);
	//	m1.put(null,"testpal");
		System.out.println("Map details:"+m1);
		m1.remove(22);
		System.out.println("Map details:"+m1);
		
	}

}