package com.hyr.Parallelexecution;

import org.testng.annotations.Test;

public class Testclass3 
{

@Test
	
	public void TestMethod8()
	{
		System.out.println("Testclass3 >> testmethod8 >>"+ Thread.currentThread().getId());
	}
@Test
	
	public void TestMethod9()
	{
		System.out.println("Testclass3 >> testmethod9 >>"+ Thread.currentThread().getId());
	}
@Test

public void TestMethod10()
{
	System.out.println("Testclass3 >> testmethod10 >>"+ Thread.currentThread().getId());
}
@Test

public void TestMethod11()
{
	System.out.println("Testclass3 >> testmethod11 >>"+ Thread.currentThread().getId());
}
}
