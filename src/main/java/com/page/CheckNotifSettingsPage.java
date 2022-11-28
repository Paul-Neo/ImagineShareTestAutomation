package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckNotifSettingsPage {

	private WebDriver driver;
	
	public CheckNotifSettingsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private By notifications = By.cssSelector("div.-workspace-content label");
	
	public List<String> getNotificationSettings() {
		List<String>lists = new ArrayList<>();
		List<WebElement>notificationSettingLists = driver.findElements(notifications);
		
		for(WebElement e : notificationSettingLists) {
			String notifNames = e.getText();
			System.out.println("Notification Names: "+notifNames);
			lists.add(notifNames);
		}
		return lists;
	}
}
