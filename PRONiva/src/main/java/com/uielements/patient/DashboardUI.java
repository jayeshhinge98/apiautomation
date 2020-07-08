package com.uielements.patient;

import org.openqa.selenium.By;

public class DashboardUI {

	public By ProfileButton = By.xpath("//button[@aria-label='Profile button']");
	public By Logout=By.xpath("//li[@role='menuitem' and text()='Logout']");
	public By ProfileSettings=By.xpath("//li[@role='menuitem' and text()='Profile Settings']");
	public By LogoutConfirmButton=By.xpath("//div[@class='confirmation-button-wrapper']/button[2]");
	public By CancelConfirmButton=By.xpath("//div[@class='confirmation-button-wrapper']/button[1]");
	public By LogoutPopupMessage=By.className("logout-box-text");
	
	//RelationShip to patient
	public By RelationshipToPatientYes=By.xpath("//button[contains(@class,'btn-check background')]/span[1]");
	public By RelationshipToPatientNo=By.xpath("//button[contains(@class,'btn-submit background')]/span[1]");
	

}
