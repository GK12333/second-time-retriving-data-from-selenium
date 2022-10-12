package com.hyr.test;

import java.sql.Driver;

import org.testng.annotations.Test;

public class RunningBrowser extends DriverSetUp
{
	@Test

	public void SeleniumDriver()
	{
		driver.get(Url);
		System.out.println("OpenRange Hrm Site");
		
		
	}
	
}
