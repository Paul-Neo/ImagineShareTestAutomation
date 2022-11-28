package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ElementUtil;

public class SearchPage {

	private WebDriver driver;

	public SearchPage(WebDriver driver) {

		this.driver = driver;
	}

	private By clientsName = By.xpath("//h1[@class='-visible']");
	private By fileName = By.xpath("//div[@class='-preview-title']");
	private By filterClientname = By.xpath("//input[@name='filter.clientName']");
	private By applyFilterButton = By.xpath("//button[text()='Apply Filter']");
	private By downloadButton = By.xpath("//span[text()=' Download']");

	private By navLinks = By.cssSelector("div.tab-bar-nav a");
	private By filePreviewNavLinks = By.cssSelector("div.tab-bar-nav span");
	private By filePreviewButtons = By.xpath("//button");

	public void navigateToClientsWorkspace(String name) {

		By clientWorkspace = By.xpath("//h4[text()='" + name + "']/following::a[text()='Go to client workspace']");
		driver.findElement(clientWorkspace).click();

	}

	public void navigateToClientSettings(String name) {

		By clientSettings = By.xpath("//a[text()='Go to client settings']");
		driver.findElement(clientSettings).click();
	}

	public void selectFolder_OR_File(String name) throws InterruptedException {

		ElementUtil elementUtil = new ElementUtil();
		
//		By folderName = By.xpath("//div[text()='" + name + "']");
//		driver.findElement(folderName).click();
		
		
		By folderName =  elementUtil.getDivXpathData(name);
		
		Thread.sleep(2000);
		driver.findElement(folderName).click();
		
		
	}

	public String getClientsName() {

		return driver.findElement(clientsName).getText();
	}

	public List<String> getNavLinks() {

		List<String> lists = new ArrayList<>();
		List<WebElement> elementLists = driver.findElements(navLinks);

		for (WebElement e : elementLists) {

			String linkNames = e.getText();
			System.out.println("Link Name: " + linkNames);
			lists.add(linkNames);
		}

		return lists;
	}

	public void applySearchFilter(String clientName) throws InterruptedException {

		driver.findElement(filterClientname).sendKeys(clientName);
		driver.findElement(applyFilterButton).click();
		Thread.sleep(2000);
	}

	public String getFileName() {

		return driver.findElement(fileName).getText();
	}

	public List<String> getfilePreviewNavButtons() {

		List<String> lists = new ArrayList<>();
		List<WebElement> elementLists = driver.findElements(filePreviewButtons);

		for (WebElement e : elementLists) {

			String linkNames = e.getText();
			System.out.println("Button Name: " + linkNames);
			lists.add(linkNames);
		}

		return lists;
	}

	public List<String> getfilePreviewNavlinks() {

		List<String> lists = new ArrayList<>();
		List<WebElement> elementLists = driver.findElements(filePreviewNavLinks);

		for (WebElement e : elementLists) {

			String buttonNames = e.getText();
			System.out.println("Link Name: " + buttonNames);
			lists.add(buttonNames);
		}

		return lists;
	}

	public boolean isDownLoadButtonExist() {

		return driver.findElement(downloadButton).isDisplayed();
	}

}
