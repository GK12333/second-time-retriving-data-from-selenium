package com.hyr.Screenshot;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RootTest 
{
	public static WebDriver driver;
	public static String screenshotFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	@Parameters("browserName")
	@BeforeTest
	public void Setup(ITestContext context,@Optional("chrome") String browserName)
	{
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "edge"	:
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		default:
			System.out.println("Browsername is invalid");
			break;
		}
		driver.manage().window().maximize();
		Capabilities capabilities= ((RemoteWebDriver) driver).getCapabilities();
		String device=capabilities.getBrowserName()+""+capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf("."));
		String author=context.getCurrentXmlTest().getParameter("author");
		
		//get the test name dynamic way
	extentTest=extentReports.createTest(context.getName());
 extentTest.assignAuthor(author);
 extentTest.assignDevice(device);
	}
	@AfterTest
	public void teatdown()
	{
		driver.quit();
	}
	
	@BeforeSuite
	public void  initialiseExtentReports()
	{
		
		 extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter_all=new ExtentSparkReporter
				("AllTests.html");
		
		
		extentReports.attachReporter(sparkReporter_all);
	
		extentReports.setSystemInfo("os",System.getProperty("os.name"));
		extentReports.setSystemInfo("java version",System.getProperty("java.version"));
	}
	
	
	@AfterSuite
	public void generateExtentReports() throws Exception
	{
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());

		
	}
//	@BeforeMethod
//	public void methodname(Method m)
//	{
//		m.getAnnotation(Test.class).groups();
//	}
//	
	@AfterMethod
	
	public void checkstatus(Method m,ITestResult result)
	{
		
		if(result.getStatus() ==ITestResult.FAILURE) {
			String screenshotPath=null;
			screenshotPath=	captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
		    extentTest.addScreenCaptureFromPath(screenshotPath);
		extentTest.fail(result.getThrowable());
		} else if(result.getStatus()==ITestResult.SUCCESS) {
	extentTest.pass(m.getName()+"is passed");
	
	}
	//m.getAnnotation(Test.class).gro
		//extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}

	
	
	
	public String captureScreenshot(String fileName)
	{
		if(screenshotFolderName == null ) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHH:mm:ss");
			screenshotFolderName=myDateObj.format(myFormatObj);
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+"screenshotFolderName/"+ fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}

}

