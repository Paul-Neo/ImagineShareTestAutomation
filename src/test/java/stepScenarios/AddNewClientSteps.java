package stepScenarios;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.AddNewClientPage;
import com.page.AllWorkspacesPage;
import com.qa.factory.DriverFactory;
import com.qa.util.NavigateUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewClientSteps {

	private AddNewClientPage addNewClient = new AddNewClientPage(DriverFactory.getDriver());
	private NavigateUtil navigateUtil = new NavigateUtil(DriverFactory.getDriver());
	
	private String expectedClientName;
	private String expectedClientIdentifier;
	private String expectedEngagementTypes;
	private String deletedClientName;
	private String newClientName;
	private String newClientID;
	private String newEngagementTypes;
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String postalCode;
	private String country;
	private String state;
	
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

		String clientName = addNewClient.setClientName();
		String clientIdentifier = addNewClient.setClientIdentifier(clientName);
		
		String staffName = newClientInfo.get(0).get("Assign Staff");
		String engagementTypes = newClientInfo.get(0).get("Engagement Types");

		addNewClient.assignStaffAndSelectEngagementTypes(staffName, engagementTypes);

		// getting the expected clientName to use in assertion
		expectedClientName = clientName;
		expectedClientIdentifier = clientIdentifier;
		expectedEngagementTypes = engagementTypes;
	}

	@When("Click Next")
	public void click_next() throws InterruptedException {

		addNewClient.clickNext();
	}

	@Then("Staff Notification should be displayed")
	public void staff_notification_should_be_displayed(DataTable dataTable) throws InterruptedException {

		List<String> expectedNotificationLists = dataTable.asList();
		System.out.println("Expected Notification lists " + expectedNotificationLists);

		List<String> actualNotificationLists = addNewClient.getStaffNotifications();
		Assert.assertTrue(expectedNotificationLists.equals(actualNotificationLists));

		addNewClient.clickSaveButton();
		addNewClient.sleep();
		
	}

	@Then("Client should be added on the client list")
	public void client_should_be_added_on_the_client_list() throws InterruptedException {

//		Assert.assertTrue(addNewClient.isClientAddedSuccessfully(expectedClientName));

	}

	@Then("Clients Overview should be correct")
	public void clients_overview_should_be_correct() throws InterruptedException {

		Assert.assertTrue(addNewClient.isClientGeneralInfoCorrect(expectedClientName, expectedClientIdentifier,
				expectedEngagementTypes));

	}

	@When("User Selects a Client")
	public void user_selects_a_client() throws InterruptedException {

		addNewClient.selectClient(expectedClientName);

		deletedClientName = expectedClientName;

	}

	@Then("Selected Client should be on the archive list")
	public void selected_client_should_be_on_the_archive_list() {
		
		Assert.assertTrue(addNewClient.isClientMovedToArchived(deletedClientName));

	}

	@When("User Selects a client in the archive list")
	public void user_selects_a_client_in_the_archive_list() throws InterruptedException {

		addNewClient.selectClientFromArchivedList(deletedClientName);
	}

	@Then("Client Should be deleted")
	public void client_should_be_deleted() {

		Assert.assertTrue(addNewClient.isClientSuccessfullyDeleted(deletedClientName));
	}
		
	@Given("User added a new Client")
	public void user_added_a_new_client() throws InterruptedException {
	 
//		addNewClient.navigateToClientSettingsPage();
		navigateUtil.clickBasePageTab("Workspaces");
		addNewClient.clickNewClientButton();
		addNewClient.clickCreateNewClientLink();
		
	
	
		String clientName = addNewClient.setClientName();
		String clientIdentifier = addNewClient.setClientIdentifier(clientName);
		
		String staffName = "Paul Napadao";
		String engagementTypes = "1040";

		addNewClient.assignStaffAndSelectEngagementTypes(staffName, engagementTypes);
		
		// getting the expected clientName to use in assertion
		expectedClientName = clientName;
		expectedClientIdentifier = clientIdentifier;
		expectedEngagementTypes = engagementTypes;
		
		addNewClient.clickNext();
		addNewClient.clickSaveButton();
		
		
	}
	
	@When("User select a client")
	public void user_select_a_client() throws InterruptedException {
		
		addNewClient.findAndClickClientName(expectedClientName);

	}
	
//	@When("Navigates to {string} tab")
//	public void navigates_to_tab(String tabName) throws InterruptedException {
//		
//		addNewClient.navigateToTab(tabName);
//		
//		Assert.assertTrue(addNewClient.isClientGeneralInfoCorrect(expectedClientName, expectedClientIdentifier,
//				expectedEngagementTypes));
//	    
//	}

	
	@When("Updates client info")
	public void updates_client_info() throws InterruptedException {
	    
		addNewClient.clickUpdateGeneralInfo();
		
		newClientName =  addNewClient.setNewClientName();
		newClientID = addNewClient.setNewClientID(newClientName);
		newEngagementTypes = addNewClient.updateEngagementTypes();
		
		System.out.println("New Client Name: " + newClientName);
		System.out.println("New Client ID: " + newClientID);
		System.out.println("New Added Engagement Types: " + newEngagementTypes);
		
		addNewClient.clickSaveButton();
		
	}
	
	@Then("Clients info should be updated")
	public void clients_info_should_be_updated() throws InterruptedException {
	  
		Assert.assertTrue(addNewClient.isClientGeneralInfoCorrect
				(newClientName, newClientID, newEngagementTypes));
		
	}
	
	@When("Enter Phone number")
	public void enter_phone_number() throws InterruptedException {
		
		addNewClient.setPhoneNumber();	
	   
	}
	
	@When("User click set primary")
	public void user_click_set_primary() throws InterruptedException {
		
	   
		addNewClient.clickSetPrimary();
	}
	
	@Then("Number should be set as primary")
	public void number_should_be_set_as_primary() {
	   
		
		Assert.assertTrue(addNewClient.isPhoneNumberSetAsPrimary());
	}
	
	@When("Enter Address")
	public void enter_address() throws InterruptedException {
		
		addNewClient.clickAddAddress();
		
		streetAddress1 = addNewClient.setStreetAddress1();
		streetAddress2 = addNewClient.setStreetAddress2();
		city = addNewClient.setCity();
		postalCode = addNewClient.setPostalCode();
		country = addNewClient.selectValueInAddressDropdown("Country", "United States");
		state = addNewClient.selectValueInAddressDropdown("State", "AL");
		
		addNewClient.clickAddAddress2();
	
	}
	
	
	@Then("Address should be set as primary")
	public void address_should_be_set_as_primary() {
		
		String expectedFullAddress = streetAddress1 + ", " + streetAddress2 + 
				"\n" + city + ", " + state + " " + 
				postalCode + "\n" + "US" + "\n" + "(Primary)";
		
		String actualFullAddress = addNewClient.getFullAddress();
		
		System.out.println("Expected Full Address: " + expectedFullAddress);
		System.out.println(" Actual Full Address: " + addNewClient.getFullAddress());
		
		
		Assert.assertTrue(expectedFullAddress.equals(actualFullAddress));
		
	}

}
