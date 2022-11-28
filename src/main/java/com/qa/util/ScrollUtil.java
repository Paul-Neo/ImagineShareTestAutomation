package com.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollUtil {

	private WebDriver driver;
	
	public ScrollUtil(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void scrollPage(int value) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,"+value+")");

	}
}
