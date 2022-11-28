package stepScenarios;

import com.page.AddNewTagPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewTagSteps {


	private AddNewTagPage addNewTagPage = new AddNewTagPage(DriverFactory.getDriver());
	
	@When("Click new tag button")
	public void click_new_tag_button() throws InterruptedException {
	
		addNewTagPage.clickNewTagButton();
	}

	@When("User enter a name {string}")
	public void user_enter_a_name(String name) throws InterruptedException{
	 
		addNewTagPage.enterName(name);
		
	}

	@When("Select a type {string}")
	public void select_a_type(String type) throws InterruptedException {
	    
		addNewTagPage.selectType(type);
	}

	@When("Click create custom tag button")
	public void click_create_custom_tag_button() {
	   
		addNewTagPage.clickCreateButton();
	}

	@Then("The new tag should be added on the custom tags list")
	public void the_new_tag_should_be_added_on_the_custom_tags_list() {
	
	}
}
