package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.PageActions;

public class BasePages extends PageActions{

	
	private WebDriver driver;
	
	public BasePages(WebDriver driver) {
		
		this.driver = driver;
		
	}

	private String sideNavTabName = "//span[normalize-space()='{0}']";
	
	
	public void clickTabName(String tabName) {
		
		By selectedTabName = By.xpath(sideNavTabName.replace("{0}", tabName));
		
		clickOn(driver, selectedTabName);
		
	}
}
