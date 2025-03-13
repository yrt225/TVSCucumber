package com.tvsmotors.stepdefinitions;

import io.cucumber.java.en.When;

public class BookingSteps extends BaseSteps 
{
	@When("user selects the vehicle {string}")
	public void user_selects_the_vehicle_tvs_ntorq(String modelName)
	{

bookingPageActions.verifySelectAVehicle();
bookingPageActions.selectVehicle(modelName);
		
	}
	

}
