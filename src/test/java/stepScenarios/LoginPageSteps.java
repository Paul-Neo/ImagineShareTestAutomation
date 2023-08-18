package stepScenarios;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.URL;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private URL url = new URL();

	@Given("User is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver().get(url.getUrl());

		loginPage.waitLoginPageToLoad();
	}
	
	@Given("User turned on the Two Factor Authentication")
	public void user_turned_on_the_two_factor_authentication(DataTable dataTable) throws InterruptedException {
		
		List<Map<String, String>> userCredentials = dataTable.asMaps(String.class, String.class);
		
		DriverFactory.getDriver().get(url.getUrl());
		
		loginPage.waitLoginPageToLoad();
		
		String userName = userCredentials.get(0).get("User Name");
		String password = userCredentials.get(0).get("Password");
		
		loginPage.doLogin(userName, password);
		
		loginPage.turnOn_TFA();
		loginPage.logOutUser();

	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() throws InterruptedException {

		loginPage.getTitlePage();
	}

	@Then("Title page should be {string}")
	public void title_page_should_be(String expectedTitleName) throws InterruptedException {

		String actualTitleName = loginPage.getTitlePage();

		System.out.println("Expected Page Title Name is: " + expectedTitleName);
		System.out.println("Actual Page Title Name is: " + actualTitleName);

		Assert.assertTrue(expectedTitleName.equals(actualTitleName));

	}

	@When("User enters correct email address {string}")
	public void user_enters_correct_email_address(String emailAddres) {

		loginPage.setEmailAddress(emailAddres);

	}

	@When("User enters correct password {string} and User gets the title of the page")
	public void user_enters_correct_password_and_user_gets_the_title_of_the_page(String password) {

		loginPage.setPassword(password);
	}

	@When("Clicks Sign In button")
	public void clicks_sign_in_button() throws InterruptedException {

		loginPage.clickSignInButton();
	}

	@Then("Two Factor Authentication displayed")
	public void two_factor_authentication_displayed() {

		Assert.assertTrue(loginPage.isTwoFactorAuthDisplayed());
	}

	@When("User enter correct six digit code")
	public void user_enter_correct_six_digit_code() {

		loginPage.setSixDigitCode();
	}

	@When("Click verify")
	public void click_verify() throws InterruptedException {
		loginPage.clickVerify();
	}

	@Then("User will login successfully")
	public void user_will_login_successfully() {

	}

	@When("User enters wrong email address {string}")
	public void user_enters_wrong_email_address(String wrongEmailAddress) {

		loginPage.setEmailAddress(wrongEmailAddress);
	}

	@When("User enters wrong password {string}")
	public void user_enters_wrong_password(String wrongPassword) {

		loginPage.setPassword(wrongPassword);
	}

	@Then("Error message should be displayed {string}")
	public void error_message_should_be_displayed(String expectedErrorMessage) {

		String actualErrorMessage = loginPage.getSigInErrorMessage();

		System.out.println("Expected Error Message is: " + expectedErrorMessage);
		System.out.println("Actual Error Message is: " + actualErrorMessage);
	}

	@Then("User clicks try again button")
	public void user_clicks_try_again_button() {

		loginPage.clickTryAgainButton();
	}

	@When("User clicks forgot password")
	public void user_clicks_forgot_password() {

		loginPage.clickForgotPassword();
	}

	@Then("Forgot password window should be displayed")
	public void forgot_password_window_should_be_displayed() {

		Assert.assertTrue(loginPage.isForgotPasswordFormExist());
	}

	@When("User clicks back to login")
	public void user_clicks_back_to_login() throws InterruptedException {

		loginPage.clickBackToLoginButton();
	}

	@Then("Sign in with Microsoft should be displayed")
	public void sign_in_with_microsoft_should_be_displayed() {

		loginPage.clickSignInWithSSO();
	}
	
	@When("User turned off the Two Factor Authentication")
	public void user_turned_off_the_two_factor_authentication() throws InterruptedException {
	   
		loginPage.turnOff_TFA();
	}
	
	@Then("Enable TFA button should be displayed")
	public void enable_tfa_button_should_be_displayed() {
	
		Assert.assertTrue(loginPage.isTFA_turnOff());
	}

}
