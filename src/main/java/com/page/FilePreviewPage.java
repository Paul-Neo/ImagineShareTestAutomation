package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.DropDownUtil;
import com.qa.util.NavigateUtil;
import com.qa.util.ScrollUtil;

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
	private By PDF_tronStatus = By.xpath("//strong[contains(text(),'PDFtron')]/following::p[@class='-to-display'][1]");
	private By updateButton = By.xpath("//button[text()='Update']");
	private By switchOn = By.xpath("//strong[contains(text(),'PDFtron')]/following::label[@class='switch'][1]");
	private By firmSettings = By.xpath("//span[text()='Firm Settings']");
	private By advanceSettings = By.xpath("//a[text()='Advanced Settings']");
	private By pdfIcon = By.xpath("//i[@class='far fa-edit fa-lg']");
	private By saveButton = By.xpath("//button[text()='Save']");
	private By pdfEditorIframe = By.xpath("//div[@class='custom-ribbons-container']");
	private By pdfEditorToolBarButtons = By.cssSelector("div.tool-group-buttons-scroll button");
	
	
	
	public String clickPDF_file() throws InterruptedException {
		
		
		Thread.sleep(5000);
		driver.findElement(latestPDF_file).click();
		Thread.sleep(5000);
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
	
	public void navigateToAdvanceSettings() throws InterruptedException {
		
		driver.findElement(firmSettings).click();;
		driver.findElement(advanceSettings).click();;
		Thread.sleep(3000);
		
	}
	
	public void pdfEditorToggleOn() throws InterruptedException {
		
		String actualStatus = driver.findElement(PDF_tronStatus).getText();
		
		if(actualStatus.equals("Off")) {
			
			ScrollUtil scrollDown = new ScrollUtil(driver);
			
			scrollDown.scrollPage(1000);//scroll down
			Thread.sleep(2000);
			driver.findElement(updateButton).click();
			Thread.sleep(2000);
			scrollDown.scrollPage(-2000);//scroll up
			driver.findElement(switchOn).click();
			scrollDown.scrollPage(1000);//scroll down
			driver.findElement(saveButton).click();
			Thread.sleep(5000);
			
		}
		
		
	}
	
	public void clickPDF_Icon() throws InterruptedException {
		
		driver.findElement(pdfIcon).click();
		Thread.sleep(5000);
		
	}
	
	public boolean isPdfTronExist() throws InterruptedException {
		
		 driver.switchTo().frame("webviewer-1");
		 Thread.sleep(5000);
		 return driver.findElement(pdfEditorIframe).isDisplayed();
		
	}
	
	public List<String> getPdfTronToolBarButtonsList() {
		
		List<String> list = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(pdfEditorToolBarButtons);
		
		for(WebElement e : elementList) {
			
				String listNames = e.getAttribute("aria-label");
				System.out.println("Tool Bar Button Name: " + listNames);
				
				list.add(listNames);
			
		}
		
		
		return list;
		
	}
	
	

	
	

}
