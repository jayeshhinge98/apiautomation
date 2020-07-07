package com.actions.patient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.CommonActions;
import com.uielements.patient.DDashboardUI;
import com.uielements.patient.DLoginUI;

public class DLoginAction {

	DLoginUI login1 = new DLoginUI();
	DDashboardUI dd = new DDashboardUI();
	CommonActions ca = new CommonActions();

	public void DiplomateLogin(WebDriver driver, String username,
			String password, String scenario) {
		ca.enterTextInTextField(driver, login1.UsernameUI, username);
		ca.enterTextInTextField(driver, login1.PasswordUI, password);
		ca.clickOnElement(driver, login1.LoginButtonUI);
		if (scenario.equalsIgnoreCase("valid"))
			Assert.assertTrue(ca.isElementPresent(driver, dd.DDashboardUI),
					"FAIL: Login failed");
		if (scenario.equalsIgnoreCase("Invalid"))
			Assert.assertTrue(
					ca.isElementPresent(driver, login1.LoginButtonUI),
					"FAIL: Login failed");
	}

	public void DiplomateLogout(WebDriver driver, WebDriverWait wait) {
		ca.clickOnElement(driver, dd.DLogoutUI);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(dd.DSignOutButtonUI));
		ca.clickOnElement(driver, dd.DSignOutButtonUI);
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(login1.LoginButtonUI));
			Assert.assertTrue(
					ca.isElementPresent(driver, login1.LoginButtonUI),
					"FAIL: Diplomate user unable to logout.");
		} catch (Exception e) {
			Assert.fail("FAIL: Diplomate user unable to logout." + e);
		}
	}
}
