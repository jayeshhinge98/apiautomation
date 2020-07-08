package com.uielements.patient;

import org.openqa.selenium.By;

public class YopmailUI {

	// yopmail: http://www.yopmail.com/en/

	public By emailField = By.id("login");
	public By CheckInbox = By.className("sbut");
	public By OpenEmail=By.xpath("//div/div[7]/div/a/span[@class='lmfd']");
	public By CheckNewEmails=By.className("slientext");
	public By CurrentEmailTimeSubject=By.xpath("//div/div[7]/div/a/span[@class='lmfd']/span[1]");
	public By CurrentEmailTimeBody=By.xpath("//b[text()='Date:']/parent::div");
	public By PatientPortalSignupLink=By.xpath("//a[contains(text(),'Patient Portal link')]");
	
	//Email Body content verification
	
	
	
	
}
