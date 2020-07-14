package com.actions;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonActions {

	// public static boolean verifyIf(WebDriver driver, By locator,
	// String expectedConditions) {
	// boolean check=false;
	// Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	// .pollingEvery(Duration.ofSeconds(5))
	// .withTimeout(Duration.ofMinutes(1))
	// .ignoring(NoSuchElementException.class);
	// switch (expectedConditions) {
	// case "elementToBeSelected":
	// check=wait.until(ExpectedConditions.elementToBeSelected(locator));
	// return check;
	// case "invisibilityOfElementLocated":
	// check=wait.until(ExpectedConditions
	// .invisibilityOfElementLocated((locator)));
	// return check;
	// case "stalenessOf":
	// check=wait.until(ExpectedConditions.stalenessOf(driver
	// .findElement(locator)));
	// return check;
	// default:
	// System.out.println("Please provide expected condition");
	// return check;
	// }
	// }

	/**
	 * @method : Used to find visibility of an element
	 * @param driver
	 *            : WebDriver object
	 * @param locator
	 *            : By object
	 * @return WebElement
	 */

	public static WebElement findVisibleElement(WebDriver driver, By locator) {
		WebElement webElement = null;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofSeconds(5))
				.withTimeout(Duration.ofMinutes(1))
				.ignoring(NoSuchElementException.class);
		webElement = wait.until(ExpectedConditions
				.presenceOfElementLocated(locator));
		return webElement;
	}
	/**
	 *  Used to check whether element is present or not
	 * @param driver
	 * @param locator
	 * @return boolean
	 */
	public static boolean isElementVisible(WebDriver driver, By locator) {
		try{
			findVisibleElement(driver, locator);
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}

	
	/**
	 * Description: Used to verify page title
	 * 
	 * @param driver
	 *            : WebDriver object
	 * @param title
	 *            : string used to compare with actual title
	 * @return boolean
	 */
	public static boolean verifyTitle(WebDriver driver, String title) {
		if (driver.getTitle().equals(title)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Description: Used to navigate to required URL
	 * 
	 * @param driver
	 * @param URL
	 */
	public void navigte_to_url(WebDriver driver, String URL) {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(URL);
	}

	/**
	 * Used to enter text into text field
	 * 
	 * @param driver
	 * @param by
	 * @param keysToSend
	 */
	public static void enterTextInTextField(WebDriver driver, By by,
			String keysToSend) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(keysToSend);
	}

	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param colnum
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public static String[][] getExcelData(String sheetName, String rownum,
			String colnum) throws Exception, IOException {
		String data[][] = null;
		File file = new File(""); // Add filename here
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

	/**
	 * 
	 * @param driver
	 * @param by
	 * @return
	 */
	public static String getTextForLocator(WebDriver driver, By by) {
		return driver.findElement(by).getText();
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 * @return
	 */
	public static String getToolTipForLocator(WebDriver driver, By by) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(by)).build().perform();
		return driver.findElement(by).getText();
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 * @param attributeName
	 * @return
	 */
	public static String getAttributeValue(WebDriver driver, By by,
			String attributeName) {
		return driver.findElement(by).getAttribute(attributeName);
	}

	/**
	 * 
	 * @param con
	 * @param sqlquery
	 * @param columnName
	 * @return
	 */
	public static String returnDBData(Connection con, String sqlquery,
			String columnName) {
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
