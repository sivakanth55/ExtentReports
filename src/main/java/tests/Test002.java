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

public class Test002 extends BaseTest{


	WebDriver driver = DriverFactory.getInstance().driver;

	
	@Test
	public void flipkart_test() {
		//logger = BaseTest.extent.createTest("siva_diverTest01");
		logger = BaseTest.extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.assignCategory("Online-Shopping-Tests");

		driver.get("http://www.flipkart.com");
		logger.log(Status.INFO, "The title of the page is: " + driver.getTitle());

	}

	@Test
	public void jabong_test() {
		// logger = extent.createTest("siva_diverTest02");
		logger = BaseTest.extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.assignCategory("Online-Shopping-Tests");
		DriverFactory.getInstance().driver.get("http://www.jabong.com");
		logger.log(Status.INFO, "The title of the page is: " + driver.getTitle());

	}

	@Test
	public void myntra_test() {
		logger = BaseTest.extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.assignCategory("Online-Shopping-Tests");
		DriverFactory.getInstance().driver.get("http://www.myntra.com");
		logger.log(Status.INFO, "The title of the page is: " + driver.getTitle());
		Assert.assertTrue(false);
	

	}
	
}
