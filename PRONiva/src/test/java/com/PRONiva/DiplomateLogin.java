package com.PRONiva;

import org.testng.annotations.Test;

import com.actions.patient.LoginAction;
import com.utilities.SuiteBase;

public class DiplomateLogin extends SuiteBase {

	LoginAction la = new LoginAction();

	// @Test(priority = 1)
	public void verifyDiplomateLoginUsingValidCredentials() {
		la.Login(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#",
				"valid");
		la.Logout(chdriver, chwait);
	}

	@Test(priority = 2)
	public void verifyDiplomateLoginUsingInValidCredentials() {
		la.Login(chdriver, "prod_jayes@sharklasers.com", "Abd1234#",
				"Invalid");
	}

	// @Test(priority = 3)
	public void verifyDiplomateLogout() {
		la.Login(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#",
				"valid");
		la.Logout(chdriver, chwait);
	}

}
