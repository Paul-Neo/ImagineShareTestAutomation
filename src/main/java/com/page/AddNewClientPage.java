package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.DropDownUtil;
import com.qa.util.ElementUtil;
import com.qa.util.FileFinderUtil;

public class AddNewClientPage {

	private ElementUtil elementUtil = new ElementUtil();

	private WebDriver driver;

	public AddNewClientPage(WebDriver driver) {

		this.driver = driver;

	}

	private By clientSettingsPage = By.xpath("//span[text()='Client Settings']");
	private By newClientBtn = By.xpath("//button[text()='New Client']");
	private By createNewClientLink = By.xpath("//a[text()='Create new client']");
	private By clientName = By.xpath("//input[@name = 'client.name']");
	private By clientIdentifier = By.xpath("//input[@name = 'client.identifier']");
	private By dropDown = By.xpath("//div[@class='css-1wy0on6 react-select__indicators']");
	private By nextBtn = By.xpath("//button[text()='Next']");
	private By staffNotifications = By.cssSelector("div.client-form label");
	private By saveBtn = By.xpath("//button[text()='Save']");
	
	// Delete 
	private By clientName_overview = By.xpath("//h1[@class='-visible']");
//	private By archiveBtn = By.xpath("//button[text()='Archive Clients']");
	private By viewArchiveOptionBtn = By.xpath("//div[@class='-options -yt-edit-option']");
	private By viewArchiveLink = By.xpath("//a[text()='View Archive']");
	private By noClientFoundText = By.xpath("//h2[text()='No client found.']");
	
	
	
	//General Info
	private By generalInfo_clientName = By.xpath("//small[text()='Client name']/following::p[1]");
	private By generalInfo_clientIdentifier = By.xpath("//small[text()='Client identifier']/following::p[1]");
	private By generalInfo_engagemenTypes = By.xpath("//small[text()='Engagement types']/following::p[1]");
	
	
	
	
	public void navigateToClientSettingsPage() {

		driver.findElement(clientSettingsPage).click();
	}

	public void clickNewClientButton() {

		driver.findElement(newClientBtn).click();
	}

	public void clickCreateNewClientLink() {

		driver.findElement(createNewClientLink).click();
	}

	public void enterClientInfo(String clientName, String clientIdentifier, String StaffName, String enagagementTypes) {

		DropDownUtil dropDownUtil = new DropDownUtil(driver);

		By selectedEnagagementType = elementUtil.getDivXpathData(enagagementTypes);

		driver.findElement(this.clientName).sendKeys(clientName);
		driver.findElement(this.clientIdentifier).sendKeys(clientIdentifier);

		dropDownUtil.selectFromDropDown(dropDown, StaffName);

		driver.findElement(selectedEnagagementType).click();

	}

	public void clickNext() {

		driver.findElement(nextBtn).click();
	}

	public List<String> getStaffNotifications() {

		List<String> list = new ArrayList<>();
		List<WebElement> notificationList = driver.findElements(staffNotifications);

		for (WebElement e : notificationList) {

			String notificationName = e.getText();
			System.out.println("Notification Name: " + notificationName);
			list.add(notificationName);

		}

		return list;

	}

	public void clickSave() throws InterruptedException {

		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	public boolean isClientAddedSuccessfully(String clientName) {

		//return driver.findElement(clientName_overview).getText();
		
		FileFinderUtil findClient = new FileFinderUtil(driver);
		
		driver.findElement(clientSettingsPage).click();
		
		findClient.clickClientName(clientName);
		return driver.findElement(clientName_overview).isDisplayed();
		

	}

	public boolean isClientGeneralInfoCorrect(String clientName, String clientIdentifier, String engagementTypes) {
		
		boolean isCorrect = false;
		
		String expectedClientName = driver.findElement(generalInfo_clientName).getText();
		String expectedClientIdentifier = driver.findElement(generalInfo_clientIdentifier).getText();
		String expectedEngagementTypes = driver.findElement(generalInfo_engagemenTypes).getText();
		
		if(expectedClientName.equals(clientName)
				&& expectedClientIdentifier.equals(clientIdentifier)
				&& expectedEngagementTypes.equals(expectedEngagementTypes)) {

			isCorrect = true;
		}
			
		return isCorrect;
		
	}
	
	public void selectClient(String clientName) throws InterruptedException {

		FileFinderUtil findClient = new FileFinderUtil(driver);
		
		findClient.clickaCheckbox(clientName);
		
	}

	public boolean isClientMovedToArchived(String archivedClientName) {
		
		driver.findElement(viewArchiveOptionBtn).click();
		driver.findElement(viewArchiveLink).click();
		return driver.findElement(elementUtil.getDivXpathData(archivedClientName)).isDisplayed();
	
	}
	
	public void selectClientFromArchivedList(String archivedClient) throws InterruptedException {
		
		By selectedArchivedClient = By.xpath("//div[contains(text(),'Thomas Shelby')]/preceding::input[@type='checkbox'][1]");
		driver.findElement(selectedArchivedClient).click();
		Thread.sleep(4000);
	}
	
	public boolean isClientSuccessfullyDeleted() {
		
		return driver.findElement(noClientFoundText).isDisplayed();
	}
	

}