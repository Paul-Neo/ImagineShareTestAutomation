package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.util.DropDownUtil;
import com.qa.util.NavigateUtil;

public class FilePreviewPage {

	private WebDriver driver;
	
	public FilePreviewPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By latestPDF_file = By.xpath("//div[@class='table-cell -pdf-80']/following::a[1]");
	private By PDFfileName = By.xpath("//div[@class='-preview-title']");
	private By shareButton = By.xpath("//button[text()='Share ']");
//	private By requestSigButton = By.xpath("//button[text()='Request Signature']");
	private By downloadButton = By.xpath("//span[text()=' Download']");
	private By privateNotesLink = By.xpath("//span[text()='Private Notes']");
	private By detailsLink = By.xpath("//span[text()='Details']");
	private By activityLink = By.xpath("//span[text()='Activity']");
	private By assocClientDropDown = By.xpath("//small[text()='Associated Client: ']/following::div[@class='css-1pcexqc-container']");
	private By tagsDropDown = By.xpath("//div[@class='css-16pqwjk-indicatorContainer']");
	private By filesTab = By.xpath("//a[text()='Files']");

	
	public String clickPDF_file() throws InterruptedException {
		
		driver.findElement(latestPDF_file).click();
		Thread.sleep(1000);
		return driver.findElement(PDFfileName).getText();
		
	}
	
	public boolean isContentsDisplayed() {
		
		boolean isContentDispalyed = false;
		
		if(driver.findElement(shareButton).isDisplayed() &&
				driver.findElement(downloadButton).isDisplayed() &&
				driver.findElement(privateNotesLink).isDisplayed() &&
				driver.findElement(detailsLink).isDisplayed() &&
				driver.findElement(activityLink).isDisplayed()) {
			
			isContentDispalyed = true;
			
		}
		
		return isContentDispalyed;
	}

	public void navToDetailsLink() {
		
		driver.findElement(detailsLink).click();
	}
	
	public String getDefaultAssocClient() {
		
		return driver.findElement(assocClientDropDown).getText();
		
	}
	
	public void selectTags() {
		
		DropDownUtil dropDown = new DropDownUtil(driver);
		
		dropDown.selectFromDropDown(tagsDropDown, "2018");
		
		driver.navigate().refresh();
	}
	
	public boolean isFileRemoved(String movedFile) {
		
		
		String latestPDF_fileName = driver.findElement(PDFfileName).getText();
		
		boolean isFileRemoved = false;
		
		if(movedFile != latestPDF_fileName) {
			
			isFileRemoved = true;
		}
		
		return isFileRemoved;
		
	}
	
	public void selectAssocClient(String assocClient) {
		
		DropDownUtil dropDown = new DropDownUtil(driver);
		
		dropDown.selectFromDropDown(assocClientDropDown, assocClient);
	}

	public void navigateToSelectedAssocClient(String selectedAssocClient) throws InterruptedException {
		
		NavigateUtil nav = new NavigateUtil(driver);
		
		nav.navigateToClientWorkspace(selectedAssocClient);
		driver.findElement(filesTab).click();
		
		
	}
	
	

	

}
