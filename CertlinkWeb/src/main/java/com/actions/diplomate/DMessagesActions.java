package com.actions.diplomate;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.CommonActions;
import com.google.common.base.CharMatcher;
import com.uielements.diplomate.DDashboardUI;
import com.utilities.TestUtitlies;

public class DMessagesActions {
	DDashboardUI dd = new DDashboardUI();
	CommonActions ca = new CommonActions();
	TestUtitlies tu = new TestUtitlies();
	DLoginAction dla = new DLoginAction();

	public String getUnreadMessageCount(WebDriver driver) {
		new WebDriverWait(driver, 60).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
		Wait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		f.until(ExpectedConditions.presenceOfElementLocated(dd.MessageHistoryAllMessage));
		return (CharMatcher.digit().retainFrom(ca.getTextForLocator(driver, dd.MessageHistoryAllUnreadMessage)));
	}

	public void UnreadMessageCount(WebDriver driver, Connection con, String sqlquery, WebDriverWait wait) {
		assertEquals(getUnreadMessageCount(driver), ca.returnDBData(con, sqlquery, "Total"),
				"Result is not matching for unread message count");
	}

	public String getAllMessageCount(WebDriver driver) {
		Wait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		f.until(ExpectedConditions.presenceOfElementLocated(dd.MessageHistoryAllMessage));
		return CharMatcher.digit().retainFrom(ca.getTextForLocator(driver, dd.MessageHistoryAllMessage));

	}

	public void AllMessageCount(WebDriver driver, Connection con, String sqlquery, WebDriverWait wait) {
		assertEquals(getAllMessageCount(driver), ca.returnDBData(con, sqlquery, "Total"),
				"Result is not matching for All Message count");
	}

	public void UnreadMessageCountOnBurger(WebDriver driver, Connection con, String sqlquery, WebDriverWait wait) {
		ca.clickOnElement(driver, dd.MessagesUI);
		// new WebDriverWait(driver, 60).until(
		// webDriver -> ((JavascriptExecutor) webDriver).executeScript("return
		// document.readyState").equals("complete"));
		Wait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		f.until(ExpectedConditions.visibilityOfElementLocated(dd.MessageHistoryBurgerCount));// ,
																								// "data-message-count"));
		String s = ca.getAttributeValue(driver, dd.MessageHistoryBurgerCount, "data-message-count");
		assertEquals(s, ca.returnDBData(con, sqlquery, "Total"), "Result is not matching on burger");
	}

	public void UnreadMessageTabSelected(WebDriver driver) {
		ca.clickOnElement(driver, dd.MessageHistoryAllUnreadMessage);
		if (!ca.getAttributeValue(driver, dd.MessageHistoryAllUnreadMessage, "class").contains("selected")) {
			Assert.fail("Unable to navigate to Unread Messages tab.");
		}
	}

	public void AllMessageTabSelected(WebDriver driver) {
		ca.clickOnElement(driver, dd.MessageHistoryAllMessage);
		if (!ca.getAttributeValue(driver, dd.MessageHistoryAllMessage, "class").contains("selected")) {
			Assert.fail("Unable to navigate to All Messages tab.");
		}
	}

	public void detailsOfMessage(WebDriver driver, String number, WebDriverWait wait) {
		ca.clickOnElement(driver, dd.MessageHistoryViewDetailsButton("2"));
		String s = ca.getTextForLocator(driver, dd.MessageHistorySubjectOfMessage("2"));
		String s1 = ca.getTextForLocator(driver, dd.MessageHistoryDateOfMessage("2"));
		if (!ca.getTextForLocator(driver, dd.MessageHistorySubjectAndDateOnViewDetailsPopUp).contains(s)
				&& !ca.getTextForLocator(driver, dd.MessageHistorySubjectAndDateOnViewDetailsPopUp).contains(s1)) {
			Assert.fail("Incorrect Subject and Date is displaying on pop-up");
		}
		ca.clickOnElement(driver, dd.MessageHistoryViewDetailsPopUpCloseButton);
		markMessageUnReadUsingCheckbox(driver, number, wait);
	}

	public void markMessageUnReadUsingCheckbox(WebDriver driver, String number, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(dd.MessageHistoryCheckBox(number)));
		ca.clickOnElement(driver, dd.MessageHistoryCheckBox(number));
		ca.clickOnElement(driver, dd.MessageHistoryUnread);
	}

	public void markMessageReadUsingCheckbox(WebDriver driver, String number, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(dd.MessageHistoryCheckBox(number)));
		ca.clickOnElement(driver, dd.MessageHistoryCheckBox(number));
		ca.clickOnElement(driver, dd.MessageHistoryRead);
	}

	public void UserAbleToMarkAsRead(WebDriver driver, String string, WebDriverWait wait) {
		if (getUnreadMessageCount(driver).equals("0")) {
			System.out.println("All Messages read by user");
		} else {
			int beforeCount = Integer.parseInt(getUnreadMessageCount(driver));
			ca.clickOnElement(driver, dd.MessageHistoryFilterOptionsExpand);
			wait.until(ExpectedConditions.elementToBeClickable(dd.MessageHistorySortByReceivedDateLabel));
			ca.clickOnElement(driver, dd.MessageHistorySortByReceivedDateLabel);
			ca.clickOnElement(driver, dd.MessageHistorySortByUnreadLabel);
			wait.until(ExpectedConditions.attributeContains(dd.MessageHistorySubjectOfMessage(string), "class",
					"font-bold"));
			ca.clickOnElement(driver, dd.MessageHistoryCheckBox(string));
			ca.clickOnElement(driver, dd.MessageHistoryMarkAsReadButton);
			ca.clickOnElement(driver, dd.MessageHistoryFilterOptionsCollapse);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			int afterCount = Integer.parseInt(getUnreadMessageCount(driver));
			if (afterCount >= beforeCount) {
				Assert.fail("Unable to mark message as read.");
			}
		}

	}

	public void UserAbleToMarkAsUnRead(WebDriver driver, String string, WebDriverWait wait) {
		int beforeCount = Integer.parseInt(getUnreadMessageCount(driver));
		if (getAllMessageCount(driver).equals(getUnreadMessageCount(driver))) {
			System.out.println("All unread Messages are present.");

		} else {
			ca.clickOnElement(driver, dd.MessageHistoryFilterOptionsExpand);
			wait.until(ExpectedConditions.elementToBeClickable(dd.MessageHistorySortByReceivedDateLabel));
			ca.clickOnElement(driver, dd.MessageHistorySortByReadLabel);
			String s = null;
			do {
				s = ca.getAttributeValue(driver, dd.MessageHistorySubjectOfMessage(string), "class");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} while (!s.contains("font-bold"));
			ca.clickOnElement(driver, dd.MessageHistoryCheckBox(string));
			ca.clickOnElement(driver, dd.MessageHistoryMarkAsUnreadButton);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			int afterCount = Integer.parseInt(getUnreadMessageCount(driver));
			if (afterCount <= beforeCount) {
				Assert.fail("Unable to mark message as Unread.");
			}
		}

	}

	public void Pagination(WebDriver driver, WebDriverWait wait) {
	
		if(Integer.parseInt(getAllMessageCount(driver))<10) {
			System.out.println("No Pagination available as count of messages is less than equal to 10");
		}else{
			
		}
		
	}
}