package stepScenarios;

import java.util.List;
import java.util.Map;

import com.page.RequestFilesPage;
import com.qa.factory.DriverFactory;
import com.qa.util.NavigateUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestFilesSteps {

	private RequestFilesPage requestFilesPage = new RequestFilesPage(DriverFactory.getDriver());
	private NavigateUtil nav = new NavigateUtil(DriverFactory.getDriver());

	@Given("Select Request files")
	public void select_request_files() throws InterruptedException {
	    
		requestFilesPage.selectRequestFiles();
	}

	@When("Click Create request files link")
	public void click_create_request_files_link() {
	 
		requestFilesPage.clickCreateRequestFileButton();
	}
	
	@Given("User is on Client Workspace with Client Name {string}")
	public void user_is_on_client_workspace_with_client_name(String clientName) throws InterruptedException {
		
		nav.navigateToClientWorkspace(clientName);
		
	}

	@When("User navigates to Files Tab")
	public void user_navigates_to_files_tab() throws InterruptedException {
		
		requestFilesPage.clickFilesTab();
	
	}
	
	@When("Toggle Expiration date, Add Instructions and Send Emails")
	public void toggle_expiration_date_add_instructions_and_send_emails() throws InterruptedException {

		requestFilesPage.clickToggles();
		
	}
	
	@When("User Enters the following Informations")
	public void user_enters_the_following_informations(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> toggleInfo =  dataTable.asMaps(String.class, String.class);
		
		String instruction	= toggleInfo.get(0).get("Instructions");
		String sendMails = toggleInfo.get(0).get("Send Emails");
		String emailMessage = toggleInfo.get(0).get("Email Message");
		String recieveEmails = toggleInfo.get(0).get("Recieve Emails");
		
		requestFilesPage.enterInstructions(instruction);
		requestFilesPage.clickSendMailsDropDown(sendMails);
		
		requestFilesPage.enterEmailMessage(emailMessage);
		requestFilesPage.clickRecieveDropDown(recieveEmails);
		
	}
	
	@When("User click Select Folder")
	public void user_click_select_folder() throws InterruptedException {

		requestFilesPage.clickSelectFolderBtn();
		
	}
	
	@When("Add a new folder")
	public void add_a_new_folder() throws InterruptedException {
	
		requestFilesPage.addNewFolderDestination();
		
	}

}
