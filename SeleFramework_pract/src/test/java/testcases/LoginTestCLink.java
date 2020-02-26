package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Appointment;
import Pages.Baseclass;
import Pages.LoginPage;
import utilities.Browserfactory;
import utilities.ExcelDataProvider;
import utilities.Helper;

public class LoginTestCLink extends Browserfactory{
	
	
	@Test
	public void LogginAppl() throws Exception
	{
		
		//System.out.println(driver.getTitle());
		logger=report.createTest("Login to CLink");
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("http://uat.culturalinkiq.net/");

		driver.manage().window().maximize();
			
		//js.executeScript("window.scrollBy(0,1000)");
		LoginPage page= PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		page.Loginto(ed.getStringData("Sheet1", 0, 0), ed.getStringData("Sheet1", 0, 1));
		
		logger.fail("Login UnSuccess");
		 

	}

}
