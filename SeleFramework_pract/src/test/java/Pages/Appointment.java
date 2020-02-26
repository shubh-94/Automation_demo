package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.Browserfactory;

public class Appointment extends LoginPage{
		
	public Appointment(WebDriver ldriver) {
		super(ldriver);
		// TODO Auto-generated constructor stub
	}
	/*public Appointment(WebDriver ldriver) {
		super(ldriver);
	}
   */

	@FindBy(xpath="//*[@id='root']/div[2]/section/section/ul/li[6]/div/span") WebElement Appointments;
	@FindBy(xpath="//*[@id='/appointments$Menu']/li[1]") WebElement newapt;
	@FindBy(xpath="//*[@id='container']/div[3]/button") WebElement NextButton;
	@FindBy(xpath="//*[@id='form']/div[1]/div/div/span[1]") WebElement Region;
	@FindBy(xpath="//*[@id='form']/div[2]/div/div[1]/span[1]") WebElement Facility;
	@FindBy(xpath="//*[@id='container']/div[3]/button[2]") WebElement NextButton1; 
	@FindBy(xpath="//*[@id='appointmentDetailForm']/div[1]/div/div[1]/span[1]") WebElement Language;
	@FindBy(xpath="//div[@id='appointmentDetailForm']/div[2]/div/div/span/span[2]") WebElement Calendar;
	
	public void AppointmentType() throws InterruptedException
	{
			Actions action=new Actions(driver);
			action.moveToElement(Appointments).build().perform(); 
			Thread.sleep(2000);
			newapt.click();
			Thread.sleep(7000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", NextButton);
		    NextButton.click();
		    Thread.sleep(5000);
		    js.executeScript("window.scrollBy(0,-1500)");
		    Region.click();
		    
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//ul[@id='ddlelement_options']/li")).click();
		  
		    Facility.click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//ul[@id='ddlelement_options']/li")).click();
		    
		    js.executeScript("window.scrollBy(0,1500)");
		    NextButton1.click();
	}	
	
	public void AppointmentDetails()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1500)");
		Language.click();
		driver.findElement(By.xpath("//ul[@id='language_options']/li[3]")).click();
		Calendar.click();
	}
	
	public void Selectdate()
	{
		
	}

}
