package com.selpract.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * 
 * @author Milind.Torawane 
 *         Let’s see what happens internally when invoke the
 *         perform() method above Move Mouse Action: Mouse gets moved to the
 *         middle of the element. Here, the element is scrolled into view and
 *         its location gets calculated using getBoundingClientRect. Build:
 *         build() method is used to generate a composite action containing all
 *         actions. In this case, it’s just a single move mouse action. If you
 *         observe, we have not invoked it in our above command. This is because
 *         the build is executed in the perform method internally. Perform:
 *         perform() method performs the actions we have specified. But before
 *         that, it internally invokes build() method first. After the build,
 *         the action is performed.
 */

public class MouseHover {

	WebDriver driver;

	@Test
	public void dropselection() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/menu/");
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector("#ui-id-4"));
		act.moveToElement(ele).build().perform();

	}

}
