package com.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.CheckBoxUtil;
import com.qa.util.GenerateRandomStrings;
import com.qa.util.ToolBarButtonsUtil;

public class FolderTemplatePage {

	private WebDriver driver;
	private GenerateRandomStrings generateRandomStrings = new GenerateRandomStrings();

	public FolderTemplatePage(WebDriver driver) {

		this.driver = driver;
	}

	// Create Template

	private By newTemplateButton = By.xpath("//a[text()='New template']");
	private By headerMessage = By.xpath("//div[text()='Create Template']");
	private By folderTemplateNameTextField = By.xpath("//input[@name='folderTemplate.name']");
	private By descriptionTextField = By.xpath("//input[@name='folderTemplate.description']");
	private By createTemplateButton = By.xpath("//button[text()='Create Template']");

	private By templateNames = By.xpath("//a[@class='-filename']");
	private By selectedfolderTemplateName = By.xpath("//div[text()='Update Template']/following::small[text()]");
	private By newFolderButton = By.xpath("//div[@class='-folder-row-list ']");

	// Delete Template

	private By folderTemplateSettings = By.xpath("//i[@class='far fa-ellipsis-v']");
	private By delete = By.xpath("//a[text()='Delete']");
	private By deleteSelectedFolderTemplate = By.cssSelector("div.card-body b");
	private By alertBoxHeader = By.xpath("//div[@class='card-header alert-message danger']");
	private By alertBoxOkBtn = By.xpath("//button[text()='Okay']");
	private By cancelBtn = By.xpath("//button[text()='Cancel']");

	// Apply Template

	private By applyFolderTemplate = By.xpath("//span[text()='Apply folder template']");
	private By selectFolderTemplateBtn = By.xpath("//button[text()='Select folder template']");
	private By doneBtn = By.xpath("//button[text()='Done']");
	private By selectedTemplateReady = By.xpath("//div[@class='-title']");
	private By applyTemplateBtn = By.xpath("//button[text()='Apply Template']");
	private By latestAppliedTemplate = By.xpath("//div[@class='table-cell -folder-template']/following::a[1]");
	private By expectedFoldersCount = By.xpath(
			"//a[contains(text(),'Paul Template2')]/preceding::input[@type='radio'][1]/following::div[@style='min-width: 150px;'][1]");
	private By actualFoldersCount = By.xpath("//div[@class='table-head']/following::div[@class='table-cell' and text()='5']");
	

	// actions

	public void clickNewTemplateButton() throws InterruptedException {

		driver.findElement(newTemplateButton).click();
		Thread.sleep(5000);
	}
	
	public void clickCreateTemplate() throws InterruptedException {

		driver.findElement(createTemplateButton).click();
		Thread.sleep(2000);
	}


	public void clickNewFolderButton() throws InterruptedException {

		driver.findElement(newFolderButton).click();
		Thread.sleep(2000);
	}

	// setters

	public String setFolderTemplateName() throws InterruptedException {

		String folderTemplateName = generateRandomStrings.generateFirstName() + " Template Folder Test";
		
		driver.findElement(folderTemplateNameTextField).clear();
		Thread.sleep(2000);
		driver.findElement(folderTemplateNameTextField).sendKeys(folderTemplateName);
		Thread.sleep(2000);

		return folderTemplateName;

	}

	public void setFolderTemplateDescription(String descriptionName) throws InterruptedException {

		driver.findElement(descriptionTextField).sendKeys(descriptionName);
		Thread.sleep(2000);
	}

	// getters

	public String getHeaderMessage() throws InterruptedException {

		Thread.sleep(2000);
		return driver.findElement(headerMessage).getText();

	}

	
	public String getFolderTemplateName() {

		driver.findElement(templateNames).click();
		return driver.findElement(selectedfolderTemplateName).getText();

	}

	public void clickCancelBtn() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(cancelBtn).click();
	}

	public void openFolderTemplateSettings() throws InterruptedException {

		driver.findElement(folderTemplateSettings).click();
		Thread.sleep(3000);

	}

	public void chooseDelete() throws InterruptedException {

		driver.findElement(delete).click();
		Thread.sleep(3000);

	}

	public String getAlertBoxHeader(String header) {

		return driver.findElement(alertBoxHeader).getText();
	}

	public String getSelectedTemplateNameForDeletion() {

		return driver.findElement(deleteSelectedFolderTemplate).getText();
	}

	public void clickOkBtn() throws InterruptedException {

		driver.findElement(alertBoxOkBtn).click();
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	public List<String> getTemplateList() {

		List<String> list = new ArrayList<>();
		List<WebElement> templateLists = driver.findElements(templateNames);

		for (WebElement e : templateLists) {

			String templateNames = e.getText();
			System.out.println("Template Name: " + templateNames);
			list.add(templateNames);
		}

		return list;

	}

	public void selectApplyFolderTemplate() throws InterruptedException {

		ToolBarButtonsUtil toolBar = new ToolBarButtonsUtil(driver);

		toolBar.clickNewFolder(applyFolderTemplate);

	}

	public void clickSelectFolderTemplateBtn() {

		driver.findElement(selectFolderTemplateBtn).click();
	}

	public int selectTemplate(String templateName) throws InterruptedException {

		CheckBoxUtil clickRadioBtn = new CheckBoxUtil();

		By selectedTemplate = clickRadioBtn.getaPrecedingRadiobtn(templateName);
		Thread.sleep(2000);
		driver.findElement(selectedTemplate).click();

		String count = driver.findElement(this.expectedFoldersCount).getText();
		int expectedFoldersCount = Integer.parseInt(count);

		return expectedFoldersCount;

	}

	public void clickDone() {

		driver.findElement(doneBtn).click();

	}

	public boolean isTemplateReadyToApply() {

		return driver.findElement(selectedTemplateReady).isDisplayed();
	}

	public void clickApplyTemplateBtn() throws InterruptedException {

		driver.findElement(applyTemplateBtn).click();
		Thread.sleep(5000);
	}

	public String getLatestAppliedTemplate() {

		return driver.findElement(latestAppliedTemplate).getText();
	}

	public int getAppliedTemplateFoldersCount() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(latestAppliedTemplate).click();
		Thread.sleep(3000);
		String count = driver.findElement(actualFoldersCount).getText();
		
		System.out.println("FOLDER COUNT: " + count);

		int actualCount = Integer.parseInt(count);
		
		

		return actualCount + 1;
	}

	public int getTemplateFolderCount() {

		return driver.findElements(templateNames).size();
	}

}
