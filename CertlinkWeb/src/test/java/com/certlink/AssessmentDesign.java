package com.certlink;

import org.testng.annotations.Test;

import com.actions.diplomate.AssessmentDesignActions;
import com.actions.diplomate.DLoginAction;
import com.uielements.diplomate.DAssessmentDesignUI;
import com.utilities.SuiteBase;

public class AssessmentDesign extends SuiteBase{
	AssessmentDesignActions  ad=new  AssessmentDesignActions();
	DAssessmentDesignUI ui=new DAssessmentDesignUI();
	DLoginAction login=new DLoginAction();
	@Test
	public void verifyAssessmentDesign() {
		login.DiplomateLogin(chdriver, "jayeshautomation1@sharklasers.com", "Abcd1234#", "valid");
		ad.assessmentDesign(chdriver,chwait);
		login.DiplomateLogout(chdriver, chwait);
	}
	
}
