package com.page;

import java.util.concurrent.TimeUnit;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.util.NavigateUtil;
import com.qa.util.PageActions;
import com.qa.util.ScrollUtil;

public class LoginPage extends PageActions {

	private WebDriver driver;

	// constructor
	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators
	private By emailAddressTxtField = By.name("email");
	private By passwordTxtField = By.name("password");
	private By signInBtn = By.xpath("//button[text()=' Sign in ']");

	private final String SECRETCODE = "IFFTQXSLIQUCU4BJGI2XAWZXMY7WKTZG";
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

	/** Page Actions **/

	public void waitLoginPageToLoad() {

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public void turnOn_TFA() throws InterruptedException {

		ScrollUtil scrollDown = new ScrollUtil(driver);
		NavigateUtil nav = new NavigateUtil(driver);

		clickOn(driver, goToAdmin);
		nav.navigateToMyProfile();

		scrollDown.scrollPage(1500);

		String twoFactorCode = getOtp();

		sendKeys(driver, securityCodeTxt, twoFactorCode);
		clickOn(driver, enableTfaButton);
		Thread.sleep(3000);
	}

	public void turnOff_TFA() throws InterruptedException {

		NavigateUtil nav = new NavigateUtil(driver);

		clickOn(driver, goToAdmin);
		nav.navigateToMyProfile();

		clickOn(driver, disabledTfaButton);

		Thread.sleep(2000);
	}

	public boolean isTFA_turnOff() {

		return isElementDisplayed(driver, enableTfaButton);

	}

	public void clickBackToLoginButton() throws InterruptedException {

		clickOn(driver, backToLoginButton);
		Thread.sleep(3000);
	}

	public void clickSignInWithSSO() {

		WebElement clickSigIn = driver.findElement(loginWithSSO);
		clickSigIn.click();
	}

	public void doLogin(String emailAddress, String password) throws InterruptedException {

		sendKeys(driver, emailAddressTxtField, emailAddress);
		sendKeys(driver, passwordTxtField, password);
		clickOn(driver, signInBtn);
		Thread.sleep(3000);

	}

	public void logOutUser() throws InterruptedException {

		clickOn(driver, profileDropDown);
		clickOn(driver, logout);
		Thread.sleep(3000);

	}

	public boolean isTwoFactorAuthDisplayed() {

		return isElementDisplayed(driver, twoFactorAuth);
	}

	public void clickVerify() throws InterruptedException {

		clickOn(driver, verifyButton);
	}

	public void clickSignInButton() throws InterruptedException {

		clickOn(driver, signInBtn);

		Thread.sleep(4000);
	}

	public void clickTryAgainButton() {

		clickOn(driver, tryAgainButton);
	}

	public void clickForgotPassword() {

		clickOn(driver, forgotPasswordLink);
	}

	public boolean isForgotPasswordFormExist() {

		return isElementDisplayed(driver, forgotPasswordForm);
	}

	/** Setters **/

	public void setEmailAddress(String emailAddress) {

		sendKeys(driver, emailAddressTxtField, emailAddress);
	}

	public void setPassword(String password) {

		sendKeys(driver, passwordTxtField, password);
	}

	public void setSixDigitCode() {

		String twoFactorCode = getOtp();

		sendKeys(driver, otp, twoFactorCode);

	}

	/** Getters **/
	
	public String getTitlePage() throws InterruptedException {

		// comment out sleep when doing a regression test to avoid error in getting
		// title page
		Thread.sleep(2000);
		return driver.getTitle();
	}

	public String getSigInErrorMessage() {

		return getElementText(driver, signInErrorMessage);
	}
	
	public String getOtp() { //Get OTP

		Totp totp = new Totp(SECRETCODE);
		String twoFactorCode = totp.now();

		return twoFactorCode;
	}

}
