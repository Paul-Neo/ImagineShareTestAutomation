package com.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateUtil {

	private WebDriver driver;
	private ElementUtil elementUtil = new ElementUtil();
	
	public NavigateUtil(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By allFilesTab = By.xpath("//span[text()='All ' and text()=' Files']");
	private By generalFiles = By.xpath("//a[text()='General Files']");
	private By staffFilesFolder = By.xpath("//a[text()='Staff Files']");
	
	private By searchBox = By.xpath("//input[@type = 'search' and @name = 'query']");
	private By searchIcon = By.xpath("//i[@class='item right fal fa-search']");
	private By goToClientWorkspace = By.xpath("//a[text()='Go to client workspace']");
	private By goToClientSettings = By.xpath("//a[text()='Go to client settings']");

	private By profileDropDown = By.xpath("//div[@class='-profile-info']");
	private By myProfile = By.xpath("//a[text()='My Profile ']");
	

	
	public void generalFolder() throws InterruptedException {
		
		driver.findElement(allFilesTab).click();
		driver.findElement(generalFiles).click();
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
	
	public void personalFolder(String folderName) throws InterruptedException {
		
		By selectedFolderName = elementUtil.get_a_XpathData(folderName);
		
		driver.findElement(allFilesTab).click();
		driver.findElement(staffFilesFolder).click();
		driver.findElement(selectedFolderName).click();
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		
	}
	
	public void navigateToClientWorkspace(String clientsName) throws InterruptedException {

		driver.findElement(searchBox).sendKeys(clientsName);
		driver.findElement(searchIcon).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(goToClientWorkspace).click();
		
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void navigateToClientSettings(String clientsName) throws InterruptedException {

		driver.findElement(searchBox).sendKeys(clientsName);
		driver.findElement(searchIcon).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(goToClientSettings).click();
		
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	public void clickSelectedTab(String tabName) {
		
		By selectedTabName =  elementUtil.get_a_XpathData(tabName);
		driver.findElement(selectedTabName).click();
	}
	
	public void navigateToMyProfile() throws InterruptedException {
		
		driver.findElement(profileDropDown).click();
		driver.findElement(myProfile).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
}
