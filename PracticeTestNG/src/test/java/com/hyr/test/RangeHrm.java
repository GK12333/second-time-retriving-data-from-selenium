package com.hyr.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RangeHrm extends DriverSetUp
{
	
		
		
//		@Test(priority=2)
//		public void NavigateToMyInfo()
//		{
//			driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
//			//driver.findElement(By.xpath("//a[contains(@class,'oxd-main-menu-item active')]")).click();
//		}
		
         @SuppressWarnings("deprecation")
		@Test()
		
		public void AddNewEmployDetails() throws InterruptedException
		{
			//Thread.sleep(10000);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
				//new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Add Employee']")));
//			new   WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(myDynamicElement));
// 
			
			//myDynamicElement.click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		}


//		@Test
//		public void VerifyMyInfo()
//		{
//			
//			System.out.println(driver.findElement(By.xpath("//div[@class=\"orangehrm-paper-container\"]")).isDisplayed());
//		//System.out.println(driver.findElement(By.className("orangehrm-card-container")).isDisplayed());
//		
//		//driver.quit();
//		}
		
		
		
//	//SuppressWarnings("deprecation")
//		@SuppressWarnings("deprecation")
//		//@SuppressWarnings("deprecation")
//		@Test
//		
//		public void AddNewEmployDetails() throws InterruptedException
//		{
//			//Thread.sleep(10000);
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//			
//				//new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Add Employee']")));
////			new   WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(myDynamicElement));
//// 
//			
//			//myDynamicElement.click();
//		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
//		}
		
		//@SuppressWarnings("deprecation")
		//@Test
		
//		public void EditEmploy0217()
//		{
//			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			
//		//	new WebDriverWait(driver, 15  ).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Chenzira ']/preceding ::button[1]")));
//
//			
//		//	driver.findElement(By.xpath("//div[text()='Chenzira ']/preceding ::button[1]")).click();
//			
//			//div[text()='0217'] / following:: i[2]
//			
//	
//					new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("//div[text()='0217'] / following:: i[2]")));
//
//			
//			//driver.findElement(By.xpath("//div[text()='0217'] / following:: i[2]")).click();
//			
//			
//		}

}
