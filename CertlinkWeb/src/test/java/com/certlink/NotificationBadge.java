package com.certlink;

import org.testng.annotations.Test;

import com.actions.CommonActions;
import com.actions.diplomate.DLoginAction;
import com.utilities.SuiteBase;

public class NotificationBadge extends SuiteBase {
	DLoginAction dla = new DLoginAction();
	CommonActions ca= new CommonActions();
	
	// Scenarios:
	// Requirement: 
	// 1. Count of schedules expected to sent on previous day based on last run time 
	// 2. Last Run Time should be previous day and get NotificationScheduleUid and add 
	// those into NotificationScheduledHistory table and get the count of users with status check IsSuccess 
	// Also while checking history it should consider previous day date
	// 3. Check NotificationReport against the UId whether it is triggered or not.

	@Test
	public void CheckNotification() {
		String query = "select mb.acronym, ns.NotificationMessageUid,ns.NotificationScheduleUid ,ns.currentstatus,nm.Name,ns.Name,ns.StartDateFrom,ns.LastRunTime,ns.NextRunTime from NotificationSchedule ns"
				+ "		inner join NotificationMessage nm on ns.NotificationMessageUid=nm.NotificationMessageUid"
				+ "		inner join masterboard mb on mb.BoardUid=nm.BoardUid" + "		 where "
				+ "		 ns.Inactive=0 and isnull(nm.isdeleted,0)=0 and nm.inactive=0 and ns.EndDateTo>getutcdate() and performJob is not null and "
				+ "		mb.BoardUid  in ('9E1DE1C6-2A1C-58AC-8205-165B77FD109A','120FCB08-E6EE-27F3-966D-17AF7DA5422C','A2A6B0EB-82DE-2B6C-5696-3126796A43CD',"
				+ "		'1A8C6DC8-98DB-3493-8E24-B473B617A101','129A5476-147E-28E6-A59A-C53581CD4F1E','6638E07C-1FA4-0A98-4662-C6BE4DD96614','160BEB8D-A245-42B0-F413-D248B604203F',"
				+ "		'3754EB7D-FFEF-3A30-95B0-F10800024E02') order by ns.NextRunTime";
	
		//System.out.println("Under method");
		
		 ca.returnDBData(con, query, "currentstatus");
		 ca.returnDBData(con, query, "LastRunTime");
		 ca.returnDBData(con, query, "count");
	}

}
