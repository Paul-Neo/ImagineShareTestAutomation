package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.util.ElementUtil;

public class FirmSettingsPage {

	WebDriver driver;
	
	public FirmSettingsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By accountsList = By.cssSelector("a.-account-select-link");
	private By goToAdmin = By.xpath("//a[text()='Go to admin']");
	private By firms = By.xpath("//a[text()='Firms']");
	private By changeStatusButton = By.xpath("//button[text()='change']");
	private By statusDropDown = By.xpath("//select[@name='status']");
	private By saveButton = By.xpath("//button[text()='save']");
	private By profile = By.xpath("//div[@class='-profile-info']");
	private By switchAccounts = By.xpath("//a[text()='Switch accounts ']");
	private By firmSettingsNavs = By.cssSelector("div.tab-bar-nav a");

	
	public List<String> getFirms() {
		
		List<String> lists = new ArrayList<>();
		List<WebElement> elementLists = driver.findElements(accountsList);
		
		for(WebElement e : elementLists) {
			
			String accLists = e.getText();
			System.out.println("Account Name: " + accLists);
			lists.add(accLists);
		}
		
		return lists;
	
	}
	
	public void clickGoToAdmin() {
		
		driver.findElement(goToAdmin).click();
	}
	
	public void clickFirm(String firmName) {
		
		ElementUtil elementUtil = new ElementUtil();
		
		driver.findElement(firms).click();
		driver.findElement(elementUtil.get_a_XpathData(firmName)).click();
		
	}
	
	public void changeFirmStatus(String subscriptionStatus) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-1500)");
		
		driver.findElement(changeStatusButton).click();
		
		Select dropDown = new Select(driver.findElement(statusDropDown));
		dropDown.selectByVisibleText(subscriptionStatus);
		
		driver.findElement(saveButton).click();
		Thread.sleep(1000);
		
	}
	
	public void navigateToAccountSelections() throws InterruptedException {
		
		driver.findElement(profile).click();
		Thread.sleep(2000);
		driver.findElement(switchAccounts).click();
		driver.navigate().refresh();
		
	}
	
	public List<String> getFirmSettingsPageLinks() {
		
		List<String> list = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(firmSettingsNavs);
		
		for(WebElement e : elementList) {
			
			String linkNames = e.getText();
			System.out.println("Link Name : " + linkNames);
			list.add(linkNames);
			
		}
		
		return list;
		
	}
	
	
	
}
