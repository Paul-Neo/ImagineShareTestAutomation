package stepScenarios;

import org.junit.Assert;

import com.page.AdminPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps {

	private AdminPage admin = new AdminPage(DriverFactory.getDriver());
	
	@Given("User is on Admin Page")
	public void user_is_on_admin_page() {
		
		admin.navigateToAdminPage();
	   
	}
	
	@When("Clicks user profile dropdown")
	public void clicks_user_profile_dropdown() {
		
		admin.clickUserProfileDropdown();
	   
	}
	
	@Then("Dropdown menu should be correct")
	public void dropdown_menu_should_be_correct() {
	
		Assert.assertTrue(admin.isDropdownMenuComplete());
	}
}
