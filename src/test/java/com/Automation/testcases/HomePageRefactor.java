package com.Automation.testcases;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MobileAutomation.base.TestBase;
import com.MobileAutomation.pages.HomePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HomePageRefactor extends TestBase {
	
	AppiumDriver driver;
	HomePage objHomePage;
	
	
	

	public HomePageRefactor() throws IOException {
		super();
		// TODO Auto-generated constructor 
	}

	public AndroidDriver mobileDriver;

	@BeforeMethod
	public void initialize() {
		mobileDriver = initializeDriver();
	}

	@Test(description = "To view the Dashboard and select the Vehicle")

	public void HomePage() throws IOException, InterruptedException {
		
		objHomePage = new HomePage(mobileDriver);
		objHomePage.selectVehicle();		

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		this.mobileDriver.quit();
	}
}
