package com.uielements.patient;

import org.openqa.selenium.By;

public class LoginUI {

	
	
	public By Username=By.name("email");
	public By Password=By.xpath("//label[text()='Password']/parent::div/div/input");
	public By LoginButton =By.id("loginButton");
	public By ForgotPasswordUI=By.xpath("//div[@class='forgetpassword-field']/button");
	public By PoweredByFooter=By.className("powered-by");	// compare with "Powered by "
	public By FooterLogo=By.className("niva-logo");
	public By Instrunctions(int i){
			return By.xpath("//div[contains(@class,'instruction_div')]/ol/li[+"+i+"+]");
	};
	public By LoginPageHeader=By.xpath("//title[contains(@class,'welcome-title')]");
	public By LoginError=By.xpath("//form/div[@class='error']");
	public By SignUpInstrunctions(int i){
		return By.xpath("//div[contains(@class,'instruction_div')]/ol/li[+"+i+"+]/p"); 
	}
	public By SignUpInstrunctionsHeader(int i){
		return By.xpath("//div[contains(@class,'instruction_div')]/ol/li[+"+i+"+]/h3"); 
	}
	public By ConfirmPassword=By.xpath("//label[text()='Confirm Password']/parent::div/div/input");
	public By Register=By.cssSelector("#regiserButton > span:nth-child(1)");
	public By Registrylogo=By.cssSelector("div.logo__container > img");
	public By BackToRegisterButton=By.xpath("//button[contains(@class,'backLink--register')]"); 
	public By SecurityQuestionSubtitle=By.xpath("//p[contains(@class,'securityquestions')]");
	public By SecurityQuestionDrodpdown1=By.id("select-Question 1");
	public By SecurityQuestion1Options(int i){ return By.cssSelector("#menu-Question'\' 1 > div > ul > li:nth-child("+i+")");} 
	//*[@id="menu-Question 1"]/div[2]/ul/li[2]
	public By SecurityQuestionDrodpdown2=By.id("select-Question 2");
	public By SecurityQuestion2Options(int i){ return By.cssSelector("#menu-Question'\' 2 > div > ul > li:nth-child("+i+")");}
	public By SubmitButton=By.xpath("//button[contains(@class,'submit')]");
	public By SecurityQuestion1Answer=By.xpath("//*[@id='select-Question 1']/ancestor::div[@class='form__height']/div/div[5]/div/input[@placeholder='Answer']");
	public By SecurityQuestion2Answer=By.xpath("//*[@id='select-Question 2']/ancestor::div[@class='form__height']/div/div[7]/div/input[@placeholder='Answer']");	
	public By SuccessMessage=By.id("message-id");	// Registration successful! Please Login to continue.
	
	// Forgot Password
	public By BackToLoginButton=By.className("backLink--login");
	public By ForGotPasswordTitle=By.xpath("//title[contains(@class,'forgetPassTitle')]");
	public By ForgotPasswordEmailAddress=By.xpath("//label[text()='Email Address']/parent::div/div/input");
	public By ForgotPasswordSubtitle=By.xpath("//h6[contains(@class,'forgetPass-subtitle')]");
	public By ForgotPasswordEmailAddressError=By.xpath("//div[@class='error']");
	public By ResendEmailTitle=By.xpath("//h4[contains(@class,'resendemail-title')]");
	public By ResendEmailSubTitle=By.xpath("//h6[contains(@class,'resendemail-subtitle')]");
	public By ResentButton=By.xpath("//button[contains(@class,'btn-resendEmail')]");
	
	
	
	
	
	
	
	
}
