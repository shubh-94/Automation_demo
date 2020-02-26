package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import Pages.LoginPage;

public class Helper extends LoginPage{

	public Helper(WebDriver ldriver) {
		super(ldriver);
		// TODO Auto-generated constructor stub
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
	/*
	public void handlealerts()
	{
		
	}*/
}
