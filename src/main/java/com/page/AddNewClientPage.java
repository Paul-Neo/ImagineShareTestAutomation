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
	private GenerateRandomStrings generateRandomStrings = new GenerateRandomStrings();

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
	
	//General Info - Add Primary number
	private By addPhoneBtn = By.xpath("//button[text()=' Add phone']");
	private By phoneTypeDropdown = By.xpath("//strong[text()='Primary Phone']/following::div[@class='css-1wy0on6 react-select__indicators'][1]");
	private By phoneNumberTxtField = By.xpath("//input[@type='tel']");
	private By setAsPrimaryLink = By.xpath("//small[contains(text(),'Primary')]");
	private By addPhoneNumberBtn = By.xpath("//button[text()='Add Phone Number']");
	private By primaryPhoneNumber = By.xpath("//p[text()='Mobile:']/following::p[1]");
	
	//General Ino - Add Primary Address
	private By addAddressBtn = By.xpath("//button[text()=' Add address']");
	private By streetAddress1TextField = By.xpath("//input[@name='address.street1']");
	private By streetAddress2TextField = By.xpath("//input[@name='address.street2']");
	private By cityTextField = By.xpath("//input[@name='address.city']");
	private By postalCodeTextField = By.xpath("//input[@name='address.postal']");
	private By addAddress2Btn = By.xpath("//button[text()='Add Address']");
	private String dropDown = "//label[text()='{0}']/following::div[@class='css-1wy0on6 react-select__indicators'][1]";
	private By fullAddressLabel = By.xpath("//div[@class='-address']");
	
	public void navigateToClientSettingsPage() {

		driver.findElement(clientSettingsPage).click();
	}

	public void clickAddAddress() throws InterruptedException {
		
		driver.findElement(addAddressBtn).click();
		Thread.sleep(2000);
		
	}
	
	public void clickNewClientButton() {

		driver.findElement(newClientBtn).click();
	}

	public void clickSetPrimary() throws InterruptedException {
		
		driver.findElement(setAsPrimaryLink).click();
		Thread.sleep(3000);
	}
	
	public void clickCreateNewClientLink() {

		driver.findElement(createNewClientLink).click();
	}
	
	public void clickNext() throws InterruptedException {

		driver.findElement(nextBtn).click();
		Thread.sleep(2000);
		
	}

	public void assignStaffAndSelectEngagementTypes(String StaffName, String enagagementTypes) throws InterruptedException {

		DropDownUtil dropDownUtil = new DropDownUtil(driver);
		
		By selectedEnagagementType = elementUtil.getDivXpathData(enagagementTypes);
		
		dropDownUtil.selectFromDropDown(assignStaffDropDown, StaffName);

		driver.findElement(selectedEnagagementType).click();
		
		Thread.sleep(3000);

	}
	
	public String setClientName() throws InterruptedException {
		
		
		String firstName = generateRandomStrings.generateFirstName();
		String lastName = generateRandomStrings.generateLastName();
		
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
	
	public void clickAddAddress2() throws InterruptedException {
		
		driver.findElement(addAddress2Btn).click();
		Thread.sleep(2000);
	}
	
	public String setStreetAddress1() throws InterruptedException {
		
		String address = generateRandomStrings.generateAddress1();
		
		driver.findElement(streetAddress1TextField).sendKeys(address);
		Thread.sleep(2000);
		
		return address;
	}
	
	public String setStreetAddress2() throws InterruptedException {
		
		String address = generateRandomStrings.generateAddress2();
		
		driver.findElement(streetAddress2TextField).sendKeys(address);
		Thread.sleep(2000);
		
		return address;
	}
	
	public String setCity() throws InterruptedException {
		
		String city = generateRandomStrings.generateCity();
		
		driver.findElement(cityTextField).sendKeys(city);
		Thread.sleep(2000);
		
		return city;
		
	}
	
	public String setPostalCode() throws InterruptedException {
		
		String postalCode = generateRandomStrings.generatePostalCode();
		
		driver.findElement(postalCodeTextField).sendKeys(postalCode);
		Thread.sleep(2000);
		
		return postalCode;
	}
	
	public String selectValueInAddressDropdown(String labelName, String selectedValue) {
		
		//Set Country or Set State
		
		DropDownUtil dropdown = new DropDownUtil(driver);
		
		By dropDownElement = By.xpath(dropDown.replace("{0}", labelName));
		
		dropdown.selectFromDropDown(dropDownElement, selectedValue);
		
		
		return selectedValue;
		
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
		
		String newName = generateRandomStrings.generateFirstName() + " " + generateRandomStrings.generateLastName();
		
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
	
	public void setPhoneNumber() throws InterruptedException {
		
		DropDownUtil dropDown = new DropDownUtil(driver);
		
		String phoneNumber = generateRandomStrings.generatePhoneNumber();
		
		
		driver.findElement(addPhoneBtn).click();
		dropDown.selectFromDropDown(phoneTypeDropdown, "Mobile");
		driver.findElement(phoneNumberTxtField).sendKeys(phoneNumber);
		Thread.sleep(5000);
		driver.findElement(addPhoneNumberBtn).click();
		Thread.sleep(3000);
	
		
	}
	
	public boolean isPhoneNumberSetAsPrimary() {
		
		return driver.findElement(primaryPhoneNumber).isDisplayed();
	}
	
	public String getFullAddress() {
		
		return driver.findElement(fullAddressLabel).getText();
		
	}
	
	
}