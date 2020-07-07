package com.test.SeleniumPrograms;

import java.sql.Timestamp;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportExamples {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:/QA/chromedriver.exe");
		driver = new ChromeDriver();

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		// String os = cap.getPlatform().toString();
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println(os);
		String v = cap.getVersion().toString();
		System.out.println(v);

		htmlReporter = new ExtentHtmlReporter(
				"D:/QA/My Workspace/CertlinkWeb/TestReport-"+new Timestamp(new Date().getTime())+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// extent.setSystemInfo("OS", os);
		extent.setSystemInfo("Browser", browserName + " " + v);

		// configuration items to change the look and feel
		// add content, manage tests etc
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@Test
	public void testCase1() {
		test = extent.createTest("Test Case 1", "PASSED test case");
		Assert.assertTrue(true);
	}

	@Test
	public void testCase2() {
		test = extent.createTest("Test Case 2", "PASSED test case");
		Assert.assertTrue(true);
	}

	@Test
	public void testCase3() {
		test = extent.createTest("Test Case 3", "PASSED test case");
		Assert.assertTrue(true);
	}

	@Test
	public void testCase4() {
		test = extent.createTest("Test Case 4", "PASSED test case");
		Assert.assertTrue(false);
	}

	@Test
	public void testCase5() {
		test = extent.createTest("Test Case 5", "SKIPPED test case");
		throw new SkipException("Skipping this test with exception");
	}

	@Test(enabled = false)
	public void testCase6() {
		test = extent.createTest("Test Case 6",
				"I'm Not Ready, please don't execute me");
	}

	@AfterMethod
	public void endMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()
					+ " Failed.", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()
					+ " Success.", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()
					+ " Skipped.", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void endClass() {
		extent.flush();
		driver.quit();
	}
}
