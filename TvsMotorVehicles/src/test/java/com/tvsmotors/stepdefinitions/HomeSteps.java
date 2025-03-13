package com.tvsmotors.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.tvsmotors.pageactions.HomePageActions;

import io.cucumber.java.en.Given;

public class HomeSteps extends BaseSteps {
	
	WebDriver driver;
	
	@Given("User navigates to the Booking Page")
	public void user_navigates_to_the_booking_page()
	{
	    
	    homePageActions.clickBooking();

		
	}
	
	

}
