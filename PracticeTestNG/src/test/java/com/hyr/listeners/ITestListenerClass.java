package com.hyr.listeners;

import org.apache.poi.sl.draw.geom.IAdjustableShape;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");

		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");

	}

	public void onStart(ITestContext context) {
		System.out.println("onStart");

	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");

	}

}
