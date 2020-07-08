package com.actions.patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.actions.CommonActions;
import com.uielements.patient.DashboardUI;
import com.uielements.patient.LoginUI;

public class LoginAction {

	LoginUI login1 = new LoginUI();
	DashboardUI dd = new DashboardUI();
	CommonActions ca = new CommonActions();

	public void Login(WebDriver driver, String username, String password,
			String scenario) {
		ca.enterTextInTextField(driver, login1.Username, username);
		ca.enterTextInTextField(driver, login1.Password, password);
		ca.clickOnElement(driver, login1.LoginButton);
		if (scenario.equalsIgnoreCase("valid"))
			Assert.assertTrue(ca.isElementPresent(driver, dd.ProfileButton),
					"FAIL: Login failed");
		if (scenario.equalsIgnoreCase("Invalid"))
			Assert.assertTrue(ca.isElementPresent(driver, login1.LoginButton),
					"FAIL: Login failed");
	}

	public void Logout(WebDriver driver) {
		ca.clickOnElement(driver, dd.ProfileButton);
		ca.clickOnElement(driver, dd.Logout);
		
		ca.ExplicitWait(driver).until(ExpectedConditions
				.visibilityOfElementLocated(dd.LogoutPopupMessage));
		ca.clickOnElement(driver, dd.LogoutConfirmButton);
		try {
			ca.ExplicitWait(driver).until(ExpectedConditions
					.visibilityOfElementLocated(login1.LoginButton));
			Assert.assertTrue(ca.isElementPresent(driver, login1.LoginButton),
					"FAIL: Patient user unable to logout.");
		} catch (Exception e) {
			Assert.fail("FAIL: Patient user unable to logout." + e);
		}
	}
}
