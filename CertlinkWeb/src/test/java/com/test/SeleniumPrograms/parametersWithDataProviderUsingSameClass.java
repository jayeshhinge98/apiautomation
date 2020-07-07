package com.test.SeleniumPrograms;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parametersWithDataProviderUsingSameClass {
  @DataProvider(name="testDP")
  public Object[][] dataProviderMethod() {
	  return new Object[][]{
			  {"First","Jayesh"},
			  {"Last","Hinge"},		  
	  } ;
  }
  
  @Test(dataProvider="testDP")
  public void print(String s1,String s2){
	  System.out.println(s1+" Name:"+s2);
  }
}
