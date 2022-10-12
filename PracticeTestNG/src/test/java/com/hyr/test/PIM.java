package com.hyr.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PIM extends DriverSetUp
{

	@SuppressWarnings("deprecation")
	@Test
	public void AddEmployDetails() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		Thread.sleep(3000);
				
		driver.findElement(By.cssSelector("div>input[placeholder='First Name']")).sendKeys("Gopi",Keys.ENTER);
		driver.findElement(By.cssSelector("div>input[placeholder='Middle Name']")).sendKeys("Krishna",Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kativarapu",Keys.ENTER);
		//driver.findElement(By.xpath("//div[@class='oxd-switch-wrapper']/label")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		
		//driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//label[text()='Nickname']/following::div/input[1]")).sendKeys("GK",Keys.ENTER);
		driver.findElement(By.xpath("//label[text()='License Expiry Date']/following ::div/i[1]")).sendKeys("2022-09-13");
		driver.findElement(By.xpath("//input[@value=\"1\"]")).click();
//	WebElement	driver.findElement(By.xpath("//label[text()='Nationality']/following :: div[5]"));
		//driver.findElement(By.xpath("//p[text()=' * Required']//following :: button[1]")).click();
		//Thread.sleep(3000);
		new   WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@type,'submit')]")));
		//driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		
		

	}
	

	
	
}
