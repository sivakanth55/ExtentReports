package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.io.FileUtils;

public class ExtentManager {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	WebDriver driver = DriverFactory.getInstance().driver;

	//@BeforeTest
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Report/executionReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SIPOTLUR-IN");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Sivakanth");

		htmlReporter.config().setDocumentTitle("FABS-AUTOMATION");
		htmlReporter.config().setReportName("AUTOMATION-RESULTS");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	

	// @Test
	public void passTest() {
		logger = extent.createTest("passTest");
		Assert.assertTrue(true);

		logger.log(Status.PASS, "User login is sucess");

		// logger.log(Status.PASS, MarkupHelper.createLabel("Test Case is
		// Passed", ExtentColor.GREEN));
	}

	// @Test
	public void failTest() {
		logger = extent.createTest("failTest");
		DriverFactory.getInstance().driver.get("http://www.yahoo.com");
		System.out.println(driver.getTitle());

		Assert.assertTrue(false);
		// logger.log(Status.PASS, "Test Case (failTest) Status is passed");
		// logger.log(Status.PASS, MarkupHelper.createLabel("Test Case
		// (failTest) Status is passed", ExtentColor.RED));
	}

	// @Test
	public void skipTest() {
		logger = extent.createTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}



	

}
