package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class demo3 extends demo1{
	public static WebDriver chdriver = null;
	///demo1 d=new demo1();

	@Test
	public void demo31() {
		System.setProperty("webdriver.chrome.driver",
				"D:/chromedriver.exe");
		chdriver = new ChromeDriver();
		chdriver.manage().window().maximize();
		chdriver.get("https://accounts.google.com/ServiceLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=AddSession");
		//chdriver.findElement(nextUI).click();
		//System.out.println(msgUI.getText());
		
	}

}
