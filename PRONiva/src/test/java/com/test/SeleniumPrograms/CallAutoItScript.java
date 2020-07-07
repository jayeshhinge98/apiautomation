package com.test.SeleniumPrograms;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CallAutoItScript {
	@Test
	public void importFileUsingAutoIT() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users/Sai/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");
		// driver.findElement(By.id("uploadfile")).sendKeys("D:/Device info.PNG");;
		// above line is working to select file
		// now we will use AutoIt

		// WinWaitActive("Open")
		// Send("C:\Users\Sai\Downloads\ImportantLinks.txt")
		// Send("{Enter}")
		// D:\\UploadFileScript1.exe

		// ControlFocus("Open","","Edit1")
		// ControlSend("Open","","Edit1","C:\Users\Sai\Downloads\ImportantLinks.txt")
		// ControlClick("Open","","Button1")
		// D:\\UploadFileScript2.exe
		
		driver.findElement(By.id("uploadfile")).click();
		try {
			Runtime.getRuntime().exec("D:\\UploadFileScript2.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
