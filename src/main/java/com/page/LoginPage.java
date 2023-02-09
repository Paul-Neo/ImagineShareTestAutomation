package com.page;

import java.util.concurrent.TimeUnit;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.NavigateUtil;
import com.qa.util.ScrollUtil;

public class LoginPage {

	private WebDriver driver;
	
	//construction
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//Locators
	private By emailAddress = By.name("email");
	private By password = By.name("password");
	private By signInButton = By.xpath("//button[text()=' Sign in ']");
	
	private final String  SECRETCODE = "IFFTQXSLIQUCU4BJGI2XAWZXMY7WKTZG";
	private By twoFactorAuth = By.xpath("//div[text()='Two Factor Authentication']");
	private By otp = By.xpath("//input[@name='otp']");
	private By verifyButton = By.xpath("//button[text()='Verify']");
	
	private By signInErrorMessage = By.xpath("//div[text()='Error with sign in']");
	private By tryAgainButton = By.xpath("//button[text()='Try again']");
	
	private By forgotPasswordLink = By.xpath("//em[text()='Forgot Password?']");
	private By forgotPasswordForm = By.xpath("//form[@name='forgotPassowrdForm']");
	private By backToLoginButton = By.xpath("//a[text()=' Back To Login ']");
	
	private By loginWithSSO = By.xpath("//*[local-name()='svg']");
	
	private By profileDropDown = By.xpath("//div[@class='-profile-info']");
	private By securityCodeTxt = By.xpath("//label[text()='Security Code']/following::input[1]");
	private By enableTfaButton = By.xpath("//button[text()='Enable TFA']");
	private By logout = By.xpath("//a[text()='Logout']");
	private By goToAdmin = By.xpath("//a[text()='Go to admin']");
	private By disabledTfaButton = By.xpath("//button[text()='Disable TFA']");
	
	//page actions
	
	public void waitLoginPageToLoad() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public String getTitlePage() throws InterruptedException {
		
		// comment out sleep when doing a regression test to avoid error in getting title page
		Thread.sleep(2000);
		return driver.getTitle();
		
	}
	
	public void enterEmailAddress(String emailAddress) {
		
		driver.findElement(this.emailAddress).sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) {
		
		driver.findElement(this.password).sendKeys(password);
	}
	
	public boolean isTwoFactorAuthDisplayed() {
		
		return driver.findElement(twoFactorAuth).isDisplayed();
	}
	
	/**
	 * Getting OTP code
	 *
	 * */
	
	public String getOtp() {
		
		Totp totp = new Totp(SECRETCODE);
		String twoFactorCode = totp.now();
		
		return twoFactorCode;
	}
	
	public void enterSixDigitCode() {
		
		String twoFactorCode = getOtp();
		driver.findElement(otp).sendKeys(twoFactorCode);
		

	} 
	
	public void clickVerify() throws InterruptedException {
		
		driver.findElement(verifyButton).click();
		Thread.sleep(3000);
		
	}
	
	public void clickSignInButton() throws InterruptedException {
		
		driver.findElement(signInButton).click();
		Thread.sleep(4000);
	}
	
	public String getSigInErrorMessage() {
		
		return driver.findElement(signInErrorMessage).getText();
	}
	
	public void clickTryAgainButton() {
		
		driver.findElement(tryAgainButton).click();
	}
	
	public void clickForgotPassword() {
		
		driver.findElement(forgotPasswordLink).click();
	}
	
	public boolean isForgotPasswordFormExist() {
		
		return driver.findElement(forgotPasswordForm).isDisplayed();
	}
	
	public void clickBackToLoginButton() throws InterruptedException {
		
		driver.findElement(backToLoginButton).click();
		Thread.sleep(3000);
	}
	
	public void clickSignInWithSSO() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement clickSigIn = driver.findElement(loginWithSSO);
		clickSigIn.click();
		
	}
	
	public void doLogin(String emailAddress, String password) throws InterruptedException {
		
		driver.findElement(this.emailAddress).sendKeys(emailAddress);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(signInButton).click();
		Thread.sleep(3000);
		
		
	}

	public void logOutUser() throws InterruptedException {
		
		driver.findElement(profileDropDown).click();
		driver.findElement(logout).click();
		Thread.sleep(33000);
		
	}
	
	public void turnOn_TFA() throws InterruptedException {
		
		ScrollUtil scrollDown = new ScrollUtil(driver);
		NavigateUtil nav = new NavigateUtil(driver);
		
		driver.findElement(goToAdmin).click();
		Thread.sleep(3000);
		nav.navigateToMyProfile();
		
		scrollDown.scrollPage(1500);
		
		String twoFactorCode = getOtp();
		
		driver.findElement(securityCodeTxt).sendKeys(twoFactorCode);
		Thread.sleep(2000);		
		driver.findElement(enableTfaButton).click();
		Thread.sleep(3000);
	
		
	}
	
	public void turnOff_TFA() throws InterruptedException {
		
		NavigateUtil nav = new NavigateUtil(driver);
		
		driver.findElement(goToAdmin).click();
		Thread.sleep(3000);
		
		nav.navigateToMyProfile();
		
		driver.findElement(disabledTfaButton).click();
	
		Thread.sleep(2000);
	}
	
	public boolean isTFA_turnOff() {
		
		return driver.findElement(enableTfaButton).isDisplayed();
		
	}
		
	
}
