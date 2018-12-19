package com.actions.board_admin;

import org.openqa.selenium.WebDriver;

import com.actions.CommonActions;
import com.uielements.diplomate.DLoginUI;

public class LoginActions {
	
	DLoginUI login1=new DLoginUI();
	CommonActions ca=new CommonActions();
	public void DiplomateLogin(WebDriver driver,String username,String password) {
		ca.enterTextInTextField(driver,login1.UsernameUI , username);
	}

}
