package com.tvsmotors.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.tvsmotors.pageactions.BookingPageActions;
import com.tvsmotors.pageactions.HomePageActions;
import com.tvsmotors.pageactions.SelectVehiclePageActions;
import com.tvsmotors.utilities.ConfigUtil;
import com.tvsmotors.utilities.DriverFactoryUtility;
import com.tvsmotors.utilities.ExtentManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseSteps {
	
	public WebDriver driver;
	
	protected HomePageActions homePageActions;
	protected BookingPageActions bookingPageActions;
	protected SelectVehiclePageActions selectVehiclePageActions;
	
	public BaseSteps()
	{
	//	String browser = ConfigUtil.getProperty("browser");
		String browser = ConfigUtil.getBrowser();
		this.driver = DriverFactoryUtility.getDriver(browser);
		initializePages();
		//ExtentManager.getExtentReport().createTest(io.cucumber.java.Scenario.
		
	}
	
	
	
	public void initializePages()
	{
		homePageActions = new HomePageActions(driver);
		bookingPageActions = new BookingPageActions(driver);
		selectVehiclePageActions = new SelectVehiclePageActions(driver);

	}
	
	
}
