package com.hyr.test;

import org.testng.annotations.Test;

public class TestGroupDependency extends RangeHrm
{
	@Test(groups = "EnterLoginDetails")
	public void test1()
	{
		System.out.println("Test method1");
	}

	@Test(groups = "EnterLoginDetails")
	public void test2()
	{
		System.out.println("Test method2");
	}

	@Test(groups = "EnterLoginDetails")
	public void test3()
	{
		System.out.println("Test method3");
	}
	@Test(dependsOnMethods = "EnterLoginDetails")
	public void test4()
	{
		System.out.println("Main method");
	}
	

}
