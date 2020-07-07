package com.test.SeleniumPrograms;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;

public class DynamicTableElement {

	@Test(priority = 1, enabled = false)
	public void dynamicLocatorForTableFun() {

		System.setProperty("webdriver.chrome.driver",
				"C://Users/Sai/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		String createdrecord = "A. Ramos";
		List<WebElement> l = driver.findElements(By
				.xpath("//table[@id='example']/tbody/tr/td[text()='"
						+ createdrecord + "']//following-sibling::td"));
		List<String> s = new LinkedList<String>();
		l.forEach(webelement -> {
			s.add(webelement.getText());
		});
		s.forEach(string -> {
			System.out.println(string + "\t");
		});
		System.out.println("------------"
				+ CharMatcher.digit().retainFrom(s.get(4)));
		int salary = Integer.parseInt(CharMatcher.digit().retainFrom(s.get(4)));
		System.out.println("Salary of " + createdrecord + " is: " + salary);
		System.out.println("Salary of " + createdrecord + " is: "
				+ Integer.valueOf(CharMatcher.digit().retainFrom(s.get(4))));
		driver.close();
		System.out.println("Salary of " + createdrecord + " is: "
				+ Integer.valueOf(s.get(4).replaceAll("[^0-9]", "")));
	}

	@Test(priority = 2)
	public void DynamicTableWithLinkedHashMap() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users/Sai/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		String createdrecord = "A. Ramos";
		List<WebElement> data = driver.findElements(By
				.xpath("//table[@id='example']/tbody/tr/td[text()='"
						+ createdrecord + "']//following-sibling::td"));
		List<WebElement> headers = driver.findElements(By
				.xpath("//table[@id='example']/thead/tr/th"));
		Map<String, String> m = new LinkedHashMap<String, String>(); // maintain
																		// insertion
																		// order
		List<String> key = new LinkedList<String>();
		List<String> value = new LinkedList<String>();
		value.add(createdrecord);
		data.forEach(webele -> {
			value.add(webele.getText());
		});
		headers.forEach(webele -> {
			key.add(webele.getText());
		});
		for (int i = 0; i < key.size(); i++) {
			m.put(key.get(i), value.get(i));
		}
		System.out.println(key);
		System.out.println(value);
		System.out.println(m);
		System.out.println("Salary of " + m.get("Name") + " is: "
				+ m.get("Salary"));
		driver.quit();

	}

}
