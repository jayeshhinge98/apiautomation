package com.test.SeleniumPrograms;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Way 1: This can be done by executing testng-failed.xml file as TestNG Suite
// Way 2: 
public class ExecuteFailedTestCases  implements IRetryAnalyzer {
	int count=0;
	@BeforeTest
	public void beforeTest() {
	}

	@Test(retryAnalyzer=ExecuteFailedTestCases.class)
	public void failureMethod() {

		Assert.assertEquals(false, true);
		System.out.println("Testing demo..");
	}

	@Test(retryAnalyzer=ExecuteFailedTestCases.class)
	public void passMethod() {

		Assert.assertEquals(true, true);
		System.out.println("Testing demo..");
	}

	@Test(retryAnalyzer=ExecuteFailedTestCases.class)
	public void failureMethod2() {
		System.out.println("Testing demo..");
		Assert.assertEquals(false, true);

	}

	@AfterTest
	public void afterTest() {
		
		
	}

	@Override
	public boolean retry(ITestResult result) {
		
		final int maxAttemptCount=2;
		if(count<maxAttemptCount){
			count++;
			return true;
		}
		return false;
	}
	
}
