package com.actions;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonActions {

	public static void selectFromDropDownUsingValue(WebDriver driver, By loc, String selectType, String value) {
		Select select = new Select(driver.findElement(loc));

		switch (selectType) {
		case "selectByValue":
			select.selectByValue(value);
			break;
		case "selectByIndex":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "selectByVisibleText":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Please provide the selector");
		}
	}

	public static String sendKeys(WebDriver driver, String strLocType, String strLocValue, String param1) {
		switch (strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).clear();
			driver.findElement(By.id(strLocValue)).sendKeys(param1);
			break;
		case "name":
			driver.findElement(By.name(strLocValue)).clear();
			driver.findElement(By.name(strLocValue)).sendKeys(param1);
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).clear();
			driver.findElement(By.xpath(strLocValue)).sendKeys(param1);
		case "className":
			driver.findElement(By.className(strLocValue)).clear();
			driver.findElement(By.className(strLocValue)).sendKeys(param1);
		case "linkText":
			driver.findElement(By.linkText(strLocValue)).clear();
			driver.findElement(By.linkText(strLocValue)).sendKeys(param1);
		case "cssSelector":
			driver.findElement(By.cssSelector(strLocValue)).clear();
			driver.findElement(By.cssSelector(strLocValue)).sendKeys(param1);
		default:
			System.out.println("Please provide the selector");
		}
		return null;

	}

	public static String click(WebDriver driver, String strLocType, String strLocValue, String param1) {
		switch (strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).click();
			break;
		case "name":
			driver.findElement(By.name(strLocValue)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).click();
			break;
		case "className":
			driver.findElement(By.className(strLocValue)).click();
			break;
		case "linkText":
			driver.findElement(By.linkText(strLocValue)).click();
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(strLocValue)).click();
			break;
		default:
			System.out.println("Please provide the selector");
			break;
		}
		return null;

	}

	public static boolean verifyTitle(WebDriver driver, String title) {
		if (driver.getTitle().equals(title)) {
			return true;
		} else {
			return false;
		}
	}

	public static void navigte_to_url(WebDriver driver, String URL) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public static void closeBrowser(WebDriver driver) {
		driver.close();
		driver.quit();
	}

	public boolean isElementPresent(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (driver.findElement(by).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementEnabled(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (driver.findElement(by).isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnElementByMouseHover(WebDriver driver, By by) {
		if (isElementPresent(driver, by)) {
			new Actions(driver).moveToElement(driver.findElement(by)).click().build().perform();
			System.out.println("Element " + by.toString() + " clicked by mouse hover.");
			// logger.log(LogStatus.INFO,"Element "+by.toString()+" clicked.");

		} else {
			System.out.println("Element " + by.toString() + " not present.");
			// logger.log(LogStatus.FAIL,"Element "+by.toString()+" not present.");
			Assert.fail("Element " + by.toString() + " not present.");
		}
	}

	public void mouseHoverOnElement(WebDriver driver, By by) {
		if (isElementPresent(driver, by)) {
			new Actions(driver).moveToElement(driver.findElement(by)).build().perform();
			// System.out.println("Element " + by.toString() +
			// " clicked by mouse hover.");
			// logger.log(LogStatus.INFO,"Element "+by.toString()+" clicked.");

		} else {
			System.out.println("Element " + by.toString() + " not present.");
			// logger.log(LogStatus.FAIL,"Element "+by.toString()+" not present.");
			Assert.fail("Element " + by.toString() + " not present.");
		}
	}

	public void clickOnElement(WebDriver driver, By by) {
		if (isElementPresent(driver, by)) {
			driver.findElement(by).click();
			System.out.println("Element " + by.toString() + " clicked.");
			// logger.log(LogStatus.INFO,"Element "+by.toString()+" clicked.");

		} else {
			System.out.println("Element " + by.toString() + " not present.");
			// logger.log(LogStatus.FAIL,"Element "+by.toString()+" not present.");
			Assert.fail("Element " + by.toString() + " not present.");
		}
	}

	public void clearText(WebDriver driver, By by) {
		if (isElementPresent(driver, by)) {
			driver.findElement(by).clear();
			System.out.println("Textfield " + by.toString() + " cleared.");
			// logger.log(LogStatus.INFO,"Textfield "+by.toString()+" cleared.");

		} else {
			System.out.println("Textfield " + by.toString() + " not present.");
			// logger.log(LogStatus.FAIL,"Element "+by.toString()+" not present.");
			Assert.fail("Textfield " + by.toString() + " not present.");
		}
	}

	public void enterTextInTextField(WebDriver driver, By by, String keysToSend) {
		if (isElementPresent(driver, by)) {
			clickOnElement(driver, by);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(keysToSend);
			System.out.println("Entered text in Textfield " + by.toString() + ".");
			// logger.log(LogStatus.INFO,"Entered text in Textfield "+by.toString()+".");
		} else {
			System.out.println("Textfield " + by.toString() + " not present.");
			// logger.log(LogStatus.FAIL,"Element "+by.toString()+" not present.");
			Assert.fail("Textfield " + by.toString() + " not present.");
		}
	}

	public static String[][] getExcelData(String sheetName) throws Exception, IOException {
		String data[][] = null;
		File file = new File("");
		Workbook wb = new XSSFWorkbook(file);
		Sheet sheet = wb.getSheet(sheetName);
		int numberOfRows = sheet.getLastRowNum();
		int numberofCells = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberofCells; j++) {
				System.out.print(sheet.getRow(i).getCell(j) + "\t");
			}
			System.out.println("");
		}

		return data;
	}

	public String getTextForLocator(WebDriver driver, By by) {
		return driver.findElement(by).getText();
	}

	public String getAttributeValue(WebDriver driver, By by, String attributeName) {
		return driver.findElement(by).getAttribute(attributeName);
	}

	public String returnDBData(Connection con, String sqlquery, String columnName) {
		String result = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlquery);

			while (rs.next()) {
				result = rs.getString(columnName);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;

	}
}
