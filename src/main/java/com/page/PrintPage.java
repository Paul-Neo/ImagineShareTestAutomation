package com.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintPage {

	
	private WebDriver driver;
	
	public PrintPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	private By printBtn = By.xpath("//span[text()=' Print ']");
	private By iframe = By.tagName("iframe");
	private By latestFolder = By.xpath("//div[@class= 'table-cell -folder-empty']/following::a[1]");

	
	public void clickPrintBtn() throws InterruptedException {
		
		driver.findElement(printBtn).click();
		Thread.sleep(8000);
		
		
	}
	
	public boolean isFileReadyForPrint() {
		
		int frameCount = driver.findElements(iframe).size();
		int expectedCount = 4;
		boolean isFileReadyForPrint = false;
		
		if(frameCount == expectedCount) {
			
			System.out.println("Expected Frame Count: " + expectedCount);
			System.out.println("Actual Frame Count: " + frameCount);
			
			isFileReadyForPrint = true;
			
		}
		
		return isFileReadyForPrint;
		
	}
	
	public void clickLatestFolder() throws InterruptedException {
		
		driver.findElement(latestFolder).click();
		Thread.sleep(3000);
	
	}
	
	
}



