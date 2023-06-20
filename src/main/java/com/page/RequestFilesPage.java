package com.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.DropDownUtil;
import com.qa.util.GenerateRandomStrings;
import com.qa.util.ToolBarButtonsUtil;

public class RequestFilesPage {

	private WebDriver driver;
	
	private DropDownUtil dropDown = new DropDownUtil(DriverFactory.getDriver());
	private GenerateRandomStrings generateRandomStrings = new GenerateRandomStrings();
	
	public RequestFilesPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By requestFiles = By.xpath("//span[text()='Request files']");
	private By createRequestFilesButton = By.xpath("//button[text()='Create request files link']");
	private By filesTab = By.xpath("//a[text()='Files']");
	private By expirationToggle = By.xpath("//input[@name='expires']/following::span[1]");
	private By instructionsToggle = By.xpath("//input[@name='addInstructions']/following::span[1]");
	private By sendEmailsToggle = By.xpath("//input[@name='sendEmails']/following::span[1]");
	private By receiveEmailsToggle = By.xpath("//input[@name='receiveEmails']/following::span[1]");
	
	private By instructions = By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
	private By emailMessage = By.xpath("//textarea[@name='emailMessage']");
	
	private By sendMailsDropDown = By.xpath("//strong[text()='Send emails']/following::div[@class='css-16pqwjk-indicatorContainer react-select__indicator react-select__dropdown-indicator'][1]");
	private By receiveMailsDropDown = By.xpath("//strong[text()='Receive emails']/following::div[@class='css-16pqwjk-indicatorContainer react-select__indicator react-select__dropdown-indicator'][1]");
	
	private By selectFolderBtn = By.xpath("//button[text()='Select Folder']");
	private By newFolderBtn = By.xpath("//div[text()='Select Folder']/following::button[text()='New Folder']");
	private By folderNameTxtfield = By.xpath("//div[text()='Select Folder']/following::button[1]/following::input[@type='text'][1]");
	private By saveBtn = By.xpath("//button[contains(text(),'ave')]");
	
	
	public void selectRequestFiles() throws InterruptedException {
		
		ToolBarButtonsUtil toolbarButtons = new ToolBarButtonsUtil(driver);
		toolbarButtons.selectLinkAction(requestFiles);
		
	}
	
	public void clickCreateRequestFileButton() {
		
		driver.findElement(createRequestFilesButton).click();
	}
	
	public void clickFilesTab() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(filesTab).click();
		Thread.sleep(2000);
	}
	
	public void clickToggles() throws InterruptedException {
		
		driver.findElement(expirationToggle).click();
		driver.findElement(instructionsToggle).click();
		driver.findElement(sendEmailsToggle).click();
		driver.findElement(receiveEmailsToggle).click();
		Thread.sleep(3000);
	}
	
	public void enterInstructions(String instructions) throws InterruptedException {
		
		driver.findElement(this.instructions).sendKeys(instructions);
		Thread.sleep(2000);
	}
	
	public void enterEmailMessage(String emailMessage) throws InterruptedException {
		
		driver.findElement(this.emailMessage).sendKeys(emailMessage);
		Thread.sleep(2000);
		
	}
	
	public void clickSendMailsDropDown(String sendMails) throws InterruptedException {
		
		dropDown.selectFromDropDown(sendMailsDropDown, sendMails);
		Thread.sleep(2000);
		
	}
	
	public void clickRecieveDropDown(String recieveEmails) throws InterruptedException {
		
		dropDown.selectFromDropDown(receiveMailsDropDown, recieveEmails);
		Thread.sleep(2000);
	}
	
	public void clickSelectFolderBtn() throws InterruptedException {
		
		driver.findElement(selectFolderBtn).click();
		Thread.sleep(3000);
	}
	
	public void addNewFolderDestination() throws InterruptedException {
		
		String newFolderName = generateRandomStrings.randomString(5);
		driver.findElement(newFolderBtn).click();
		Thread.sleep(2000);
		driver.findElement(folderNameTxtfield).sendKeys(newFolderName);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		
		
	}
	
	
}
