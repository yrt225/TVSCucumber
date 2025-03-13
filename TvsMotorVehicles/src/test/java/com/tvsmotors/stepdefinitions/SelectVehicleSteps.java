package com.tvsmotors.stepdefinitions;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.tvsmotors.utilities.ExcelUtil;
import com.tvsmotors.utilities.JsonUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectVehicleSteps extends BaseSteps {
	
	@When("user selects vehicle model {string}")
	public void user_selects_vehicle_model_drum_sxc(String modelType)
	{

		selectVehiclePageActions.selectVehicleAndProceedToDetails(modelType);
		

}
	

	@When("user enters personal Details for {string}, {string} and {string}")
	public void user_enters_personal_details_for_and(String userName, String dealerName, String oTP) 
	{
		
		JsonNode userData= JsonUtil.getUserDataByUsername(userName);
		String mobileNumber = userData.get("MobileNumber").asText();
		String fullName = userData.get("FullName").asText();
		String emailID = userData.get("EmailID").asText();
		
		JsonNode dealerData= JsonUtil.getDealerDataByDealerName(dealerName);
		String address = dealerData.get("Address").asText();
		
		
		//JsonNode userData = JsonUtil.getDataFromJson("src/main/resources/testdata/json/userDetails.json", "Users" ,"UserName",userName);
		//JsonNode dealerData = JsonUtil.getDataFromJson("src/main/resources/testdata/json/dealerAddress.json", "DealerAddresses", "DealerName", dealerName);
		System.out.println(address+mobileNumber+fullName+emailID+oTP);
        selectVehiclePageActions.submitPersonalDetails(address, mobileNumber, fullName, emailID, oTP);
        
        
        
        /*Map<String, String> userData = ExcelUtil.readUserData(userName);
     
	    
        String mobileNumber = userData.get("MobileNumber");
		String fullName = userData.get("FullName");
		String emailID = userData.get("EmailID");
		
		Map<String, String> dealerData = ExcelUtil.readDeadlerData(dealerName);
		
		String address = dealerData.get("Address");*/
			
				
	}
	
	
	@Then("user gets booking successful message")
	public void user_gets_booking_successful_message()
	{
	System.out.println("Booking not successful");
	}
	
	
	
	

}
