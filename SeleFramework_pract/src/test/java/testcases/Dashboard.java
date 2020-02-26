package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Appointment;
import Pages.Baseclass;
import Pages.LoginPage;
import utilities.Browserfactory;
import utilities.Helper;

public class Dashboard extends Browserfactory
{

	
	@Test
	public void Appointments() throws Exception
	{
		
	    //logger=report.createTest("New Appointment");
		Appointment apt= PageFactory.initElements(driver, Appointment.class);
		Thread.sleep(20000);
		//Helper.captureScreenshot();
		
		apt.AppointmentType();
		Helper.captureScreenshot();
		apt.AppointmentDetails();
		//Thread.sleep(5000);	
		Helper.captureScreenshot();
		apt.Selectdate();
	    Helper.captureScreenshot();
	    //Appointment.captureScreenshot();
	    apt.patient_information();

	}
	
}
