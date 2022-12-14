package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.NavigateUtil;
import com.qa.util.ToolBarButtonsUtil;
public class DeletePage {

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
	
	private By LatestArchived = By.xpath("//a[@class='-filename'][1]");
	private By latestArchived_CB = By.xpath("//a[@class='-filename']/preceding::input[1]");
	
	private By createNewFolder = By.xpath("//span[text()='Create new folder']");
	private By folderName = By.xpath("//input[@name='folderName']");
	private By saveButton = By.xpath("//button[text()='Save']");
	private By latestFolderName = By.xpath("//div[@class='table-cell -folder-empty']/following::a[1]");
	private By latestFolderCB = By.xpath("//div[@class='table-cell -folder-empty']/preceding::input[@type='checkbox'][1]");
	
	//private By processingBar = By.xpath("");
	
	public void clickLatestPDF_CB() {
		
		driver.findElement(LatestPDF_File_CB).click();
	}
	
	public void clickLatestArchvied_CB() {
		
		driver.findElement(latestArchived_CB).click();
	}

	public boolean isFileUploaded(String expectedFile) {

		boolean isFileUploaded = false;

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
	}
	
	public String getLatestArchivedFile() {
		
		return driver.findElement(LatestArchived).getText();
	}
	
	public void delete() throws InterruptedException {
		
		String expectedAlertMsg = "Delete this";
		String expectedCardBodyMsg = "Are you sure? This cannot be undone.";
		
		driver.findElement(deleteBtn).click();
		
		String actualAlertMsg = driver.findElement(deleteAlertMessaage).getText();
		String actualCardBodyMsg = driver.findElement(deleteCardBodyMessage).getText();
		
		System.out.println("Expected Alert Message: " + expectedAlertMsg);
		System.out.println("Actual Alert Msg: " + expectedAlertMsg);
		
		if(actualAlertMsg.contains(expectedAlertMsg)
				&& expectedCardBodyMsg.equals(actualCardBodyMsg)
				&& driver.findElement(delete_cancelButton).isDisplayed()) {
			
			driver.findElement(alertDeleteBtn).click();
			Thread.sleep(2000);
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
	
