package com.utilities;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
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
	public static WebDriver chdriver = null;
	public static WebDriver iOSdriver = null;
	public static WebDriver safaridriver = null;
	public static WebDriver ffdriver = null;
	public static HtmlUnitDriver hldriver = null;
	public static WebDriverWait chwait = null;
	public static FluentWait<WebDriver> chfwait = null;
	public static ExtentReports report = null;
	public static ExtentTest logger = null;
	public static Connection con = null;
	private static String reportFileName = "Test-Automaton-Report" + ".html";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "TestReport";
	private static String reportFileLocation = reportFilepath + fileSeperator + reportFileName;

	@BeforeTest
	public void setUp() throws SQLException, ClassNotFoundException {
		setUpChrome();
		try {
			// DriverManager.registerDriver(new
			// com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Trying to connect");
			String dburl = "jdbc:sqlserver://10.22.43.6:1433;databaseName=FIGMDHQIManagementABMS";
			con = DriverManager.getConnection(dburl, "mapping", "mp3245");
			System.out.println("Connection Established Successful and the DATABASE NAME IS:"
					+ con.getMetaData().getDatabaseProductName());
		} catch (Exception e) {
			System.out.println("Unable to make connection with DB");
			e.printStackTrace();
		}
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

	public void setUpSafari() {
		safaridriver = new SafariDriver();
		safaridriver.manage().window().maximize();
	}

	public void setUpHeadLessBrowser() {
		hldriver = new HtmlUnitDriver();
		hldriver.setJavascriptEnabled(true);
		hldriver.manage().window().maximize();
	}

	public void setUpChrome() {
		System.setProperty("webdriver.chrome.driver", "D:/QA/chromedriver.exe");
		chdriver = new ChromeDriver();
		chdriver.manage().window().maximize();
		
	}

	public void setUpFirefox() {
		System.setProperty("webdriver.gecko.driver", "/src/main/resources/geckodriver");
		ffdriver = new FirefoxDriver();
		ffdriver.manage().window().maximize();
	}

	public void setUpIOS() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability(CapabilityType.VERSION, "6.1");
		// capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Mac");
		capabilities.setCapability("app",
				"/Users/username/Downloads/InternationalMountains   /build/Release-iphonesimulator/InternationalMountains.app");
		// iOSdriver = new IOSDriver(new URL("http://127.0.0.1:4725/wd/hub"),
		// capabilities);
		// Desktop.getDesktop().open(new File("/Applications/Appium.app"));
	}

	@AfterTest(alwaysRun = true)
	public void cleanUp() {
		// chdriver.quit();
		// ffdriver.quit();
		// safaridriver.quit();
		// iOSdriver.quit();
		// iOSdriver.quit();
		// hldriver.quit();
	}

}
