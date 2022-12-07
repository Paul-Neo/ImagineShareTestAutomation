package stepScenarios;

import com.page.PrintPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PrintSteps {
	
	private PrintPage printPage = new PrintPage(DriverFactory.getDriver());
	
	@When("Click Print")
	public void click_print() throws InterruptedException {

//		printPage.clickPrintBtn();
		
	}
	
	
	@Then("File should be ready for print")
	public void file_should_be_ready_for_print() {

		printPage.isFileReadyForPrint();
	}

}
