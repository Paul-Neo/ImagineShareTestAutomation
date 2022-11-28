package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

	private WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	private By goToAdminPage = By.xpath("//a[text()='Go to admin']");
	private By userProfileDropdown = By.xpath("//li[@class='dropdown']");
	private By switchAccount = By.xpath("//a[text()='Switch accounts ']");
	private By myProfile = By.xpath("//a[text()='Switch accounts ']");
	private By goToAdminLink = By.xpath("//a[text()=' Go to Admin ']");
	private By logout = By.xpath("//a[text()='Logout']");
	
	public void navigateToAdminPage() {
		
		driver.findElement(goToAdminPage).click();
		driver.navigate().refresh();
		
	}
	
	public void clickUserProfileDropdown() {
		
		driver.findElement(userProfileDropdown).click();
	}
	
	public boolean isDropdownMenuComplete() {
		
		boolean isComplete = false;
		
		if(driver.findElement(switchAccount).isDisplayed() && 
			driver.findElement(myProfile).isDisplayed() && 
			driver.findElement(goToAdminLink).isDisplayed() && 
			driver.findElement(logout).isDisplayed()) {
			
			isComplete = true;
		}
		
		return isComplete;
	}
	
	
	
	
	
	
}
