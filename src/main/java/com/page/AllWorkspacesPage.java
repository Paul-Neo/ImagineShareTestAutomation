package com.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ElementUtil;

public class AllWorkspacesPage {

	private WebDriver driver;
	
	private ElementUtil elementUtil = new ElementUtil();
	
	public AllWorkspacesPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By sideBarLinks = By.xpath("//span[@class='-text']");
	
	public void selectFirm(String firmName) {
		
		By selectedFirm = elementUtil.getSpanXpathData(firmName);
		driver.findElement(selectedFirm).click();
	}
	
	public String getFirmProfile(String firmProfile) {
		
		By selectedFirmProfile = elementUtil.getSmallXpathData(firmProfile);
		
		return driver.findElement(selectedFirmProfile).getText();
	}
	
	public int getSideBarLinkcount() {
		
		return driver.findElements(sideBarLinks).size();
	}
	
	public List<String> getSideBarLinks() {
		
		List<String> lists = new ArrayList<>();
		List<WebElement> sideBarLinkNames = driver.findElements(this.sideBarLinks);
		
		for(WebElement e : sideBarLinkNames) {
			
			String linkNames = e.getText();
			System.out.println(linkNames);
			lists.add(linkNames);
		}
		
		return lists;
	}
	
	public String getNewUrl() {
		
		
		return driver.getCurrentUrl();
	}
	
	public String changeUrl() {
		
	
		String url = getNewUrl();
		char[] newChar;
		String newUrl = "";
		
		if(url.charAt(2)!= 'i') {
			
			newChar = url.toCharArray();
			newChar[2] = 'i';
			
			 newUrl = newUrl.toString();

		}
		
		return newUrl;
		
	}
	
}