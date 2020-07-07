package com.test.SeleniumPrograms;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTesting {

	@Parameters({"First","Last"})
	@Test
	public void useParameters(String firstName,String lastName) {
		System.out.println("Full Name is:"+firstName+" "+lastName);
	}
}
