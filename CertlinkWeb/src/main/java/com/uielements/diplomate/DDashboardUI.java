package com.uielements.diplomate;

import org.openqa.selenium.By;

public class DDashboardUI {

	public By DDashboardUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Dashboard']");
	public By AssessmentDesignUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Assessment Design']");
	public By AssessmentUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Assessment']");
	public By QuestionHistoryUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Question History']");
	public By ResourcesUI = By.xpath("//div[@id='divNavigationItems']/a/span[text()='Resources']");
	public By NeedHelpUI = By.xpath("//div[@id='RightSideMenuOnDiplomate']/div/span/span[text()='Need Help?']");
	public By MessagesUI = By.xpath("//div[@id='RightSideMenuOnDiplomate']/div/span/span[text()='Notifications']");
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
		return By.xpath(
				"//div[@class='accordion-row-container'][" + optionnumber + "]//span[@class='icon-fonts icon-plus']");
		// div[@class='accordion-row-container'][1]/descendant::span[1]
	}

	// div[1]/div[@class='accordion-title-row
	// row']/div[1]/div/span/span[@class='icon-fonts icon-plus']
	public By ResourcesGetNameList = By.xpath("//div[@class='accordion-detail-row']/div/div/h3");
	public By NoResourceFoundMessage = By.xpath("//div[@class='accordion-container']/div/div/h4");
	public By ResourceContainers = By.className("accordion-row-container");

	public By ResourceContentAreaDropdownOptions1(String optionnumber) {
		return By.xpath("//*[@id='contentarea']/option[" + optionnumber + "]");
	}

	public By ResourceProviderDropdownOptions1(String optionnumber) {
		return By.xpath("//*[@id='provider']/option[" + optionnumber + "]");
	}

	// My Account
	public By MyAccountProfilePicUpload = By.className("file-upload");
	public By MyAccountEmailField = By.id("txtEmail");
	public By MyAccountFirstName = By.id("txtFirstName");
	public By MyAccountMiddleName = By.id("txtMiddleName");
	public By MyAccountLastName = By.id("txtLastName");
	public By MyAccountSuffix = By.id("ddlSuffix");
	public By MyAccountAlternateNames = By.id("txtAlternateNames");
	public By MyAccountGender = By.id("ddlGender");
	public By MyAccountADASetting = By.id("ddlADASetting");
	// link 1
	// link 2
	public By MyAccountbtnResetPassword = By.id("btnResetPasswordPopup");
	public By MyAccountbtnResetPasswordPopupX = By.xpath("//*[@id='PageContent_UpdPanel2']/div[1]/button/span/span[3]");
	public By MyAccountbtnResetPasswordPopupClose = By.xpath("//*[@id='PageContent_UpdPanel2']/div[3]/button");
	public By MyAccountbtnResetPasswordPopupSave = By.id("btnResetPassword");
	public By MyAccountResetPasswordPopupOldPassword = By.id("PageContent_PasswordOld");
	public By MyAccountResetPasswordPopupNewPassword = By.id("txtResetPassword");
	public By MyAccountResetPasswordPopupConfirmPassword = By.id("PageContent_txtResetPasswordconfirm");
	public By MyAccountResetPasswordPopupLabel = By.id("ResetPasswordlabel");
	public By MyAccountResetPasswordPopupOldPasswordError = By.id("PasswordOldError");
	public By MyAccountResetPasswordPopupNewPasswordError = By.id("PasswordNewError");
	public By MyAccountResetPasswordPopupConfirmPasswordError = By.id("ConfirmPasswordError");
	public By MyAccountSaveSuccessMessage = By
			.xpath("//div[@class='notifyjs-metro-base notifyjs-metro-success']/div[2]/div[2]");

	// *[@class='notifyjs-metro-base notifyjs-metro-success']
	public By MyAccountPhoneNo = By.id("txtPhoneNo");
	public By MyAccountPreferedContactEmail = By.id("//input[@id='rdoEmail' and @name='PreferedContact']");
	public By MyAccountPreferedContactPhone = By.id("//input[@id='rdoPhone' and @name='PreferedContact']");
	public By MyAccountAddAQuestion = By.xpath("//button[contains(text(),'Add a Question')]");

	public By MyAccountDeleteButton(String questionNumber) {
		return By.xpath("//select[@id='ddlquestion_" + questionNumber + "']/parent::div/parent::div/div[2]/i");
	}

	public By MyAccountGetSecurityQuestionCount = By.xpath("//label[contains(text(),'You must select a minimum of')]");
	public By MyAccountSecurityQuestionsAnswered = By.xpath("//select[@name='ddlQuestion']");
	public By MyAccountSaveAccount = By.id("btnUpdate");

	// Messages
	public By MessageHistoryPageHeader = By.xpath("//h1[contains(text(),'Your Notification History')]");
	public By MessageHistoryFilterOptionsExpand = By
			.xpath("//span[@class='text-container']/preceding-sibling::span/span[1]");
	public By MessageHistoryFilterOptionsCollapse = By
			.xpath("//span[@class='text-container']/preceding-sibling::span/span[2]");
	public By MessageHistoryFilterByDateStartDate = By.id("txt-startdate");
	public By MessageHistoryFilterByDateEndDate = By.id("txt-enddate");
	public By MessageHistoryClearFiltersSearch = By.xpath("//a[text()='Clear Filters/Search']");
	public By MessageHistoryReceivedDate = By.id("sentdate");
	public By MessageHistoryRead = By.id("read");
	public By MessageHistoryUnread = By.id("unread");
	public By MessageHistorySearchTermField = By.id("search-term");
	public By MessageHistorySearchTermFieldSendButton = By.className("glyphicon glyphicon-search");
	// It will return names of lists
	public By MessageHistorySortByLabelsList = By.className("breadcrumbs-filtered-line sort-lbl");
	public By MessageHistorySortByReceivedDateLabel = By.xpath("//*[@id='lblsentdate']/text()");
	public By MessageHistorySortByReadLabel = By.xpath("//*[@id='lblread']/text()");
	public By MessageHistorySortByUnreadLabel = By.xpath("//*[@id='lblunread']/text()");
	// If count of messages is greater than 10
	public By MessageHistoryPagination = By.xpath("//*[@id='light-pagination']/ul/li");
	// Get the class name of below webelement to check button disable functionality
	// If ClassName is='current' then current page is selected
	// If ClassName is='disabled' then prev or next button is not present
	// getAttribute("class")
	public By MessageHistoryPaginationPrev = By.xpath("//*[@id='light-pagination']/ul/li[1]");

	public By MessageHistoryPaginationNext(String last) {
		return By.xpath("//*[@id='light-pagination']/ul/li[" + last + "]");
	}

	public By MessageHistoryGetCurrentPageNumber = By
			.xpath("//*[@id='light-pagination']/ul/li[@class='active']/span/text()");
	public By MessageHistoryAllMessage = By.cssSelector("#btnall-readmsg-Row");
	public By MessageHistoryAllUnreadMessage = By.cssSelector("#btnall-unreadmsg-Row");

	// Last will be start from 2
	public By MessageHistoryViewDetailsButton(String last) {
		return By.xpath("//div[" + last + "]/div[3]/span/a[contains(text(),'View Details')]");
	}

	public By MessageHistorySubjectOfMessage(String last) {
		return By.xpath(
				"//div[" + last + "]/div[3]/span/a[contains(text(),'View Details')]//ancestor::div[2]/div[2]/span[2]");
	}

	public By MessageHistoryDateOfMessage(String last) {
		return By.xpath(
				"//div[" + last + "]/div[3]/span/a[contains(text(),'View Details')]//ancestor::div[2]/div[4]/span[2]");
	}

	public By MessageHistorySubjectAndDateOnViewDetailsPopUp = By
			.xpath("//*[@id='view-message-modal']/div/div/div[1]/h3");

	// div[@class='history-table history-table-5-col']/div[2]/div[3]/span/a

	// allows to find xpath for checkbox with number position 1-10
	public By MessageHistoryCheckBox(String number) {
		return By.xpath("//div[@class='history-table-row row'][" + number + "]/div/div/input[@type='checkbox']");
	}

	// get attribute: data-message-count
	public By MessageHistoryBurgerCount = By.xpath("//div/span/span[@class='icon-fonts icon-icon-messages']");
	public By MessageHistoryViewDetailsPopUpCloseButton = By
			.cssSelector("#view-message-modal > div > div > div.modal-header > button > span > span.path3");
			
	public By MessageHistoryMarkAsUnreadButton=By.cssSelector("#btn-mark-unread > div");
	public By MessageHistoryMarkAsReadButton=By.cssSelector("#btn-mark-read > div");
	
	
}
