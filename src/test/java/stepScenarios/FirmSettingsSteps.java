package stepScenarios;

import java.util.List;

import org.junit.Assert;

import com.page.FirmSettingsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirmSettingsSteps {
	
	
	private FirmSettingsPage firmSettings = new FirmSettingsPage(DriverFactory.getDriver());
	private List<String> actualAccountLists;
	
	

	@Given("User is on accounts page")
	public void user_is_on_accounts_page() {

		System.out.println("User is on accounts page");
	}

	
	@Then("Firms should be displayed")
	public void firms_should_be_displayed(DataTable dataTable) {
		
		List<String> expectedAccountLists =  dataTable.asList();
		
		actualAccountLists = firmSettings.getFirms();

		System.out.println("Expected Account Lists: " + expectedAccountLists);
		System.out.println("Acctual Account Lists: " + actualAccountLists);
		
		Assert.assertTrue(actualAccountLists.equals(expectedAccountLists));
		
	}
	
	@When("User Go to Admin")
	public void user_go_to_admin() {
		
		firmSettings.clickGoToAdmin();

	}
	
	@When("Click a firm {string}")
	public void click_a_firm(String firmName) {
	  
		firmSettings.clickFirm(firmName);
		
	}
	
	@When("Update subscription status {string}")
	public void update_subscription_status(String subscriptionStatus) throws InterruptedException {
	  
		firmSettings.changeFirmStatus(subscriptionStatus);
		firmSettings.navigateToAccountSelections();
	
	}
	
	@Then("Links should be displayed")
	public void links_should_be_displayed(DataTable dataTable) {
	  
		List<String> expectedLinkNames =  dataTable.asList();
		System.out.println("Expected Link Names : " + expectedLinkNames);
		
		List<String> actualLinkNames =  firmSettings.getFirmSettingsPageLinks();
		System.out.println("Actual Link Names : " + actualLinkNames );
		
		Assert.assertTrue(expectedLinkNames.equals(actualLinkNames));
		
		
	}



}
