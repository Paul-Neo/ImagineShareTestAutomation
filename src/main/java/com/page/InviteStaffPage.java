package com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.util.ElementUtil;
import com.qa.util.GenerateRandomStrings;

public class InviteStaffPage {

	private WebDriver driver;
	private GenerateRandomStrings generateRandomStrings = new GenerateRandomStrings();

	public InviteStaffPage(WebDriver driver) {

		this.driver = driver;
	}

	private By firmSettingsPage = By.xpath("//span[text()='Firm Settings']");
	private By membersTab = By.xpath("//a[text()='Members']");
	private By inviteStaffBtn = By.xpath("//button[text()='Invite staff']");
	private By createNewStaffBtn = By.xpath("//a[text()='Create new staff']");
	private By emailAddressTxtField = By.xpath("//input[@name='email']");
	private By fullNameTxtField = By.xpath("//input[@name='fullname']");
	private By ownerPriviledgeCheckBox = By.xpath("//input[@name='owner']");
	private By personalNoteTxtArea = By.xpath("//textarea[@name='personalNote']");
	private By sendNowBtn = By.xpath("//span[text()=' Send now']");
	private By InvitationResultModelCloseBtn = By.xpath("//button[text()='Close']");
	private By statusDropDown = By.xpath("//select[@name='staff.status']");
	private By saveBtn = By.xpath("//button[text()=' Save ']");
	private By okayBtn = By.xpath("//button[text()='Okay']");
	private By staffMemebers = By.xpath("//tr[@class='-staff-item']/following::div[@class='yt-row']");
	

	public void navigateToFirmSettingsPage() {

		driver.findElement(firmSettingsPage).click();
	}

	public void clickMemeberstab() throws InterruptedException {

		driver.findElement(membersTab).click();
		Thread.sleep(2000);
	}

	public void clickInviteStaffButton() throws InterruptedException {

		driver.findElement(inviteStaffBtn).click();
		Thread.sleep(2000);
	}

	public void selectCreateNewStaff() throws InterruptedException {

		driver.findElement(createNewStaffBtn).click();
		Thread.sleep(2000);
	}

	public String setupNewStaffInfo() throws InterruptedException {

		String firstName = generateRandomStrings.generateFirstName();
		String lastName = generateRandomStrings.generateLastName();
		String fullName = firstName + " " + lastName;
		String emailAddress = firstName + lastName +"@gmail.com";
		
		driver.findElement(emailAddressTxtField).sendKeys(emailAddress);
		driver.findElement(fullNameTxtField).sendKeys(fullName);
		driver.findElement(ownerPriviledgeCheckBox).click();
		driver.findElement(personalNoteTxtArea).sendKeys("Test Staff");
		Thread.sleep(3000);
		
		return fullName;
	
	}

	public void sendInvite() throws InterruptedException {

		
		driver.findElement(sendNowBtn).click();
		driver.findElement(InvitationResultModelCloseBtn).click();
	}

	public boolean isNewStaffAddedOnTheList(String staffName) {
		
		ElementUtil elementUtil = new ElementUtil();
		
		By newStaffAdded = elementUtil.get_a_XpathData(staffName);
		
		return driver.findElement(newStaffAdded).isDisplayed();
	}

	public void clickStaffMemberSettings(String staffName) throws InterruptedException {
		
		By selectedStaff = By.xpath("//a[text()='"+staffName+"']/following::a[1]");
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(selectedStaff).click();
		
	}
	
	public void updateStaffStatus(String status) {
		
		Select selectStatus = new Select (driver.findElement(statusDropDown));
		
		driver.findElement(statusDropDown).click();
		System.out.println("Selecting Status : " + status);
		selectStatus.selectByVisibleText(status);
		
		driver.findElement(saveBtn).click();
		
	}
	
	public void deleteStaff(String staffName) throws InterruptedException {
		
		By deleteStaff = By.xpath("//a[text()='"+staffName+"']/following::i[@class='far fa-trash-alt']");
		
		driver.findElement(deleteStaff).click();
		Thread.sleep(2000);
		driver.findElement(okayBtn).click();
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	public int getStaffMemberCount() {
		
		List<WebElement> elementList = driver.findElements(staffMemebers);
		
		int staffMemebersCount = elementList.size();
		
		return staffMemebersCount + 1;
		
	}
	
}
