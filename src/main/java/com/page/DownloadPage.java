package com.page;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.CheckBoxUtil;
import com.qa.util.ElementUtil;
import com.qa.util.NavigateUtil;
import com.qa.util.PageActions;

public class DownloadPage extends PageActions {

	private WebDriver driver;
	private ElementUtil elementUtil = new ElementUtil();
	private CheckBoxUtil checkBoxUtil = new CheckBoxUtil();
	
	public DownloadPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By searchBox = By.xpath("//input[@type='search' and @class='no-border']");
	private By filePreviewDownloadButton = By.xpath("//span[text()=' Download']");
	private By toolBarDownloadButton = By.xpath("//button[contains(text(),'Download')]");
	private By fileName;
	private By filesTab = By.xpath("//a[text()='Files']");
	private By selectAllFiles = By.xpath("//div[text()='Filename']/preceding::input[@type='checkbox'][1]");
	
	public void enterFileName(String fileName) {
		
		driver.findElement(searchBox).sendKeys(fileName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public boolean isFileNameDisplayed(String fileName) {
		
		this.fileName = elementUtil.getDivXpathData(fileName);
		
		return driver.findElement(this.fileName).isDisplayed();
	}
	
	public void clickFileName(String fileName) {
		
		this.fileName = elementUtil.getDivXpathData(fileName);
		
		 driver.findElement(this.fileName).click();
	}
	
	public void clickFilePreviewButton() {
		
		driver.findElement(filePreviewDownloadButton).click();
	}
	
	public void navigateToWorkspaceFiles(String clientName) throws InterruptedException {
			
		NavigateUtil nav = new NavigateUtil(driver);
		nav.navigateToClientWorkspace(clientName);
//		driver.findElement(filesTab).click();
		
		clickOn(driver, filesTab);
		
	}
	
	public void clickFolderName(String folderName) {
		
		fileName = checkBoxUtil.getaPrecidingCheckBox(folderName);
		
		driver.findElement(fileName).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(toolBarDownloadButton).click();
	}
	
	public String getFolderName(String folderName) {
		
		fileName =elementUtil.get_a_XpathData(folderName);
		
		return driver.findElement(fileName).getText();
	}
	
	public void tickCheckBoxForAllFiles() throws InterruptedException{
		
		driver.findElement(selectAllFiles).click();
		Thread.sleep(2000);
	}
	
	public void clickToolBarButton() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(toolBarDownloadButton).click();
		Thread.sleep(5000);
		
	}
	
}
