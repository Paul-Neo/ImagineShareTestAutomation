package com.qa.util;

import org.openqa.selenium.By;

public class ElementUtil {

	/*
	 * can return a xpath that is applicable for contains method and starting with
	 * //div
	 * 
	 */

	public By getDivXpathData(String htmlValue) {

		String start = "//div[contains(text(),'";
		String end = "')]";

		By fullLocatorData = By.xpath(start + htmlValue + end);

		return fullLocatorData;

	}
	
	/*
	 * can return a exact xpath that is applicable for contains method and starting with
	 * //div
	 * 
	 */
	
	public By getDivExactXpathData(String htmlValue) {

		String start = "//div[text()='";
		String end = "']";

		By fullLocatorData = By.xpath(start + htmlValue + end);

		return fullLocatorData;

	}

	/*
	 * can return a xpath that is applicable for contains method and starting with
	 * //span
	 * 
	 */
	
	public By getSpanXpathData(String htmlValue) {

		String start = "//span[contains(text(),'";
		String end = "')]";

		By fullLocatorData = By.xpath(start + htmlValue + end);

		return fullLocatorData;
	}

	/*
	 * can return a xpath that is applicable for contains method and starting with
	 * //small
	 * 
	 */

	public By getSmallXpathData(String htmlValue) {

		String start = "//small[contains(text(),'";
		String end = "')]";

		By fullLocatorData = By.xpath(start + htmlValue + end);

		return fullLocatorData;
	}

	/*
	 * can return a xpath that is applicable for contains method and starting with
	 * //a
	 * 
	 */
	
	public By get_a_XpathData(String htmlValue) {

		String start = "//a[contains(text(),'";
		String end = "')]";

		By fullLocatorData = By.xpath(start + htmlValue + end);

		return fullLocatorData;
	}

	/*
	 * can return a xpath that is applicable for contains method and starting with
	 * //H4
	 * 
	 */
	
	public By getH4XpathData(String htmlValue) {

		String start = "//a[contains(text(),'";
		String end = "')]";

		By fullLocatorData = By.xpath(start + htmlValue + end);

		return fullLocatorData;
	}

}
