package com.MobileAutomation.utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.MobileAutomation.base.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class Listener  extends TestBase implements ITestListener{
	public Listener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TestCase Case Execution Started :"+result.getName());
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCase Passed :"+result.getName());
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("TestCase Case Execution Started :"+result.getName());
		String testMethodName = result.getMethod().getMethodName();
		AndroidDriver mobileDriver = null;
		try {
			mobileDriver = (AndroidDriver)result.getTestClass().getRealClass().getDeclaredField("mobileDriver").get(result.getInstance());	
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
		takeScreenShotPath(testMethodName, mobileDriver);
	} catch(IOException e1) {
		e1.printStackTrace();
	}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase Case Execution Skipped :"+result.getName());
	}
	
	//@Override
	//public void onTestFailedButwitinSuccessPercentage(ITestResult result) {
		
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	}

}
