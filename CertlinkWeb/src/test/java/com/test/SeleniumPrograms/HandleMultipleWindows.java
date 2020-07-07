package com.test.SeleniumPrograms;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleMultipleWindows {
	@Test
	public void multipleWindowHandling() {
		System.setProperty("webdriver.chrome.driver",
				"D://QA/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(
				By.xpath("//*[contains(text(),'Follow On Twitter')]")).click();
		Set<String> s = driver.getWindowHandles();
		for (String s1 : s) {
			if (!parentWindow.equals(s1)) {
				 try {
	                    Thread.sleep(5000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
				driver.switchTo().window(s1);
				System.out.println("Title of pop-up is: " + driver.getTitle());
				driver.close();
			}
		}
	    driver.switchTo().window(parentWindow);
		driver.findElement(
				By.xpath("//*[contains(text(),'Like us On Facebook')]")).click();
		Set<String> s2 = driver.getWindowHandles();
		for (String s1 : s2) {
			if (!parentWindow.equals(s1)) {
				 try {
	                    Thread.sleep(5000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
				driver.switchTo().window(s1);
				System.out.println("Title of pop-up is: " + driver.getTitle());
				driver.close();
			}
		}
	    
		
	}
}
