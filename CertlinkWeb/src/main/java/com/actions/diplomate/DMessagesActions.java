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

	public void UnreadMessageCount(WebDriver driver, Connection con, String sqlquery, WebDriverWait wait) {
		new WebDriverWait(driver, 60).until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		Wait<WebDriver> f=new FluentWait<WebDriver>(driver).
				withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		f.until(ExpectedConditions.presenceOfElementLocated(dd.MessageHistoryAllMessage));
		String s = CharMatcher.digit().retainFrom( ca.getTextForLocator(driver, dd.MessageHistoryAllUnreadMessage));
		assertEquals(s, ca.returnDBData(con, sqlquery,"Total"),"Result is not matching");
	}

	public void AllMessageCount(WebDriver driver, Connection con, String sqlquery, WebDriverWait wait) {
		//ca.clickOnElement(driver, dd.MessagesUI);
//		new WebDriverWait(driver, 60).until(
//		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));	
		Wait<WebDriver> f=new FluentWait<WebDriver>(driver).
				withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		f.until(ExpectedConditions.presenceOfElementLocated(dd.MessageHistoryAllMessage));
		String s = CharMatcher.digit().retainFrom(ca.getTextForLocator(driver, dd.MessageHistoryAllMessage));
		assertEquals(s, ca.returnDBData(con, sqlquery, "Total"),"Result is not matching");
	}
	
	public void UnreadMessageCountOnBurger(WebDriver driver, Connection con, String sqlquery, WebDriverWait wait) {
		ca.clickOnElement(driver, dd.MessagesUI);
//		new WebDriverWait(driver, 60).until(
//		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		Wait<WebDriver> f=new FluentWait<WebDriver>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		f.until(ExpectedConditions.visibilityOfElementLocated(dd.MessageHistoryBurgerCount));//, "data-message-count"));
		String s = ca.getAttributeValue(driver, dd.MessageHistoryBurgerCount, "data-message-count");		
		assertEquals(s, ca.returnDBData(con, sqlquery,"Total"),"Result is not matching");
	}

	public void UnreadMessageTabSelected(WebDriver driver) {
		ca.clickOnElement(driver, dd.MessageHistoryAllUnreadMessage);
		if(!ca.getAttributeValue(driver, dd.MessageHistoryAllUnreadMessage, "class").contains("selected"))
		{
			Assert.fail("Unable to navigate to Unread Messages tab.");
		}
	}
	public void AllMessageTabSelected(WebDriver driver) {
		ca.clickOnElement(driver, dd.MessageHistoryAllMessage);
		if(!ca.getAttributeValue(driver, dd.MessageHistoryAllMessage, "class").contains("selected"))
		{
			Assert.fail("Unable to navigate to All Messages tab.");
		}
	}

	public void detailsOfMessage(WebDriver driver) {
		ca.clickOnElement(driver, dd.MessageHistoryViewDetailsButton("2"));
		String s=ca.getTextForLocator(driver, dd.MessageHistorySubjectOfMessage("2"));
		String s1=ca.getTextForLocator(driver, dd.MessageHistoryDateOfMessage("2"));
		if(!ca.getTextForLocator(driver, dd.MessageHistorySubjectAndDateOnViewDetailsPopUp).contains(s)) {
			Assert.fail("Incorrect Subject is displaying on pop-up");
		}if(!ca.getTextForLocator(driver, dd.MessageHistorySubjectAndDateOnViewDetailsPopUp).contains(s1)) {
			Assert.fail("Incorrect Date is displaying on pop-up");
		}		
	}

	public void markMessageUnread(WebDriver chdriver) {
		//
		
		
	}
	
}
