package com.test.oopsPrograms.Inheritance;


public class inheritance {

	public static void main(String[] args) {

		
		
		C c1=new C();
		c1.displayA();//A
		c1.displayB();//C
		c1.displayC();//C
		c1.displayPrivate();//A
		
		//C c1=new B();// or new A();
		B b1=new B();
		//Object b=new ArrayList();
		b1.displayB();//B
		b1.displayA();//A
		b1.displayPrivate();//A
		
		B b2=new C();
		b2.displayA();//A
		b2.displayPrivate();//A
		b2.displayB();//C
		
		A a1=new A();
		a1.displayA();
		a1.displayPrivate();
		
		A a2=new C();
		a2.displayPrivate();

		c1.addition(20, 30);
		
		b1.addition(20, 20);
		
		
	}

}


