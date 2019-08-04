package com.selpract.basic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WindowHandling {
	
	WebDriver driver;

	@Test(priority=0)
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void handleWindows() throws InterruptedException{
		
		driver.findElement(By.cssSelector("#button1")).click();
		String parentWindow=driver.getWindowHandle();
		System.out.println("Current window handle>"+parentWindow);
		
		Set<String>s1=driver.getWindowHandles();
		Iterator<String>I1=s1.iterator();
		
		while (I1.hasNext()) {

			String childWindow = I1.next();
			System.out.println("Child window>>" + childWindow);
			if (!childWindow.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(childWindow);
				Thread.sleep(10000);
				String currentChildWind=driver.getCurrentUrl();
				System.out.println("Current child URL>>"+currentChildWind);
			}
		}
		
		driver.switchTo().window(parentWindow);
		System.out.println("Switcehd to paren" +parentWindow);
		String windoURL=driver.getCurrentUrl();
		System.out.println("Current window URL>>"+windoURL);
	}

}
