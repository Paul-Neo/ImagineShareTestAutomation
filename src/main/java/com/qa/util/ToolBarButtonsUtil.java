package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolBarButtonsUtil extends PageActions{

	private WebDriver driver;
	
	
	public ToolBarButtonsUtil(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	//Files
	
	private By newLinkBtn = By.xpath("//button[text()='New Link']");
	private By newFolderBtn = By.xpath("//button[text()='New Folder']");
	private By newFileBtn = By.xpath("//button[text()='New File']");
	private By uploadNewFilesBtn = By.xpath("//span[text()='Upload new files']");
	private By archiveBtn = By.xpath("//button[contains(text(),'Archive')]");
	
	// Both
	private By archiveSettings = By.xpath("//button[@class='yt-btn x-small info']/following::i[1]");
	private By viewArchiveLink = By.xpath("//a[text()='View Archive']");
	
	//Client Settings
	
	private By notificationSettingsBtn = By.xpath("//button[text()='Notification Setting']");
	private By staffSetingsBtn = By.xpath("//button[text()='Staff Setting']");
	
	
	
	public void clickArchive() throws InterruptedException {
		
		ScrollUtil scroll = new ScrollUtil(driver);
		scroll.scrollPage(-1500);
		
		clickOn(driver, archiveBtn);
		sleep(20000);
	}	
	
	public void selectLinkAction(By linkAction) throws InterruptedException {
		
		ScrollUtil scroll = new ScrollUtil(driver);
		scroll.scrollPage(-1500);
		driver.findElement(newLinkBtn).click();
		Thread.sleep(3000);
		driver.findElement(linkAction).click();
		Thread.sleep(3000);
		
	}
	
	public void clickNewFolder(By selectedButton) throws InterruptedException {
		
		ScrollUtil scroll = new ScrollUtil(driver);
		scroll.scrollPage(-1500);
		driver.findElement(newFolderBtn).click();
		Thread.sleep(3000);
		driver.findElement(selectedButton).click();
		Thread.sleep(3000);
	

	}
	
	public void uploadNewFiles() throws InterruptedException {
		
		ScrollUtil scroll = new ScrollUtil(driver);
		scroll.scrollPage(-1500);
		driver.findElement(newFileBtn).click();
		driver.findElement(uploadNewFilesBtn).click();
		

	}
	
	public void viewArchive() throws InterruptedException {
		
		ScrollUtil scroll = new ScrollUtil(driver);
		scroll.scrollPage(-1500);
		driver.findElement(archiveSettings).click();
		driver.findElement(viewArchiveLink).click();
	}
	
	public void clickNotificationSettings(By selectedSettings) throws InterruptedException {
		
		ScrollUtil scroll = new ScrollUtil(driver);
		scroll.scrollPage(-1500);
		driver.findElement(notificationSettingsBtn).click();
		driver.findElement(selectedSettings).click();
		Thread.sleep(3000);
	}
	
	public void clickStaffSettings(By selectedSettings) throws InterruptedException {
		
		ScrollUtil scroll = new ScrollUtil(driver);
		scroll.scrollPage(-1500);
		driver.findElement(staffSetingsBtn).click();
		Thread.sleep(2000);
		driver.findElement(selectedSettings).click();
		Thread.sleep(3000);
		
	}
	
		
}
