package com.test.SeleniumPrograms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleAlerts {
	/////// These are javascripts alerts
	//  It can also handle the Leave and Cancel pop-up
	
	@Test
	public void handleAlerts() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users/Sai/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.findElement(
				By.xpath("//button[text()='Click me!' and @class='btn btn-default']"))
				.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text:"+alert.getText());
		alert.accept();// dismiss();
		driver.findElement(
				By.xpath("//button[text()='Click me!' and @class='btn btn-default btn-lg']"))
				.click();
		System.out.println("Alert text:"+alert.getText());
		// alert=driver.switchTo().alert();
		alert.accept();
		driver.findElement(
				By.xpath("//button[text()='Click me!' and @class='btn btn-default btn-lg']"))
				.click();
		System.out.println("Alert text:"+alert.getText());
		// alert=driver.switchTo().alert();
		alert.dismiss();
		driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"))
				.click();
		alert=driver.switchTo().alert();
		alert.sendKeys("Jayesh Hinge");
		System.out.println("Alert text:"+alert.getText());
		alert.accept();
		

	}
}
