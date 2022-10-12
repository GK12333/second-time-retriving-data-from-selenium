package com.hyr.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ITestListenerClass.class)
public class Testclass1 
{

	
	@Test
	
	public void TestMethod1()
	{
		System.out.println("i'm inside testmethod1");
	}
@Test
	
	public void TestMethod2()
	{
	System.out.println("i'm inside testmethod2");
	Assert.assertTrue(false);

	}
@Test(timeOut = 1000)

public void TestMethod3() throws Exception
{
	Thread.sleep(2000);
	
	System.out.println("i'm inside testmethod3");

}
@Test(dependsOnMethods = "TestMethod3")

public void TestMethod4()
{
	System.out.println("i'm inside testmethod4");

}
}
