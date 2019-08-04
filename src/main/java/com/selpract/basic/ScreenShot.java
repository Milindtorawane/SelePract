package com.selpract.basic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ScreenShot {

	WebDriver driver;

	@Test
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://seleniumpractice.blogspot.com/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(),"Milind");
	}

	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException {

		String TestCaseName = result.getName();
		System.out.println(TestCaseName);
		
	
		if (ITestResult.FAILURE == result.getStatus()) {
			
			// TakesScreenshot is the interface to capture the web page
			TakesScreenshot obj = (TakesScreenshot) driver;
			File srcFile = obj.getScreenshotAs(OutputType.FILE);
			// Declare destination path for saving the screenShot
			File dest = new File("D:\\" + TestCaseName + ".png");

			// Copy the source file to destination
			FileUtils.copyFile(srcFile, dest);
			System.out.println("Screen shot taken successfully");
		}

	}

}
