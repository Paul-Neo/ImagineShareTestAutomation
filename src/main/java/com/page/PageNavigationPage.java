package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PageNavigationPage {

	private WebDriver driver;
	
	public PageNavigationPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	private By ellipsisMenu = By.xpath("//button[text()='New File']/following::i[1]");
	private By viewArchiveLink = By.xpath("//a[text()='View Archive']");
	private By columnHeaders = By.cssSelector("div.table-head div");
//	private By pageFilterDropDown = By.xpath("//select[@name='numPerPage']");
	private By showLabel = By.xpath("//div[@class='yt-toolbar']/following::label[1]");
	
	
	public void navigateToArchiveList() throws InterruptedException {
		
		driver.findElement(ellipsisMenu).click();
		driver.findElement(viewArchiveLink).click();
		Thread.sleep(10000);
	}
	
	public List<String> getColumnHeaders() {
		
		List<String> list = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(columnHeaders);
		
		for(WebElement e : elementList) {
			
			String columnNames = e.getText();
			System.out.println("Column Names: " + columnNames);
			if(columnNames.equals("")) {
		//	list.add(null);
			}else
				list.add(columnNames);
		
		}
		
		return list;
		
		
	}
	
	public void selectPageFilter(String pageFilterValue) {
		
		Select dropDown = new Select(driver.findElement(By.name("numPerPage")));
		
		dropDown.selectByVisibleText(pageFilterValue);
		
	}
	
	public String getLabelText() {
		
		return driver.findElement(showLabel).getText();
	}
	
	
}
