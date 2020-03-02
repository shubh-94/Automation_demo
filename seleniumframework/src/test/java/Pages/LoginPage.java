package Pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	protected static WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(id="email") WebElement emailid;
	@FindBy(id="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement Loginbtn;
	
	public void Loginto(String emailappl,String passwordappl)
	{
		emailid.sendKeys(emailappl);
		password.sendKeys(passwordappl);
		Loginbtn.click();
	}
	
	
	 public void openBrowser(){
		 System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("http://uat.culturalinkiq.net/");

	 }
	 
	 public static String captureScreenshot()
		{ 		
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshotpath=System.getProperty("user.dir")+"/Screenshots/FreeCLink_"+getCurrentDateTime()+".png";
			try
			{
				FileHandler.copy(src, new File(screenshotpath));
				System.out.println("Screenshot captured");
			}
			catch(IOException e)
			{
				System.out.println("Unable to capture Screenshot" +e.getMessage());
			}
			return screenshotpath;
		}
		
		public static String getCurrentDateTime()
		{
			DateFormat custformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			Date currentdate=new Date();
			return custformat.format(currentdate);
		}

}
