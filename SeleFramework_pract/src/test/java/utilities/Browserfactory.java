package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Browserfactory {
	
	protected static WebDriver driver;
	public ExcelDataProvider ed;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	public static WebDriver startApplication()
	
	{
		String browsername="Chrome";
		String appURL="http://uat.culturalinkiq.net/";
		if(browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		else if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","./IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support these browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}


	@BeforeSuite
	public void setupSuite()
	{
		
		Reporter.log("Setting up and starting the test", true);
		ed=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Test startup completed", true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot()).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot()).build());

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot()).build());

		}
		report.flush();
	}

	public static void quitBrowser(WebDriver driver){
		driver.quit();
	}
}
