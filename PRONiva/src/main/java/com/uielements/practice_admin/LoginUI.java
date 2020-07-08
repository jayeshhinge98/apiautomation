package com.uielements.practice_admin;

import org.openqa.selenium.By;

public class LoginUI {

	// Author: Jayesh Hinge
	// Unit: ABFM

	public By username = By.id("username");
	public By password = By.name("password");
	public By loginButton = By.xpath("//span[contains(text(),'Login')]");
}
