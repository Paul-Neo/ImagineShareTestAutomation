package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the threadLocal driver on the basis of
	 * given browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver init_Driver(String browser) {

		System.out.println("browser valus is: " + browser);

		if (browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			
		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			
		} else {
			System.out.println("Incorrect browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return getDriver();
	}

	/**
	 * This method used to get driver with threadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		
		
		return tlDriver.get();
	}

}
