package com.selpract.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author Milind.Torawane 
 * 			Uploading files in WebDriver is done by simply using
 *         the sendKeys() method on the file-select input field to enter the
 *         path to the file to be uploaded.
 */
public class UploadFile {

	WebDriver driver;
	
	@Test
	public void fileUpload() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.findElement(By.id("uploadfile_0")).sendKeys("D:\\Credentials.txt");
		
	}

}
