package com.PRONiva;

import java.io.IOException;

import org.testng.annotations.Test;

import com.actions.patient.DashboardActions;
import com.actions.patient.LoginAction;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.utilities.SuiteBase;

public class DiplomateDashboard extends SuiteBase {
	LoginAction dla = new LoginAction();
	DashboardActions dda = new DashboardActions();

//	PRO side mai bas login -> navgate to PRO and assign PRO to a user. 
	
	// @Test(priority = 1)
	public void verifyResourcePageContentsPresent() {
		dla.Login(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		
	}

	// @Test(priority = 2)
	public void verifyResourceSearchFunctional() {
		dla.Login(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		dda.ResourcesSearch(chdriver, "testing", con);

	}

	@Test(priority = 1)
	public void verifyUserAccountUpdate() throws Exception, JsonMappingException, IOException {
		dla.Login(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		dda.UpdateMyAccountSettings(chdriver, con,
				"select i.Middle from Individual i inner join FIGUser f on i.IndividualUid=f.FIGUserUid where f.LoginName='prod_jayesh@sharklasers.com'",
				chwait);
		//dla.DiplomateLogout(chdriver, chwait);
	}

	@Test(priority = 2)
	public void verifyPasswordReset() throws Exception, JsonMappingException, IOException {
		dda.PasswordResetMyAccountSettings(chdriver,chwait,"prod_jayesh@sharklasers.com","Abcd1234#","Abcd1234#");
	}
	
}
