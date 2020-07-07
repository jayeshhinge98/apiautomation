package com.test.SeleniumPrograms;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenshots {
	@Test
	public void screenshot() {
		System.setProperty("webdriver.chrome.driver",
			"D://QA/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
		screenshotCM(driver);
		//File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	}

	public void screenshotCM(WebDriver driver) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,
					new File("D:/MyScreenshot" + System.currentTimeMillis()
							+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
