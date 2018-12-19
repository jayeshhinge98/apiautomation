package com.uielements.diplomate;

import org.openqa.selenium.By;

public class DLoginUI {

	//https://mycertlink.org
	//https://www.mycertlink.org/Dashboard/login.aspx#
	
	public By UsernameUI=By.id("MainContent_txtusername");
	public By PasswordUI=By.id("MainContent_txtpassword");
	public By LogionButtonUI =By.id("btnLogin");
	public By ForgotPasswordUI=By.linkText("Forgot your password?");
	public By RequestAccessToCertLinkUI=By.xpath("//*[@id=\"divLogin\"]/div[3]/div[2]/a/");
	
		
}
