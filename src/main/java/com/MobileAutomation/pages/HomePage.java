package com.MobileAutomation.pages;


import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.MobileAutomation.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase {
	    // Other code remains unchanged
	public AndroidDriver mobileDriver;

    

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"NEX.iO - BLE\"]")
	@CacheLookup
	WebElement viewNEX;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"NEX.iO - BLE\"]")
    @CacheLookup
	WebElement Vehicle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    @CacheLookup
	WebElement Submit;
	

    // Add other elements here using correct resource IDs or other locators

	public HomePage(AndroidDriver mobileDriver) throws IOException {
        super();
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public void selectVehicle() throws InterruptedException {
			try {
				viewNEX.click();
				Vehicle.isSelected();
				Submit.click();
				

			} catch (WebDriverException e) {
				throw new RuntimeException("Unable to click on Vehicle: " + e.getMessage());
			}
		}

		
}


