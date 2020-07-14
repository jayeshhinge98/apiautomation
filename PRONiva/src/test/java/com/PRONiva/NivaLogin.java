package com.PRONiva;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.CommonActions;
import com.actions.patient.LoginAction;
import com.aventstack.extentreports.Status;
import com.utilities.SuiteBase;

public class NivaLogin extends SuiteBase {

	LoginAction la = new LoginAction(driver);
	CommonActions tu = new CommonActions();

	@Test(priority = 1,description="TC01: Verify patient able to login Patient Portal using valid credentials")
	public void LoginUsingValidCredentials() { 
		logger.log(Status.INFO, "Navigating to URL");
		tu.navigte_to_url(driver, "https://niva-demo03.figmd.com");
		logger.log(Status.INFO, "Trying to login");
		la.Login( "jayeshabfmC010@yopmail.com", "Niva@1234");
		logger.log(Status.INFO, "Verifying user logged in or not");
		Assert.assertTrue( la.isNivaUserPresentOnDashBoard(),"Login failed");
		logger.log(Status.PASS, "Patient logged in successfully using valid credentials.");
		la.Logout();
		Assert.assertTrue(la.isNivaUserPresentOnLoginPage(),"Patient failed to log out.");
		logger.log(Status.INFO, "User logged out successfully.");
	}
	
	@Test(priority = 2,description="TC02: Verify patient able to login Patient Portal using invalid credentials")
	public void LoginUsingInvalidCredentials() {
		tu.navigte_to_url(driver, "https://niva-demo03.figmd.com");
		logger.log(Status.INFO, "Trying to login");
		la.Login("jayeshabfmC010@yopmail.com", "Niva@123434");
		boolean loginFailed=la.isNivaUserPresentOnLoginPage();
		Assert.assertTrue(loginFailed,"Patient failed to login.");
		logger.log(Status.PASS, "Patient not able to login using invalid credentials.");
	}
	@Test(priority = 3,description="TC03: Verify patient able to log-out")
	public void verifyLogout() {
		tu.navigte_to_url(driver, "https://niva-demo03.figmd.com");
		la.Login( "jayeshabfmC010@yopmail.com", "Niva@1234");
		logger.log(Status.INFO, "Trying to logout");
		la.Logout();
		Assert.assertTrue(la.isNivaUserPresentOnLoginPage(),"Patient failed to log out.");
		logger.log(Status.PASS, "Patient able to logout successfully.");
	}
	@Test(priority = 4,description="TC04: Verify all login page UI Elements")
	public void verifyLoginPageUI(){
		logger.log(Status.INFO, "Verifying all Login page UI elements.");
		la.LoginPageUI(logger);
	}  

	


}