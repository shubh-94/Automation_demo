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
	}

	@FindBy(xpath="//*[@id='root']/div[2]/section/section/ul/li[6]/div/span") WebElement Appointments;
	@FindBy(xpath="//*[@id='/appointments$Menu']/li[1]") WebElement newapt;
	@FindBy(xpath="//*[@id='container']/div[3]/button") WebElement NextButton;
	@FindBy(xpath="//*[@id='form']/div[1]/div/div/span[1]") WebElement Region;
	@FindBy(xpath="//*[@id='form']/div[2]/div/div[1]/span[1]") WebElement Facility;
	@FindBy(xpath="//div[@id='form']/div[3]/div/div/div") WebElement Address;
	@FindBy(xpath="//div[@id='form']/div[3]/div/div/div") WebElement Department;
	@FindBy(xpath="//div[@id='form']/div[5]/div/div/input") WebElement ProviderName;
	@FindBy(xpath="//div[@id='form']/div[6]/div/div/input") WebElement ProviderContact;
	@FindBy(xpath="//*[@id='container']/div[3]/button[2]") WebElement NextButton1; 
	@FindBy(xpath="//*[@id='appointmentDetailForm']/div[1]/div/div[1]/span[1]") WebElement Language;
	@FindBy(xpath="//div[@id='appointmentDetailForm']/div[2]/div/div/span/span[2]") WebElement Calendar;
	@FindBy(xpath="//div[@id='appointmentDetailForm']/div[2]/div/div/span/span[3]") WebElement AppointmentTime;
	@FindBy(id="duration") WebElement Duration;
	@FindBy(xpath="//div[@id='appointmentDetailForm']/div[6]/div/div/span") WebElement interpreterRequested;
	@FindBy(id="meetingPoint") WebElement MeetingPoint;
	@FindBy(xpath="//*[@id='container']/div[3]/button[2]") WebElement nextButton;
	@FindBy(xpath="//div[@id='patientForm']/div/div[2]/div/div/span/span") WebElement PatientIdtype;
	@FindBy(id="value1") WebElement Patientid;
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
		   // driver.findElement(By.xpath("//ul[@id='ddlelement_options']/li")).click();
		    Thread.sleep(3000);
		    WebElement regionname= driver.findElement(By.xpath("//ul[@id='ddlelement_options']/li"));
		    regionname.click();
		    String reg= regionname.getText();
		    System.out.println("Region is : "+reg);		    
		    Thread.sleep(3000);
		    		    		  
		    Facility.click();
		    Thread.sleep(3000);
		    WebElement facilityName= driver.findElement(By.xpath("//ul[@id='ddlelement_options']/li"));
		    facilityName.click();
		    String fac= facilityName.getText();
		    System.out.println("Facility is : "+fac);
		    Thread.sleep(3000);
		    
		    Address.click();
		    Thread.sleep(2000);
		    WebElement addressdetails= driver.findElement(By.xpath("//div[@id='form']/div[3]/div/div/div"));
		    addressdetails.click();
		    String add= addressdetails.getText();
		    System.out.println("Address details is : "+add);
		    Thread.sleep(2000);		    
		    
		    js.executeScript("window.scrollBy(0,1500)");
		    
		    Department.click();
		    /*WebElement departmentName= driver.findElement(By.xpath("//div[@id='form']/div[3]/div/div/div"));
		    departmentName.click();
		    String dept= departmentName.getText();
		    System.out.println("Address details is:" +dept);*/
		    Thread.sleep(2000);	
		    
		    ProviderName.click();
		    WebElement providerName= driver.findElement(By.xpath("//div[@id='form']/div[5]/div/div/input"));	
		    providerName.sendKeys("Jenny Baren");
		    String provN=providerName.getAttribute("value");
		    System.out.println("Provider Name is : "+provN);		  		    
		    Thread.sleep(2000);
		    
		    ProviderContact.click();
		    WebElement ProviderContact= driver.findElement(By.xpath("//div[@id='form']/div[6]/div/div/input"));
		    ProviderContact.sendKeys("240 356 4567");
		    String provC=ProviderContact.getAttribute("value");		    
		    System.out.println("Provider Contact is : "+provC);		   
		    Thread.sleep(2000);	    
		    
		    NextButton1.click();
		    Thread.sleep(3000);

	}	
	
	public void AppointmentDetails() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1500)");
		
		Language.click();
		WebElement Lang= driver.findElement(By.xpath("//ul[@id='language_options']/li[2]"));
	    Lang.click();
	    String lang= Lang.getText();
	    System.out.println("Selected Language is : "+lang);
	    Thread.sleep(2000);	
	}
	
	public void Selectdate() throws InterruptedException
	{
		//Calendar.click();
		Calendar.click();		
		WebElement Date= driver.findElement(By.xpath("//tr[5]/td[7]/span"));
		Date.click();
		/*String date= Date.getText();
		System.out.println("Selected Date is : "+date);*/
		Thread.sleep(2000);
		
		//AppointmentTime.click();
		/*AppointmentTime.click();
		WebElement Time= driver.findElement(By.xpath("//ul[@id='startTime_options']/li[13]"));
		Time.click();*/
		/*String time= Time.getText();
		System.out.println("Selected Time is : "+time);
		Thread.sleep(2000);*/
		
		//Duration.click();	
		Duration.sendKeys("30");
		WebElement duration= driver.findElement(By.xpath("//div[@id='form']/div[6]/div/div/input"));
		//duration.sendKeys("30");
		String durat=duration.getAttribute("value");		    
		System.out.println("Appointment duration is : "+durat);			
		Thread.sleep(2000);		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(6000);

		/*interpreterRequested.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='interpreter_options']/li[2]")).click(); 		
		Thread.sleep(2000);
        */	
		MeetingPoint.sendKeys("Recep-10");	
		WebElement meetingPoint= driver.findElement(By.xpath("//div[@id='appointmentDetailForm']/div[7]/div/div/input"));
		//meetingPoint.sendKeys("Recep-10");
		String meet= meetingPoint.getAttribute("value");
		System.out.println("Meeting point is : "+meet);
		Thread.sleep(2000);
		
		nextButton.click();
		js.executeScript("window.scrollBy(0,-1500)");
			
		}
			
	public void patient_information() throws InterruptedException
	{
		PatientIdtype.click();
		//Thread.sleep(2000);
		WebElement patientidtype=driver.findElement(By.xpath("//li[contains(.,'Medicaid')]"));
		patientidtype.click();
		String PidT= patientidtype.getText();
		System.out.println("Patient id type is : "+PidT);
			
		Patientid.click();
		WebElement patientid=driver.findElement(By.xpath("//li[contains(.,'Medicaid')]"));
		patientid.sendKeys("MID-20");
		String pID= patientid.getAttribute("value");
		System.out.println("Patient id is : "+pID);
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




/*String month="February 2020";
String day="1";

while(true)
{
	String text=driver.findElement(By.xpath("//div[@id='startTime_datepopup']/div/div[3]/button")).getText();
	if(text.equals(month))
	{
		break;
	}
	else
	{
*/

