package com.hyr.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicClass1 
{



	WebDriver driver;

@Test()

	public void Testlogin() throws Exception
	{
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='oxd-sidepanel-header']/a")).isDisplayed());
		Thread.sleep(3000);
		driver.quit();


	}
//	
//	@DataProvider()
//	public Object[][] dp1()
//	{
//		Object[][] data=new Object[2][2];
//		
//		data[0][0]="Admin";
//		data[0][1]="admin123";
//		
//		data[1][0]="Admin";
//		data[1][1]="admin1234";
//		
//		
//		return data;
//	}
	
}


