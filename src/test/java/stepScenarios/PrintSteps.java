package stepScenarios;

import org.junit.Assert;

import com.page.PrintPage;
import com.qa.factory.DriverFactory;
import com.qa.util.NavigateUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PrintSteps {
	
	private PrintPage printPage = new PrintPage(DriverFactory.getDriver());
	private NavigateUtil nav = new NavigateUtil(DriverFactory.getDriver());
	
	
	
	@When("Click Print")
	public void click_print() throws InterruptedException {

		printPage.clickPrintBtn();
		
	}
	
	
	@Then("File should be ready for print")
	public void file_should_be_ready_for_print() {

		Assert.assertTrue(printPage.isFileReadyForPrint());
		
	}
	
	@Given("User is inside a folder")
	public void user_is_inside_a_folder() throws InterruptedException {
	
		nav.navigateToGeneralFolder();
		printPage.clickLatestFolder();
		
	}

}
