package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.DropDownUtil;

public class MovePage {

	private WebDriver driver;
	private DropDownUtil dropDown = new DropDownUtil(DriverFactory.getDriver());

	public MovePage(WebDriver driver) {

		this.driver = driver;
	}

	private By toolBarMoveButton = By.xpath("//button[text()='Move ']");
	private By moveFilesWindow = By.xpath("//div[contains(text(),'Move files')]");
	private By saveButton = By.xpath("//button[text()='Save']");
	private By moveDropDown = By.xpath("//div[@class='css-16pqwjk-indicatorContainer']");
	private By latestPDF_file = By.xpath("//div[@class='table-cell -pdf-80']/following::a[1]");
	private By fileName = By.xpath("//div[@class='-preview-title']");

	public String findMovedFile() {
		
		driver.findElement(latestPDF_file).click();
		System.out.println("Latest File Name is : "+driver.findElement(fileName).getText());
		return driver.findElement(fileName).getText();

	}

	public void clickMove() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-1500)");

		driver.findElement(toolBarMoveButton).click();

	}

	public String getMoveWindowText() {

		return driver.findElement(moveFilesWindow).getText();
	}

	public void selectDestination(String destination) {

		System.out.println("Moving Files to... " + destination);
		dropDown.selectFromDropDown(moveDropDown, destination);

	}

	public void clickSave() throws InterruptedException {

		driver.findElement(saveButton).click();
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	public void sleep(int sec) throws InterruptedException {

		Thread.sleep(sec);
	}

}
