package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.CheckBoxUtil;
import com.qa.util.DropDownUtil;
import com.qa.util.FileFinderUtil;
import com.qa.util.NavigateUtil;

public class AddNewContactPage {

	private WebDriver driver;

	public AddNewContactPage(WebDriver driver) {
		this.driver = driver;
	}

	private By allContactsPage = By.xpath("//span[text()='All ' and text()=' Contacts']");
	private By contactsList = By.cssSelector("tbody a");
	private By addContactsBtn = By.xpath("//a[text()='Add contacts']");
	private By emailAddress = By.xpath("//input[@name='email']");
	private By fullName = By.xpath("//input[@name='fullname']");
	private By personalNote = By.xpath("//textarea[@name='personalNote']");
	private By sendNowBtn = By.xpath("//span[text()=' Send now']");
	private By uploadAndSendInviteBtn = By.xpath("//button[text()='Yes, upload and send invite']");
	private By InvitationResultModelCloseBtn = By.xpath("//button[text()='Close']");
	private By archiveContactsBtn = By.xpath("//button[text()='Archive Contacts']");
	private By viewArchiveOptionBtn = By.xpath("//div[@class='-options -yt-edit-option']");
	private By viewArhiveLink = By.xpath("//a[text()='View Archive']");
	private By deleteContactsBtn = By.xpath("//button[text()='Delete Contacts ']");
	private By alertDeleteBtn = By.xpath("//button[text()='Delete']");
	private By chooseFromExistingContactsBtn = By.xpath("//button[text()='Choose from existing contacts']");
	private By existingContactsDropDown = By.xpath("//div[@class='css-1wy0on6 react-select__indicators']");
	private By removeFromClientBtn = By.xpath("//button[text()='Remove from Client ']");
	private By noClientContactsTxt = By.cssSelector("div.u-centerText h3");

	public void navigateToClientsOverview(String clientName) throws InterruptedException {
		NavigateUtil nav = new NavigateUtil(driver);

		nav.navigateToClientSettings(clientName);
	}

	public void clickAddContactsBtn() {

		driver.findElement(addContactsBtn).click();
	}

	public void fillContactsInfo(String emailAddress, String fullName, String personalNote)
			throws InterruptedException {

		driver.findElement(this.emailAddress).sendKeys(emailAddress);
		driver.findElement(this.fullName).sendKeys(fullName);
		driver.findElement(this.personalNote).sendKeys(personalNote);
		Thread.sleep(1000);
	}

	public void sendContactInvitation() throws InterruptedException {

		driver.findElement(sendNowBtn).click();
		Thread.sleep(1000);
		driver.findElement(uploadAndSendInviteBtn).click();
		driver.findElement(InvitationResultModelCloseBtn).click();
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	public void isContactSuccessfullyAdded(String contactName) throws InterruptedException {

		FileFinderUtil findContact = new FileFinderUtil(driver);

		findContact.clickaCheckbox_contacts(contactName);
	}

	public void deleteContact(String contactName) throws InterruptedException {

		CheckBoxUtil checkBox = new CheckBoxUtil();
		driver.findElement(archiveContactsBtn).click();
		driver.findElement(viewArchiveOptionBtn).click();
		driver.findElement(viewArhiveLink).click();
		Thread.sleep(5000);
		driver.findElement(checkBox.getTDPrecidingCheckBox(contactName)).click();
		driver.findElement(deleteContactsBtn).click();
		driver.findElement(alertDeleteBtn).click();
		Thread.sleep(5000);

	}

	public void clickChooseFromExistingContactsBtn() {

		driver.findElement(chooseFromExistingContactsBtn).click();
	}

	public void selectFromExistingContact(String contactName) {

		DropDownUtil dropDown = new DropDownUtil(driver);

		dropDown.selectFromDropDown(existingContactsDropDown, contactName);

	}

	public void removeContactFromClient(String contactName) throws InterruptedException {

		FileFinderUtil findContact = new FileFinderUtil(driver);

		findContact.clickaCheckbox_contacts(contactName);

		driver.findElement(removeFromClientBtn).click();
		driver.findElement(alertDeleteBtn).click();

	}

	public String getExpectedText() {

		return driver.findElement(noClientContactsTxt).getText();
	}

	public boolean isContactSuccessfullyDelete(String deletedContact) {

		driver.findElement(allContactsPage).click();
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
