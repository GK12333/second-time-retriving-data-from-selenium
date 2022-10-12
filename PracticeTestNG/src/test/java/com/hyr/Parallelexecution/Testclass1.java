package com.hyr.Parallelexecution;

import org.testng.annotations.Test;

public class Testclass1 
{

	//it's a sequentional execution 
	@Test
	
	public void TestMethod1()
	{
		System.out.println("Testclass1 >> testmethod1 >>"+ Thread.currentThread().getId());
	}
@Test
	
	public void TestMethod2()
	{
		System.out.println("Testclass1 >> testmethod2 >>"+ Thread.currentThread().getId());
	}
@Test

public void TestMethod3()
{
	System.out.println("Testclass1 >> testmethod3 >>"+ Thread.currentThread().getId());
}
@Test

public void TestMethod4()
{
	System.out.println("Testclass1 >> testmethod4  >>"+ Thread.currentThread().getId());
}
}
