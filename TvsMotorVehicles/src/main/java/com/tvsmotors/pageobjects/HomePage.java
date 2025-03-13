package com.tvsmotors.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tvsmotors.utilities.WaitUtil;
import com.tvsmotors.utilities.WebElemetUIHelper;

public class HomePage  {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href='https://www.tvsmotor.com/book-online']")
	private WebElement buyVehicle;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBuyVehicle() {
		return buyVehicle;
	}

	public void setBuyVehicle(WebElement buyVehicle) {
		this.buyVehicle = buyVehicle;
	}
	
	
	
	
	
	

}
