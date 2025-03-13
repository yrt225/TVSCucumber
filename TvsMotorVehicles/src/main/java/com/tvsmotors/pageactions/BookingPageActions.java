package com.tvsmotors.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tvsmotors.pageobjects.BookingPage;
import com.tvsmotors.utilities.WebElemetUIHelper;

public class BookingPageActions {
	
	BookingPage bookingPage;
	WebElemetUIHelper webElemetUIHelper;
	
	public BookingPageActions(WebDriver driver)
	{
		this.bookingPage = new BookingPage(driver);
	    this.webElemetUIHelper = new WebElemetUIHelper(driver);

	}
	
	public void verifySelectAVehicle()
	{

		webElemetUIHelper.assertThePresenceOfElement(bookingPage.getSelectAVehicle());
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.visibilityOf(selectAVehicle)); boolean
		 * isSelectAVehicleDisplayed = selectAVehicle.isDisplayed();
		 * Assert.assertEquals(isSelectAVehicleDisplayed, true);
		 */

	}
	
	public void selectVehicle(String modelName) 
	{
		
		webElemetUIHelper.click(bookingPage.getModelNameElement(modelName));
		
		/*WaitUtil waitUtil = new WaitUtil();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(modelNameElement));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,1200)");
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        modelNameElement.click();*/
	}


}
