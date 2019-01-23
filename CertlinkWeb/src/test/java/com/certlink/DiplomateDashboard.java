package com.certlink;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.actions.diplomate.DDashboardActions;
import com.actions.diplomate.DLoginAction;
import com.utilities.SuiteBase;

public class DiplomateDashboard extends SuiteBase {
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
	public void verifyUserAccountUpdate() {
		dla.DiplomateLogin(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#", "valid");
		dda.UpdateMyAccountSettings(chdriver, con,
				"select i.Middle from Individual i inner join FIGUser f on i.IndividualUid=f.FIGUserUid where f.LoginName='prod_jayesh@sharklasers.com'",
				chwait);
		dla.DiplomateLogout(chdriver, chwait);

	}

}
