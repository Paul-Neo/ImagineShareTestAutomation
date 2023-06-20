package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.util.DropDownUtil;

public class FileVersionPage {

	private WebDriver driver;
	
	public FileVersionPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	private By firmSettingsPage = By.xpath("//span[text()='Firm Settings']");
	private By advanceSettingsTab = By.xpath("//a[text()='Advanced Settings']");
	private By editBtn = By.xpath("//button[text()='Edit']");
	private By updateBtn = By.xpath("//button[text()='Update']");
	private By fileVersioningDropdown = By.xpath("//div[text()='File Versioning']/following::div[@class='css-1wy0on6 react-select__indicators'][1]");
	private By versionColumn = By.xpath("//div[@class='table-cell _10' and text()='Versions']");
	private By fileVersionIcon = By.xpath("//i[@class='fas fa-copy -active']");
	private By currentFileVersion = By.xpath("//small[text()='current']/preceding::input[@name='file'][1]");
	private By fileVersionBtns = By.xpath("//div[text()='File Versions']/following::button");
	private By generalFilesColumns = By.cssSelector("div.table-head div");
	
	
	public void enableFileVersioning(String fileVersioningStatus) {
		
		DropDownUtil dropDownUtil = new DropDownUtil(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(firmSettingsPage).click();
		driver.findElement(advanceSettingsTab).click();
		
		js.executeScript("window.scrollBy(0,2500)");
		driver.findElement(editBtn).click();
		
		js.executeScript("window.scrollBy(0,-2500)");
		dropDownUtil.selectFromDropDown(fileVersioningDropdown, fileVersioningStatus);
		
		js.executeScript("window.scrollBy(0,2500)");
		driver.findElement(updateBtn).click();
		
	}
	
	public boolean isVersionColumnDisplayed() {
		
		return driver.findElement(versionColumn).isDisplayed();
	}
	
	public void clickFileVersioningIcon() {
		
		driver.findElement(fileVersionIcon).click();
	}
	
	public void selectCurrentFileVersion(){
		
		driver.findElement(currentFileVersion).click();
	}
	
	public List<String> isButtonsEnabled() {
		
		List<String> list = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(fileVersionBtns);
		boolean isEnabled = false;
		
		for(WebElement e : elementList) {
			
			
			String buttonNames = e.getText();
			System.out.println("Button Names: " + buttonNames);
			
			if(driver.findElement(fileVersionBtns).isEnabled()) {
			
				isEnabled = true;
				System.out.println("Is Button Enabled? " + isEnabled);
		
				list.add(buttonNames);
				
			}else {
				
				System.out.println(buttonNames + "IS DISABLED!!");
			}
		}
		
		return list;
	}
	
	public List<String> getColumnNames(){
		
		List<String> list = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(generalFilesColumns);
		
		for(WebElement e : elementList) {
			
			String columnName = e.getText();
			System.out.println("Column Name: " + columnName);
			
			if(columnName == "") {
				
			list.add(columnName);
			list.remove(0);
		
		}else
			
			list.add(columnName);	
	}
		
		return list;
	}
}
