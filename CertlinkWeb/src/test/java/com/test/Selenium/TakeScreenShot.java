package com.test.Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TakeScreenShot {
		
	@Test
	public void randomName() throws IOException {
		
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		TakesScreenshot tc=(TakesScreenshot) driver;		
		File source=tc.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"//Screenshots//" + "demo.png"	;
		File destination=new File(dest);
		FileUtils.copyFile(source, destination);
	}
}
