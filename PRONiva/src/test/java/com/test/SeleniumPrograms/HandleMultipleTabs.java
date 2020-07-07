package com.test.SeleniumPrograms;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleMultipleTabs {
	@Test
	public void handleMutipleTabs() {
		System.setProperty("webdriver.chrome.driver",
				"D://QA/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/a"))
				.click();
		Set<String> s = driver.getWindowHandles();
		for (String s1 : s) {
			if(!s1.equals(parentWindow)){
				 try {
	                    Thread.sleep(5000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
				
				driver.switchTo().window(s1);
				System.out.println("Switched to tab:"+driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.name("first_name")).sendKeys("Jayesh");
	}
}
