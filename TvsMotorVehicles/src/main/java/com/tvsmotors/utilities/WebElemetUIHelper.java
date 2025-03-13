package com.tvsmotors.utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebElemetUIHelper {
	
	WebDriver driver;
	WaitUtil waitUtil;
	
	public WebElemetUIHelper(WebDriver driver) 
	{
		this.driver=driver;
		this.waitUtil= new WaitUtil(driver);
		
	}
	
	public void clickWithImplicitWait(WebElement element)
	{
		String waitTime =ConfigUtil.getProperty("implicitWait");
		int wait = Integer.parseInt(waitTime);
		waitUtil.implicitlyWait(driver,wait);
		element.click();
		
	}
	
	public void assertThePresenceOfElement(WebElement element)
	{
		waitUtil.explicitWait(driver, ExpectedConditions.visibilityOf(element), 30);
		Assert.assertEquals(element.isDisplayed(), true);
		
		
	}
	public void click(WebElement element)
	{
		
		waitUtil.explicitWait(driver , ExpectedConditions.elementToBeClickable(element), 30);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String scrollElementIntoMiddle = "window.scrollBy(0, arguments[0].getBoundingClientRect().top - window.innerHeight / 2);";
		js.executeScript(scrollElementIntoMiddle, element);
		waitUtil.waitForSeconds(2);
		element.click();
		waitTillPageInReadyState();
		
		ExtentManager.getTest().log(Status.INFO, "Clicked on Element:"+element);
		
		//ExtentTest test = ExtentManager.getTest();
		//test.log(Status.INFO, "Clicked on:"+ element);
		
		//js.executeScript("window.scroll(0,1200)")
	}
	public void selectAValueFromDropDown(WebElement elementDD, WebElement elementValue, String value ) 
	{
		
		elementDD.click();
		elementDD.sendKeys(value);	
		waitUtil.waitForSeconds(4);
        elementValue.click();
        waitUtil.waitForSeconds(4);
		
	}
	
	public void enterText(WebElement element,String input)
	{
		waitUtil.explicitWait(driver , ExpectedConditions.elementToBeClickable(element), 30);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scroll(0,1200)");
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		element.sendKeys(input);
		ExtentManager.getTest().log(Status.INFO, "Entered the Element:"+element+"with the vlaue"+ input);
		
		//ExtentTest test = ExtentManager.getTest();
		//test.log(Status.INFO, "Text is entered"+ element);
		
		
	}
	
	

	public void waitTillPageInReadyState()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));

		// Custom ExpectedCondition that checks if the page is completely loaded
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() 
		{
			public Boolean apply(WebDriver driver) 
			{
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				return js.executeScript("return document.readyState").equals("complete");
			}
		};
		
		wait.until(pageLoadCondition);
		System.out.println("Page loaded successfully.");
	}
	
	
	

}
