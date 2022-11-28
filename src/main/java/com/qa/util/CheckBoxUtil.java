package com.qa.util;

import org.openqa.selenium.By;

public class CheckBoxUtil {
	
	

	/*
	 * can return xpath of a checkbox that is preciding of the selected element and starting with //a
	 * 
	 * */
	
	public By getaPrecidingCheckBox(String htmlValue) {
	
	String start = "//a[contains(text(),'";
	String end = "')]/preceding::input[@type='checkbox'][1]";
	
	By fullLocatorData = By.xpath(start+htmlValue+end);
	
	return fullLocatorData;
}
	
	
	/*
	 * can return xpath of a checkbox that is preciding of the selected element and starting with //td
	 * 
	 * */
	
	public By getTDPrecidingCheckBox(String htmlValue) {
		
		String start = "//td[contains(text(),'";
		String end = "')]/preceding::input[@type='checkbox'][1]";
		
		By fullLocatorData = By.xpath(start+htmlValue+end);
		
		return fullLocatorData;
	}
	
	/*
	 * can return xpath of a radio button that is preciding of the selected element and starting with //a
	 * 
	 * */
	
	public By getaPrecedingRadiobtn(String htmlValue) {
		
		String start = "//a[contains(text(),'";
		String end = "')]/preceding::input[@type='radio'][1]";
		
		By fullLocatorData = By.xpath(start+htmlValue+end) ;
	
		return fullLocatorData;
	}
	

	

	
}
