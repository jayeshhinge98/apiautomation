package com.actions.diplomate;

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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.CommonActions;
import com.uielements.diplomate.DDashboardUI;
import com.utilities.TestUtitlies;

import okio.Timeout;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.javascript.host.fetch.Response;

import com.google.common.base.Function;

public class DDashboardActions {

	DDashboardUI dd = new DDashboardUI();
	CommonActions ca = new CommonActions();
	TestUtitlies tu = new TestUtitlies();
	DLoginAction dla=new DLoginAction();

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
		// System.out.println("Text: " +
		// driver.findElement(dd.MyAccountMiddleName).getText());		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)				 
			        .withTimeout(120, TimeUnit.SECONDS)
			        .pollingEvery(5, TimeUnit.SECONDS)
			        .ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
		{
		  public WebElement apply(WebDriver driver) {
		  return driver.findElement(dd.MyAccountMiddleName);
		}
		});
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(dd.MyAccountMiddleName));
		ca.enterTextInTextField(driver, dd.MyAccountMiddleName, middle);
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
	}
	

	public void PasswordResetMyAccountSettings(WebDriver chdriver, WebDriverWait wait,String username, String oldPassword, String newPassword) {
		wait.until(ExpectedConditions.elementToBeSelected(dd.MyAccountbtnResetPassword));
		ca.clickOnElement(chdriver, dd.MyAccountbtnResetPassword);
		ca.enterTextInTextField(chdriver,dd.MyAccountResetPasswordPopupOldPassword, oldPassword);
		ca.enterTextInTextField(chdriver, dd.MyAccountResetPasswordPopupNewPassword, newPassword);
		ca.enterTextInTextField(chdriver, dd.MyAccountResetPasswordPopupConfirmPassword, newPassword);
		ca.clickOnElement(chdriver, dd.MyAccountbtnResetPasswordPopupSave);
		Assert.assertEquals( ca.getTextForLocator(chdriver, dd.MyAccountSaveSuccessMessage), "Password changed.");
		//dla.DiplomateLogout(chdriver, chwait);
		//dla.DiplomateLogin(chdriver, username, newPassword, "valid");	
	}

}
