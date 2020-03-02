package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.Browserfactory;
import utilities.ConfigDataProvider;
import utilities.ExcelDataProvider;
import utilities.Helper;

public class Baseclass {
	
	public WebDriver driver;
	public ExcelDataProvider ed;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		
		Reporter.log("Setting up and starting the test", true);
		ed=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCLink_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Test startup completed", true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@BeforeClass
	public void setup()
	{
		//Browserfactory.startApplication(driver,config.getBrowser() ,config.getQAurl());
	}*/
	
	/*@AfterClass
	public void tearDown()
	{
		Browserfactory.quitBrowser(driver);
	}*/
	/*@AfterMethod
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
	}*/
}
