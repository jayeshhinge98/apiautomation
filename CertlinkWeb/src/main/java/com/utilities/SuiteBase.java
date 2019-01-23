package com.utilities;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.Driver;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import com.aventstack.extentreports.ExtentReports;

public class SuiteBase {
	public static WebDriver chdriver = null;
	public static WebDriver iOSdriver = null;
	public static WebDriver safaridriver = null;
	public static WebDriver ffdriver = null;
	public static HtmlUnitDriver hldriver = null;
	public static WebDriverWait chwait = null;
	public static FluentWait<WebDriver> chfwait = null;
	public static ExtentReports report = null;
	public static Connection con=null;

	@BeforeTest
	public void setUp() throws SQLException, ClassNotFoundException {
		// setUpSafari();
		// safaridriver.get("https://www.google.com");
		setUpChrome();
		chdriver.get("https://www.mycertlink.org/Dashboard/login.aspx#");
		// setUpHeadLessBrowser();
		// hldriver.get("https://www.google.com");

		try {
			//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());    
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
		System.setProperty("webdriver.chrome.driver", "D:/Jayesh Hinge/chromedriver.exe");
		chdriver = new ChromeDriver();
		chdriver.manage().window().maximize();
		chwait = new WebDriverWait(chdriver, 60);
		chfwait = new FluentWait<WebDriver>(chdriver).pollingEvery(Duration.ofSeconds(5))
				.withMessage("Looking for Logout");

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
