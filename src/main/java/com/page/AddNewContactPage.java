package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.CheckBoxUtil;
import com.qa.util.DropDownUtil;
import com.qa.util.FileFinderUtil;
import com.qa.util.GenerateRandomStrings;
import com.qa.util.NavigateUtil;
import com.qa.util.PageActions;

public class AddNewContactPage extends PageActions{

	private WebDriver driver;
	private GenerateRandomStrings generateRandomStrings = new GenerateRandomStrings();

	public AddNewContactPage(WebDriver driver) {
		this.driver = driver;
	}

	private By workspacesPage = By.xpath("//span[text()='Workspaces']");
	private By contactsList = By.cssSelector("tbody a");
	private By addContactsBtn = By.xpath("//button[text()='Add Contacts']");
	private By emailAddressTxtField = By.xpath("//input[@name='email']");
	private By fullNameTxtField = By.xpath("//input[@name='fullname']");
	private By personalNoteTxtField = By.xpath("//textarea[@name='personalNote']");
	private By sendNowBtn = By.xpath("//span[text()=' Send now']");
	private By uploadAndSendInviteBtn = By.xpath("//button[text()='Yes, upload and send invite']");
	private By InvitationResultModelCloseBtn = By.xpath("//button[text()='Close']");
	private By archiveContactsBtn = By.xpath("//button[text()='Archive Contacts']");
	private By viewArchiveOptionBtn = By.xpath("//div[@class='-options -yt-edit-option']");
	private By viewArhiveLink = By.xpath("//a[text()='View Archive']");
	private By deleteContactsBtn = By.xpath("//button[text()='Delete Contacts ']");
	private By alertDeleteBtn = By.xpath("//div[@class='alert-modal modal-anim-enter-done']//button[@class='yt-btn danger' and text()='Delete']");
	private By chooseFromExistingContactsBtn = By.xpath("//button[text()='Choose from existing contacts']");
	private By existingContactsDropDown = By.xpath("//div[@class='css-1wy0on6 react-select__indicators']");
	private By removeFromClientBtn = By.xpath("//button[text()='Remove from Client ']");
	private By noClientContactsTxt = By.cssSelector("div.u-centerText h3");

	
	public void navigateToClientsOverview(String clientName) throws InterruptedException {
		NavigateUtil nav = new NavigateUtil(driver);

		nav.navigateToClientWorkspace(clientName);
		
	}

	public void clickAddContactsBtn() {

		driver.findElement(addContactsBtn).click();
	}

	public String setContactsInfo()throws InterruptedException {

		
//		driver.findElement(this.emailAddress).sendKeys(emailAddress);
//		driver.findElement(this.fullName).sendKeys(fullName);
//		driver.findElement(this.personalNote).sendKeys(personalNote);
//		Thread.sleep(1000);
		
		String firstName = generateRandomStrings.generateFirstName();
		String lastName = generateRandomStrings.generateLastName();
		String fullName = firstName + " " + lastName;
		String emailAddress = firstName + lastName + "@gmail.com";
		String personalNote = "Personal Note Test";
		
//		driver.findElement(this.emailAddress).sendKeys(emailAddress);
//		driver.findElement(this.fullName).sendKeys(fullName);
//		driver.findElement(this.personalNote).sendKeys(personalNote);
		
		sendKeys(driver, emailAddressTxtField, emailAddress);
		sendKeys(driver, fullNameTxtField, fullName);
		sendKeys(driver, personalNoteTxtField, personalNote);
		
		
//		Thread.sleep(2000);
		return fullName;
		
		
	}

	public void sendContactInvitation() throws InterruptedException {

//		driver.findElement(sendNowBtn).click();
//		Thread.sleep(1000);
//		driver.findElement(uploadAndSendInviteBtn).click();
//		driver.findElement(InvitationResultModelCloseBtn).click();
//		driver.navigate().refresh();
//		Thread.sleep(2000);
		
		clickOn(driver, sendNowBtn);
		clickOn(driver, uploadAndSendInviteBtn);
		sleep(10000);
		clickOn(driver, InvitationResultModelCloseBtn);
		refreshPage(driver);

	}

	public void isContactSuccessfullyAdded(String contactName) throws InterruptedException {

		FileFinderUtil findContact = new FileFinderUtil(driver);

		findContact.clickaCheckbox_contacts(contactName);
	}

	public void deleteContact(String contactName) throws InterruptedException {

		CheckBoxUtil checkBox = new CheckBoxUtil();
		
//		driver.findElement(archiveContactsBtn).click();
//		driver.findElement(viewArchiveOptionBtn).click();
//		driver.findElement(viewArhiveLink).click();
//		Thread.sleep(4000);
//		driver.findElement(checkBox.getTDPrecidingCheckBox(contactName)).click();
//		driver.findElement(deleteContactsBtn).click();
//		Thread.sleep(2000);
//		driver.findElement(alertDeleteBtn).click();
//		Thread.sleep(4000);
		
		clickOn(driver, archiveContactsBtn);
		clickOn(driver, viewArchiveOptionBtn);
		clickOn(driver, viewArhiveLink);
		clickOn(driver, checkBox.getTDPrecidingCheckBox(contactName));
		clickOn(driver, deleteContactsBtn);
		sleep(3000);
		clickOn(driver, alertDeleteBtn);
		sleep(3000);

	}

	public void clickChooseFromExistingContactsBtn() {

//		driver.findElement(chooseFromExistingContactsBtn).click();
		
		clickOn(driver, chooseFromExistingContactsBtn);
	}

	public void selectFromExistingContact(String contactName) {

		DropDownUtil dropDown = new DropDownUtil(driver);

		dropDown.selectFromDropDown(existingContactsDropDown, contactName);

	}

	public void removeContactFromClient(String contactName) throws InterruptedException {

		FileFinderUtil findContact = new FileFinderUtil(driver);

		findContact.clickaCheckbox_contacts(contactName);
//		sleep(2000);
//		driver.findElement(removeFromClientBtn).click();
//		sleep(2000);
//		driver.findElement(alertDeleteBtn).click();
//		sleep(2000);
		
		clickOn(driver, removeFromClientBtn);
		clickOn(driver, alertDeleteBtn);
	}

	public String getExpectedText() {

//		return driver.findElement(noClientContactsTxt).getText();
		
		return getElementText(driver, noClientContactsTxt);
	}

	public boolean isContactSuccessfullyDelete(String deletedContact) {

		driver.findElement(workspacesPage).click();
		driver.navigate().refresh();

		List<String> list = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(contactsList);
		boolean isDeleted = true;
	
		System.out.println("Deleted Contact is: " + deletedContact);

		for (WebElement e : elementList) {

			String contactName = e.getText();
			System.out.println("Contact Name is: " + contactName);
			
			if(contactName.equals(deletedContact)) {
				
				System.out.println("Deleting not successfully");
				isDeleted = false;
				
				list.add(contactName);

			}
		}
		
		System.out.println("IS CONTACT DELETED?" + isDeleted);

		return isDeleted;

	}

}
