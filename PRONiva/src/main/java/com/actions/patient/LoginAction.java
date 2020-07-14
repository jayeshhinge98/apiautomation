package com.actions.patient;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.actions.CommonActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uielements.patient.DashboardUI;
import com.uielements.patient.LoginUI;

public class LoginAction extends CommonActions {

	LoginUI loginUI = new LoginUI();
	DashboardUI dashboardUI = new DashboardUI();

	/**
	 * 
	 * @param driver
	 * @param username
	 * @param password
	 */
	public void Login(WebDriver driver, String username, String password) {
		
		enterTextInTextField(driver, loginUI.Username, username);
		enterTextInTextField(driver, loginUI.Password, password);
		driver.findElement(loginUI.LoginButton).click();
	}

	/**
	 * 
	 * @param driver
	 */
	public void Logout(WebDriver driver) {
		driver.findElement(dashboardUI.ProfileButton).click();
		driver.findElement(dashboardUI.Logout).click();
		isElementVisible(driver, dashboardUI.LogoutPopupMessage);
		driver.findElement(dashboardUI.LogoutConfirmButton).click();
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public boolean isNivaUserPresentOnLoginPage(WebDriver driver) {
		if (isElementVisible(driver, loginUI.LoginButton)) {
			return true;
		} else {
			return false;
		}
	}

	public void LoginPageUI(WebDriver driver, ExtentTest logger) {
		Assert.assertEquals(
				getTextForLocator(driver, loginUI.Instrunctions(1)),
				"To log into your account, please enter your email address and the password",
				"Instruction message not present.");
		logger.log(Status.INFO, "1st Instrunction is present");
		Assert.assertEquals(
				getTextForLocator(driver, loginUI.Instrunctions(2)),
				"Click \"Login\"", "Instruction message not present.");
		logger.log(Status.INFO, "2nd Instrunction is present");
		Assert.assertEquals(
				getTextForLocator(driver, loginUI.LoginPageHeader),
				"Account Login");
		logger.log(Status.INFO, "Login page header is present");
		Assert.assertTrue(isElementVisible(driver, loginUI.PoweredByFooter));
		logger.log(Status.INFO, "Footer text is present");
		Assert.assertTrue(isElementVisible(driver, loginUI.FooterLogo));
		logger.log(Status.INFO, "Footer logo is present");
		logger.log(Status.PASS, "Verified all Login page UI elements.");
	}

	public boolean isNivaUserPresentOnDashBoard(WebDriver driver) {
		return isElementVisible(driver, dashboardUI.ProfileButton);
	}

	// public void

}
