package com.test.SeleniumPrograms;

import org.testng.annotations.DataProvider;


public class DataProviderClass {
	@DataProvider(name="testDP")
	public Object[][] DataProMethod() {
		return new Object[][]{
				{"First","Jayesh"},{"Last","Hinge"}
		};
	}
}
