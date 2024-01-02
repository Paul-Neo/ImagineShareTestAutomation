package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.util.DropDownUtil;
import com.qa.util.PageActions;
import com.qa.util.ScrollUtil;
import com.qa.util.ToolBarButtonsUtil;
import com.qa.util.URL;

public class UploadPage extends PageActions{

	private WebDriver driver;
	private URL url = new URL();
	
	public UploadPage(WebDriver driver) {

		this.driver = driver;
	}

	private By newFileBtn = By.xpath("//button[text()='New File']");
	private By uploadNewFileBtn = By.xpath("//span[text()='Upload new files']");
	private By headerText = By.xpath("//div[@class='card-header']");
	private By browse = By.xpath("//input[@multiple and @type='file']");
	private By saveAndUpload = By.xpath("//button[text()='Upload & save']");
	private By latestPDF_File = By.xpath("//div[@class='table-cell -pdf-80']/following::a");
	private By fileSubtask = By.xpath("//div[@class='table-cell -pdf-80']");
	private By rename = By.xpath("//a[text()='Rename ']");
	private By renameInput = By.xpath("//input[@name='newFilename']");
	private By save = By.xpath("//button[contains(text(),'ave')]");
	private By errorMessage = By.xpath("//p[contains(text(),'A')]");
	private By createNewFolder = By.xpath("//span[text()='Create new folder']");
	private By folderName = By.xpath("//input[@name='folderName']");
	private By FirmSettings = By.xpath("//span[text()='Firm Settings']");
//	private By latestHidden_PDF_File = By.xpath("//i[@class='u-danger fad fa-eye-slash -pointer']/preceding::a[@class='-filename']");
	private By details = By.xpath("//span[text()='Details']");
	private By fileStatus = By.xpath("//small[text()='Status:']/following::div[@class][1]");
	
	//Advance Settings elements
	
	private By advanceSettingsTab = By.xpath("//a[text()='Advanced Settings']");
	private By editBtn = By.xpath("//button[text()='Edit']");
	private By fileUploadSettingsDropDown = By.xpath("//div[text()='Default Status of Newly Uploaded Files']/following::div[@class='css-1wy0on6 react-select__indicators'][1]");
	private By updateBtn = By.xpath("//button[text()='Update']");
	
	
	public void uploadFiles() throws InterruptedException {
			
		ToolBarButtonsUtil toolBarButtons = new ToolBarButtonsUtil(driver);
		
		toolBarButtons.uploadNewFiles();
			
	}
	
	public void renameFile(String newName) throws InterruptedException {
		
		driver.findElement(fileSubtask).click();
		driver.findElement(rename).click();
		driver.findElement(renameInput).sendKeys(newName);
		driver.findElement(save).click();
		Thread.sleep(2000);
	}

	public String getHeaderText() throws InterruptedException {

		Thread.sleep(2000);
		return driver.findElement(headerText).getText();
	}

	public void browseFile(String fileName) {

		String fileLoc = url.getFileLoc() + fileName;

		driver.findElement(browse).sendKeys(fileLoc);

	}

	public void clickSave() throws InterruptedException {

		driver.findElement(saveAndUpload).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	public boolean isFileUploaded(String expectedFileName) {

		boolean isFileUploaded;
//		expectedFileName = expectedFileName + " (New)";
//		expectedFileName = expectedFileName + " (New)";
		String latest = driver.findElement(latestPDF_File).getText();

		System.out.println("latest file is: " + latest);
		System.out.println("Expected File is: " + expectedFileName);

		if (latest.equals(expectedFileName)) {

			System.out.println("File Uploaded Successfully!!");
			isFileUploaded = true;
		}

		else {

			System.out.println("File has not been uploaded");
			isFileUploaded = false;
		}

		return isFileUploaded;
	}

	public DeletePage doFileUpload(String fileName) throws InterruptedException {

		String fileLoc = url.getFileLoc() + fileName;
		ScrollUtil scroll = new ScrollUtil(driver);
		
		scroll.scrollPage(-1500);
		
//		driver.findElement(newFileButton).click();
//		Thread.sleep(2000);
//		driver.findElement(uploadNewFiles).click();
//		Thread.sleep(2000);
//		driver.findElement(browse).sendKeys(fileLoc);
//		Thread.sleep(2000);
//		driver.findElement(saveAndUpload).click();
//		Thread.sleep(5000);
//		driver.navigate().refresh();
//		Thread.sleep(7000);
		
		clickOn(driver, newFileBtn);
		clickOn(driver, uploadNewFileBtn);
		sleep(0);
//		sendKeys(driver, browse, fileLoc);
		driver.findElement(browse).sendKeys(fileLoc);
//		sendKeys(driver, browse, fileLoc);
		sleep(5000);
		clickOn(driver, saveAndUpload);
		sleep(3000);
//		refreshPage(driver);
//		sleep(3000);
		
		
		return new DeletePage(driver);
	}
	
	public String renameWithInvalidChar() throws InterruptedException {
		
		driver.findElement(fileSubtask).click();
		driver.findElement(rename).click();
		
		return doInvalidCharCheck(renameInput);
	}
	
	public String createFolderWithInvalidChar() throws InterruptedException {
		
		ToolBarButtonsUtil toolBarButtons = new ToolBarButtonsUtil(driver);
		
		toolBarButtons.clickNewFolder(createNewFolder);
		
		return doInvalidCharCheck(folderName);
	}
	
	public String doInvalidCharCheck(By textField) throws InterruptedException {
		
		String invalidChars[] = {"/",":","*","?","<",">","|",};
		String expectedErrorMessage = "";
		int errorMessageCount = 0;
		int invalidCharsCount = invalidChars.length;
		boolean isErrorMessageDisplayedCorrectly = false;
		
		for(int x = 0; x<invalidCharsCount; x++) {
			
			driver.findElement(textField).sendKeys(invalidChars[x]);
			boolean saveButtonDisabled = driver.findElement(save).isEnabled();
			
			if(driver.findElement(errorMessage).isDisplayed() && saveButtonDisabled == false ) {
				
				isErrorMessageDisplayedCorrectly = true;
				
				expectedErrorMessage = driver.findElement(errorMessage).getText();
				System.out.println("Error Message : " + expectedErrorMessage);
				
				errorMessageCount ++;
				
				driver.findElement(textField).clear();
				
				Thread.sleep(1000);
				
			}
		
		}
		
		System.out.println("Array Lenght is: " + invalidCharsCount);
		System.out.println("Error Count is: " + errorMessageCount);
		
		if(invalidCharsCount == errorMessageCount) {
			
			System.out.println("Is Error Message displayed Correctly? " + isErrorMessageDisplayedCorrectly);
		}
			
		return expectedErrorMessage;
	}

	public void setDefaultFileUploads(String fileUploadSettings) throws InterruptedException {
		
		DropDownUtil dropDown = new DropDownUtil(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(FirmSettings).click();
		driver.findElement(advanceSettingsTab).click();
		driver.findElement(editBtn).click();
		
		js.executeScript("window.scrollBy(0,-1500)");
		Thread.sleep(2000);
		
		dropDown.selectFromDropDown(fileUploadSettingsDropDown, fileUploadSettings);
		driver.findElement(updateBtn).click();
		
	}
	
	public String checkFileVisibilityStatus() {

		
		driver.findElement(latestPDF_File).click();
		driver.findElement(details).click();
		
		return driver.findElement(fileStatus).getText();
	}
}
