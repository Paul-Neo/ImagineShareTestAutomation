package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.DropDownUtil;
import com.qa.util.ElementUtil;
import com.qa.util.FileFinderUtil;
import com.qa.util.GenerateRandomStrings;

public class AddNewClientPage {

	private ElementUtil elementUtil = new ElementUtil();
	private GenerateRandomStrings generateRandomNames = new GenerateRandomStrings();

	private WebDriver driver;

	public AddNewClientPage(WebDriver driver) {

		this.driver = driver;

	}

	private By clientSettingsPage = By.xpath("//span[text()='Client Settings']");
	private By newClientBtn = By.xpath("//button[text()='New Client']");
	private By createNewClientLink = By.xpath("//a[text()='Create new client']");
	private By clientNameTxtField = By.xpath("//input[@name = 'client.name']");
	private By clientIdentiferTxtField = By.xpath("//input[@name = 'client.identifier']");
	private By assignStaffDropDown = By.xpath("//div[@class='css-1wy0on6 react-select__indicators']");
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
	
	private By updateGeneralInfoBtn = By.xpath("//button[text()='Update general client info']");
	private By clientNameUpdateTxtField = By.xpath("//input[@name='client.name']");
	private By clientIdentifierUpdateTxtField = By.xpath("//input[@name='client.identifier']");
	
	private By generalInfo = By.cssSelector("div.-static p");
	
	
	public void navigateToClientSettingsPage() {

		driver.findElement(clientSettingsPage).click();
	}

	public void clickNewClientButton() {

		driver.findElement(newClientBtn).click();
	}

	public void clickCreateNewClientLink() {

		driver.findElement(createNewClientLink).click();
	}

	public void assignStaffAndSelectEngagementTypes(String StaffName, String enagagementTypes) throws InterruptedException {

		DropDownUtil dropDownUtil = new DropDownUtil(driver);
		
		By selectedEnagagementType = elementUtil.getDivXpathData(enagagementTypes);
		
		dropDownUtil.selectFromDropDown(assignStaffDropDown, StaffName);

		driver.findElement(selectedEnagagementType).click();
		
		Thread.sleep(3000);

	}
	
	public String setClientName() throws InterruptedException {
		
		
		String firstName = generateRandomNames.generateFirstName();
		String lastName = generateRandomNames.generateLastName();
		
		String clientName = firstName + " " +  lastName;
		
		System.out.println("EXPECTED CLIENT NAME IS " + clientName);
		
		driver.findElement(clientNameTxtField).sendKeys(clientName);
		
		Thread.sleep(2000);
		
		return clientName;

	}
	
	public String setClientIdentifier(String clientName) throws InterruptedException {
		
		String clientIdentifier = clientName + " TestID";
		driver.findElement(clientIdentiferTxtField).sendKeys(clientIdentifier);
		Thread.sleep(2000);
		
		return clientIdentifier;
		
	}
	
	public void clickNext() throws InterruptedException {

		driver.findElement(nextBtn).click();
		Thread.sleep(2000);
		
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
		Thread.sleep(5000);
	}

	public boolean isClientAddedSuccessfully(String clientName) throws InterruptedException {
		
		FileFinderUtil findClient = new FileFinderUtil(driver);
		driver.findElement(clientSettingsPage).click();
		findClient.clickClientName(clientName); 

		
		return driver.findElement(clientName_overview).isDisplayed();
		
	}

	public boolean isClientGeneralInfoCorrect(String clientName, String clientIdentifier, String engagementTypes) {
		
		boolean isCorrect = false;
		
		String actualCLientName = driver.findElement(generalInfo_clientName).getText();
		String actualClientIdentifier = driver.findElement(generalInfo_clientIdentifier).getText();
		String actualEngagementTypes = driver.findElement(generalInfo_engagemenTypes).getText();
		
		
		System.out.println("Actual Client Name : " + actualCLientName);
		System.out.println("Expected Client Name : " + clientName);
		
		System.out.println("Actual Client Identifer : " + actualClientIdentifier);
		System.out.println("Expected Client Identifer : " + clientIdentifier);
		
		System.out.println("Actual Client Engagment Types : " + actualEngagementTypes);
		System.out.println("Expected Client Engagment Types : " + engagementTypes);
		
		if(actualCLientName.equals(clientName)
				&& actualClientIdentifier.equals(clientIdentifier)
				&& actualEngagementTypes.contains(engagementTypes)) {

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
		
		By selectedArchivedClient = By.xpath("//div[contains(text(),'"+archivedClient+"')]/preceding::input[@type='checkbox'][1]");
		driver.findElement(selectedArchivedClient).click();
		Thread.sleep(4000);
	}
	
	public boolean isClientSuccessfullyDeleted() {
		
		return driver.findElement(noClientFoundText).isDisplayed();
	}
	
	public void clickUpdateGeneralInfo() throws InterruptedException {
		
		driver.findElement(updateGeneralInfoBtn).click();
		Thread.sleep(2000);
		
		
	}
	
	public String setNewClientName() throws InterruptedException {
		
		String newName = generateRandomNames.generateFirstName() + " " + generateRandomNames.generateLastName();
		
		driver.findElement(clientNameUpdateTxtField).clear();
		Thread.sleep(2000);
		driver.findElement(clientNameUpdateTxtField).sendKeys(newName);
		
		return newName;
		
	}
	
	public String setNewClientID(String newClientName) throws InterruptedException {
		
		String newClientID = newClientName + " testID";
		
		driver.findElement(clientIdentifierUpdateTxtField).clear();
		Thread.sleep(2000);
		driver.findElement(clientIdentifierUpdateTxtField).sendKeys(newClientID);
		
		return newClientID;
		
	}
	
	public String updateEngagementTypes() throws InterruptedException {
		
		String newEngagementTypes = "Tax Planning";
		
		By selectedEnagagementType = elementUtil.getDivXpathData(newEngagementTypes);
		
		Thread.sleep(2000);
		driver.findElement(selectedEnagagementType).click();
		
		return newEngagementTypes;
		
	}	
	
	public boolean isClientsGeneralInfoUpdated() {
		
		return  driver.findElement(generalInfo).isDisplayed();	 
		
	}
	
}