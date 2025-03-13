package com.tvsmotors.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;
import com.tvsmotors.utilities.ConfigUtil;
import com.tvsmotors.utilities.DriverFactoryUtility;
import com.tvsmotors.utilities.ExtentManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	WebDriver driver;
	
	@Before
	public void setUp(Scenario scenario)
	{
		//String requiredBrowser = ConfigUtil.getProperty("browser");
		String requiredBrowser = ConfigUtil.getBrowser();
		driver =DriverFactoryUtility.getDriver(requiredBrowser);
		String baseUrl = ConfigUtil.getProperty("baseURL");
        driver.get(baseUrl);
        ExtentManager.createTest(scenario.getName());
        ExtentManager.getTest().log(Status.INFO, "Starting Scenario:"+scenario.getName());

	}
	
	@After
	public  void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed-Screenshot");
			ExtentManager.getTest().log(Status.FAIL, "Scenario-failed:"+scenario.getName());
			ExtentManager.getTest().addScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64));
		}
		else
		{
			ExtentManager.getTest().log(Status.PASS, "Scenario-Passed:"+scenario.getName());
		}
		if(driver!=null)
		{
			
			driver.quit();
			
		}
		
		ExtentManager.flushReport();
		
		
	}

}
