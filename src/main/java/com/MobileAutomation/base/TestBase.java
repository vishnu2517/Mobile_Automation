package com.MobileAutomation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	public AndroidDriver mobileDriver;
	public String appiumServer = "127.0.0.1";
	public int appiumPort = 4723;
	URI appiumURL = null;
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com" + "/greavesMobileAutomation/config/OR.properties");
		   prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public AndroidDriver initializeDriver()
	{
		try {
			appiumURL = new URI("http://" + appiumServer + ":" + appiumPort + "/wd/hub");
			this.mobileDriver = new AndroidDriver(setAppCapabilitiesAndroid());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mobileDriver;
	}
	public DesiredCapabilities setAppCapabilitiesAndroid() {
	DesiredCapabilities cap = new DesiredCapabilities();
	 cap.setCapability("platformName", "Android");
	 cap.setCapability("platformName", "Android");
	 cap.setCapability("automationName", "UiAutomator2");
	 cap.setCapability("deviceName", "RZCT40TL9JH");
	 cap.setCapability("app", System.getProperty("user.dir")+"/applications"+"/app-release.apk");// path of the app location
	
	//cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/applications"+"/app-release.apk");
	
	return cap;
	}
	
	public String takeScreenShotPath(String testCaseName,AndroidDriver mobileDriver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) mobileDriver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		//String destinationFile = System.getProperty("user.dir")+/"reports/"+testCaseName+".png";
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		//FileUtils.copyFile(source, new File(destinationFile));
		//FileUtils.copyFile
		return destinationFile;
		
	}
	

}
