package com.certlink;

import org.testng.annotations.Test;

import com.actions.board_admin.LoginActions;
import com.utilities.SuiteBase;

public class Login extends SuiteBase {

	LoginActions la = new LoginActions();

	@Test(priority = 1)
	public void verifyDiplomateLoginUsingValidCredentials() {
		la.DiplomateLogin(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		la.DiplomateLogout(chdriver, chwait);
	}

	@Test(priority = 2)
	public void verifyDiplomateLoginUsingInValidCredentials() {
		la.DiplomateLogin(chdriver, "prod_jayes@sharklasers.com", "Abd1234#", "Invalid");
	}

	@Test(priority = 3)
	public void verifyDiplomateLogout() {
		la.DiplomateLogin(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		la.DiplomateLogout(chdriver, chwait);
	}
	
	

}
