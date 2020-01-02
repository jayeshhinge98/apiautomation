package com.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SuiteBase {
	public static WebDriver driver = null;
	public static WebDriverWait chwait = null;
	public static FluentWait<WebDriver> chfwait = null;
	public static ExtentReports reports = null;
	public static ExtentTest logger = null;
	public static Connection con = null;
	public static ExtentHtmlReporter reporter = null;
	TestUtitlies tu = new TestUtitlies();

	//@BeforeMethod
	//@BeforeTest
//	@Parameters("Firefox")
	public void setUp(String browser) throws Exception {
		// A. Setup browser
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver();
		}
		// Check if parameter passed as 'ie'
		else if (browser.equalsIgnoreCase("ie")) {
			// set path to IEDriverServer.exe
			System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
			// create IE instance
			driver = new EdgeDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// B. Navigate to login screen
		driver.get("https://pegasus-qapro.figmd.com/");

		// C. DB settings
		try {
			// DriverManager.registerDriver(new
			// com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("org.postgresql.Driver");
			System.out.println("Trying to connect");
			String dburl = "jdbc:postgresql://35.192.221.231:5432;databaseName=qa_pro";
			con = DriverManager.getConnection(dburl, "postgres", "postgres");
			System.out.println("Connection Established Successful and the DATABASE NAME IS:"
					+ con.getMetaData().getDatabaseProductName());
		} catch (Exception e) {
			System.out.println("Unable to make connection with DB");
			e.printStackTrace();
		}

		// D. Reports configuration
		reporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Reports/PROExtentReport_" + tu.getDateTime() + ".html");
		reporter.config().setDocumentTitle("PRO-NIVADocument");
		reporter.config().setReportName("PRO-NIVA As ReportName");
		reporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Environment", "Production");
		reports.setSystemInfo("OS", "Windows Server 2012 R2");
		reports.setSystemInfo("User Name", "Jayesh Hinge");

	}

	@BeforeMethod
	public void reports(Method m) {
		logger = reports.createTest(m.getName());
		logger.assignAuthor("Jayesh Hinge");
		System.out.println(m.getName());
	}

	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));

		} else if (result.getStatus() == ITestResult.FAILURE) {
			try {
				// Create reference of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our
				// project home directory and
				// result.getName() will return name of test case so that screenshot name will
				String destination = System.getProperty("user.dir") + "//Screenshots//" + result.getName()
						+ tu.getDateTime() + ".png";
				File dest = new File(destination);
				// be same
				FileUtils.copyFile(source, dest);

				System.out.println("Screenshot taken");
				// test.log(Status.FAIL,test.addScreenCaptureFromPath(destination) );

				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
				logger.log(Status.FAIL, result.getThrowable() + "Image" + logger.addScreenCaptureFromPath(destination));

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
				logger.fail(result.getThrowable());
			}
		} else {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}
	}

	@AfterTest(alwaysRun = true)
	public void cleanUp() {
		System.out.println("End of test scenarios.");
		reports.flush();
		driver.close();
		try {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void setUp2() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// B. Navigate to login screen
		driver.get("https://pegasus-qapro.figmd.com/");
		driver.manage().window().maximize();

		// C. DB settings
		try {
			// DriverManager.registerDriver(new
			// com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("org.postgresql.Driver");
			System.out.println("Trying to connect");
			String dburl = "jdbc:postgresql://35.192.221.231:5432/qa_pro";
			con = DriverManager.getConnection(dburl, "postgres", "postgres");
			System.out.println("Connection Established Successful and the DATABASE NAME IS:"
					+ con.getMetaData().getDatabaseProductName());
		} catch (Exception e) {
			System.out.println("Unable to make connection with DB");
			e.printStackTrace();
		}

		// D. Reports configuration
		reporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Reports/PROExtentReport_" + tu.getDateTime() + ".html");
		reporter.config().setDocumentTitle("PRO-NIVADocument");
		reporter.config().setReportName("PRO-NIVA As ReportName");
		reporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Environment", "Production");
		reports.setSystemInfo("OS", "Windows Server 2012 R2");
		reports.setSystemInfo("User Name", "Jayesh Hinge");

	}
}
