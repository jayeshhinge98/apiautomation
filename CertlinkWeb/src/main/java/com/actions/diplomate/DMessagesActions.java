package com.actions.diplomate;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
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
		new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				// return d.findElement(dd.MessageHistoryAllMessage).getText().length()>5;
				return ca.getTextForLocator(driver, dd.MessageHistoryAllMessage).length() > 6;
			}
		});

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
		new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				// return d.findElement(dd.MessageHistoryAllMessage).getText().length()>5;
				return ca.getTextForLocator(driver, dd.MessageHistoryAllMessage).length() > 6;
			}
		});
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
		System.out.println("Subject: " + s + "\nDate: " + s1);
		if (!ca.getTextForLocator(driver, dd.MessageHistorySubjectAndDateOnViewDetailsPopUp).contains(s)
				&& !ca.getTextForLocator(driver, dd.MessageHistorySubjectAndDateOnViewDetailsPopUp).contains(s1)) {
			Assert.fail("Incorrect Subject and Date is displaying on pop-up");
		}

		Wait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		f.until(ExpectedConditions.elementToBeClickable(dd.MessageHistoryViewDetailsPopUpCloseButton));
		ca.clickOnElement(driver, dd.MessageHistoryViewDetailsPopUpCloseButton);
		//markMessageUnReadUsingCheckbox(driver, number, wait);

	}

	public void markMessageUnReadUsingCheckbox(WebDriver driver, String number, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(dd.MessageHistoryCheckBox(number)));
		ca.clickOnElement(driver, dd.MessageHistoryCheckBox(number));
		ca.clickOnElement(driver, dd.MessageHistoryUnread);
		Assert.assertEquals(dd.MyAccountSaveSuccessMessage, "Data saved successfully.",
				"Unable to mark Message as Unread.");
	}

	public void markMessageReadUsingCheckbox(WebDriver driver, String number, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(dd.MessageHistoryCheckBox(number)));
		ca.clickOnElement(driver, dd.MessageHistoryCheckBox(number));
		ca.clickOnElement(driver, dd.MessageHistoryRead);
		Assert.assertEquals(dd.MyAccountSaveSuccessMessage, "Data saved successfully.",
				"Unable to mark Message as read.");
	}

	public void UserAbleToMarkAsRead(WebDriver driver, String string, WebDriverWait wait) {
		if (getUnreadMessageCount(driver).equals("0")) {
			System.out.println("All Messages read by user");
		} else {
			int beforeCount = Integer.parseInt(getUnreadMessageCount(driver));
			ca.clickOnElement(driver, dd.MessageHistoryFilterOptionsExpand);
			wait.until(ExpectedConditions.elementToBeClickable(dd.MessageHistoryReceivedDate));
			ca.clickOnElement(driver, dd.MessageHistoryReceivedDate);
			ca.clickOnElement(driver, dd.MessageHistoryUnread);
			wait.until(ExpectedConditions.attributeContains(dd.MessageHistorySubjectOfMessage(string), "class",
					"font-bold"));
			ca.clickOnElement(driver, dd.MessageHistoryCheckBox(string));
			ca.clickOnElement(driver, dd.MessageHistoryMarkAsReadButton);

			ca.clickOnElement(driver, dd.MessageHistoryUnread);
			ca.clickOnElement(driver, dd.MessageHistoryReceivedDate);
			ca.clickOnElement(driver, dd.MessageHistoryFilterOptionsCollapse);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			System.out.println("Before count:" + beforeCount);
			wait.until(ExpectedConditions.visibilityOfElementLocated(dd.MyAccountSaveSuccessMessage));
		
			Assert.assertEquals(ca.getTextForLocator(driver, dd.MyAccountSaveSuccessMessage), "Data saved successfully.",
					"Unable to mark Message as read.");
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(dd.MyAccountSaveSuccessMessage)));
			int afterCount = Integer.parseInt(getUnreadMessageCount(driver));
			System.out.println("After count on message read:" + afterCount);
			if (afterCount >= beforeCount) {
				Assert.fail("Unable to mark message as read.");
			}
		}

	}

	public void UserAbleToMarkAsUnRead(WebDriver driver, String string, WebDriverWait wait) {

		if (getAllMessageCount(driver).equals(getUnreadMessageCount(driver))) {
			System.out.println("All unread Messages are present.");

		} else {
			int beforeCount = Integer.parseInt(getUnreadMessageCount(driver));
			ca.clickOnElement(driver, dd.MessageHistoryFilterOptionsExpand);
			wait.until(ExpectedConditions.elementToBeClickable(dd.MessageHistoryReceivedDate));
			ca.clickOnElement(driver, dd.MessageHistoryReceivedDate);
			ca.clickOnElement(driver, dd.MessageHistoryRead);
			System.out.println("Filter selected to mark message on top");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					String actual = ca.getAttributeValue(driver, dd.MessageHistorySubjectOfMessage(string), "class");
					if (actual.equals("font-bold"))
						return false;
					else
						return true;
				}
			});
			System.out.println("checked unread message shown on top");
			ca.clickOnElement(driver, dd.MessageHistoryCheckBox(string));
			ca.clickOnElement(driver, dd.MessageHistoryMarkAsUnreadButton);
			ca.clickOnElement(driver, dd.MessageHistoryRead);
			ca.clickOnElement(driver, dd.MessageHistoryReceivedDate);
			ca.clickOnElement(driver, dd.MessageHistoryFilterOptionsCollapse);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			System.out.println("Before count" + beforeCount);
			wait.until(ExpectedConditions.visibilityOfElementLocated(dd.MyAccountSaveSuccessMessage));
			Assert.assertEquals(ca.getTextForLocator(driver, dd.MyAccountSaveSuccessMessage), "Data saved successfully.",
					"Unable to mark Message as Unread.");
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(dd.MyAccountSaveSuccessMessage)));
			int afterCount = Integer.parseInt(getUnreadMessageCount(driver));
			System.out.println("After count on message unread" + afterCount);
			if (afterCount <= beforeCount) {
				Assert.fail("Unable to mark message as Unread.");
			}
		}

	}

	public void Pagination(WebDriver driver, WebDriverWait wait) {

		if (Integer.parseInt(getAllMessageCount(driver)) < 10) {
			System.out.println("No Pagination available as count of messages is less than equal to 10");
		} else {
			// int index = 3;
			try {
				Thread.sleep(3000);
			} catch (Exception e) {

			}
			int count = (Integer.parseInt(getAllMessageCount(driver)) / 10) + 3;
			if (ca.getAttributeValue(driver, dd.MessageHistoryPaginationPrev, "class").equals("disabled")) {
				System.out.println("User is on first page.");
				ca.clickOnElement(driver, dd.MessageHistoryPaginationNext(count - 1));
				if (!ca.getTextForLocator(driver, dd.MessageHistoryGetCurrentPageNumber)
						.equals(Integer.toString(count - 1))
						&& !ca.getAttributeValue(driver, dd.MessageHistoryPaginationPrevClass, "class").equals("prev")
						&& !ca.getAttributeValue(driver, dd.MessageHistoryPaginationNext(count), "class")
								.equals("disabled")) {
					Assert.fail("Forward Pagination is not working.");
				}

				ca.clickOnElement(driver, dd.MessageHistoryPaginationNext(2));
				if (!ca.getTextForLocator(driver, dd.MessageHistoryGetCurrentPageNumber).equals(Integer.toString(1))
						&& !ca.getAttributeValue(driver, dd.MessageHistoryPaginationPrev, "class").equals("disabled")
						&& !ca.getAttributeValue(driver, dd.MessageHistoryPaginationNext(count), "class")
								.equals("next")) {
					Assert.fail("Pagination is not working.");
				}

			} else if (ca.getAttributeValue(driver, dd.MessageHistoryPaginationNext(count), "class")
					.equals("disabled")) {
				System.out.println("User is on last page.");

			}
		}
	}

	public void dateFilter(WebDriver driver, WebDriverWait wait) {
		ca.clickOnElement(driver, dd.MessageHistoryFilterOptionsExpand);
		ca.clickOnElement(driver, dd.MessageHistoryFilterByDateStartDate);
		Select s=new Select(driver.findElement(dd.MessageHistoryMonthSelector));
		s.selectByValue("");
	}

	public void searchFunctionality(WebDriver chdriver, WebDriverWait chwait) {

	}

}