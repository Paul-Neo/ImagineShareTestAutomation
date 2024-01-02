package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RenameUtil extends PageActions {

	private WebDriver driver;
	private GenerateRandomStrings generateRandomStrings = new GenerateRandomStrings();

	private By fileSubtask = By.xpath("//div[@class='table-cell -pdf-80']");
	private By rename = By.xpath("//a[text()='Rename ']");
	private By renameInput = By.xpath("//input[@name='newFilename']");
	private By save = By.xpath("//button[text()='save']");
	
	
	
	public RenameUtil(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void renameLatestPDF() throws InterruptedException {

		String generatedText = generateRandomStrings.randomString(4);
		
//		driver.findElement(fileSubtask).click();
//		driver.findElement(rename).click();
//		driver.findElement(renameInput).clear();
//		driver.findElement(renameInput).sendKeys("Renamed"+generatedText);
//		driver.findElement(save).click();
//		Thread.sleep(3000);
		
		clickOn(driver, fileSubtask);
		clickOn(driver, rename);
		clearText(driver, renameInput);
		sendKeys(driver, renameInput, "Renamed" + generatedText);
		clickOn(driver, save);
		sleep(3000);
		
	}
	
	
	
}

