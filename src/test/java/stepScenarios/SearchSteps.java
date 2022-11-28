package stepScenarios;

import java.util.List;

import org.junit.Assert;

import com.page.SearchPage;
import com.qa.factory.DriverFactory;
import com.qa.util.SearchUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	private SearchPage searchPage = new SearchPage(DriverFactory.getDriver());
	private SearchUtil search = new SearchUtil(DriverFactory.getDriver());

	private String clientsName;
	private String fileName;

	@When("User search {string}")
	public void user_search(String name) {

		clientsName = name;
		search.search(name);
	}

	@When("Click Go to Clients Workspace")
	public void click_go_to_clients_workspace() {

		searchPage.navigateToClientsWorkspace(clientsName);
	}

	@When("Select the expected folder")
	public void select_the_expected_folder() throws InterruptedException {

		String folderName = clientsName;

		searchPage.selectFolder_OR_File(folderName);
	}

	@Then("Client name should be correct")
	public void client_name_should_be_correct() {

		System.out.println("Expected Clients Name: " + clientsName);

		String actualClientsname = searchPage.getClientsName();
		System.out.println("Actual Clients Name: " + actualClientsname);

		Assert.assertTrue(clientsName.equalsIgnoreCase(actualClientsname));

	}

	@Then("Client Workspace links should be displayed")
	public void client_workspace_links_should_be_displayed(DataTable dataTable) {

		List<String> expectedLinkLists = dataTable.asList(String.class);
		System.out.println("Expected Link Lists: " + expectedLinkLists);

		List<String> actualLinkLists = searchPage.getNavLinks();

		Assert.assertTrue(expectedLinkLists.equals(actualLinkLists));
	}

	@When("Click Go to Clients Settings")
	public void click_go_to_clients_settings() {

		searchPage.navigateToClientSettings(clientsName);
	}

	@Then("Clients Settigs links should be displayed")
	public void clients_settigs_links_should_be_displayed(DataTable dataTable) {

		List<String> expectedLinkLists = dataTable.asList(String.class);
		System.out.println("Expected Link Lists: " + expectedLinkLists);

		List<String> actualLinkLists = searchPage.getNavLinks();

		Assert.assertTrue(expectedLinkLists.equals(actualLinkLists));

	}

	@When("User Enter a client name in advance search {string}")
	public void user_enter_a_client_name_in_advance_search(String clientName) throws InterruptedException {

		searchPage.applySearchFilter(clientName);
		
	}

	@When("Select the expected file")
	public void select_the_expected_file() throws InterruptedException {

		fileName = this.clientsName;
		searchPage.selectFolder_OR_File(fileName);
	}

	@Then("File name should be correct")
	public void file_name_should_be_correct() {

		System.out.println("Expected File Name is: " + fileName);

		String actualFileName = searchPage.getFileName();
		System.out.println("Actual File Name is: " + actualFileName);

		Assert.assertTrue(fileName.equals(actualFileName));
	}

	@Then("buttons should be displayed")
	public void buttons_should_be_displayed(DataTable dataTable) {

		List<String> expectedButtons = dataTable.asList(String.class);
		List<String> actualButtons = searchPage.getfilePreviewNavButtons();

		Assert.assertTrue(expectedButtons.equals(actualButtons) && searchPage.isDownLoadButtonExist());
	}

	@Then("Links should also displayed")
	public void links_should_also_displayed(DataTable dataTable) {

		List<String> expectedLinks = dataTable.asList(String.class);
		List<String> actualLinks = searchPage.getfilePreviewNavlinks();

		Assert.assertTrue(expectedLinks.equals(actualLinks));

	}

}
