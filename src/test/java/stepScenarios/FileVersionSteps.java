package stepScenarios;

import java.util.List;

import org.junit.Assert;

import com.page.FileVersionPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileVersionSteps {

	private FileVersionPage fileVersioning = new FileVersionPage(DriverFactory.getDriver());
	
	@Given("File versioning is switched to {string}")
	public void file_versioning_is_switched_to(String fileVersioningStatus) {

		fileVersioning.enableFileVersioning(fileVersioningStatus);
		
		
	}

	@Then("Versions column should be displayed")
	public void versions_column_should_be_displayed() {

		Assert.assertTrue(fileVersioning.isVersionColumnDisplayed());
		
	}

	@When("User clicks a file version icon")
	public void user_clicks_file_a_version_icon() {

		fileVersioning.clickFileVersioningIcon();
		
	}

	@When("User selects a file version")
	public void user_selects_a_file_version() {

		fileVersioning.selectCurrentFileVersion();
		
	}

	@Then("All buttons should be enabled")
	public void all_buttons_should_be_enabled(DataTable datatable) {
		
		List<String> expectedButtons =  datatable.asList();		
		System.out.println("Expected Buttons : " + expectedButtons);
		
		List<String> actualButtons = fileVersioning.isButtonsEnabled();
		System.out.println("Actual Buttons : " + actualButtons);
		
		Assert.assertTrue(expectedButtons.equals(actualButtons));
		
		
	}
	
	@Then("Version column should not be displayed")
	public void version_column_should_not_be_displayed(DataTable dataTable) {
	  
		List<String> expectedColumnNames =  dataTable.asList();
		System.out.println("Expected Column Names: " + expectedColumnNames);
		
		List<String> actualColumnNames = fileVersioning.getColumnNames();
		System.out.println("Actual Column Names: " +actualColumnNames);
		
		Assert.assertTrue(expectedColumnNames.equals(actualColumnNames));
		
		
	}
}
