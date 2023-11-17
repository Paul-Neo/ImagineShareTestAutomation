package stepScenarios;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.AllWorkspacesPage;
import com.page.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.URL;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllWorkspacesPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AllWorkspacesPage allWorkspacesPage = new AllWorkspacesPage(DriverFactory.getDriver());

	@Given("User has already logged in to Imagine Time")
	public void user_has_already_logged_in_to_imagine_time(DataTable dataTable) throws InterruptedException {

		URL url = new URL();

		List<Map<String, String>> userCredential = dataTable.asMaps();

		String emailAddress = userCredential.get(0).get("Email Address");
		String password = userCredential.get(0).get("Password");

		loginPage.waitLoginPageToLoad();

		DriverFactory.getDriver().get(url.getUrl());

		System.out.println("Email Adress: " + emailAddress);
		System.out.println("Password: " + password);
		loginPage.doLogin(emailAddress, password);
		
	}

	@Then("User Select a firm {string}")
	public void user_select_a_firm(String firmName) throws InterruptedException {

		allWorkspacesPage.selectFirm(firmName);
		
	}

	@Then("Profile firm should be {string}")
	public void profile_firm_should_be(String expectedFirmProfile) {
		
		System.out.println("Expected Firm Profile is: " + expectedFirmProfile);

		String actualFirmProfile = allWorkspacesPage.getFirmProfile(expectedFirmProfile);
		System.out.println("Actual Firm Profile is: " + actualFirmProfile);

		Assert.assertTrue(expectedFirmProfile.equals(actualFirmProfile));

	}

	@Given("User is on {string} page")
	public void user_is_on_all_client_page(String basePageTabName) throws InterruptedException {

		allWorkspacesPage.clickBasePageTab(basePageTabName);
		
	}

	@When("User gets the side bar links lists")
	public void user_gets_the_side_bar_links_lists(DataTable dataTable) {

		List<String> expectedLinksList = dataTable.asList();
		System.out.println("Expected Links List: " + expectedLinksList);

		List<String> actualLinksList = allWorkspacesPage.getSideBarLinks();
		System.out.println("Actual Links List: " + actualLinksList);

		Assert.assertTrue(expectedLinksList.equals(actualLinksList));

	}

	@When("Links count shoud be {int}")
	public void links_count_shoud_be(Integer expectedCount) {
		
		Assert.assertTrue(allWorkspacesPage.getSideBarLinkcount() == expectedCount);
		
	}
	
	
}
