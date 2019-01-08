package com.uielements.diplomate;

import org.openqa.selenium.By;

public class DDashboardUI {

	public By DDashboardUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Dashboard']");
	public By AssessmentDesignUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Assessment Design']");
	public By AssessmentUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Assessment']");
	public By QuestionHistoryUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Question History']");
	public By ResourcesUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Resources']");
	public By NeedHelpUI = By.xpath("//div[@id='RightSideMenuOnDiplomate']/div/span/span[text()='Need Help?']");
	public By NotificationsUI = By.xpath("//div[@id='RightSideMenuOnDiplomate']/div/span/span[text()='Notifications']");
	public By DMyAccountUI = By.xpath("//div[@id='RightSideMenuOnDiplomate']/div/span/span[text()='My Account']");
	public By DLogoutUI = By.xpath("//div[@id='RightSideMenuOnDiplomate']/div/span/span[text()='Sign Out']");
	public By DSignOutButtonUI = By.id("btnSelfLogout");
	public By DSignOutCancelButtonUI = By.xpath("//*[@id=\"confirmlogoutModal\"]/div/div/div[2]/button[2]");
	public By DSignOutCloseButtonUI = By.xpath("//*[@id=\"confirmlogoutModal\"]/div/div/div[1]/button/span/span[3]");
	public By SiteTitleUI = By.className("site-title");

	// Resources
	public By ResourcePageUI = By.xpath("//*[@id='divResource']/div/div[1]/div[1]/div/div[1]/div/h1");
	public By ResourceSearchFieldUI = By.className("resource-search");
	public By ResourceSearchSubmitButtonUI = By.className("glyphicon glyphicon-search");
	public By ResourceProviderDropDownUI = By.id("provider");
	public By ResourceContentAreaDropDownUI = By.id("contentarea");
	public By ResourceContentAreaDropdownOptions = By.xpath("//*[@id='contentarea']/option");
	public By ResourceProviderDropdownOptions = By.xpath("//*[@id='provider']/option");
	public By ResourcesExpandButton = By.xpath("//span[@class='icon-fonts icon-plus']");
	public By ResourcesExpandButtons(int optionnumber) {
		return By.xpath("//div[@class='accordion-row-container'][" + optionnumber + "]//span[@class='icon-fonts icon-plus']");
		//div[@class='accordion-row-container'][1]/descendant::span[1]
	}
	//div[1]/div[@class='accordion-title-row row']/div[1]/div/span/span[@class='icon-fonts icon-plus'] 
	public By ResourcesGetNameList = By.xpath("//div[@class='accordion-detail-row']/div/div/h3");
	public By NoResourceFoundMessage=By.xpath("//div[@class='accordion-container']/div/div/h4");
	public By ResourceContainers =By.className("accordion-row-container");
	public By ResourceContentAreaDropdownOptions1(String optionnumber) {
		return By.xpath("//*[@id='contentarea']/option[" + optionnumber + "]");
	}

	public By ResourceProviderDropdownOptions1(String optionnumber) {
		return By.xpath("//*[@id='provider']/option[" + optionnumber + "]");
	}
	
	// My Account
	public By MyAccountProfilePicUpload=By.className("file-upload");
	public By MyAccountEmailField=By.id("txtEmail");
	public By MyAccountFirstName=By.id("txtFirstName");
	public By MyAccountMiddleName=By.id("txtMiddleName");
	public By MyAccountLastName=By.id("txtLastName");
	public By MyAccountSuffix=By.id("ddlSuffix");
	public By MyAccountAlternateNames=By.id("txtAlternateNames");
	public By MyAccountGender=By.id("ddlGender");
	public By MyAccountADASetting=By.id("ddlADASetting");
	// link 1
	// link 2
	public By MyAccountbtnResetPassword=By.id("btnResetPasswordPopup");
	public By MyAccountbtnResetPasswordPopupX=By.xpath("//*[@id='PageContent_UpdPanel2']/div[1]/button/span/span[3]");
	public By MyAccountbtnResetPasswordPopupClose=By.xpath("//*[@id='PageContent_UpdPanel2']/div[3]/button");	
	public By MyAccountbtnResetPasswordPopupSave=By.id("btnResetPassword");
	public By MyAccountResetPasswordPopupOldPassword=By.id("PageContent_PasswordOld");	
	public By MyAccountResetPasswordPopupNewPassword=By.id("txtResetPassword");	
	public By MyAccountResetPasswordPopupConfirmPassword=By.id("PageContent_txtResetPasswordconfirm");
	public By MyAccountResetPasswordPopupLabel=By.id("ResetPasswordlabel");
	public By MyAccountResetPasswordPopupOldPasswordError=By.id("PasswordOldError");	
	public By MyAccountResetPasswordPopupNewPasswordError=By.id("PasswordNewError");	
	public By MyAccountResetPasswordPopupConfirmPasswordError=By.id("ConfirmPasswordError");
	public By MyAccountPasswordChangeSuccessMessage=By.xpath("//div[contains(text(),'Password changed.')]");	
	//*[@class='notifyjs-metro-base notifyjs-metro-success']
	public By MyAccountPhoneNo=By.id("txtPhoneNo");
	public By MyAccountPreferedContactEmail=By.id("//input[@id='rdoEmail' and @name='PreferedContact']");
	public By MyAccountPreferedContactPhone=By.id("//input[@id='rdoPhone' and @name='PreferedContact']");
	public By MyAccountADASetting=By.id("ddlADASetting");
	public By MyAccountADASetting=By.id("ddlADASetting");
	public By MyAccountADASetting=By.id("ddlADASetting");
	public By MyAccountADASetting=By.id("ddlADASetting");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
