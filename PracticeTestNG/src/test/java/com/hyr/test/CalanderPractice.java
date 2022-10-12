package com.hyr.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.NeedsLocalLogs;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalanderPractice 
{

	//WebDriver driver;
	@Test
	public static void Calander() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver	driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		driver.findElement(By.id("first_date_picker")).click();
		selectDate(driver,"05/jan/2015");
		
		driver.findElement(By.id("second_date_picker")).click();
		selectDate(driver, "05/Jun/2025");
		
	}
	
	public static void selectDate(WebDriver driver,String date) throws Exception
	{
		
		//by writing this code  will select the current date and time
		Calendar calendar=Calendar.getInstance();
		
		
		try {
			
			//by writing this line of code will match the user input date format
		SimpleDateFormat TargetDateFormat=new SimpleDateFormat("dd/MMM/yyyy");
		
		//if we set the true it will forward the extra days to next month,so you could set false
		TargetDateFormat.setLenient(false);
		
		//converting the string format date to java format by using date class
		Date formatedTargetedDate=TargetDateFormat.parse(date);
		
		
		//it will select the user input date
		calendar.setTime(formatedTargetedDate);
		}
		catch(Exception w)
		{
			throw new Exception("invalid date is provided ,please check the date");
		}
		
		//select the target month like user given month
		int targetMonth=calendar.get(calendar.MONTH);
		
		//select the target year like user given year
		int targetYear=calendar.get(calendar.YEAR);
		
		//select the target date of month like user given date of month
		int targetDay=calendar.get(calendar.DAY_OF_MONTH);
		
		
		//current date, when ever you opened web page it first appear
		String currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
		
		//setting current month and year
		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);
		
		//using while other than if because if we used if condition it will verify only one
		//time but when we used while condition and check the above code it will verify until
		//given one of the condition is true...
		while(currentMonth < targetMonth || currentYear < targetYear) {
			driver.findElement(By.className("ui-datepicker-next")).click();
			currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}

		while(currentMonth > targetMonth || currentYear > targetYear) {
			driver.findElement(By.className("ui-datepicker-prev")).click();
			currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}
		
		
		if(currentMonth == targetMonth && currentYear == targetYear)
			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()="+targetDay+"]")).click();
		else
			throw new Exception("unable to select the date because of current and target dates mismatch");
				
		
	}
}
