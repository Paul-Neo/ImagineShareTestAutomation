package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.util.NavigateUtil;
import com.qa.util.PageActions;
import com.qa.util.ToolBarButtonsUtil;
public class DeletePage extends PageActions{

	private WebDriver driver;
	
	public DeletePage(WebDriver driver) {

		this.driver = driver;
	}
	
	private By filesTab = By.xpath("//a[text()='Files']");
	
	private By option = By.xpath("//div[@class='-options -pointer']");
	private By viewArchivedFiles = By.xpath("//a[text()='View Archive']");
	
	private By deleteBtn = By.xpath("//button[contains(text(),'Delete')]");
	private By alertDeleteBtn = By.xpath("//button[@class='yt-btn danger']");
	private By deleteAlertMessaage = By.xpath("//div[@class='card-header alert-message danger']");
	private By deleteCardBodyMessage = By.xpath("//div[@class='card-body']");
	private By delete_cancelButton = By.xpath("//button[text()='Cancel']");
	
	private By latestPDF_fileName = By.xpath("//div[@class='table-cell -pdf-80']/following::a[1]");
	private By LatestPDF_File_CB = By.xpath("//div[@class='table-cell -pdf-80']/preceding::input[1]");
	
	private By createNewFolder = By.xpath("//span[text()='Create new folder']");
	private By folderName = By.xpath("//input[@name='folderName']");
	private By saveButton = By.xpath("//button[text()='Save']");
	private By latestFolderName = By.xpath("//div[@class='table-cell -folder-empty']/following::a[1]");
	private By latestFolderCB = By.xpath("//div[@class='table-cell -folder-empty']/preceding::input[@type='checkbox'][1]");
	
	public void clickLatestPDF_CB() {
		
		driver.findElement(LatestPDF_File_CB).click();
	}
	

	public boolean isFileUploaded(String expectedFile) throws InterruptedException {

		boolean isFileUploaded = false;

		Thread.sleep(2000);
		String latestFile = driver.findElement(latestPDF_fileName).getText();

	//	expectedFile = expectedFile + " (New)";

		System.out.println("Latest File: " + latestFile);
		System.out.println("Expected File: " + expectedFile);

		if (latestFile.equals(expectedFile)) {

			isFileUploaded = true;

		}
		return isFileUploaded;
	}
	
	public void clickArchive() throws InterruptedException {

		ToolBarButtonsUtil toolbarButtons = new ToolBarButtonsUtil(driver);
		toolbarButtons.clickArchive();
		
	}
	
	public void navToArchivedFiles() throws InterruptedException {
		
		driver.findElement(option).click();
		driver.findElement(viewArchivedFiles).click();
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	public void delete() throws InterruptedException {
		
		String expectedAlertMsg = "Delete this";
		String expectedCardBodyMsg = "Are you sure? This cannot be undone.";
		
		clickOn(driver, deleteBtn);
		
		String actualAlertMsg = driver.findElement(deleteAlertMessaage).getText();
		String actualCardBodyMsg = driver.findElement(deleteCardBodyMessage).getText();
		
		System.out.println("Expected Alert Message: " + expectedAlertMsg);
		System.out.println("Actual Alert Msg: " + expectedAlertMsg);
		
		if(actualAlertMsg.contains(expectedAlertMsg)
				&& expectedCardBodyMsg.equals(actualCardBodyMsg)
				&& isElementDisplayed(driver, delete_cancelButton)) {
			
			clickOn(driver, alertDeleteBtn);
			
			Thread.sleep(5000);
		}
		
		
	}
	
	public void navigateToClientWorkspace(String clientWorkspace) throws InterruptedException {
		
		NavigateUtil nav = new NavigateUtil(driver);
		nav.navigateToClientWorkspace(clientWorkspace);
		driver.findElement(filesTab).click();
		
	}

	public void createNewFolder(String folderName) throws InterruptedException {
		
		ToolBarButtonsUtil toolBarUtil = new ToolBarButtonsUtil(driver);
		
		toolBarUtil.clickNewFolder(createNewFolder);
		Thread.sleep(5000);
		driver.findElement(this.folderName).sendKeys(folderName);
		driver.findElement(saveButton).click();
		driver.navigate().refresh();
	}
	
	public String getLatestFolderName() {
		
		return driver.findElement(latestFolderName).getText();		

	}
	
	public void clickLatestFolderCB() {
		
		driver.findElement(latestFolderCB).click();
	}
	
	public void refresh() {
		
		driver.navigate().refresh();
	}
	
	
}
	
