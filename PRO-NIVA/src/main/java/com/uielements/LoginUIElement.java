package com.uielements;

import org.openqa.selenium.By;

public class LoginUIElement {
	public By UserNameFieldUI = By.id("username");
	public By PasswordFieldUI = By.name("password");
	public By LoginButton = By.xpath("//*[text()='Login']");
	public By DashboardNavigationButton = By.xpath("//span[@title='PRO']");
	public By ProceedToPROButton = By.xpath("//span[text()='Proceed to PRO']");
	public By PatientNameFromList= By.xpath(
			"//div[text()='PATIENT NAME']//parent::div//parent::div//parent::div/div[2]/div[2]/div/span/div/span");
	////div[text()='PATIENT NAME']//parent::div//parent::div//parent::div/div[2]/div//div[@class='name-mrn__details']/span
	public By AssignPROButton=By.xpath("//div[text()='PATIENT NAME']//parent::div//parent::div//parent::div/div[2]/div[18]//button");
	public By MessageTextUI=By.id("message-id");
		
	
	
}
