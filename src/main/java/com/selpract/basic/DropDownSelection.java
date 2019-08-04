package com.selpract.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownSelection {
	
	WebDriver driver;
	
	@Test
	public void dropselection(){
		
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");		
		WebElement ele= driver.findElement(By.xpath("//select[@name='country']"));
		ele.click();
		Select sel= new Select(ele);
		sel.selectByIndex(5);
		sel.selectByValue("china");
		sel.selectByVisibleText("");
		//List<WebElement>optlist=sel.getOptions();
	
		
		
		
	}

}
