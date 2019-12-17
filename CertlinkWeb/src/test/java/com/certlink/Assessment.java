package com.certlink;

import org.testng.annotations.Test;

import com.actions.diplomate.AssessmentActions;
import com.actions.diplomate.DLoginAction;
import com.utilities.SuiteBase;

public class Assessment extends SuiteBase{
	
	DLoginAction login=new DLoginAction();
	AssessmentActions aa=new AssessmentActions();
	@Test
	public void verifyAssessment() {
		login.DiplomateLogin(chdriver, "jayeshautomation2@sharklasers.com", "Abcd1234#", "valid");
		aa.assessment(chdriver,chwait);
		//login.DiplomateLogout(chdriver, chwait);
	}

}
