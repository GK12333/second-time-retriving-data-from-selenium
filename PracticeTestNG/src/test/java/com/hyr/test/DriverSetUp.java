package com.hyr.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp
{
	public static 	WebDriver driver;
	
	String Url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@SuppressWarnings("deprecation")
	@BeforeSuite
	
	public void OpenBrowser()
	{ 
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		

	}
	@Test(priority = 1)
	public void LoginPage() 
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(4000);
	}

}
