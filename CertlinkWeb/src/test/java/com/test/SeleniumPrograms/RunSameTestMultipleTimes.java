package com.test.SeleniumPrograms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

// To run same test case multiple times by using annotation attribute "invocationCount"

public class RunSameTestMultipleTimes {
	static int count=1;
  @Test(invocationCount=20)
  public void runMethod() {
	  System.out.println("Count.."+count);
	  count++;
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
