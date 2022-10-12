package com.hyr.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReferenceOrange
{
	WebDriver driver;
	
	@BeforeTest
	public void BrowserPart() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		
	}
	@Test(priority = 1)
	public void LoginPage() throws Exception
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(4000);
	}
	
	
	
@SuppressWarnings("deprecation")
@Test(priority = 2)

	public void CreateNewEmployee() throws Exception
	{
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("div>input[placeholder='First Name']")).sendKeys("Gopi",Keys.ENTER);
		driver.findElement(By.cssSelector("div>input[placeholder='Middle Name']")).sendKeys("Krishna",Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kativarapu",Keys.ENTER);
		
		Thread.sleep(3000);
		
//		Actions action = new Actions(driver);
//		WebElement element= driver.findElement(By.xpath("//button[@type='submit']"));
//		action.moveToElement(element).click().perform();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	
//Thread.sleep(4000);
   
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
//driver.findElement(By.xpath("//label[text()='Nickname']/following::div/input")).sendKeys("GK",Keys.ENTER);
driver.findElement(By.xpath("//label[text()='License Expiry Date']/following ::i[1]")).sendKeys("20220913");
driver.findElement(By.xpath("//input[@value='1']")).click();





		//WebDriverWait wait= (new WebDriverWait(driver, 5));
		
//	new WebDriverWait(driver,15).until(ExpectedConditions. invisibilityOfElementLocated(By.xpath("//label[text()='Nickname']/following::div[1]")));
//	new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Nickname']/following::div/input")));
//		driver.findElement(By.xpath("//label[text()='Nickname']/following::div/input")).sendKeys("GK",Keys.ENTER);
//		
		
//		
//		WebElement element1= driver.findElement(By.xpath("//label[text()='License Expiry Date']/following ::i[1]"));
//		action.moveToElement(element1).sendKeys("2022-09-13").perform();
		
//		new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='License Expiry Date']/following ::i[1]")));
//		driver.findElement(By.xpath("//label[text()='License Expiry Date']/following ::i[1]")).sendKeys("2022-09-13");
		
//		driver.findElement(By.xpath("//input[@value='1']")).click();
		
	//	driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		

	}


	
}
