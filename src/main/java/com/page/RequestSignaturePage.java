package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.DropDownUtil;
import com.qa.util.FileFinderUtil;

public class RequestSignaturePage {

	private WebDriver driver;

	public RequestSignaturePage(WebDriver driver) {

		this.driver = driver;
	}

	private By requestSignatureButton = By.xpath("//button[text()='Request Signature']");

	private By fileName = By.xpath("//div[@class='-title']");
	private By firstName = By.xpath("//input[@placeholder = 'First name' and @value ='']");
	private By lastName = By.xpath("//input[@placeholder = 'Last name' and @value ='']");
	private By emailAddress = By.xpath("//input[@placeholder = 'Email' and @value ='']");
	private By instructions = By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
	private By prepareRequestButton = By.xpath("//button[text()='Prepare Request']");
	private By requestCreated = By.xpath("//h4[text()='Signature request created']");
	private By signersNotified = By.xpath("//h4[text()='Signers notified']/following::small");
	private By fileUploadLocation = By.xpath("//div[@class='css-ue83k8-singleValue react-select__single-value react-select__single-value--is-disabled']");
	private By addNewButton = By.xpath("//button[text()=' Add new']");
	
	private By templateDropDown = By.xpath(
			"//label[text()='Choose a template']/following::div[@class='css-1wy0on6 react-select__indicators'][1]");

	private By latestPDF_subtask = By.xpath("//div[@class='table-cell -pdf-80']");
	private By subtask_reqSig = By.xpath("//a[text()='Request signature']");
	
	private By toggleViewed = By.xpath("//p[text()='Notify when viewed']/following::label[@class='switch'][1]");
	private By toggleCompleted = By.xpath("//p[text()='Notify when completed']/following::label[@class='switch'][1]");
	
	private By individualAuthDropDown = By.xpath("//div[@class='css-151xaom-placeholder react-select__placeholder' and text()='-- Select from the following --']");
	private By individualAuthAnswer = By.xpath("//input[@placeholder = 'Shared answer' and @value = '']");
	
	
	public void clickFile(String fileName) {

		FileFinderUtil fileFinder = new FileFinderUtil(driver);

		fileFinder.clickFileName(fileName);

	}

	public void clickRequestSignature() throws InterruptedException {

		driver.findElement(requestSignatureButton).click();
		Thread.sleep(2000);
	}

	public String getFileName() {

		return driver.findElement(fileName).getText();
	}

	public void selectTemplate(String selectedValue) throws InterruptedException {

		DropDownUtil dropDown = new DropDownUtil(driver);
		dropDown.selectFromDropDownExactValue(templateDropDown, selectedValue);
		Thread.sleep(2000);

	}

	public void enterSignerDetails(String firstName, String lastName, String emailAddress, String instructions) {

		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.emailAddress).sendKeys(emailAddress);
		driver.findElement(this.instructions).sendKeys(instructions);

	}

	public void enterSignerDetails(String firstName, String lastName, String emailAddress) {

		driver.findElement(addNewButton).click();

		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.emailAddress).sendKeys(emailAddress);

	}

	public void clickPrepareRequestButton() throws InterruptedException {

		driver.findElement(prepareRequestButton).click();
		Thread.sleep(5000);
	}

	public boolean isSignatureReqCreated() {

		return driver.findElement(requestCreated).isDisplayed();
	}

	public String notifiedSigner() {

		return driver.findElement(signersNotified).getText();

	}

	public String getFileUploadLocationName() {

		return driver.findElement(fileUploadLocation).getText();

	}

	public void clickAddNew() {

		driver.findElement(addNewButton).click();
	}

	public void openSigReqFromSubtask() throws InterruptedException {

		driver.findElement(latestPDF_subtask).click();
		driver.findElement(subtask_reqSig).click();
		Thread.sleep(1000);
	}

	public void notificationToggleOff() {
		
		driver.findElement(toggleViewed).click();
		driver.findElement(toggleCompleted).click();
	}
	
	public void selectIndividualAuthentication(String question, String answer) throws InterruptedException {
		
		DropDownUtil dropDown = new DropDownUtil(driver);
		
		dropDown.selectFromDropDown(individualAuthDropDown, question);
		driver.findElement(individualAuthAnswer).sendKeys(answer);
		Thread.sleep(2000);
	}
}
