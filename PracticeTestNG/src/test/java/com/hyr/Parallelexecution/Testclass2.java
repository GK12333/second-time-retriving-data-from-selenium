package com.hyr.Parallelexecution;

import org.testng.annotations.Test;

public class Testclass2 
{
@Test
	
	public void TestMethod5()
	{
		System.out.println("Testclass2 >> testmethod5 >>"+ Thread.currentThread().getId());
	}
@Test
	
	public void TestMethod6()
	{
		System.out.println("Testclass2 >> testmethod6 >>"+ Thread.currentThread().getId());
	}
@Test

public void TestMethod7()
{
	System.out.println("Testclass2 >> testmethod7 >>"+ Thread.currentThread().getId());
}

	
}
