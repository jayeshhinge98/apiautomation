package com.test.Selenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WindowHandling {
	
	@Test
	public void testWindowHandle() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.speedtest.net/#");
		String parent=driver.getWindowHandle();
		Thread.sleep(4000);		
		driver.findElement(By.xpath("//a[text()='See Rankings']")).click();
		Thread.sleep(4000);
		
		
		/**********Method 1: Using iterator*************/
		
//		Set<String> getWindows=driver.getWindowHandles();
//		Iterator<String> iterator = getWindows.iterator();
//		if (iterator.hasNext()) {
//			String child= iterator.next();
//			System.out.println(child);
//			if(!child.equalsIgnoreCase(parent))
//				driver.switchTo().window(child);
//				System.out.println("Print title:"+driver.getTitle());
//				Thread.sleep(4000);
//				driver.close();
//			driver.switchTo().window(parent);
//			System.out.println("Print parent title:"+driver.getTitle());
//			
//		}
		
		
		/**********Method 2: Easy method as compared to above*************/
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs);
		driver.switchTo().window( tabs.get(1));
		System.out.println("Print title:"+driver.getTitle());
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window( tabs.get(0));
		System.out.println("Print title:"+driver.getTitle());
	
		try {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
