package com.hyr.test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestDependency
{
	String TrackingNumber=null;
	@Ignore
	@Test()

	public void CreateShipment()
	{
		System.out.println(5/0);
		TrackingNumber="AB12X7";
		
		System.out.println("CreateShipment");
	}
	@Test(dependsOnMethods = {"CreateShipment"},ignoreMissingDependencies = true)
	
	public void TrackShipment() throws Exception
	{
		if(TrackingNumber !=null)
			
		System.out.println("TrackShipment");
		else 
			throw new Exception("invalid Tracking number"); 
			
	}
	@Test(dependsOnMethods = {"CreateShipment","TrackShipment"},ignoreMissingDependencies = true)
	
	public void CancelShipment() throws Exception
	{
		if(TrackingNumber !=null)
			
			System.out.println("Cancel Shipment");
			else 
				throw new Exception("invalid Tracking number"); 

		
	}
	

}
