package com.certlink;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actions.diplomate.DDashboardActions;
import com.actions.diplomate.DLoginAction;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.utilities.SuiteBase;

public class DiplomateMyAccount extends SuiteBase {
	DLoginAction dla = new DLoginAction();
	DDashboardActions dda = new DDashboardActions();

	// @Test(priority = 1)
	public void verifyResourcePageContentsPresent() {
		dla.DiplomateLogin(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		dda.Resources(chdriver);
	}

	// @Test(priority = 2)
	public void verifyResourceSearchFunctional() {
		dla.DiplomateLogin(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		dda.ResourcesSearch(chdriver, "testing", con);

	}

	@Test(priority = 1)
	public void verifyUserAccountUpdate() throws Exception, JsonMappingException, IOException {
		dla.DiplomateLogin(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		dda.UpdateMyAccountSettings(chdriver, con,
				"select i.Middle from Individual i inner join FIGUser f on i.IndividualUid=f.FIGUserUid where f.LoginName='prod_jayesh@sharklasers.com'",
				chwait);
		//dla.DiplomateLogout(chdriver, chwait);
	}

	@Test(priority = 2)
	public void verifyPasswordReset() throws Exception, JsonMappingException, IOException {
		//dla.DiplomateLogin(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		dda.PasswordResetMyAccountSettings(chdriver,chwait,"prod_jayesh@sharklasers.com","Abcd1234#","Abcd1234#");
	}
	
}
