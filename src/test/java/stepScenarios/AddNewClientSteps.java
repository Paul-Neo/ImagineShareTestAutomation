package stepScenarios;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.AddNewClientPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewClientSteps {

	private AddNewClientPage addNewClient = new AddNewClientPage(DriverFactory.getDriver());
	private String expectedClientName;
	private String expectedClientIdentifier;
	private String expectedEngagementTypes;

	@Given("User is on Client Settings page")
	public void user_is_on_client_settings_page() {

		addNewClient.navigateToClientSettingsPage();
		
	}

	@When("User clicks new client button")
	public void user_clicks_new_client_button() {

		addNewClient.clickNewClientButton();
	}

	@When("Clicks Create new client")
	public void clicks_create_new_client() {

		addNewClient.clickCreateNewClientLink();
	}

	@When("User enters client information")
	public void user_enters_client_information(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> newClientInfo = dataTable.asMaps(String.class, String.class);

		String clientName = addNewClient.enterClientName();
		String clientIdentifier = addNewClient.enterClientIdentifier();
		String staffName = newClientInfo.get(0).get("Assign Staff");
		String engagementTypes = newClientInfo.get(0).get("Engagement Types");

		addNewClient.assignStaffAndSelectEngagementTypes(staffName, engagementTypes);

		// getting the expected clientName to use in assertion
		expectedClientName = clientName;
		expectedClientIdentifier = clientIdentifier;
		expectedEngagementTypes = engagementTypes;
	}

	@When("Click Next")
	public void click_next() {

		addNewClient.clickNext();
	}

	@Then("Staff Notification should be displayed")
	public void staff_notification_should_be_displayed(DataTable dataTable) throws InterruptedException {

		List<String> expectedNotificationLists = dataTable.asList();

		System.out.println("Expected Notification lists " + expectedNotificationLists);

		List<String> actualNotificationLists = addNewClient.getStaffNotifications();

		Assert.assertTrue(expectedNotificationLists.equals(actualNotificationLists));

		addNewClient.clickSave();

	}

	@Then("Client should be added on the client list")
	public void client_should_be_added_on_the_client_list() throws InterruptedException {

		Assert.assertTrue(addNewClient.isClientAddedSuccessfully(expectedClientName));

	}

	@Then("Clients Overview should be correct")
	public void clients_overview_should_be_correct() {

		Assert.assertTrue(addNewClient.isClientGeneralInfoCorrect(expectedClientName, expectedClientIdentifier,
				expectedEngagementTypes));

	}

	@When("User Selects a Client {string}")
	public void user_selects_a_client(String clientName) throws InterruptedException {

		addNewClient.selectClient(clientName);

		expectedClientName = clientName;

	}

	@Then("Selected Client should be on the archive list")
	public void selected_client_should_be_on_the_archive_list() {

		
		Assert.assertTrue(addNewClient.isClientMovedToArchived(expectedClientName));

	}

	@When("User Selects a client in the archive list")
	public void user_selects_a_client_in_the_archive_list() throws InterruptedException {

		addNewClient.selectClientFromArchivedList(expectedClientName);
	}

	@Then("Client Should be deleted")
	public void client_should_be_deleted() {

		Assert.assertTrue(addNewClient.isClientSuccessfullyDeleted());
	}

}
