package com.tvsmotors.utilities;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	WebDriver driver;
	
	public WaitUtil(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	
	public void waitForMilliSeconds(long milliSeconds)
	{
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void waitForSeconds(long milliSeconds)
	{
		waitForMilliSeconds(milliSeconds*1000);
		
	}
	
	public void implicitlyWait(WebDriver driver, long waitTime)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		
		
	}
	
	/*public void explicitWait(WebDriver driver, long waitTime , ExpectedCondition<T> expCondition )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	    wait.until(expCondition
		
		
	}*/
	
	
	public void explicitWait(WebDriver driver, ExpectedCondition<?> expCondition, long waitTime) {
        for (int i = 1; i < 4; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
                wait.until(
                        refreshed(expCondition));
                return;
            } catch (WebDriverException wde) {
            	waitForMilliSeconds(2);
            }
        }
        throw new RuntimeException("Webdriver exception failed more than 3 times");
    }

    /**
     * Catches and handles StaleElementReference and UnhandledAlertExceptions to allow wait to continue
     *
     * @param expCondition Expected condition
     * @return ExpectedCondition
     */
    private <T> ExpectedCondition<T> refreshed(final ExpectedCondition<T> expCondition) {
        return new ExpectedCondition<T>() {
            @Override
            public T apply(WebDriver webDriver) {
                try {
                    return expCondition.apply(webDriver);
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return String.format("%s", expCondition);
            }
        };
    }

}
