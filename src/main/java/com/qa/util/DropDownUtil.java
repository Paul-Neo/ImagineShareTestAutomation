package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownUtil {

	private ElementUtil elementUtil = new ElementUtil();

	private WebDriver driver;

	public DropDownUtil(WebDriver driver) {

		this.driver = driver;
	}
	
	public void linkSettings(String linkSettings, String question, String expectedAnswer) throws InterruptedException {
		
		By linkDropDown = By.xpath("//strong[contains(text(),'Who has access')]/following::div[@class='css-1wy0on6 react-select__indicators'][1]");
		By questionsDropDown = By.xpath("//input[@placeholder = 'Shared answer']/preceding::div[@class='css-151xaom-placeholder react-select__placeholder'][1]");

		By selectedLinkSettings = elementUtil.getDivXpathData(linkSettings);
		
		By selectedQuestion = elementUtil.getDivXpathData(question);
				
		By answer = By.xpath("//input[@name='password' and @placeholder = 'Shared answer']");
		
		driver.findElement(linkDropDown).click();
		Thread.sleep(2000);
		driver.findElement(selectedLinkSettings).click();
		
		driver.findElement(questionsDropDown).click();
		Thread.sleep(2000);
		driver.findElement(selectedQuestion).click();
		
		driver.findElement(answer).sendKeys(expectedAnswer);
		
		
	}
	
	public void selectFromDropDown(By dropDown, String selected) {
		
		By selectedValue = elementUtil.getDivXpathData(selected);
		
		driver.findElement(dropDown).click();
		driver.findElement(selectedValue).click();
		
	}
	
	public void selectFromDropDownExactValue(By dropDown, String selected) {
		
		By selectedValue = elementUtil.getDivExactXpathData(selected);
		
		driver.findElement(dropDown).click();
		driver.findElement(selectedValue).click();
		
	}
	
}
