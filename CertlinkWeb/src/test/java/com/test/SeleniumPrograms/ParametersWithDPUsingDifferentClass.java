package com.test.SeleniumPrograms;

import org.testng.annotations.Test;

public class ParametersWithDPUsingDifferentClass {
  @Test(dataProvider="testDP",dataProviderClass=DataProviderClass.class)
  public void testingDP(String s1,String s2) {
  System.out.println(s1+" Name: "+s2);
  }
}
