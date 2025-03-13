package com.tvsmotors.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tvsmotors.pageactions.BookingPageActions;
import com.tvsmotors.pageactions.HomePageActions;
import com.tvsmotors.pageactions.SelectVehiclePageActions;
import com.tvsmotors.pageobjects.BookingPage;
import com.tvsmotors.pageobjects.HomePage;
import com.tvsmotors.pageobjects.SelectVehiclePage;

public class BaseTest {
	public WebDriver driver;
	 //HomePage homePage ;
	 //BookingPage bookingPage;
	//SelectVehicle selectVehiclePage;
	
	protected HomePageActions homePageActions;
	protected BookingPageActions bookingPageActions;
	protected SelectVehiclePageActions selectVehiclePageActions;
	 
	
		public void initializePages()
		{
			
		 homePageActions = new HomePageActions(driver);	
		 bookingPageActions = new BookingPageActions(driver);
		 selectVehiclePageActions = new SelectVehiclePageActions(driver);	
			
		}
	
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tvsmotor.com/");
		initializePages();
	}
	
	
	 @AfterMethod
	  public void tearDown()
	  {
       if(driver!=null)//browser is open 
		  {
			  driver.quit();
		  }
	  }

}
