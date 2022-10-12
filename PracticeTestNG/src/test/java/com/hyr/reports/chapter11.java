package com.hyr.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chapter11 {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
		Capabilities capabilities= ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getBrowserVersion());
		
		
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter_all=new ExtentSparkReporter("AllTests.html");
		ExtentSparkReporter sparkReporter_failed=new ExtentSparkReporter("FailedTests.html");
		sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		ExtentSparkReporter sparkReporter_skipandwarning=new ExtentSparkReporter("skipAndWarningTests.html");

		sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.SKIP,Status.WARNING}).apply();

		
		extentReports.attachReporter(sparkReporter_all,sparkReporter_failed,sparkReporter_skipandwarning);

		
		//it will run
		extentReports
		.createTest(" test 1","test description 1")
		.assignAuthor("Gopi")
		.assignCategory("smoke")
		.assignDevice("chrome 99")
		.pass("this is passed test");
		
		//it will run
		
		extentReports
		.createTest(" test 2","test description 2")
		.assignAuthor("pavan")
		.assignCategory("sanity")
		.assignDevice("edge")
		.skip("this is skip test");
		
		//it will run
		extentReports
		.createTest(" test 3","test description 3")
		.assignDevice("edge")
		.assignCategory("sanity")
		.assignAuthor("anil")
		.fail("this is failed test");
		
		//it will run
		extentReports
		.createTest(" test 4","test description 4")
		.assignDevice("edge")
		.assignDevice("edge 33")
		.assignCategory("sanity")
		.assignCategory("smoke")
		.assignAuthor("anil")
		.assignAuthor("rama")
		.warning("this is warning  test");
		
		//it also run
		extentReports
		.createTest(" test 5","test description 5")
		.assignDevice("edge","chrome","firefox")
		.assignCategory("sanity","smoke","regression")
		.assignAuthor("anil","madhav","botsha")
		.fail("this is failed test");
		
		
		//it will also run
		extentReports
		.createTest(" test 6","test description 6")
		.assignDevice("edge","chrome","firefox")
		.assignCategory(new String[] {"sanity","smoke","regression"})
		.assignAuthor(new String[] {"anil","madhav","botsha"})
		.pass("this is passed test");
		
		extentReports.flush();
driver .quit();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("skipAndWarningTests.html").toURI());

	}

}
