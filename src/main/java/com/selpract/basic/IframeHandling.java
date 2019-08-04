package com.selpract.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * org.openqa.selenium.NoSuchFrameException: No frame element found by name or id iframe
 * 
 * 
 */


public class IframeHandling {

	static WebDriver driver;

	@Test(priority=0)
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("https://www.toolsqa.com/iframe-practice-page/");
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void iframeHandling() {
		// Find out the total iframes from web page
	
		int iframeSize = driver.findElements(By.xpath("//iframe")).size();
		System.out.println("Size of total iframe> " + iframeSize);

		// Print all the iframes

		List<WebElement> iframelist = driver.findElements(By.tagName("iframe"));
		for (WebElement iframe : iframelist) {
			System.out.println("iframe text>>" + iframe.getText());
			System.out.println("iframe tag Name>" + iframe.getTagName());
			System.out.println("iframe attribute>" + iframe.getAttribute("name"));
			
			

		}
		
		//Switch to frame by index 
		driver.switchTo().frame(1);
		
		//Switch to frame by name 
		driver.switchTo().frame("iframe1");
		
		//Switch to default and  parent frame
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		

	}

}
