package com.tvsmotors.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tvsmotors.pageobjects.BookingPage;
import com.tvsmotors.pageobjects.HomePage;
import com.tvsmotors.pageobjects.SelectVehiclePage;

public class RegistrationTest extends BaseTest{
	
	public WebDriver driver;
	
    HomePage homePage ;
    BookingPage bookingPage;
	
	@BeforeMethod
	public void initializePages()
	{
		
		homePage = new HomePage(driver);	
		bookingPage = new BookingPage(driver);
		
		
	}
	
  @Test
  public void bookAVehicleTest() 
  {
	  
	  
	  //homePage.clickBooking();
	  
	 // bookingPage.verifySelectAVehicle();
	  
	 // bookingPage.selectVehicle("TVS Jupiter");
	  
	//  SelectVehiclePage selectVehiclePage = new SelectVehiclePage(driver);
	 // selectVehiclePage.selectVehicleAndProceedToDetails("DRUM SXC");
	//  selectVehiclePage.submitPersonalDetails("560045-", "7204780642", "Faisal Ahmed", "faisalextentia@gmail.com", "1234");
	 
			  
	  
  }
  
 
  
}
