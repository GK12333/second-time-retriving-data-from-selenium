package com.hyr.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chapter3 {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports=new ExtentReports();
		   ExtentSparkReporter sparkReporter=new ExtentSparkReporter
			  ("report.html");
		
		       extentReports.attachReporter(sparkReporter);
		   
		       //method chaining process write the code like this for 
		       //readability
		       extentReports.createTest("Test 1")
		       .log(Status.INFO,"info1")
		       .log(Status.INFO, "info 2")
		       .log(Status.INFO, "info 2")
		       .log(Status.INFO, "info 2")
		       .log(Status.INFO, "info 2")
		       .log(Status.PASS, "pass 2")
		       .log(Status.WARNING, "warning 2")
		       .log(Status.WARNING, "warning 2")
		       .log(Status.SKIP, "skip 2")
		       .log(Status.FAIL, "fail 2");
		       
		       
		       
		   
		       extentReports.flush();
		       
		       Desktop.getDesktop().browse(new File("report.html").toURI());
		
	}
	
}
