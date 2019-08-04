package com.selpract.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

/*
 * Alert is interfaced
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AlertHandling {
	
	WebDriver driver;
	
	@Test
	public void alertHandling(){
		
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe" );
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.sendKeys("Milind");
		alert.getText();
		
	
	}
	

}
