package com.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class TestUtitlies {

	public String randomAlphabetic(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}

	public String randomAlphaNumeric(int count) {
		return RandomStringUtils.randomAlphanumeric(count);
	}
	
	public String randomNumeric(int count) {
		return RandomStringUtils.randomNumeric(count);
	}
	
	public String getDateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String dateTime = df.format(date).replace("/", "_");
		// String newTime=dateTime.replace("/", "_");
		return dateTime.replace(":", ".");
	}
	

}
