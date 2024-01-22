package com.qa.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {
	
	public void sleep(long milliseconds) throws InterruptedException {
		
		Thread.sleep(milliseconds);
	}
	
	public void refreshPage(WebDriver driver) {
		
		driver.navigate().refresh();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	public void sendKeys(WebDriver driver, By locator, String value) {
		
//		new WebDriverWait(driver, 240).
//		until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
//		driver.findElement(locator).sendKeys(value);
		
		new WebDriverWait(driver, Duration.ofSeconds(240)).
		until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		driver.findElement(locator).sendKeys(value);
//		
	}
	
	public String getElementText(WebDriver driver, By locator) {
		
		new WebDriverWait(driver, Duration.ofSeconds(240)).
		until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		
		return driver.findElement(locator).getText();
	}
	
	public void clickOn(WebDriver driver, By locator) {
		
		new WebDriverWait(driver, Duration.ofSeconds(240)).
		until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
		
		driver.findElement(locator).click();
		
	}
	
	public void clearText(WebDriver driver, By locator) {
		
		new WebDriverWait(driver, Duration.ofSeconds(240)).
		until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		
		driver.findElement(locator).clear();
		
	}
	
	public boolean isElementDisplayed(WebDriver driver, By Locator) {
		
		new WebDriverWait(driver, Duration.ofSeconds(240)).
		until(ExpectedConditions.visibilityOf(driver.findElement(Locator)));
		
		return driver.findElement(Locator).isDisplayed();
		
	}
	
	public boolean isElementEnabled(WebDriver driver, By Locator) {
		
		new WebDriverWait(driver, Duration.ofSeconds(240)).
		until(ExpectedConditions.visibilityOf(driver.findElement(Locator)));
		
		return driver.findElement(Locator).isEnabled();
		
	}
	
	
	public boolean isElementNotDisplayed(WebDriver driver, By Locator) {
		
		new WebDriverWait(driver, Duration.ofSeconds(240)).
		until(ExpectedConditions.invisibilityOf(driver.findElement(Locator)));
		
		return driver.findElement(Locator).isDisplayed();
		
	}

}
