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

public class BookingTest extends BaseTest{
	
	

	
  @Test
  public void bookAVehicleTest() 
  {
	  
	  
	  homePageActions.clickBooking();
	  
	  bookingPageActions.verifySelectAVehicle();
	  
	  bookingPageActions.selectVehicle("TVS Jupiter");

	  selectVehiclePageActions.selectVehicleAndProceedToDetails("DRUM SXC");
	  selectVehiclePageActions.submitPersonalDetails("560045-", "7204780642", "Faisal Ahmed", "faisalextentia@gmail.com", "1234");
	 
			  
	  
  }
  
 
  
}
