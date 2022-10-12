package com.hyr.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngAnnotations
{
WebDriver driver;

@BeforeTest
public void ChromeInitialization()
{
	WebDriverManager.chromedriver().setup();
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
		
}

@AfterTest

public void TearDown()
{
	driver.quit();
}

@Test
public void Launchapp()
{
	driver.get("https://www.facebook.com/login.php/");
}

@Test

public void EnterLoginDetails()
{
	driver.findElement(By.name("email")).sendKeys("sbsbhv",Keys.ENTER);
	
}



}
