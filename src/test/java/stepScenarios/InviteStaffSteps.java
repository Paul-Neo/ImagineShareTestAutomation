package stepScenarios;


import org.junit.Assert;

import com.page.InviteStaffPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InviteStaffSteps {

	private InviteStaffPage inviteStaffPage = new InviteStaffPage(DriverFactory.getDriver());
	private String staffName;
	private int expectedStaffMemberCount;
	
	@Given("User is on Firm Settings page")
	public void user_is_on_firm_settings_page() {

		inviteStaffPage.navigateToFirmSettingsPage();
		
	}

	@When("User Click Members tab")
	public void user_click_members_tab() throws InterruptedException {
		
		inviteStaffPage.clickMemeberstab();
		
		int staffMembercount =  inviteStaffPage.getStaffMemberCount();
		
		System.out.println("Staff Member Count before inviting is: " + staffMembercount);
		
		expectedStaffMemberCount = staffMembercount;
	}
	
	@When("Click Invite staff button")
	public void click_invite_staff_button() throws InterruptedException {

		inviteStaffPage.clickInviteStaffButton();
	}
	
	@When("Create new staff")
	public void create_new_staff() throws InterruptedException {

		inviteStaffPage.selectCreateNewStaff();
	}
	
	@When("User Fill up Staff information")
	public void user_fill_up_staff_information() throws InterruptedException {
		
		staffName = inviteStaffPage.setupNewStaffInfo();
		
	}
	
	@When("User send an Invite")
	public void user_send_an_invite() throws InterruptedException {
	    
		inviteStaffPage.sendInvite();
	
	}
	
	@Then("New Staff should be added on the list")
	public void new_staff_should_be_added_on_the_list() {

		inviteStaffPage.isNewStaffAddedOnTheList(staffName);
	}

	@When("User click settings for selected staff member")
	public void user_click_settings_for_selected_staff_member() throws InterruptedException {
	    
		inviteStaffPage.clickStaffMemberSettings(staffName);
	}
	
	@When("Select {string} status")
	public void select_status(String status) {
	
		inviteStaffPage.updateStaffStatus(status);
	}
	
	@When("Delete the staff member")
	public void delete_the_staff_member() throws InterruptedException {
	
		inviteStaffPage.deleteStaff(staffName);
	}
	
	@Then("Staff member count should be correct")
	public void staff_member_count_should_be() {
	
		System.out.println("Expected StaffMember Count is: " + expectedStaffMemberCount);
		
		int actualStaffMemberCount =  inviteStaffPage.getStaffMemberCount();
		System.out.println("Actual StaffMember Count is: " + actualStaffMemberCount);
		
		Assert.assertEquals(actualStaffMemberCount, expectedStaffMemberCount);
		
	}


}
