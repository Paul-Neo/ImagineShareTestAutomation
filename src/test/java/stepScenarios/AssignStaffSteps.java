package stepScenarios;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.AssignStaffPage;
import com.qa.factory.DriverFactory;
import com.qa.util.FileFinderUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignStaffSteps {

	private AssignStaffPage assignStaffPage = new AssignStaffPage(DriverFactory.getDriver());
	private FileFinderUtil clientFinder = new FileFinderUtil(DriverFactory.getDriver());
	private String clientName;
	private int expectedStaffCount;
	private int actualStaffCount;
	

	@When("User Selects a client {string}")
	public void user_selects_a_client(String selectedClientName) throws InterruptedException {

		clientFinder.clickaCheckbox(selectedClientName);
		clientName = selectedClientName;
	}

	@Then("Tool Bar buttons should enabled")
	public void tool_bar_buttons_should_enabled() {
		
		Assert.assertTrue(assignStaffPage.areToolBarButtonsEnabled());
	}

	@When("User click Assign Staff button")
	public void user_click_assign_staff_button() throws InterruptedException {

		assignStaffPage.clickAssignStaffToolBarButton();
	}

	@When("User Select a Staff {string}")
	public void user_select_a_staff(String staffName) throws InterruptedException {

		assignStaffPage.selectStaff(staffName);
	}

	@When("Click next button")
	public void click_next_button() {

		assignStaffPage.clickNextButton();

	}

	@Then("Assigned staff notification settings should be displayed")
	public void assigned_staff_notification_settings_should_be_displayed(DataTable dataTable) {
		List<String> notifSettings = dataTable.asList(String.class);

		System.out.println("Expected Notification Settings: " + notifSettings);

		List<String> actualNotifSettings = assignStaffPage.getNotifSettings();

		Assert.assertTrue(notifSettings.equals(actualNotifSettings));

	}

	@When("Click Assign Staff button")
	public void click_assign_staff_button() {

		Assert.assertTrue(assignStaffPage.clickAssignStaffButton());

	}

	@Then("Staff should exist on Clients Assinged Staff list")
	public void staff_should_exist_on_clients_assinged_staff_list() {

	}

	// test2
	@When("User Clicks a client {string}")
	public void user_clicks_a_client(String clientName) {

		clientFinder.clickClientName(clientName);
	}

	@When("Assign a staff {string}")
	public void assign_a_staff(String staffName) throws InterruptedException {

		assignStaffPage.doAssignStaff(staffName);
	}

	@Then("Assined staffs should be dispalyed")
	public void assined_staffs_should_be_dispalyed(DataTable dataTable) {

		List<String> expectedStaffLists = dataTable.asList();

		List<String> actualStaffLists = assignStaffPage.getAssignedStaffs();

		System.out.println("Expected Staffs: " + expectedStaffLists);
		System.out.println("Actual Staffs: " + actualStaffLists);

		Assert.assertTrue(expectedStaffLists.equals(actualStaffLists));
	}

	@When("User unassign a staff {string}")
	public void user_unassign_a_staff(String staffName) throws InterruptedException {

		clientFinder.selectAssignedStaff(staffName);
		assignStaffPage.unassignStaff();

	}

	@Then("Staff should be removed from the list")
	public void staff_should_be_removed_from_the_list(DataTable dataTable) {

		List<String> expectedStaffLists = dataTable.asList();

		List<String> actualStaffLists = assignStaffPage.getAssignedStaffs();

		System.out.println("Expected Staffs: " + expectedStaffLists);
		System.out.println("Actual Staffs: " + actualStaffLists);

		Assert.assertTrue(expectedStaffLists.equals(actualStaffLists));

	}

	// test3
	@When("User assign multiple staffs")
	public void user_assign_multiple_staffs(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> staffs = 	dataTable.asMaps(String.class, String.class);
		
		String staff_1 = staffs.get(0).get("Staff1");
		String staff_2 = staffs.get(0).get("Staff2");
		
		assignStaffPage.assignMultipleSttafs(staff_1, staff_2);
	}

	@Then("Staffs should be assigned to client")

	public void staffs_should_be_assigned_to_client(DataTable dataTable) throws InterruptedException {

		assignStaffPage.navigateToAssignedStaffTab(clientName);
		
		List<String> expectedStaffLists = dataTable.asList();
		List<String> actualStaffLists = assignStaffPage.getAssignedStaffs();

		System.out.println("Expected Staffs: " + expectedStaffLists);
		System.out.println("Actual Staffs: " + actualStaffLists);

		Assert.assertTrue(expectedStaffLists.equals(actualStaffLists));
		
	}

	@When("User select all assigned staffs")
	public void user_select_all_assigned_staffs() {

		assignStaffPage.selectAllStaffs();
	}

	@When("Click Unassigned staff")
	public void click_unassigned_staff() throws InterruptedException {

		assignStaffPage.unassignStaff();
	}

	@Then("Message should be displayed {string}")
	public void message_should_be_displayed(String expectedMessage) {

		System.out.println("Expected Message is: " + expectedMessage);
	
		String actualMessage =  assignStaffPage.getExpectedMessage();
		System.out.println("Actual Message is: " + actualMessage);
		
		Assert.assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	/*
	 * 
	 * This Code is to Check Assigned staff counts if correct
	 * 
	 */
	
	
	@When("User get assigned staff count for {string}")
	public void user_get_assigned_staff_count_for(String clientName) throws InterruptedException {
		
		expectedStaffCount = clientFinder.clickClientNameAndGetStaffCount(clientName);
		
		System.out.println("Expected Staff Count is: " + expectedStaffCount);

	}
	
	@When("Get total number of assigned staffs")
	public void get_total_number_of_assign_staffs() {
	   
		actualStaffCount = assignStaffPage.getAssignedStaffCount();
		
		System.out.println("Actual Staff Count is: " + actualStaffCount);
	}
	
	@Then("Assign Staff counts should be correct")
	public void assign_staff_counts_should_be_correct() {
	  
		Assert.assertEquals(expectedStaffCount, actualStaffCount);
	}

	
}
