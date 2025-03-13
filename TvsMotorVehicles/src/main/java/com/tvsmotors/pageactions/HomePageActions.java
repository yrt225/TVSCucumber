package com.tvsmotors.pageactions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tvsmotors.pageobjects.HomePage;
import com.tvsmotors.utilities.WebElemetUIHelper;

public class HomePageActions {
	
	
	HomePage homePage;
	WebElemetUIHelper webElemetUIHelper;

	public HomePageActions(WebDriver driver) {
		
		
		this.homePage = new HomePage(driver);		
		this.webElemetUIHelper = new WebElemetUIHelper(driver);
	}


	public void clickBooking()
	{

		
		webElemetUIHelper.clickWithImplicitWait(homePage.getBuyVehicle());
		
	
				
		//booking.click();
		//WaitUtil waitUtil = new WaitUtil();
		//waitUtil.implicitlyWait(driver, 5);
		
	
		
	}

}
