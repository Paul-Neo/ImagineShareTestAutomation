package stepScenarios;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.page.ClientsPortalPage;
import com.qa.factory.DriverFactory;
import com.qa.util.NavigateUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientsPortalSteps {

	private ClientsPortalPage clientsPortalPage = new ClientsPortalPage(DriverFactory.getDriver());
	private NavigateUtil nav = new NavigateUtil(DriverFactory.getDriver());
	private String subject;
	private String message;

	@Given("User has logged in successfully")// using
	public void user_has_logged_in_successfully() {
	
		String expectedPageTitle = "My Files";
		String actualPageTitle = clientsPortalPage.getPageTitle();
		
		Assert.assertTrue(expectedPageTitle.equals(actualPageTitle));
	}
	
	@Then("Navigation Links should be displayed")// using
	public void navigation_links_should_be_displayed(DataTable dataTable) {

		List<String> expectedNavLinks = dataTable.asList();
		System.out.println("Expected Navigation links: " + expectedNavLinks);

		List<String> actualNavLinks = clientsPortalPage.getNavLinks();
		System.out.println("Actual Navigation Links: " + actualNavLinks);

		Assert.assertTrue(expectedNavLinks.equals(actualNavLinks));
	}
	
	@Given("User is on {string} tab")
	public void user_is_on_tab(String tabName) throws InterruptedException {
	   
		nav.clickSelectedTab(tabName);
		Thread.sleep(2000);
	}
	
	@Then("Files and folders should displayed")//using
	public void files_and_folders_should_displayed(DataTable dataTable) {

		List<String> expectedFiles = dataTable.asList();
		System.out.println("Expected Files: " + expectedFiles);

		List<String> actualFiles = clientsPortalPage.getMyFiles();
		System.out.println("Actual Files: " + actualFiles);

		Assert.assertTrue(expectedFiles.equals(actualFiles));
	}
	
	@Given("User has sent a message in Clients portal")//using
	public void user_has_sent_a_message_in_clients_portal(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> userInfo = dataTable.asMaps(String.class, String.class);
		
		subject = userInfo.get(0).get("Subject");
		message = userInfo.get(0).get("Message");
		
		System.out.println("Subject Entered is: "+subject);
		System.out.println("Message Entered is: "+message);

		clientsPortalPage.navigateToMessageBoardAndSendAMessage(subject, message);
		
		System.out.println("Expected Latest Subject is: "+subject);
		System.out.println("Expected Latest Message is: "+message);
		
		System.out.println("Actual Latest Subject is: "+clientsPortalPage.getSubjectText());
		System.out.println("Actual Latest Message is: "+clientsPortalPage.getMessageText());
		
		Assert.assertTrue(subject.equals(clientsPortalPage.getSubjectText())
				&& message.equals(clientsPortalPage.getMessageText()));
		
	}

	@When("User navigates to clients workspace with a Client Name {string}")//using
	public void user_navigates_to_clients_worksapce_with_a_client_name(String clientName) throws InterruptedException {
		nav.navigateToClientWorkspace(clientName);

	}

	@Then("the latest activity should be today")//using
	public void the_latest_activity_should_be_today() {

		Assert.assertTrue(clientsPortalPage.isLatestActivityTodayUpdated());
	}

	@And("{string} message should be displayed")//using
	public void message_should_be_displayed(String expectedMessage) {

		System.out.println("Expected Message is: " + expectedMessage);

		String actualMessage = clientsPortalPage.getLatestActivityMessage();
		System.out.println("Actual Message is: " + actualMessage);

		Assert.assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@When("User navigates to Messages")//using
	public void click_messages() {
		
		clientsPortalPage.clickMessagesTab();
	}
	
	@Then("Latest Message sent from client portal should be displayed")//using
	public void latest_message_sent_from_client_portal_should_be_displayed() {
		
		System.out.println("Expected Latest Subject is: "+subject);
		System.out.println("Expected Latest Message is: "+message);
		
		System.out.println("Actual Latest Subject is: "+clientsPortalPage.getSubjectText());
		System.out.println("Actual Latest Message is: "+clientsPortalPage.getMessageText());
		
		Assert.assertTrue(subject.equals(clientsPortalPage.getSubjectText())
				&& message.equals(clientsPortalPage.getMessageText()));
		
	}
	
	}
