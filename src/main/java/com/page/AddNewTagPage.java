package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class AddNewTagPage {

	private WebDriver driver;
	private ElementUtil elementUtil = new ElementUtil();

	public AddNewTagPage(WebDriver driver) {

		this.driver = driver;
	}

	private By newTagButton = By.xpath("//button[text()='New Tag']");
	private By name = By.xpath("//input[@name='tag.name']");
	private By dropDown = By.xpath("//div[@class='css-1wy0on6 react-select__indicators']");
	private By createButton = By.xpath("//button[text()='Create Custom Tag']");
	private By selectedType;

	public void clickNewTagButton() throws InterruptedException {

		driver.findElement(newTagButton).click();
	}

	public void enterName(String names) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(name).sendKeys(names);
	}

	public void selectType(String type) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(dropDown).click();

		selectedType = elementUtil.getDivXpathData(type);

		driver.findElement(selectedType).click();

	}

	public boolean clickCreateButton() {

		return driver.findElement(createButton).isEnabled();
	}

}
