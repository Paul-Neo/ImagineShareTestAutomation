package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintPage {

	
	private WebDriver driver;
	
	public PrintPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	private By printBtn = By.xpath("//span[text()=' Print ']");
	private By printIframe = By.xpath("");
	
	
	public void clickPrintBtn() throws InterruptedException {
		
		driver.findElement(printBtn).click();
		Thread.sleep(3000);
		
	}
	
	public boolean isFileReadyForPrint() {
		
		driver.switchTo().frame("");
		
		
		return true;
	}
	
}
