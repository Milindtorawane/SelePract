package com.selpract.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CheckBox {

	WebDriver driver;

	@Test
	public void dropselection() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='profession-0']"));
		if (checkBox.isSelected()) {
			System.out.println("Check box is already selected");
		} else {
			checkBox.click();
			System.out.println("Check box is not selected");
		}

	}
}
