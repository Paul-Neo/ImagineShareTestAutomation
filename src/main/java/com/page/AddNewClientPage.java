package com.page;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.DropDownUtil;
import com.qa.util.ElementUtil;
import com.qa.util.FileFinderUtil;
import com.qa.util.GenerateRandomStrings;
import com.qa.util.PageActions;

public class AddNewClientPage extends PageActions{

	private ElementUtil elementUtil = new ElementUtil();
	private GenerateRandomStrings generateRandomStrings = new GenerateRandomStrings();

	private WebDriver driver;

	public AddNewClientPage(WebDriver driver) {

		this.driver = driver;

	}

//	private By clientSettingsPage = By.xpath("//span[text()='Client Settings']");
	private By allWorkspacesPage = By.xpath("//span[text()='All ' and text()=' Workspaces']");
	private By newClientBtn = By.xpath("//button[text()='New Client']");
	private By createNewClientLink = By.xpath("//a[text()='Create New Client']");
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
	private By archiveLists = By.xpath("//div[@class='table-cell' and @style='white-space: initial; min-width: 150px;']//div[@class='overflow-hidden']");
	
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
	
	//General Info - Add Primary Address
	private By addAddressBtn = By.xpath("//button[text()=' Add address']");
	private By streetAddress1TextField = By.xpath("//input[@name='address.street1']");
	private By streetAddress2TextField = By.xpath("//input[@name='address.street2']");
	private By cityTextField = By.xpath("//input[@name='address.city']");
	private By postalCodeTextField = By.xpath("//input[@name='address.postal']");
	private By addAddress2Btn = By.xpath("//button[text()='Add Address']");
	private String dropDown = "//label[text()='{0}']/following::div[@class='css-1wy0on6 react-select__indicators'][1]";
	private By fullAddressLabel = By.xpath("//div[@class='-address']");
	
	/*Page Actions*/
	
	public void navigateToClientSettingsPage() {

		
		clickOn(driver, allWorkspacesPage);
	}

	public void clickAddAddress() throws InterruptedException {
		
		clickOn(driver, addAddressBtn);
			
	}
	
	public void clickNewClientButton() {
		
		clickOn(driver, newClientBtn);
		
	}

	public void clickSetPrimary() throws InterruptedException {
		
		
		clickOn(driver, setAsPrimaryLink);
	}
	
	public void clickCreateNewClientLink() {
		
		clickOn(driver, createNewClientLink);
		
	}
	
	public void clickNext() throws InterruptedException {

		clickOn(driver, nextBtn);
		
	}

	public void assignStaffAndSelectEngagementTypes(String StaffName, String enagagementTypes) throws InterruptedException {

		DropDownUtil dropDownUtil = new DropDownUtil(driver);
		
		By selectedEnagagementType = elementUtil.getDivXpathData(enagagementTypes);
		
		dropDownUtil.selectFromDropDown(assignStaffDropDown, StaffName);
		
		clickOn(driver, selectedEnagagementType);
		
	}
	
	public void clickAddAddress2() throws InterruptedException {
		
		clickOn(driver, addAddress2Btn);
		
	}
	
	public String selectValueInAddressDropdown(String labelName, String selectedValue) {
		
		//Set Country or Set State
		DropDownUtil dropDownUtil = new DropDownUtil(driver);
		By dropDownElement = By.xpath(dropDown.replace("{0}", labelName));
		dropDownUtil.selectFromDropDown(dropDownElement, selectedValue);
		
		return selectedValue;
		
	}
	
	public void sleep() throws InterruptedException {
		
		sleep(3000);
//		refreshPage(driver);
	}
	
	/*Setters*/
	
	public String setClientName() throws InterruptedException {
		
		String firstName = generateRandomStrings.generateFirstName();
		String lastName = generateRandomStrings.generateLastName();
		
		String clientName = firstName + " " +  lastName;
		
		System.out.println("EXPECTED CLIENT NAME IS " + clientName);
		sendKeys(driver, clientNameTxtField, clientName);
		
		Thread.sleep(2000);
		
		return clientName;

	}
	
	public String setClientIdentifier(String clientName) throws InterruptedException {
		
		String clientIdentifier = clientName + " TestID";
		
		sendKeys(driver, clientIdentiferTxtField, clientIdentifier);
		
		return clientIdentifier;
		
	}
	
	public String setStreetAddress1() throws InterruptedException {
		
		String address = generateRandomStrings.generateAddress1();
		
		sendKeys(driver, streetAddress1TextField, address);
		
		return address;
	}
	
	public String setStreetAddress2() throws InterruptedException {
		
		String address = generateRandomStrings.generateAddress2();		
		
		sendKeys(driver, streetAddress2TextField, address);
		
		return address;
	}
	
	public String setCity() throws InterruptedException {
		
		String city = generateRandomStrings.generateCity();
		
		sendKeys(driver, cityTextField, city);
		
		return city;
		
	}
	
	public String setPostalCode() throws InterruptedException {
		
		String postalCode = generateRandomStrings.generatePostalCode();
		
		sendKeys(driver, postalCodeTextField, postalCode);
		
		return postalCode;
	}
	
	/*Getters*/
	
	public List<String> getArchiveLists() {
		
		List<String> list = new ArrayList<String>();
		List<WebElement> archiveLists = driver.findElements(this.archiveLists);
		
		for(WebElement e : archiveLists) {
			
			String listOfArchive = e.getText();
			System.out.println("Archive Names: " + listOfArchive);
			list.add(listOfArchive);
		}
		
		return list;
		
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

		clickOn(driver, saveBtn);
	}
	

	public boolean isClientAddedSuccessfully(String clientName) throws InterruptedException {
		
		FileFinderUtil findClient = new FileFinderUtil(driver);
		
		clickOn(driver, allWorkspacesPage);
		findClient.clickClientName(clientName); 
			
		return isElementDisplayed(driver, clientName_overview);
		
	}

	public boolean isClientGeneralInfoCorrect(String clientName, String clientIdentifier, String engagementTypes) {
		
		boolean isCorrect = false;
		
		String actualCLientName = getElementText(driver, generalInfo_clientName);
		String actualClientIdentifier = getElementText(driver, generalInfo_clientIdentifier);
		String actualEngagementTypes = getElementText(driver, generalInfo_engagemenTypes);
		
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
		
		clickOn(driver, viewArchiveOptionBtn);
		clickOn(driver, viewArchiveLink);
		
		return isElementDisplayed(driver, elementUtil.getDivXpathData(archivedClientName));
	
	}
	
	public void selectClientFromArchivedList(String archivedClient) throws InterruptedException {
		
		By selectedArchivedClient = By.xpath("//div[contains(text(),'"+archivedClient+"')]/preceding::input[@type='checkbox'][1]");
		
		clickOn(driver, selectedArchivedClient);
		
	}
	
	public boolean isClientSuccessfullyDeleted(String deletedClientName) {
		
		List<String> archiveNames = getArchiveLists();
	
		boolean isDeleted = false;
		
		if(!archiveNames.contains(deletedClientName)) {
			
			isDeleted = true;
		}
		
		return isDeleted;
	}
	
	public void clickUpdateGeneralInfo() throws InterruptedException {
		
		clickOn(driver, updateGeneralInfoBtn);
		
	}
	
	public String setNewClientName() throws InterruptedException {
		
		String newName = generateRandomStrings.generateFirstName() + " " + generateRandomStrings.generateLastName();
		
		clearText(driver, clientNameUpdateTxtField);
		sendKeys(driver, clientNameUpdateTxtField, newName);
		
		return newName;
		
	}
	
	public String setNewClientID(String newClientName) throws InterruptedException {
		
		String newClientID = newClientName + " testID";
		
		clearText(driver, clientIdentifierUpdateTxtField);
		sendKeys(driver, clientIdentifierUpdateTxtField, newClientID);
		
		return newClientID;
		
	}
	
	public String updateEngagementTypes() throws InterruptedException {
		
		String newEngagementTypes = "Tax Planning";
		
		By selectedEnagagementType = elementUtil.getDivXpathData(newEngagementTypes);
		
		Thread.sleep(2000);
		
		clickOn(driver, selectedEnagagementType);
		
		return newEngagementTypes;
		
	}	
	
	public boolean isClientsGeneralInfoUpdated() {
		
		return isElementDisplayed(driver, generalInfo);
		
	}
	
	public void setPhoneNumber() throws InterruptedException {
		
		DropDownUtil dropDown = new DropDownUtil(driver);
		
		String phoneNumber = generateRandomStrings.generatePhoneNumber();
		
		clickOn(driver, addPhoneBtn);
		dropDown.selectFromDropDown(phoneTypeDropdown, "Mobile");
		sendKeys(driver, phoneNumberTxtField, phoneNumber);
		clickOn(driver, addPhoneNumberBtn);
		
	}
	
	public boolean isPhoneNumberSetAsPrimary() {
		
		
		return isElementDisplayed(driver, primaryPhoneNumber);
	}
	
	public String getFullAddress() {
		
		return getElementText(driver, fullAddressLabel);
		
	}
	
}