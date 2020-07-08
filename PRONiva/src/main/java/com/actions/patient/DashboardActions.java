package com.actions.patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.CommonActions;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uielements.patient.DashboardUI;
import com.utilities.TestUtitlies;

public class DashboardActions {

	DashboardUI dd = new DashboardUI();
	CommonActions ca = new CommonActions();
	TestUtitlies tu = new TestUtitlies();
	LoginAction dla = new LoginAction();

	public void Resources(WebDriver driver) {

		ca.clickOnElement(driver, dd.ResourcesUI);
		Assert.assertTrue(ca.isElementPresent(driver, dd.ResourceSearchFieldUI), "Search field not present");
		Assert.assertTrue(ca.isElementPresent(driver, dd.ResourceProviderDropDownUI),
				"ResourceProvider DropDown not present");
		Assert.assertTrue(ca.isElementPresent(driver, dd.ResourceContentAreaDropDownUI),
				"ResourceContentArea DropDown not present");
	}

	public void ResetContentAreaResourceFilter(WebDriver driver) {
		ca.clickOnElement(driver, dd.ResourceProviderDropdownOptions1("1"));
	}

	public void ResetProviderResourceFilter(WebDriver driver) {
		ca.clickOnElement(driver, dd.ResourceProviderDropdownOptions1("1"));
	}

	public void ResourcesSearch(WebDriver driver, String resources, Connection con) {
		Statement sqlStatement;
		try {
			sqlStatement = con.createStatement();
			String sqlQuery = "SELECT * FROM table_name WHERE condition";
			ResultSet resSet = sqlStatement.executeQuery(sqlQuery);
			/*
			 * while (resSet.next()) {     System.out.println(resSet.getString("")); }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ca.isElementPresent(driver, dd.ResourceContainers)) {
			ca.clickOnElement(driver, dd.ResourceSearchFieldUI);
			ca.enterTextInTextField(driver, dd.ResourceSearchFieldUI, resources);
			ca.clickOnElement(driver, dd.ResourceSearchSubmitButtonUI);
			List<WebElement> containerlist = driver.findElements(dd.ResourceContainers);
			int contSize = 1;// containerlist.size();
			for (WebElement we : containerlist) {
				ca.clickOnElement(driver, dd.ResourcesExpandButtons(contSize));
				contSize++;
			}
			List<WebElement> list = driver.findElements(dd.ResourcesGetNameList);
			int i = list.size();
			if (i < 1) {
				Assert.assertEquals(resources, driver.findElement(dd.NoResourceFoundMessage).getText(),
						"Search result is present even though items are not present");
			} else {
				for (WebElement we : list) {
					if (!we.getText().contains(resources))
						// log lines
						Assert.fail("Incorrect search result shown..!");
				}
			}

		} else {
			System.out.println("Resources are not present...!");
		}
	}

	public void ResourceClearSearch(WebDriver driver) {
		ca.clearText(driver, dd.ResourceSearchFieldUI);
		ca.clickOnElement(driver, dd.ResourceSearchSubmitButtonUI);
	}

	/*
	 * My Account: Update setting(s), Reset password, Add Profile picture, View
	 * setting(s)
	 */

	public void ViewMyAccountSettings(WebDriver driver) {
		ca.clickOnElement(driver, dd.DMyAccountUI);
		if (ca.isElementPresent(driver, dd.MyAccountEmailField)) {
			System.out.println("Diplomate navigated to My Account Successfully.");
		} else {
			Assert.fail("Diplomate My Account navigation un-successful.");
		}

	}

	public void UpdateMyAccountSettings(WebDriver driver, Connection con, String sql, WebDriverWait wait)
			throws JsonParseException, JsonMappingException, IOException {		
		ca.clickOnElement(driver, dd.DMyAccountUI);
		new WebDriverWait(driver, 60).until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		String str = driver.findElement(By.xpath("/html/body/script[25]")).getAttribute("innerHTML").toString();
		String str2 = str.substring(str.indexOf("_activeUserEntity = JSON.parse(JSON.stringify(") + 46,
				str.indexOf("var _activeUserPermissions")).trim();
		Map<String, Object> response = new ObjectMapper().readValue(str2.substring(0, str2.length() - 3),
				HashMap.class);

		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return response.get("FirstName").toString().length() != 0;
			}
		});
		System.out.println("First Name is :" + response.get("FirstName").toString());
		String middle = tu.randomAlphabetic(5);
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.presenceOfElementLocated(dd.MyAccountMiddleName));
		System.out.println("After fluent wait");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(dd.MyAccountMiddleName)).click().build().perform();
		// ca.enterTextInTextField(driver, dd.MyAccountMiddleName, middle);
		driver.findElement(dd.MyAccountMiddleName).clear();
		driver.findElement(dd.MyAccountMiddleName).sendKeys(middle);
		wait.until(ExpectedConditions.elementToBeClickable(dd.MyAccountSaveAccount));
		ca.clickOnElement(driver, dd.MyAccountSaveAccount);
		if (ca.getTextForLocator(driver, dd.MyAccountSaveSuccessMessage).equals("Profile saved.")) {
			System.out.println("Profile saved success message displays on UI");
		} else {
			System.out.println("Profile not saved.");
			Assert.fail("one or more fields required to select.");
		}

		String middleNameDB = null;
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next())
				middleNameDB = rs.getString("Middle");
			// middleNameDB = rs.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(middleNameDB, middle, "Value is not saved in DB");
		// wait the element "Add Item" to become stale
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(dd.MyAccountSaveSuccessMessage)));
		System.out.println("Success");
	}

	public void PasswordResetMyAccountSettings(WebDriver driver, WebDriverWait wait, String username,
			String oldPassword, String newPassword) {
		Actions a = new Actions(driver);
		driver.navigate().refresh();
		new WebDriverWait(driver, 60).until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		System.out.println("After wait 2");
		String str = driver.findElement(By.xpath("/html/body/script[25]")).getAttribute("innerHTML").toString();
		String str2 = str.substring(str.indexOf("_activeUserEntity = JSON.parse(JSON.stringify(") + 46,
				str.indexOf("var _activeUserPermissions")).trim();
		try {
		Map<String, Object> response = new ObjectMapper().readValue(str2.substring(0, str2.length() - 3),
				HashMap.class);

		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return response.get("FirstName").toString().length() != 0;
			}
		});
		}catch (Exception e) {
			// TODO: handle exception
		}
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.presenceOfElementLocated(dd.MyAccountbtnResetPassword));
		System.out.println("After wait 1");
		a.moveToElement(driver.findElement(dd.MyAccountbtnResetPassword)).click().build().perform();
		//ca.clickOnElement(driver, dd.MyAccountbtnResetPassword);
		driver.findElement(dd.MyAccountResetPasswordPopupOldPassword).sendKeys(oldPassword);
		driver.findElement(dd.MyAccountResetPasswordPopupNewPassword).sendKeys(newPassword);
		driver.findElement(dd.MyAccountResetPasswordPopupConfirmPassword).sendKeys(newPassword);
		ca.clickOnElement(driver, dd.MyAccountbtnResetPasswordPopupSave);
		Assert.assertEquals(ca.getTextForLocator(driver, dd.MyAccountSaveSuccessMessage), "Password changed.");
		// dla.DiplomateLogout(driver, chwait);
		// dla.DiplomateLogin(driver, username, newPassword, "valid");
	}

	public void Message(WebDriver driver) {
	
	}

	
	
}
