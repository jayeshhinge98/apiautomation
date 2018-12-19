package com.certlink;

import org.testng.annotations.Test;

import com.actions.board_admin.LoginActions;
import com.utilities.SuiteBase;

public class Login extends SuiteBase{
	
	LoginActions la=new LoginActions();	
	@Test
	public void testcase1() {
		la.DiplomateLogin(chdriver, "prod_jayesh@sharklasers.com", "Abcd1234#");
	}
	
}
