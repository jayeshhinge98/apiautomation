package com.actions.diplomate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.CommonActions;
import com.uielements.diplomate.DDashboardUI;
import com.utilities.TestUtitlies;

public class DDashboardActions {

	DDashboardUI dd = new DDashboardUI();
	CommonActions ca = new CommonActions();
	TestUtitlies tu = new TestUtitlies();

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

	public void UpdateMyAccountSettings(WebDriver driver, Connection con, String sql,WebDriverWait wait ) {
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(dd.MyAccountFirstName).getText().length() != 0;
            }
        });
		
		ca.clickOnElement(driver, dd.DMyAccountUI);
		String middle = tu.randomAlphabetic(5);
		wait.until(ExpectedConditions.elementToBeClickable(dd.MyAccountMiddleName));
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
			// rs.getString("Middle");
			middleNameDB = rs.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(middleNameDB, middle, "Value is not saved in DB");
	}

}
