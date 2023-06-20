package com.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.factory.DriverFactory;
import com.qa.util.CheckBoxUtil;
import com.qa.util.DropDownUtil;
import com.qa.util.ElementUtil;
import com.qa.util.ToolBarButtonsUtil;

public class ShareFilesPage {

	private WebDriver driver;
	private ElementUtil elementUtil = new ElementUtil();
	private CheckBoxUtil checkBoxUtil = new CheckBoxUtil();
	private DropDownUtil dropDown = new DropDownUtil(DriverFactory.getDriver());

	

	public ShareFilesPage(WebDriver driver) {

		this.driver = driver;
	}

	private By allFilesTab = By.xpath("//span[text()='All ' and text()=' Files']");
	private By toolBarButtons = By.cssSelector("div.yt-toolbar button");
	private By files_folders = By.xpath("//div[@class='yt-row center-vert']");
	private By shareFiles = By.xpath("//span[text()='Share files']");
	private By shareFilesButton = By.xpath("//button[text()='Share ']");
	private By searchBox = By.cssSelector("div.search input");
	private By createShareLink = By.xpath("//button[text()='Create share link']");
	private By selectedFile = By.xpath("//div[@class='-title']");
	private By copyLink = By.xpath("//button[text()='Copy link']");
	private By link = By.xpath("//input[@readonly]");
	private By expirationDateToggle = By.xpath("//input[@name='expires']/following::span[@class='slider round'][1]");
	private By sendEmailsToggle = By.xpath("//input[@name='sendEmails']/following::span[@class='slider round'][1]");
	private By emailMessage = By.xpath("//textarea[@name='emailMessage']");
	private By recipientDropDown = By.xpath(
			"//button[text()=' Or enter an email address ']/preceding::div[@class='css-16pqwjk-indicatorContainer react-select__indicator react-select__dropdown-indicator'][1]");
	private By directLinkDropDown = By.xpath(
			"//strong[contains(text(),'Who has access')]/following::div[@class='css-1wy0on6 react-select__indicators'][1]");

	private By selectedRecipient;
	private By applyFilterButton = By.xpath("//input[@placeholder='Search...']/following::button[text()='Apply Filter']");

	
	public void navigateToAllFilesTab() {

		driver.findElement(allFilesTab).click();
	}

	public void selectFolderName(String folderName) {

		By selectedFolderName = elementUtil.get_a_XpathData(folderName);
		driver.findElement(selectedFolderName).click();

	}

	public List<String> getToolBarButtons() {
		List<String> lists = new ArrayList<>();
		List<WebElement> webElementLists = driver.findElements(toolBarButtons);

		for (WebElement e : webElementLists) {
			String buttonNames = e.getText();
			System.out.println(buttonNames);
			lists.add(buttonNames);
		}

		return lists;
	}

	public boolean isFilesFoldersDisplayed() {

		return driver.findElement(files_folders).isDisplayed();
	}

	public void selectFile(String fileName) throws InterruptedException {

		driver.findElement(searchBox).sendKeys(fileName);
		driver.findElement(applyFilterButton).click();
		Thread.sleep(5000);

		By selectedFile = checkBoxUtil.getaPrecidingCheckBox(fileName);

		driver.findElement(selectedFile).click();
		Thread.sleep(2000);
	}

	public void selectShareFiles() throws InterruptedException {

		ToolBarButtonsUtil toolBarButtons = new ToolBarButtonsUtil(driver);

		toolBarButtons.selectLinkAction(shareFiles);

	}

	public void clickCreateShareLink() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(createShareLink).click();
	}

	public String getFileName() {

		return driver.findElement(selectedFile).getText();
	}

	public void clickCopyLink() throws InterruptedException {

		driver.findElement(copyLink).click();
		Thread.sleep(2000);
	}

	public String getLink() {

		String htmlAttribute = "value";

		WebElement linkText = driver.findElement(link);

		String linkValue = linkText.getAttribute(htmlAttribute);

		return linkValue;

	}

	public void clickToggleButton() {

		driver.findElement(expirationDateToggle).click();
	}

	public void sendEmails(String recipient, String emailMessage) throws InterruptedException {

		selectedRecipient = elementUtil.getDivXpathData(recipient);

		WebElement element = driver.findElement(selectedRecipient);

		driver.findElement(sendEmailsToggle).click();
		driver.findElement(recipientDropDown).click();

		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.perform();

		driver.findElement(this.emailMessage).sendKeys(emailMessage);

	}

	public void enterLinkSettings(String linkSettings, String question, String answer) throws InterruptedException {

		dropDown.linkSettings(linkSettings, question, answer);
		Thread.sleep(2000);

	}

	public void selectDirectLink(String linkSettings) {

		dropDown.selectFromDropDown(directLinkDropDown, linkSettings);
	}

	public void clickShareFilesButton() {

		driver.findElement(shareFilesButton).click();

	}


}

