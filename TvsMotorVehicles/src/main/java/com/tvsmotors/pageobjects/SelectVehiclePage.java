package com.tvsmotors.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tvsmotors.utilities.WebElemetUIHelper;

public class SelectVehiclePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement nextButton;
	
	@FindBy(name="pincode")
	private WebElement pincodeLocationDD;
	
	@FindBy(xpath="//div[@class='location-suggestion-container']/div[@class='location-suggestion-item']/div[1]")
	private WebElement pincodeLocationValue;
	
	@FindBy(name="mobile")
	private WebElement mobileNumber;
	
	@FindBy(name="updates")
	private WebElement updatesCheckBox;
	
	@FindBy(name="name")
	private WebElement fullName;
	
	@FindBy(name="email")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@id='checkbox-input-privacy']")
	private WebElement termsAndConditions;
	
	@FindBy(xpath="//button[text()='Verify Mobile Number']")
	private WebElement verifyMobileNumberBTN;
	
	@FindBy(xpath="//div[@class='mb-2 otp-wrapper d-flex']/input")
	private List<WebElement> OTPFields;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;
	
	public SelectVehiclePage(WebDriver driver)
	{
		
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this );
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public void setNextButton(WebElement nextButton) {
		this.nextButton = nextButton;
	}

	public WebElement getPincodeLocationDD() {
		return pincodeLocationDD;
	}

	public void setPincodeLocationDD(WebElement pincodeLocationDD) {
		this.pincodeLocationDD = pincodeLocationDD;
	}

	public WebElement getPincodeLocationValue() {
		return pincodeLocationValue;
	}

	public void setPincodeLocationValue(WebElement pincodeLocationValue) {
		this.pincodeLocationValue = pincodeLocationValue;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(WebElement mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public WebElement getUpdatesCheckBox() {
		return updatesCheckBox;
	}

	public void setUpdatesCheckBox(WebElement updatesCheckBox) {
		this.updatesCheckBox = updatesCheckBox;
	}

	public WebElement getFullName() {
		return fullName;
	}

	public void setFullName(WebElement fullName) {
		this.fullName = fullName;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public void setEmailId(WebElement emailId) {
		this.emailId = emailId;
	}

	public WebElement getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(WebElement termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public WebElement getVerifyMobileNumberBTN() {
		return verifyMobileNumberBTN;
	}

	public void setVerifyMobileNumberBTN(WebElement verifyMobileNumberBTN) {
		this.verifyMobileNumberBTN = verifyMobileNumberBTN;
	}

	public List<WebElement> getOTPFields() {
		return OTPFields;
	}

	public void setOTPFields(List<WebElement> oTPFields) {
		OTPFields = oTPFields;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}
	
	public WebElement getModelTypeElement(String modelType)
	{
		By modelTypeLocator =By.xpath("//a[text()='"+modelType+"']");
	    return wait.until(ExpectedConditions.presenceOfElementLocated(modelTypeLocator));
	}
	
	

	
	
	
	
	
	
	

}
