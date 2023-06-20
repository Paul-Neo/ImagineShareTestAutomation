package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchUtil {

	private WebDriver driver;

	public SearchUtil(WebDriver driver) {

		this.driver = driver;
	}

	private By searchBox = By.xpath("//input[@type = 'search' and @name = 'query']");
	private By searchIcon = By.xpath("//i[@class='item right fal fa-search']");
	
	public void search(String name) throws InterruptedException {
		
		driver.findElement(searchBox).sendKeys(name);
		driver.findElement(searchIcon).click();
		Thread.sleep(5000);
		
		
	}
	

}
