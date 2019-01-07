package com.actions.diplomate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.actions.CommonActions;
import com.uielements.diplomate.DDashboardUI;

public class DDashboardActions {

	DDashboardUI dd = new DDashboardUI();
	CommonActions ca = new CommonActions();

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
			/*while (resSet.next()) {
				    System.out.println(resSet.getString(""));
				}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		if (ca.isElementPresent(driver, dd.ResourceContainers)) {
		ca.clickOnElement(driver, dd.ResourceSearchFieldUI);
		ca.enterTextInTextField(driver, dd.ResourceSearchFieldUI, resources);
		ca.clickOnElement(driver, dd.ResourceSearchSubmitButtonUI);		
			List<WebElement> containerlist=driver.findElements(dd.ResourceContainers);
			int contSize=1;//containerlist.size();
			for(WebElement we :containerlist) {
				ca.clickOnElement(driver,dd.ResourcesExpandButtons(contSize));
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

		}
		else {
			System.out.println("Resources are not present...!");
		}
	}

	public void ResourceClearSearch(WebDriver driver) {
		ca.clearText(driver, dd.ResourceSearchFieldUI);
		ca.clickOnElement(driver, dd.ResourceSearchSubmitButtonUI);	
	}
	

}
