package com.tvsmotors.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tvsmotors.pageobjects.SelectVehiclePage;
import com.tvsmotors.utilities.WebElemetUIHelper;

public class SelectVehiclePageActions {
	
	SelectVehiclePage selectVehiclePage;
	WebElemetUIHelper webElemetUIHelper;
	
	public SelectVehiclePageActions(WebDriver driver) {
		
		this.selectVehiclePage = new SelectVehiclePage(driver);
		this.webElemetUIHelper = new WebElemetUIHelper(driver);
	}

	public void selectVehicleType(String modelType)
	{
		
			    
		webElemetUIHelper.click(selectVehiclePage.getModelTypeElement(modelType));
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.elementToBeClickable(modelTypeLocator));
		 * driver.findElement(modelTypeLocator).click();
		 */
		
	}
	
	public void navigateToSubmitDetailsPage()	
	{
		
		
		webElemetUIHelper.click(selectVehiclePage.getNextButton());
		
		//nextButton.click();
		
		
	}
	
	public void selectPincodeLocation(String pinCodeLocation)
	{
		
	
		webElemetUIHelper.selectAValueFromDropDown(selectVehiclePage.getPincodeLocationDD(), selectVehiclePage.getPincodeLocationValue(), pinCodeLocation);
		
		/*
		 * pincodeLocationDD.click(); pincodeLocationDD.sendKeys(pinCodeLocation); try {
		 * Thread.sleep(4000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } pincodeLocationValue.click()
		 */;
		
	}
	
	public void enterPersonalDetails(String mobileNumber , String fullName , String emailId)
	{
		
		
		webElemetUIHelper.enterText(selectVehiclePage.getMobileNumber(), mobileNumber);
		webElemetUIHelper.click(selectVehiclePage.getUpdatesCheckBox());
		webElemetUIHelper.enterText(selectVehiclePage.getFullName(), fullName);
		webElemetUIHelper.enterText(selectVehiclePage.getEmailId(), emailId);
		
		//this.mobileNumber.sendKeys(mobileNumber);
		//updatesCheckBox.click();
		//this.fullName.sendKeys(fullName);
		//this.emailId.sendKeys(emailId);
		
		
	}
	
	public void verifyMobileNumber()
	{
		
		webElemetUIHelper.click(selectVehiclePage.getTermsAndConditions());
		webElemetUIHelper.click(selectVehiclePage.getVerifyMobileNumberBTN());
		
		/*
		 * termsAndConditions.click(); verifyMobileNumberBTN.click();
		 */
	}
	
	public void submitOTP(String OTP)
	{
		
		/*char[] OTPArray = OTP.toCharArray();
		
		for(int i=0;i<OTPArray.length;i++)
		{
			OTPFields.get(i).sendKeys(String.valueOf(OTPArray[i]));
		}
		*/
		for(int i=0;i<OTP.length();i++)
		{
			selectVehiclePage.getOTPFields().get(i).sendKeys(String.valueOf(OTP.charAt(i)));		
			
		}
		
		
		webElemetUIHelper.click(selectVehiclePage.getSubmitButton());
		
		//submitButton.click();
		
		
	}
	public void selectVehicleAndProceedToDetails(String modelType)
	{
		
		selectVehicleType(modelType);
		navigateToSubmitDetailsPage();
		
	}
	public void submitPersonalDetails(String pinCodeLocation, String mobileNumber , String fullName , String emailId,String OTP)
	{
		
		selectPincodeLocation(pinCodeLocation);
		enterPersonalDetails(mobileNumber , fullName , emailId);
		verifyMobileNumber();
		submitOTP(OTP);
		
		
		
	}

}
