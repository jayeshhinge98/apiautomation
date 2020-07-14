package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SuiteBase {
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static FluentWait<WebDriver> fwait = null;
	public static ExtentReports report = null;
	public static ExtentTest logger = null;
	public static Connection con = null;
	private static String reportFileName = "Test-Automaton-Report" + ".html";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "TestReport";
	private static String reportFileLocation = reportFilepath + fileSeperator + reportFileName;

	@BeforeTest
	public void setUp() throws SQLException, ClassNotFoundException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		String fileName = getReportPath(reportFilepath);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFileName);
		// htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a
		// '('zzz')'");
		report = new ExtentReports();// System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true
		report.setSystemInfo("Environment", "PRO-Niva Automation");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("UserName", "Jayesh Hinge");
		report.attachReporter(htmlReporter);

	}

	@BeforeMethod
	public void reports(Method m) {
		logger = report.createTest(m.getName());
		System.out.println(m.getName());
	}

	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
				return reportFileLocation;
			} else {
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
		return reportFileLocation;
	}

	@AfterMethod
	public void reportsEnd(Method m) {
		logger = report.createTest(m.getName());
		System.out.println(m.getName());
	}
	
	@AfterTest(alwaysRun = true)
	public void cleanUp() {
		 driver.quit();
	}

}