package stepScenarios;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.AddNewContactPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewContactStep {

	private AddNewContactPage addNewContact = new AddNewContactPage(DriverFactory.getDriver());
	private String contactName;
	
	
	@Given("User is on Client Settings Overview {string}")
	public void user_is_on_client_settings_overview(String clientName) throws InterruptedException {
	    
		addNewContact.navigateToClientsOverview(clientName);
		
	}
	
	@When("Click Add contacts button")
	public void click_add_contacts_button() {
	   
		addNewContact.clickAddContactsBtn();
		
	}
	
	@When("User fill up add contact form")
	public void user_fill_up_add_contact_form(DataTable dataTable) throws InterruptedException {
	 
		List<Map<String, String>> contactInfo =  dataTable.asMaps(String.class, String.class);
		
		String emailAddress = contactInfo.get(0).get("Email Address");
		String fullName = contactInfo.get(0).get("Full Name");
		String personalNote = contactInfo.get(0).get("Personal Note");
				
		addNewContact.fillContactsInfo(emailAddress, fullName, personalNote);
		contactName = fullName;
		
	}
	
	@When("User send an invitation to contacts")
	public void user_send_an_invitation_to_contacts() throws InterruptedException {
	   	
		addNewContact.sendContactInvitation();
		
	}
	
	@Then("Contact should be added on client contacts list")
	public void contact_should_be_added_on_client_contacts_list() throws InterruptedException {
	 
		System.out.println("Finding " + contactName);
		addNewContact.isContactSuccessfullyAdded(contactName);
		
	}
	
	@When("User delete the contact")
	public void user_delete_the_contact() throws InterruptedException {
	   
		addNewContact.deleteContact(contactName);
	}
	
	@Then("Contact should be deleted")
	public void contact_should_be_deleted() {
	    
		Assert.assertTrue(addNewContact.isContactSuccessfullyDelete(contactName));
	}
	
	
	@When("User click choose from existing contact")
	public void user_click_choose_from_existing_contact() {
	
		addNewContact.clickChooseFromExistingContactsBtn();
		
	}
	@When("Select {string} from the contact list")
	public void select_from_the_contact_list(String selectedContactName) {
	  
		addNewContact.selectFromExistingContact(selectedContactName);
		
		contactName = selectedContactName;
	}
	
	@When("User click remove from client")
	public void user_click_remove_from_client() throws InterruptedException {
		
		addNewContact.removeContactFromClient(contactName);
	}
	
	@Then("{string} text should be displayed")
	public void text_should_be_displayed(String expectedText) {
	 
		String actualText = addNewContact.getExpectedText();
		
		Assert.assertTrue(expectedText.equals(actualText));
	}

}
