package com.certlink;

import org.testng.annotations.Test;

import com.actions.diplomate.DLoginAction;
import com.actions.diplomate.DMessagesActions;
import com.utilities.SuiteBase;

public class DiplomateMessages extends SuiteBase {

	DLoginAction dla = new DLoginAction();
	DMessagesActions dma = new DMessagesActions();

	@Test(priority = 1)
	public void verifyUnreadMessageCountOnBurgerMenu() {
		String user = "abp1@sharklasers.com";
		dla.DiplomateLogin(chdriver, user, "Abcd1234#", "valid");
		dma.UnreadMessageCountOnBurger(chdriver, con, "select SUM(CT) Total from ( \r\n"
				+ "select COUNT(SystemNotificationScheduleHistoryUid) as CT from SystemNotificationScheduleHistory \r\n"
				+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
				+ "' and IsRead=0 and IsSuccess=1 and SendMethod='Email') \r\n" + "UNION ALL \r\n"
				+ "select COUNT(NotificationScheduleHistoryUid) as CT from NotificationScheduleHistory \r\n"
				+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
				+ "')and IsRead=0 and IsSuccess=1 and SendMethod=1) \r\n" + "tempTable1", chwait);
	}

	@Test(priority = 2)
	public void verifyUnreadMessageCountOnNormalMenu() {
		String user = "abp1@sharklasers.com";
		// dla.DiplomateLogin(chdriver, user, "Abcd1234#", "valid");
		dma.UnreadMessageCount(chdriver, con, "select SUM(CT) Total from ( \r\n"
				+ "select COUNT(SystemNotificationScheduleHistoryUid) as CT from SystemNotificationScheduleHistory \r\n"
				+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
				+ "' and IsRead=0 and IsSuccess=1 and SendMethod='Email') \r\n" + "UNION ALL \r\n"
				+ "select COUNT(NotificationScheduleHistoryUid) as CT from NotificationScheduleHistory \r\n"
				+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
				+ "')and IsRead=0 and IsSuccess=1 and SendMethod=1) \r\n" + "tempTable1", chwait);
	}

	@Test(priority = 3)
	public void verifyAllMessageCountOnNormalMenu() {
		String user = "abp1@sharklasers.com";
		// dla.DiplomateLogin(chdriver, user, "Abcd1234#", "valid");
		dma.AllMessageCount(chdriver, con,
				"select SUM(CT) Total from ( select COUNT(SystemNotificationScheduleHistoryUid) as "
						+ "CT from SystemNotificationScheduleHistory where FIGUserUid=(select FIGUserUid from FIGUser "
						+ "where LoginName='" + user + "') UNION ALL "
						+ "select COUNT(NotificationScheduleHistoryUid) as CT from NotificationScheduleHistory "
						+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
						+ "')) tempTable1",
				chwait);
	}

	@Test(priority = 4)
	public void verifyUnreadMessageTabSelected() {
		dma.UnreadMessageTabSelected(chdriver);
	}

	@Test(priority = 5)
	public void verifyAllMessageTabSelected() {
		dma.AllMessageTabSelected(chdriver);
	}

	@Test(priority = 6)
	public void verifyDetailsOfMessage() {
		dma.detailsOfMessage(chdriver, "2", chwait);
	}
	
	@Test(priority = 7)
	public void verifyUserAbleToMarkAsRead() {
		dma.UserAbleToMarkAsRead(chdriver, "2", chwait);
	}

	@Test(priority = 8)
	public void verifyUserAbleToMarkAsUnRead() {
		dma.UserAbleToMarkAsUnRead(chdriver, "2", chwait);
	}
	@Test(priority = 9)
	public void verifyPagination() {
		dma.Pagination(chdriver, chwait);
	}

}
