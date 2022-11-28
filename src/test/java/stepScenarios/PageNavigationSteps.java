package stepScenarios;

import java.util.List;

import org.junit.Assert;

import com.page.PageNavigationPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PageNavigationSteps {


	private PageNavigationPage pageNavigation = new PageNavigationPage(DriverFactory.getDriver());
	private String actualLabel;
	
	@When("User go to archive list")
	public void user_go_to_archive_list() throws InterruptedException {
	    
		pageNavigation.navigateToArchiveList();
	}
	
	@Then("Column Headers should be displayed")
	public void column_headers_should_be_displayed(DataTable dataTable) {
	
		List<String> expectedColumnHeaders = dataTable.asList(String.class);
		System.out.println("Expected Column Headers: " + expectedColumnHeaders);
		
		List<String> actualColumnHeaders = pageNavigation.getColumnHeaders();
		System.out.println("Actual Column Headers: " + actualColumnHeaders);
		
		Assert.assertTrue(expectedColumnHeaders.equals(actualColumnHeaders));
		
		
	}
	
	@When("Filter per {string} pages")
	public void filter_per_pages(String pageFilterValue) {
	    
		pageNavigation.selectPageFilter(pageFilterValue);
		
	}
	
	@When("User get the label")
	public void user_get_the_label() {

		actualLabel = pageNavigation.getLabelText();
		System.out.println("Actual Label Text: " + actualLabel);
	}
	
	@Then("label should contains {string}")
	public void label_should_contains(String expectedLabel) {
	   
		System.out.println("Expected Label Text: "+ expectedLabel);
		
		Assert.assertTrue(actualLabel.contains(expectedLabel));
	}
	
}
