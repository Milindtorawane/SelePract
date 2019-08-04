package com.selpract.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	static WebDriver driver;

	//@Test(priority = 1)
	public void dragAndDrop() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		// Drag and drop from source element to destination element by locator
		// strategy
		WebElement drag = driver.findElement(By.cssSelector("#draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(10000);
		

	}

	// Drag and drop from source element using pixe
	
	@Test
	public void dragAndDropUsingOFFSet() {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver); 
		 WebElement from = driver.findElement(By.id("draggable")); 
		 WebElement to = driver.findElement(By.id("droppable")); 
		 
		 //Here, getting x and y offset to drop source object on target object location
		 //First, get x and y offset for from object
		 int xOffset1 = from.getLocation().getX();
		 int yOffset1 =  from.getLocation().getY();
		 
		 System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);
		 
		 //Secondly, get x and y offset for to object
		 int xOffset = to.getLocation().getX();
		 int yOffset =  to.getLocation().getY();
		 
		 System.out.println("xOffset--->"+xOffset+" yOffset--->"+yOffset);
		 
		 //Find the xOffset and yOffset difference to find x and y offset needed in which from object required to dragged and dropped
		 xOffset =(xOffset-xOffset1)+10;
		 yOffset=(yOffset-yOffset1)+20;
		 
		 
		 //Perform dragAndDropBy 
		 builder.dragAndDropBy(from, xOffset,yOffset).perform();
		 
		 //verify text changed in to 'Drop here' box 
		 //Get text value of 'to' element
		 String textTo = to.getText(); 
		 
		 if(textTo.equals("Dropped!")) {
		 System.out.println("PASS: Source is dropped at location as expected");
		 }else {
		 System.out.println("FAIL: Source couldn't be dropped at location as expected");
		 }
		
		}
	}


