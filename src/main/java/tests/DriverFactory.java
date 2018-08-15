package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	public static WebDriver driver;
	public static DriverFactory driverInstance = null;
	public static String browserType = "chrome";

		
    private DriverFactory()
    {
    	if (browserType.equals("chrome")) {

			try {

				String driverPath = System.getProperty("user.dir") + "/drivers";
				
				//download and copy the chromedriver.exe in drivers folder
				System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
				
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				try {
					driver.manage().window().maximize();
				} catch (Exception e) {
					System.out.println("This browser version is not supporting Window Maximize in WebDriver");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

    }
 
    // static method to create instance of Singleton class
    public static DriverFactory getInstance()
    {
        if (driverInstance == null)
        {
        	driverInstance = new DriverFactory();
        }
        
        return driverInstance;
    }
    

	
}
