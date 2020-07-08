package com.PRONiva;

import com.actions.patient.DMessagesActions;
import com.actions.patient.LoginAction;
import com.utilities.SuiteBase;

public class DiplomateMessages extends SuiteBase {

	LoginAction dla = new LoginAction();
	DMessagesActions dma = new DMessagesActions();

//	@Test(priority = 1)
//	public void verifyUnreadMessageCountOnBurgerMenu() {
//		String user = "abp1@sharklasers.com";
//		dla.DiplomateLogin(chdriver, user, "Abcd1234#", "valid");
//		dma.UnreadMessageCountOnBurger(chdriver, con, "select SUM(CT) Total from ( \r\n"
//				+ "select COUNT(SystemNotificationScheduleHistoryUid) as CT from SystemNotificationScheduleHistory \r\n"
//				+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
//				+ "' and IsRead=0 and IsSuccess=1 and SendMethod='Email') \r\n" + "UNION ALL \r\n"
//				+ "select COUNT(NotificationScheduleHistoryUid) as CT from NotificationScheduleHistory \r\n"
//				+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
//				+ "')and IsRead=0 and IsSuccess=1 and SendMethod=1) \r\n" + "tempTable1", chwait);
//	}
//
//	@Test(priority = 2,enabled=true)
//	public void verifyUnreadMessageCountOnNormalMenu() {
//		String user = "abp1@sharklasers.com";
//		// dla.DiplomateLogin(chdriver, user, "Abcd1234#", "valid");
//		dma.UnreadMessageCount(chdriver, con, "select SUM(CT) Total from ( \r\n"
//				+ "select COUNT(SystemNotificationScheduleHistoryUid) as CT from SystemNotificationScheduleHistory \r\n"
//				+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
//				+ "' and IsRead=0 and IsSuccess=1 and SendMethod='Email') \r\n" + "UNION ALL \r\n"
//				+ "select COUNT(NotificationScheduleHistoryUid) as CT from NotificationScheduleHistory \r\n"
//				+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
//				+ "')and IsRead=0 and IsSuccess=1 and SendMethod=1) \r\n" + "tempTable1", chwait);
//	}
//
//	@Test(priority = 3,enabled=true)
//	public void verifyAllMessageCountOnNormalMenu() {
//		String user = "abp1@sharklasers.com";
//		// dla.DiplomateLogin(chdriver, user, "Abcd1234#", "valid");
//		dma.AllMessageCount(chdriver, con,
//				"select SUM(CT) Total from ( select COUNT(SystemNotificationScheduleHistoryUid) as "
//						+ "CT from SystemNotificationScheduleHistory where FIGUserUid=(select FIGUserUid from FIGUser "
//						+ "where LoginName='" + user + "') UNION ALL "
//						+ "select COUNT(NotificationScheduleHistoryUid) as CT from NotificationScheduleHistory "
//						+ "where FIGUserUid=(select FIGUserUid from FIGUser where LoginName='" + user
//						+ "')) tempTable1",
//				chwait);
//	}
//
//	@Test(priority = 4,enabled=true)
//	public void verifyUnreadMessageTabSelected() {
//		dma.UnreadMessageTabSelected(chdriver);
//	}
//
//	@Test(priority = 5,enabled=true)
//	public void verifyAllMessageTabSelected() {
//		dma.AllMessageTabSelected(chdriver);
//	}
//
//	@Test(priority = 6,enabled=true)
//	public void verifyUserAbleToMarkAsRead() {
//		dma.UserAbleToMarkAsRead(chdriver, "2", chwait);
//	}
//
//	@Test(priority =7,enabled=true)
//	public void verifyUserAbleToMarkAsUnRead() {
//		dma.UserAbleToMarkAsUnRead(chdriver, "2", chwait);
//	}
//	
//	@Test(priority = 8)
//	public void verifyDetailsOfMessage() {
//		dma.detailsOfMessage(chdriver, "2", chwait);
//	}
//	
//	@Test(priority =9,enabled=true)
//	public void verifyPagination() {
//		dma.Pagination(chdriver, chwait);
//		//dla.DiplomateLogout(chdriver, chwait);
//	}
//	@Test(priority =10,enabled=true)
//	public void verifyFilter() {
//		dma.dateFilter(chdriver, chwait);
//		
//	}
//	@Test(priority =11,enabled=true)
//	public void verifySearch() {
//		dma.searchFunctionality(chdriver, chwait);
//	}
}
