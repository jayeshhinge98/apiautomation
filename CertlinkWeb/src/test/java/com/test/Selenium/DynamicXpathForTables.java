package com.test.Selenium;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DynamicXpathForTables {

	@Test
	public void xpathsForTables() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/web-table-element.php");

		System.out.println("Table Headers:");
		List<WebElement> column = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		for (WebElement s : column) {
			System.out.print( s.getText()+"\t");
		}
		System.out.println("\nTable Data:");
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		for (WebElement s : rows) {
			//System.out.print( s.getText()+"\n");
		}
		
		String cName="Kansai Nerolac Paint";
		
		// Dynamic xpath
		System.out.println("Data using row number and column number is:"+getValueUsingRowColumn(driver, 7, 1));
//		
//		while(isDisplayed(cName, driver)){
//		System.out.println("Not present");
//		}
		System.out.println("Previous Closing:"+getValueUsingName(driver, cName, 2));
		System.out.println("Current Closing:"+getValueUsingName(driver, cName, 3));
		
//		try {
//			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	String getValueUsingRowColumn(WebDriver driver,int rownum,int colnum) {
		//this is dynamic xpath
		return driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr["+rownum+"]/td["+colnum+"]")).getText();
				
	}
	String getValueUsingName(WebDriver driver,String company,int colnum) {
		//this is dynamic xpath
		return driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr//a[contains(text(),'"+company+"')]/parent::*/following-sibling::td["+colnum+"]")).getText();
				
	}
	
	boolean isDisplayed(String xpath,WebDriver driver) {
		boolean b=false;
		try {
			b=driver.findElement(By.xpath(xpath)).isDisplayed();
		}
		catch(Exception e) {
			System.out.println("Not displayed");
			driver.navigate().refresh();
		}
	
		return b; 
	}
	//@AfterMethod
	
}
