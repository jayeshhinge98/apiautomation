package com.actions.pro;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.CommonActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.base.Predicate;
import com.uielements.LoginUIElement;

public class PEGLoginAction {
	LoginUIElement lu = new LoginUIElement();
	CommonActions ca = new CommonActions();

	public void login(WebDriver driver, Connection con, String username, String password, ExtentTest logger) {
		ca.enterTextInTextField(driver, lu.UserNameFieldUI, username);
		logger.log(Status.INFO,"Username entered.");
		ca.enterTextInTextField(driver, lu.PasswordFieldUI, password);
		logger.log(Status.INFO,"Password entered.");
		ca.clickOnElement(driver, lu.LoginButton);
		logger.log(Status.INFO,"Login button clicked");
		Assert.assertEquals(ca.getTextForLocator(driver, lu.ProceedToPROButton), "PROCEED TO PRO");
		logger.info("User logged in successfully");
		
		
	}

	public void assignPRO(WebDriver driver, Connection con, ExtentTest logger) {
		ca.clickOnElement(driver, lu.ProceedToPROButton);
		logger.log(Status.INFO,"Proceed To PRO button clicked");
		new WebDriverWait(driver, 60).until(webdriver -> (JavascriptExecutor) webdriver)
				.executeScript("return document.readyState").equals("complete");
		String PatientName = ca.getTextForLocator(driver, lu.PatientNameFromList);
		ca.clickOnElement(driver, lu.AssignPROButton);
		logger.log(Status.INFO,"PRO assigned to the first patient from the list.");
		Assert.assertEquals(ca.getTextForLocator(driver, lu.MessageTextUI), "PRO assigned to selected patient successfully !");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		String query = "select is_dispatched from outreach_scheduled_jobs osj where patient_fullname like '%"
				+ PatientName + "%' and questionnaire_display_name='EPIC-26 (Baseline Survey)';";
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String returnedData=ca.returnDBData(con, query, "is_dispatched");
		logger.info("Data returned from query is=>"+returnedData);
		Assert.assertEquals(returnedData, "t");
		logger.info("PRO assigned to selected patient successfully.");
	}

}
