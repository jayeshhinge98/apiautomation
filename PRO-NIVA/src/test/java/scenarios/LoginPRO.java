package scenarios;

import org.testng.annotations.Test;

import com.actions.pro.PEGLoginAction;
import com.utilities.SuiteBase;

public class LoginPRO extends SuiteBase {
	PEGLoginAction pla = new PEGLoginAction();

	@Test(priority = 1)
	public void verifyPROLogin() {
		logger.assignCategory("Smoke", "Regression");	
		pla.login(driver, con, "amit.deshmukh", "Abcd@1234", logger);
	}

	@Test(priority = 2)
	public void verifyAssignPROWorks() {
		logger.assignCategory("Smoke", "Regression");
		pla.assignPRO(driver, con, logger);
	}
}
