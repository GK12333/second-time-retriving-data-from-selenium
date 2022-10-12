package com.hyr.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest
{
	WebDriver driver;


	//	@Test
	//	public void TestGoogle() throws Exception
	//	{
	//		WebDriverManager.chromedriver().setup();
	//
	//		driver=new ChromeDriver();
	//
	//		driver.get("https://www.google.com/");
	//
	//		driver.findElement(By.name("q")).sendKeys("hyr tutorials",Keys.ENTER);
	//
	//		System.out.println(driver.getTitle());
	//
	//		Thread.sleep(5000);
	//		driver.quit();
	//
	//	}

		@SuppressWarnings("deprecation")
		@Test
	
		public void Rangesitchecking() throws Exception
		{
			WebDriverManager.chromedriver().setup();
	
			driver=new ChromeDriver();
			// driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			//Thread.sleep(5000);
	
			driver.findElement(By.cssSelector("div>input[placeholder ='Username']")).sendKeys("Admin");
			driver.findElement(By.cssSelector("div>input[placeholder='Password']")).sendKeys("admin123");
		
			driver.findElement(By.cssSelector("div>button[type='submit']")).click();
			//driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
		}

//	@Test
//	public void LaunchFacebookSite() throws Exception
//	{
//		WebDriverManager.chromedriver().setup();
//
//		driver=new ChromeDriver();
//
//		driver.manage().window().maximize();
//
//		driver.get("https://www.facebook.com/login.php/");
//		driver.findElement(By.name("email")).sendKeys("upsc",Keys.ENTER);
//		Thread.sleep(4000);
//
//		SoftAssert softassert=new SoftAssert();
//
//
//		//Title Assertion
//
//		String ExpectedTitle="Log in to Facebook";
//		String ActualTitle=driver.getTitle();
//		softassert. assertEquals(ActualTitle, ExpectedTitle,"Title Mismatched");


		//Url Assertion

//		String ExpectedUrl="https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100";
//		String ActualUrl=driver.getCurrentUrl();
//		softassert.assertEquals(ActualUrl, ExpectedUrl,"Url  Mismatched");
//
//		//Text Assertion
//
//		String ExpectedText="";
//		String ActualText=driver.findElement(By.name("email")).getAttribute("value");
//		softassert.assertEquals(ActualText, ExpectedText," Text   Mismatched");
//
//		//Border Assertion
//
//
//		String ExpectedBoarder="1px solid rgb(240, 40, 73)";
//		String ActualBoarder=driver.findElement(By.name("email")).getCssValue("border");
//		softassert.assertEquals(ActualBoarder, ExpectedBoarder," Border   Mismatched");
//
//		//ErrorMessage Assertion
//
//
//		String ExpectedMessage="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
//		String ActualMessage=driver.findElement(By.xpath("//div[@id='email_container']/div[2]")).getText();
//		softassert.assertEquals(ActualMessage, ExpectedMessage,"  Message  Mismatched");
//		
		
		

//		driver.quit();
//		softassert.assertAll();
//







		//driver.quit();

		//driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(6)")).click();
//	}





	//	@Test
	//	public void EnterLoginDetails()
	//	{
	//		WebDriverManager.chromedriver().setup();
	//
	//		driver=new ChromeDriver();
	//		driver.manage().window().maximize();
	////		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	////		driver.findElement(By.name("username")).sendKeys("Admin");
	////		   driver.findElement(By.name("password")).sendKeys("admin123");
	////			driver.findElement(By.xpath("//button[text()='Login']")).click();
	//
	//		driver.get("https://github.com/login");
	//		driver.findElement(By.id("login_field")).sendKeys("GK12333");
	//		driver.findElement(By.name("password")).sendKeys("GOPi.123");
	//		driver.findElement(By.name("commit")).click();
	//		driver.findElement(By.cssSelector("a[data-octo-click='marketplace_click']")).click();
	//		driver.findElement(By.cssSelector("input[data-target='marketplace-filter.searchInput']")).sendKeys("Imgbot",Keys.ENTER);
	//		//driver.findElement(By.className("form-control form-control input-block js-password-field")).sendKeys("Gopi.1233");
	//		//driver.findElement(By.className("btn btn-primary btn-block js-sign-in-button")).click();
	//		//WebElement ele1=	driver.findElement(By.xpath("//input[contains(@type,'password')]"));
	//		//ele1.sendKeys("admin123");
	//	
	//
}




