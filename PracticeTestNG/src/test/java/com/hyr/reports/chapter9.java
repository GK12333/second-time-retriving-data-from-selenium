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

public class chapter9 {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
		Capabilities capabilities= ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getBrowserVersion());
		
		
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter
				("report.html");
		
		
//		sparkReporter.config().setTheme(Theme.DARK);
//		sparkReporter.config().setReportName("Report Name");
//		sparkReporter.config().setDocumentTitle("Doc Title");
//		sparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm::ss");
//		sparkReporter.config().setCss(".badge-primary{background-color:#da02b}");
//		sparkReporter.config().
//		setJs("document.getElementsByClassName(\"logo\")[0].style.display='none'");

		
		//we can also write the above code  like this
		
		
//		ExtentSparkReporterConfig config=  sparkReporter.config();
//		
//		config.setTheme(Theme.DARK);
//		config.setReportName("Report Name");
//	 	config.setTimeStampFormat("dd-MM-yyyy hh:mm::ss");
//		config.setCss(".badge-primary{background-color:#da02b}");
//		config.
//		setJs("document.getElementsByClassName(\"logo\")[0].style.display='none'");
//
//		
		
		sparkReporter.loadXMLConfig(new File ("./src/test/resources/extent reports config.xml"));
		
		
		extentReports.setSystemInfo("os",System.getProperty("os.name"));
		extentReports.setSystemInfo("java version",System.getProperty("java.version"));
		extentReports.setSystemInfo("Browser name",capabilities.getBrowserName()+capabilities.getBrowserVersion());
		extentReports.setSystemInfo("app url","www.upsc.com");
		extentReports.setSystemInfo("user name","gopikrishnakativarapu");
		extentReports.setSystemInfo("password","1234 ");

		extentReports.attachReporter(sparkReporter);

		
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
		.pass("this is failed test");
		
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
		.pass("this is passed test");
		
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
		Desktop.getDesktop().browse(new File("report.html").toURI());

	}

}
