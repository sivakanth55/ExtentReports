package tests;

import java.io.File;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {

	public static String browserType = "chrome";

	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest logger;

	@BeforeSuite
	public void reportBegin() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-Report/executionReport.html");

		System.out
				.println("report location is: " + System.getProperty("user.dir") + "/test-Report/executionReport.html");
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

	@AfterSuite
	public void reportEnd() {
		System.out.println("@AfterSuite - Closure");
		extent.flush();

	}

	@AfterMethod
	public static void getTestResult(ITestResult result) throws Exception {

		System.out.println("@AfterMethod");

		if (result.getStatus() == ITestResult.FAILURE) {
			// logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			// MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			String screenshotPath = getScreenshotPath(DriverFactory.getInstance().driver, result.getName());
			System.out.println(" screenshotPath is : " + screenshotPath);
			logger.fail(result.getThrowable());
			logger.fail("Snapshot is attached below: " + logger.addScreenCaptureFromPath(screenshotPath));
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
			MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}

		else {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}

	}

	// Creating a method getScreenshot and passing two parameters
	// driver and screenshotName are the input parameters
	public static String getScreenshotPath(WebDriver driver, String screenshotName) throws Exception {

		System.out.println("The driver value inside getScreenshotPath is " + driver);
		System.out.println("The driver Instance is " + DriverFactory.getInstance().driver);

		// below line is just to append the date format with the screenshot name
		// to avoid duplicate names
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);

		// String destination = System.getProperty("user.dir") +
		// 
		String destination = System.getProperty("user.dir") + "/test-Report/Screenshots/" + screenshotName + dateName + ".png";

		System.out.println("printing the screenshot destimation path >>> " + destination);

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		
		// Returns the captured file path
		return destination;
	}

}
