package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;
import com.qa.util.PageActions;

public class AddNewTagPage extends PageActions{

	private WebDriver driver;
	private ElementUtil elementUtil = new ElementUtil();

	public AddNewTagPage(WebDriver driver) {

		this.driver = driver;
	}

	private By newTagBtn = By.xpath("//button[text()='New Tag']");
	private By tagNameTxtField = By.xpath("//input[@name='tag.name']");
	private By dropDown = By.xpath("//div[@class='css-1wy0on6 react-select__indicators']");
	private By createBtn = By.xpath("//button[text()='Create Custom Tag']");
	private By selectedType;

	public void clickNewTagButton() throws InterruptedException {

//		driver.findElement(newTagButton).click();
		
		clickOn(driver, newTagBtn);
	}

	public void enterName(String tagName) throws InterruptedException {

//		Thread.sleep(2000);
//		driver.findElement(name).sendKeys(names);
		
		sendKeys(driver, tagNameTxtField, tagName);
	}

	public void selectType(String type) throws InterruptedException {

		Thread.sleep(2000);
//		driver.findElement(dropDown).click();
		
		clickOn(driver, dropDown);

		selectedType = elementUtil.getDivXpathData(type);
//		driver.findElement(selectedType).click();
		
		clickOn(driver, selectedType);

	}

	public boolean clickCreateButton() {

//		return driver.findElement(createBtn).isEnabled();
		
		return isElementEnabled(driver, createBtn);
		
	}

}
