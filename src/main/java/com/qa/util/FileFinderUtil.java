package com.qa.util;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileFinderUtil {

	private WebDriver driver;
	private CheckBoxUtil checkBoxUtil = new CheckBoxUtil();
	private ElementUtil elementUtil = new ElementUtil();

	private By nextPageButton = By.xpath("//a[@class='next-page' and text()='Next ']");
	private By dataLists = By.cssSelector("div.table-cell a"); 
	private By assignedStaffList = By.cssSelector("tr.-staff-item a");
	private By selectedValue;
	
	public FileFinderUtil(WebDriver driver) {

		this.driver = driver;
	}

	public void clickaCheckbox(String expectedValue) throws InterruptedException {

		selectedValue = checkBoxUtil.getaPrecidingCheckBox(expectedValue);

		List<String> lists = new ArrayList<>();

		int counter = 0;
		boolean selectedCLientNotFound = true;

		do {
			List<WebElement> elementsLists = driver.findElements(dataLists);
			int clientCount = elementsLists.size();
			for (WebElement e : elementsLists) {
				counter++;
				String currentValue = e.getText();
				System.out.println("Name: " + counter + ": " + currentValue);
				lists.add(currentValue);

				if (currentValue.contains(expectedValue)) {

					if (driver.findElement(selectedValue).isDisplayed()) {

						driver.findElement(selectedValue).click();
						Thread.sleep(3000);
						selectedCLientNotFound = false;
						break;
					}

				} else if (currentValue != expectedValue && counter == clientCount) {

					counter = 0;
					System.out.println("Clicking next button");
					driver.findElement(nextPageButton).click();
					Thread.sleep(2000);
				}

			}

			System.out.println(selectedCLientNotFound);

		} while (selectedCLientNotFound);

	}
	
	public void clickaCheckbox_contacts(String expectedValue) throws InterruptedException {

		By dataLists = By.cssSelector("div.-workspace-content td a");
		
		selectedValue = checkBoxUtil.getaPrecidingCheckBox(expectedValue);
		

		List<String> lists = new ArrayList<>();

		int counter = 0;
		boolean selectedCLientNotFound = true;

		do {
			List<WebElement> elementsLists = driver.findElements(dataLists);
			int clientCount = elementsLists.size();
			for (WebElement e : elementsLists) {
				counter++;
				String currentValue = e.getText();
				System.out.println("Name: " + counter + ": " + currentValue);
				lists.add(currentValue);

				if (currentValue.contains(expectedValue)) {

					if (driver.findElement(selectedValue).isDisplayed()) {

						driver.findElement(selectedValue).click();
						selectedCLientNotFound = false;
						break;
					}

				} else if (currentValue != expectedValue && counter == clientCount) {

					counter = 0;
					System.out.println("Clicking next button");
					driver.findElement(nextPageButton).click();
				}

			}

			System.out.println(selectedCLientNotFound);

		} while (selectedCLientNotFound);

	}
	
	public void selectAssignedStaff(String expectedValue) throws InterruptedException {

		selectedValue = checkBoxUtil.getaPrecidingCheckBox(expectedValue);

		List<String> lists = new ArrayList<>();

		int counter = 0;
		boolean selectedCLientNotFound = true;

		do {
			List<WebElement> elementsLists = driver.findElements(assignedStaffList);
			int clientCount = elementsLists.size();
			for (WebElement e : elementsLists) {
				counter++;
				String currentValue = e.getText();
				System.out.println("Name: " + counter + ": " + currentValue);
				lists.add(currentValue);

				if (currentValue.contains(expectedValue)) {

					if (driver.findElement(selectedValue).isDisplayed()) {

						driver.findElement(selectedValue).click();
						selectedCLientNotFound = false;
						break;
					}

				} else if (currentValue != expectedValue && counter == clientCount) {

					counter = 0;
					System.out.println("Clicking next button");
					driver.findElement(nextPageButton).click();
				}

			}

			System.out.println(selectedCLientNotFound);

		} while (selectedCLientNotFound);

	}

	public String clickClientName(String expectedValue) {

		selectedValue = elementUtil.get_a_XpathData(expectedValue);

		By clientName = By.xpath("//h1[@class='-visible']");
		String expectedClientName = "";

		List<String> lists = new ArrayList<>();

		int counter = 0;
		boolean selectedCLientNotFound = true;

		do {
			List<WebElement> elementsLists = driver.findElements(dataLists);
			int clientCount = elementsLists.size();
			for (WebElement e : elementsLists) {
				counter++;
				String currentValue = e.getText();
				System.out.println("Name: " + counter + ": " + currentValue);
				lists.add(currentValue);

				if (currentValue.equals(expectedValue)) {

					if (driver.findElement(selectedValue).isDisplayed()) {

						driver.findElement(selectedValue).click();
						expectedClientName = driver.findElement(clientName).getText();
						selectedCLientNotFound = false;
						break;
					}

				} else if (currentValue != expectedValue && counter == clientCount) {

					counter = 0;
					System.out.println("Clicking next button");
					driver.findElement(nextPageButton).click();
				}

			}

			System.out.println(selectedCLientNotFound);

		} while (selectedCLientNotFound);

		return expectedClientName;
	}
	
	public int clickClientNameAndGetStaffCount(String expectedValue) throws InterruptedException {

		selectedValue = elementUtil.get_a_XpathData(expectedValue);
		By staffCount = By.xpath("//a[text()='"+expectedValue+"']/following::div[1]");
		String staffCountStringValue = "";
		int staffCountIntValue = 0;
		
		List<String> lists = new ArrayList<>();

		int counter = 0;
		
		boolean selectedCLientNotFound = true;

		do {
			List<WebElement> elementsLists = driver.findElements(dataLists);
			int clientCount = elementsLists.size();
			for (WebElement e : elementsLists) {
				counter++;
				String currentValue = e.getText();
				System.out.println("Name: " + counter + ": " + currentValue);
				lists.add(currentValue);

				if (currentValue.equals(expectedValue)) {

					if (driver.findElement(selectedValue).isDisplayed()) {
						
						Thread.sleep(2000);
						staffCountStringValue =  driver.findElement(staffCount).getText();
						
						staffCountIntValue = Integer.parseInt(staffCountStringValue);
						
						driver.findElement(selectedValue).click();
					
						selectedCLientNotFound = false;
						break;
					}

				} else if (currentValue != expectedValue && counter == clientCount) {

					counter = 0;
					System.out.println("Clicking next button");
					driver.findElement(nextPageButton).click();
				}

			}

			System.out.println(selectedCLientNotFound);

		} while (selectedCLientNotFound);
		
		return staffCountIntValue;
	}

	public String clickFileName(String expectedValue) {

		selectedValue = elementUtil.get_a_XpathData(expectedValue);

		By clientName = By.xpath("//div[@class='-preview-title']");
		String expectedClientName = "";

		List<String> lists = new ArrayList<>();

		int counter = 0;
		boolean selectedCLientNotFound = true;

		do {
			List<WebElement> elementsLists = driver.findElements(dataLists);
			int clientCount = elementsLists.size();
			for (WebElement e : elementsLists) {
				counter++;
				String currentValue = e.getText();
				System.out.println("Name: " + counter + ": " + currentValue);
				lists.add(currentValue);

				if (currentValue.equals(expectedValue)) {

					if (driver.findElement(selectedValue).isDisplayed()) {

						driver.findElement(selectedValue).click();
						expectedClientName = driver.findElement(clientName).getText();
						selectedCLientNotFound = false;
						break;
					}

				} else if (currentValue != expectedValue && counter == clientCount) {

					counter = 0;
					System.out.println("Clicking next button");
					driver.findElement(nextPageButton).click();
				}

			}

			System.out.println(selectedCLientNotFound);

		} while (selectedCLientNotFound);

		return expectedClientName;
	}

}
