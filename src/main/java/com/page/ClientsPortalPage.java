package com.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.NavigateUtil;

public class ClientsPortalPage {

	private WebDriver driver;

	public ClientsPortalPage(WebDriver driver) {

		this.driver = driver;
	}

	private By NavLinks = By.cssSelector("li.-desktop-only a");
	private By myFiles = By.cssSelector("a.-filename");

	private By subjectTextBox = By.xpath("//textarea[@name='clientPost.subject']");
	private By messageTextBox = By.xpath("//textarea[@name='clientPost.content']");

	private By latestSubjectPost = By.xpath("//div[@class='new-post']/following::h4[@class='-post-header'][1]");
	private By latestMessagePost = By.xpath("//div[@class='new-post']/following::div[@class='card-body'][1]");

	private By sendButton = By.xpath("//button[text()='Send']");

	private By latestActivity = By.xpath("//div[@class='-day' and text()='Today']");
	private By activityNotification = By.xpath("//div[text()='Today']/following::a[1]");
	
	public String getPageTitle() {

		return driver.getTitle();
	}

	public List<String> getNavLinks() {
		List<String> list = new ArrayList<>();
		List<WebElement> navLinkLists = driver.findElements(NavLinks);

		for (WebElement e : navLinkLists) {

			String navigationLinkNames = e.getText();
			System.out.println(navigationLinkNames);
			list.add(navigationLinkNames);
		}

		return list;
	}

	public List<String> getMyFiles() {
		List<String> list = new ArrayList<>();
		List<WebElement> myFileList = driver.findElements(myFiles);

		for (WebElement e : myFileList) {

			String myFileNames = e.getText();
			System.out.println(myFileNames);
			list.add(myFileNames);
		}

		return list;
	}

	public void sendMessage(String subject, String message) throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(subjectTextBox).sendKeys(subject);
		driver.findElement(messageTextBox).sendKeys(message);

	}

	public void clickSendButton() throws InterruptedException {

		driver.findElement(sendButton).click();
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	public String getSubjectText() {

		return driver.findElement(latestSubjectPost).getText();
	}

	public String getMessageText() {

		return driver.findElement(latestMessagePost).getText();
	}

	public void clickMessagesTab() {

		// driver.findElement(messagesTab).click();

		String messagesTab = "Messages";
		clickSelectedTab(messagesTab);

	}

	public boolean isLatestActivityTodayUpdated() {

		return driver.findElement(latestActivity).isDisplayed();
	}

	public String getLatestActivityMessage() {

		return driver.findElement(activityNotification).getText();
	}

	public void navigateToMessageBoardAndSendAMessage(String subject, String message) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String messageBoardTab = "Message Board";

		clickSelectedTab(messageBoardTab);

		Thread.sleep(3000);
		driver.findElement(subjectTextBox).sendKeys(subject);
		driver.findElement(messageTextBox).sendKeys(message);

		driver.findElement(sendButton).click();
		driver.navigate().refresh();
		Thread.sleep(3000);

	}
	
	private void clickSelectedTab(String tabName) {

		NavigateUtil nav = new NavigateUtil(driver);
		nav.clickSelectedTab(tabName);

	}

}
