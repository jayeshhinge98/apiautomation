package com.PRONiva;

import org.testng.annotations.Test;

import com.actions.CommonActions;
import com.actions.patient.LoginAction;
import com.utilities.SuiteBase;

public class NivaLogin extends SuiteBase {

	LoginAction la = new LoginAction();
	CommonActions tu=new CommonActions();

	@Test(priority = 1)
	public void verifyNivaLoginUsingValidCredentials() {
		tu.navigte_to_url(chdriver,"https://niva-demo03.figmd.com");
		la.Login(chdriver, "jayeshabfmC010@yopmail.com", "Niva@1234",
				"valid");
		la.Logout(chdriver);
	}

	@Test(priority = 2)
	public void verifyNivaLoginUsingInValidCredentials() {
		tu.navigte_to_url(chdriver,"https://niva-demo03.figmd.com");
		la.Login(chdriver, "jayeshabfmC010@yopmail.com", "Abd1234#",
				"Invalid");
	}

	@Test(priority = 3)
	public void verifyDiplomateLogout() {
		tu.navigte_to_url(chdriver,"https://niva-demo03.figmd.com");
		la.Login(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#",
				"valid");
		la.Logout(chdriver);
	}

}
