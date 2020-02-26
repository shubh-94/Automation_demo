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
	@FindBy(xpath="//div[@id='appointmentDetailForm']/div[2]/div/div/span/span[3]") WebElement AppointmentTime;
	@FindBy(id="duration") WebElement duration;
	@FindBy(xpath="//div[@id='appointmentDetailForm']/div[6]/div/div/span") WebElement interpreterRequested;
	@FindBy(id="meetingPoint") WebElement meetingPoint;
	@FindBy(xpath="//*[@id='container']/div[3]/button[2]") WebElement nextButton;
	@FindBy(xpath="//div[@id='patientForm']/div/div[2]/div/div/span/span") WebElement patientIdtype;
	@FindBy(id="value1") WebElement patientid;
	@FindBy(xpath="//*[@id='container']/div[3]/button[2]") WebElement submit;
	
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
		    Thread.sleep(3000);
		    
		    js.executeScript("window.scrollBy(0,1500)");
		    NextButton1.click();
		    Thread.sleep(3000);

	}	
	
	public void AppointmentDetails()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1500)");
		Language.click();
		driver.findElement(By.xpath("//ul[@id='language_options']/li[3]")).click();
		
	}
	
	public void Selectdate() throws InterruptedException
	{
		String month="February 2020";
		String day="1";
		Calendar.click();
		Thread.sleep(2000);
		/*while(true)
		{
			String text=driver.findElement(By.xpath("//div[@id='startTime_datepopup']/div/div[3]/button")).getText();
			if(text.equals(month))
			{
				break;
			}
			else
			{
		*/		
		driver.findElement(By.xpath("//tr[5]/td[5]/span")).click();
		AppointmentTime.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='startTime_options']/li[18]")).click();
		duration.sendKeys("30");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(6000);

		interpreterRequested.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='interpreter_options']/li[2]")).click(); 		Thread.sleep(2000);

		meetingPoint.sendKeys("ODI-01");
		
		nextButton.click();
		js.executeScript("window.scrollBy(0,-1500)");
		
		
		}
			
	public void patient_information() throws InterruptedException
	{
		patientIdtype.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Medicaid')]")).click();
		patientid.sendKeys("MID_25");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		driver.findElement(By.xpath("//*[@id='container']/div[3]/button[2]")).click();
		js.executeScript("window.scrollBy(0,-1500)");
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		submit.click();
	}
	}

