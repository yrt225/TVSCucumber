package com.tvsmotors.pageobjects;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;

import com.tvsmotors.utilities.WaitUtil;
import com.tvsmotors.utilities.WebElemetUIHelper;

public class BookingPage  {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//h1[text()='Select a Vehicle']")
	private WebElement selectAVehicle;
	
	public BookingPage(WebDriver driver) 
	{
		
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectAVehicle() {
		return selectAVehicle;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setSelectAVehicle(WebElement selectAVehicle) {
		this.selectAVehicle = selectAVehicle;
	}
	
	public WebElement getModelNameElement(String modelName)
	{
		
	By modelNameLocator = By.xpath("(//div[@class='card-body']/div[text()='"+modelName+"'])[1]");
	
	return  wait.until(ExpectedConditions.presenceOfElementLocated(modelNameLocator));
   
	
	
	
	}

}
