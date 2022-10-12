package com.hyr.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chapter2 {

	public static void main(String[] args) throws IOException {
	   ExtentReports extentReports=new ExtentReports();
	   ExtentSparkReporter sparkReporter=new ExtentSparkReporter
		  ("report.html");
	
	       extentReports.attachReporter(sparkReporter);
	       
	    ExtentTest test1=  extentReports.createTest("Test 1");
	   test1.pass("this is passed");
	   
	   ExtentTest test2=  extentReports.createTest("Test 2");
	    test2.log(Status.FAIL,"this is failed");
	    
	     
	    extentReports.createTest("Test 3").skip("this is skipped");
	    
	       extentReports.flush();
	       
	       Desktop.getDesktop().browse(new File("report.html").toURI());
	
	}
	
	
}
