package com.certlink;

import org.testng.annotations.Test;

import com.actions.diplomate.DLoginAction;
import com.utilities.SuiteBase;

public class Login extends SuiteBase {

	DLoginAction la = new DLoginAction();

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
