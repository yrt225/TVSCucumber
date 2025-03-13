package com.tvsmotors.runner;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.tvsmotors.stepdefinitions"},
        tags = "@BookingTVSJupiter2",  
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)

public class TestRunner2 extends AbstractTestNGCucumberTests {

	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}

}
