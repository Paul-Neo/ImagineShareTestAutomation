package stepScenarios;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.page.ShareFilesPage;
import com.qa.factory.DriverFactory;
import com.qa.util.NavigateUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShareFilesSteps {

	private ShareFilesPage sharefilesPage = new ShareFilesPage(DriverFactory.getDriver());
	private NavigateUtil navigate = new NavigateUtil(DriverFactory.getDriver());
	private String selectedFileName;

	@Given("User is on All Files page")
	public void user_is_on_all_files_page() {

		sharefilesPage.navigateToAllFilesTab();
	}

	@When("User select {string} folder")
	public void user_select_folder(String folderName) {

		sharefilesPage.selectFolderName(folderName);
	}

	@Then("Files\\/Folders in General Files should be displayed on the lists")
	public void files_folders_in_general_files_should_be_displayed_on_the_lists() {

		Assert.assertTrue(sharefilesPage.isFilesFoldersDisplayed());
	}

	@Then("Tool bar buttons should exist")
	public void tool_bar_buttons_should_exist(DataTable dataTable) {

		List<String> buttonsList = dataTable.asList();

		System.out.println("Expected Button lists: " + buttonsList);

		List<String> actualButtonList = sharefilesPage.getToolBarButtons();
		System.out.println("Actual Button lists: " + actualButtonList);

		Assert.assertTrue(buttonsList.equals(actualButtonList));

	}

	@Given("User is on General Folder")
	public void user_is_on_general_folder() throws InterruptedException {

		navigate.navigateToGeneralFolder();
	}

	@When("User Select a file {string}")
	public void user_select_a_file(String fileName) throws InterruptedException {

		selectedFileName = fileName;
		System.out.println("Selected File Name is: " + selectedFileName);

		sharefilesPage.selectFile(selectedFileName);

	}
	
	@When("Select Share files")
	public void select_share_files() throws InterruptedException {
	
	sharefilesPage.selectShareFiles();
		
	}

	
	@When("Clicks Share button")
	public void clicks_share_button() {
	   
		sharefilesPage.clickShareFilesButton();
	}

	@When("User Enter in Link Settings")
	public void user_enter_in_link_settings(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> linkSettingsInfo = dataTable.asMaps(String.class, String.class);

		String linkSettings = linkSettingsInfo.get(0).get("Link Setting");
		String question = linkSettingsInfo.get(0).get("Question");
		String answer = linkSettingsInfo.get(0).get("Answer");

		sharefilesPage.enterLinkSettings(linkSettings, question, answer);

	}

	@When("Click Create Share Link button")
	public void click_create_share_link_button() {

		sharefilesPage.clickCreateShareLink();
	}

	@Then("Selected file should be displayed")
	public void selected_file_should_be_displayed() throws InterruptedException {

		System.out.println("Expected File Name: " + selectedFileName);

		String actualFileName = sharefilesPage.getFileName();
		System.out.println("Actual File Name: " + actualFileName);

		Assert.assertTrue(selectedFileName.equals(actualFileName));
	}

	@When("User Click Copy Link")
	public void user_click_copy_link() throws InterruptedException {

		sharefilesPage.clickCopyLink();
	}

	@Then("Link should be displayed")
	public void link_should_be_displayed() {

		String baseLink = "https://app.imaginetime.com";
//		String baseLink = "https://test-app.imaginetime.com";
		

		// checks the beginning of the link.

		System.out.println("Expected Link: " + baseLink);
		System.out.println("Actual Link: " + sharefilesPage.getLink());
		Assert.assertTrue(sharefilesPage.getLink().contains(baseLink));

	}

	@When("User Select {string} in Link Settings")
	public void user_select_in_link_settings(String LinkSetting) {

		sharefilesPage.selectDirectLink(LinkSetting);

	}

	@When("Toggle Expiration date and Send Emails")
	public void toggle_expiration_date_and_send_emails() {

		sharefilesPage.clickToggleButton();
	}

	@When("User select a contact in dropdown and send a Email Message")
	public void user_select_a_contact_in_dropdown_and_send_a_email_message(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> sendEmailInfo = dataTable.asMaps(String.class, String.class);

		String recipientName = sendEmailInfo.get(0).get("Recipient Name");
		String emailMessage = sendEmailInfo.get(0).get("Email Message");

		sharefilesPage.sendEmails(recipientName, emailMessage);

	}

}
