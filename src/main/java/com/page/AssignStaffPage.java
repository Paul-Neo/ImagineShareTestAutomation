package com.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.util.CheckBoxUtil;
import com.qa.util.NavigateUtil;
import com.qa.util.PageActions;
import com.qa.util.ToolBarButtonsUtil;

public class AssignStaffPage extends PageActions {

	private WebDriver driver;
	private CheckBoxUtil checkBoxUtil = new CheckBoxUtil();

	public AssignStaffPage(WebDriver driver) {

		this.driver = driver;
	}

	private By toolBarBtnLists = By.xpath("//div[@class='yt-tools space-between']//button");
	private By assignStaffBtn = By.xpath("//button[text()='Assign staff']");
	private By continueAssigning = By.xpath("//button[text()='Continue assigning']");
	private By nextButton = By.xpath("//button[text()='Next']");
	private By notificationSettings = By.cssSelector("div.card-body label");
	private By assignedStaffTab = By.xpath("//a[text()='Assigned Staff']");
	private By staffLists = By.cssSelector("tr.-staff-item a");
	private By unAssignButton = By.xpath("//button[text()='Unassigned staff ']");
	private By confirmUnassign = By.xpath("//button[text()='Yes']");
	private By selectAllStaffsCheckBox = By.xpath("//a[text()='Assigned Staff']/following::input[1]");
	private By expectedMessage = By.cssSelector("div.u-centerText h3");
	
	private String toolBarBtn = "//div[@class='yt-tools space-between']//button[contains(text(),'{0}')]";
	private String toolBarOptionName = "//div[@class = '-filter-wrapper']/following::span[text()='{0}']";

	public boolean areToolBarButtonsEnabled() {

		List<String> lists = new ArrayList<>();
		List<WebElement> toolBarButtonsLists = driver.findElements(toolBarBtnLists);
		boolean isEnabled = false;
		for (WebElement e : toolBarButtonsLists) {

			String buttonNames = e.getText();
			isEnabled = driver.findElement(toolBarBtnLists).isEnabled();
			System.out.println("Button " + buttonNames + ": is Enabaled? " + isEnabled);

			if (isEnabled == true) {
				lists.add(buttonNames);
			}

		}

		return isEnabled;

	}

	public void clickAssignStaffToolBarButton() throws InterruptedException {//DEPRECATED

		JavascriptExecutor js = (JavascriptExecutor) driver;
		ToolBarButtonsUtil toolBarUtil = new ToolBarButtonsUtil(driver);
		By assignStaff = By.xpath("//span[text()='Assign staff']");
		
		// scroll up
		js.executeScript("window.scrollBy(0,-1500)");

		toolBarUtil.clickStaffSettings(assignStaff);

	}
	
	public void clickToolBarButton(String toolBarButtonName) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// scroll up
		js.executeScript("window.scrollBy(0,-1500)");
		
		By selectedToolBarBtn = By.xpath(this.toolBarBtn.replace("{0}", toolBarButtonName));
		
		clickOn(driver, selectedToolBarBtn);
		
		
	}
	
	
	/**
	 * 
	 * This Method is to select options when clicking a tool bar buttons
	 * 
	 */
	public void selectToolBarOption(String toolBarOptionName) {
		
		By selectedToolBarOptionName = By.xpath(this.toolBarOptionName.replace("{0}", toolBarOptionName));
		
		clickOn(driver, selectedToolBarOptionName);
		
	}
	

	public void selectStaff(String staffName) throws InterruptedException {

		By selectedStaffName = checkBoxUtil.getTDPrecidingCheckBox(staffName);

		Thread.sleep(2000);
		driver.findElement(selectedStaffName).click();
	}

	public void clickNextButton() {

		driver.findElement(nextButton).click();
	}

	public List<String> getNotifSettings() {
		List<String> lists = new ArrayList<>();
		List<WebElement> notifElements = driver.findElements(notificationSettings);

		for (WebElement e : notifElements) {

			String notifNames = e.getText();
			System.out.println("Notification Names: " + notifNames);
			lists.add(notifNames);
		}

		return lists;
	}

	public boolean clickAssignStaffButton() {

		return driver.findElement(continueAssigning).isEnabled();
	}

	public void doAssignStaff(String staffName) throws InterruptedException {

		driver.findElement(assignedStaffTab).click();
		driver.findElement(assignStaffBtn).click();

		By selectedStaffName = checkBoxUtil.getTDPrecidingCheckBox(staffName);

		Thread.sleep(1000);
		driver.findElement(selectedStaffName).click();
		driver.findElement(nextButton).click();
		driver.findElement(continueAssigning).click();
		driver.navigate().refresh();
		Thread.sleep(1000);

	}

	public List<String> getAssignedStaffs() throws InterruptedException {

		List<String> list = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(staffLists);

		for (WebElement e : elementList) {

			String staffName = e.getText();
			System.out.println("Staff Name: " + staffName);
			list.add(staffName);
		}

		Thread.sleep(3000);
		return list;
	}

	public void unassignStaff() throws InterruptedException {

		driver.findElement(unAssignButton).click();
		Thread.sleep(1000);
		driver.findElement(confirmUnassign).click();
		driver.navigate().refresh();
	}

	public void assignMultipleSttafs(String staff_1, String staff_2) throws InterruptedException {

//		ToolBarButtonsUtil toolBarUtil = new ToolBarButtonsUtil(driver);
//		By assignStaff = By.xpath("//span[text()='Assign staff']");
//		
//		toolBarUtil.clickStaffSettings(assignStaff);

		By selectedStaff_1 = checkBoxUtil.getTDPrecidingCheckBox(staff_1);
		By selectedStaff_2 = checkBoxUtil.getTDPrecidingCheckBox(staff_2);

		driver.findElement(selectedStaff_1).click();
		driver.findElement(selectedStaff_2).click();

		driver.findElement(nextButton).click();
		driver.findElement(continueAssigning).click();
	}

	public void navigateToAssignedStaffTab(String clientName) throws InterruptedException {

		NavigateUtil nav = new NavigateUtil(driver);
//		nav.navigateToClientSettings(clientName);
		nav.navigateToClientWorkspace(clientName);
		Thread.sleep(3000);
//		driver.findElement(assignedStaffTab).click();
		clickOn(driver, assignedStaffTab);
	}

	public void selectAllStaffs() throws InterruptedException {

		driver.findElement(selectAllStaffsCheckBox).click();
		Thread.sleep(2000);
	}

	public String getExpectedMessage() {

		return driver.findElement(expectedMessage).getText();
	}

	public int getAssignedStaffCount() {
		
		driver.findElement(assignedStaffTab).click();
		
		List<WebElement> elementList = driver.findElements(staffLists);
		return elementList.size();
		
	}
}

































