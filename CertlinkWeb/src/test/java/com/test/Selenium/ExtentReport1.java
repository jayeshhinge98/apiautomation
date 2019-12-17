package com.test.Selenium;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport1 {

	// Use is for Responsible for lookup and feel
	ExtentHtmlReporter reporter;
	// Creates entries in you report
	ExtentReports reports;
	// Update your status in your report(PASS/ FAIL)
	ExtentTest test;
	
	WebDriver driver;

	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		reporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Reports/PROExtentReport_" + getDateTime() + ".html");
		// reports.
		reporter.config().setDocumentTitle("PRO-NIVADocument");
		// Name of the report
		reporter.config().setReportName("PRO-NIVA As ReportName");
		// Dark Theme
		reporter.config().setTheme(Theme.STANDARD);


		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Environment", "Production");
		reports.setSystemInfo("OS", "Windows Server 2012 R2");
		reports.setSystemInfo("User Name", "Jayesh Hinge");
	}

	@Test(priority = 1)
	public void VerifySuccess() {

		test = reports.createTest("To verify extent report success testcase scenario");

		// Assign category
		test.assignCategory("Smoke", "Regression");
		
		// Assign Author
		test.assignAuthor("Jayesh Hinge");

		// test.pass("This test case passed.");
	}

	@Test(priority = 2)
	public void VerifyFail() {

		test = reports.createTest("To verify extent report fail testcase scenario");

		// Assign category
		test.assignCategory("Regression");
		// Assign Author
		test.assignAuthor("Shrinivas");

		test.log(Status.INFO, "This is Step 1");
		test.log(Status.INFO, "This is Step 2");

		// test.log(Status.FAIL, "This test case VerifyFail is failed.");
		Assert.fail("This test case VerifyFail is failed");
	}

	@Test(priority = 3)
	public void VerifySkip() {

		test = reports.createTest("To verify extent report skip testcase scenario");

		// Assign category
		// test.assignCategory("Smoke");
		// Assign Author
		test.assignAuthor("Shrinivas");

		// test.log(Status.SKIP, "This test case skipped.");

		throw new SkipException("message");
	}

	// Create node which used to verify different chunks before final scenario
	// verification
	@Test(priority = 4)
	public void VerifyNodeCreation() {

		test = reports.createTest("To verify extent report nodecreation testcase scenario");

		// Assign category
		test.assignCategory("Smoke");
		// Assign Author
		test.assignAuthor("Shrinivas");

		ExtentTest node = test.createNode("Node1", "This is node 1 description");
		ExtentTest node1 = test.createNode("Node1", "This is node 1 description");
		node.info("This is child node 1 step 1");
		node.info("This is child node 1 step 2");
		node.pass("Node 1 passed");
		node1.info("This is child node 2 step A");
		node1.info("This is child node 2 step B");
		node1.pass("Node 2 passed");

		// test.pass("This test case pass");
	}

	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			// test.pass("This test case successes.");
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));

		} else if (result.getStatus() == ITestResult.FAILURE) {			
			try {
				// Create reference of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our
				// project home directory and
				// result.getName() will return name of test case so that screenshot name will
				String destination=System.getProperty("user.dir")+"//Screenshots//" + result.getName()+getDateTime() + ".png";
				File dest=new File(destination);
				// be same
				FileUtils.copyFile(source,dest );
				

				System.out.println("Screenshot taken");
				//test.log(Status.FAIL,test.addScreenCaptureFromPath(destination) );
				
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
				test.log(Status.FAIL,result.getThrowable()+"Image"+test.addScreenCaptureFromPath(destination));
				
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
				test.fail(result.getThrowable());
			}
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("End of test scenarios.");
		// driver.close();
		reports.flush();
		driver.close();
	}

	public String getDateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String dateTime = df.format(date).replace("/", "_");
		// String newTime=dateTime.replace("/", "_");
		return dateTime.replace(":", ".");
	}
}
