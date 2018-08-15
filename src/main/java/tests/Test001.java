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

public class Test001 extends BaseTest{


	WebDriver driver = DriverFactory.getInstance().driver;


	@Test
	public void bing_test() {
		//logger = BaseTest.extent.createTest("siva_diverTest01");
		logger = BaseTest.extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.assignCategory("Search-Engine-Tests");
		
		driver.get("http://www.bing.com");
		logger.log(Status.INFO, "The title of the page is: " + driver.getTitle());

	}

	@Test
	public void google_test() {
		// logger = extent.createTest("siva_diverTest02");
		logger = BaseTest.extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.assignCategory("Search-Engine-Tests");
		DriverFactory.getInstance().driver.get("http://www.google.com");

		logger.log(Status.INFO, "The title of the page is: " + driver.getTitle());

	}

	@Test
	public void yahoo_test() {
		//logger = BaseTest.extent.createTest("siva_diverTest03");
		logger = BaseTest.extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.assignCategory("Search-Engine-Tests");
		DriverFactory.getInstance().driver.get("http://www.yahoo.com");
		logger.log(Status.INFO, "The title of the page is: " + driver.getTitle());
		
		Assert.assertTrue(false);
	

	}
	
}
