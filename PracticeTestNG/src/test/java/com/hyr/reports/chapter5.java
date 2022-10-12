package com.hyr.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chapter5 {
	static WebDriver driver;
	public static void main(String[] args) throws IOException, Exception {
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter
				("report.html");


		extentReports.attachReporter(sparkReporter);


		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//Thread.sleep(5000);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  String base64code=captureScreenshot();
  String path=captureScreenshot("Orange.jpg");
  
  //test level attaching screen shots
		extentReports.
		createTest("Screenshot Test 1","this is for attaching the screenshot to the test at test level ")
		.info("this is info msg")
		.addScreenCaptureFromBase64String(base64code);
		
		extentReports.
		createTest("Screenshot Test 2","this is for attaching the screenshot to the test at test level ")
		.info("this is info msg")
		.addScreenCaptureFromBase64String(base64code,"orange home page");


		extentReports.
		createTest("Screenshot Test 3","this is for attaching the screenshot to the test at test level ")
		.info("this is info msg")
		.addScreenCaptureFromPath(path);
		
		extentReports.
		createTest("Screenshot Test 4","this is for attaching the screenshot to the test at test level ")
		.info("this is info msg")
		.addScreenCaptureFromPath(path, "orange home page");

	//================================================================================================	
		//log level attaching screen shots
		///media media type
		
		extentReports.
		createTest("Screenshot Test 5","this is for attaching the screenshot to the test at test level ")
		.info("this is fail message")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "orange hrm").build());

		
		extentReports.
		createTest("Screenshot Test 6","this is for attaching the screenshot to the test at test level ")
		.info("this is fail message")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "orange hrm").build());

	
//==================================================================================================
		//string details, media media type
		
		extentReports.
		createTest("Screenshot Test 7","this is for attaching the screenshot to the test at test level ")
		.info("this is fail message")
		.fail("first screen shot",MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail("screen shot with title",MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "orange hrm").build());

		
		extentReports.
		createTest("Screenshot Test 8","this is for attaching the screenshot to the test at test level ")
		.info("this is fail message")
		.fail("first screen shot",MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail("screen shot with title",MediaEntityBuilder.createScreenCaptureFromPath(path, "orange hrm").build());

		
//=====================================================================================================
		
		Throwable tt=new Throwable("this is the exception");
		
	//throwable,media media type
		
		extentReports.
		createTest("Screenshot Test 9","this is for attaching the screenshot to the test at test level ")
		.info("this is fail message")
		.fail(tt,MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail(tt,MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "orange hrm").build());

		
		extentReports.
		createTest("Screenshot Test 10","this is for attaching the screenshot to the test at test level ")
		.info("this is fail message")
		.fail(tt,MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(tt,MediaEntityBuilder.createScreenCaptureFromPath(path, "orange hrm").build());

		
		
		
		extentReports.flush();
		driver.quit();

		Desktop.getDesktop().browse(new File("report.html").toURI());

	}
	public static String captureScreenshot()
	{
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		String base64code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved successfully");
		return base64code;

	}
	
	
	
	
	public static String captureScreenshot(String fileName)
	{
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+ fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	return destFile.getAbsolutePath();
	}
	

}
