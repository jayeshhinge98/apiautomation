package com.test.StringPrograms;

public class AboutStringSBufferSBuilder {

	public static void main(String[] args) {

		// String is immutable which means unmodifiable and unchangeable. Once
		// it is modified, new memory gets created.
		// ********* String stored in heap memory
		// Refer below example:
		String s = "Jayesh Hinge";
		System.out.println("Address for the s:"
				+ Integer.toHexString(s.hashCode()));

		// Now create another string with same value and check the address, it
		// will be same because it is pointing to the same location in memory.
		String s1 = "Jayesh Hinge";
		System.out.println("Address for the s1:"
				+ Integer.toHexString(s1.hashCode()));

		// Now change the text for string and print the hash code,will allocates
		// new memory location
		String s2 = "Mr" + s1;
		System.out.println("Address for the s2:"
				+ Integer.toHexString(s2.hashCode()));

		/*
		 * Why string objects are immutable in java? ======> Because java uses
		 * the concept of string literal.Suppose there are 5 reference
		 * variables,all refers to one object "Sachin".If one reference variable
		 * changes the value of the object, it will be affected to all the
		 * reference variables. That is why string objects are immutable in
		 * java.
		 */

		/*
		 * StringBuffer :Java StringBuffer class is used to create mutable
		 * (modifiable) string. The StringBuffer class in java is same as String
		 * class except it is mutable i.e. it can be changed.
		 * ********************It is synchronized.****************************
		 * Note: Java StringBuffer class is thread-safe i.e. multiple threads
		 * cannot access it simultaneously. So it is safe and will result in an
		 * order.
		 */

		StringBuffer sbf1 = new StringBuffer("Jayesh Hinge");
		StringBuffer sbf2 = new StringBuffer("Jayesh Hinge");
		System.out.println("Address for the sbf1:"
				+ Integer.toHexString(sbf1.hashCode()));
		System.out.println("Address for the sbf2:"
				+ Integer.toHexString(sbf2.hashCode()));

		/*
		 * Java StringBuilder class is used to create mutable (modifiable)
		 * string. The Java StringBuilder class is same as StringBuffer class
		 * except that it is non-synchronized
		 */

		StringBuilder sbd1 = new StringBuilder("Jayesh Hinge");
		StringBuilder sbd2 = new StringBuilder("Jayesh Hinge");
		System.out.println("Address for the sdf1:"
				+ Integer.toHexString(sbd1.hashCode()));
		System.out.println("Address for the sdf2:"
				+ Integer.toHexString(sbd2.hashCode()));

		/*
		 * Non synchronized(StringBuilder) -It is not-thread safe and can't be shared between
		 * many threads without proper synchronization code. While,
		 * Synchronized(StringBuffer)- It is thread-safe and can be shared with many threads.
		 */

	}
}
