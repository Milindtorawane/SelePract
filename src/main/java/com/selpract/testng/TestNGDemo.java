package com.selpract.testng;

import org.testng.annotations.Test;

public class TestNGDemo {
	
	
	@Test(priority=3)
	public void MyMethod11(){
		
		System.out.println("Method 1");
	}
	@Test(priority=2)
	public void MyMethod2(){
		
		System.out.println("Method 2");
	}
	@Test(priority=1)
	public void MyMethod(){
		
		System.out.println("Method 3");
	}

}
