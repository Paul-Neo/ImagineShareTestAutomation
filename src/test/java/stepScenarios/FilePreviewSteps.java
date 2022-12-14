package stepScenarios;

import java.util.List;

import org.junit.Assert;

import com.page.FilePreviewPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilePreviewSteps {
	
	private FilePreviewPage filePreview = new FilePreviewPage(DriverFactory.getDriver());
	
	private String expectedAssocClient;
	private String expectedFileName;
	
	
	@When("User Clicks a PDF file")
	public void user_clicks_a_pdf_file() throws InterruptedException {

		String latestPDF_fileName = filePreview.clickPDF_file();
		System.out.println("Latest PDF File Name: " + latestPDF_fileName);
		
		expectedFileName = latestPDF_fileName;
		
	}

	@Then("buttons and links should be displayed")
	public void buttons_and_links_should_be_displayed() {
	   
		Assert.assertTrue(filePreview.isContentsDisplayed());
	}
	
	@When("Click Details link")
	public void click_details_link() {

		filePreview.navToDetailsLink();
	}
	
	@Then("Default associated client should be correct")
	

	public void default_associated_client_should_be_correct() {

		String expectedResult = "Elavon";
		String actualResult = filePreview.getDefaultAssocClient();
		
		System.out.println("Expected Associated Client: "+ expectedResult);
		System.out.println("Actual Associated Client: "+ actualResult);
		
		Assert.assertTrue(expectedResult.equals(actualResult));
	}
	
	@Then("Tags should be displayed")
	public void tags_should_be_displayed() {

		filePreview.selectTags();
	}

	@When("User selects associated client {string}")
	public void user_selects_associated_client(String assocClient) {
	 
		filePreview.selectAssocClient(assocClient);
		
		expectedAssocClient = assocClient;
	}
	
	@Then("file should be moved on selected associated client")
	public void file_should_be_moved_on_selected_associated_client() throws InterruptedException {
	   
		String movedFile = expectedFileName;
		
		Assert.assertTrue(filePreview.isFileRemoved(movedFile));
		
		filePreview.navigateToSelectedAssocClient(expectedAssocClient);
		
		String latestPDF_fileName = filePreview.clickPDF_file();
		
		System.out.println("Moved File is: " + movedFile);
		System.out.println("Latest PDF FIle is: " + latestPDF_fileName);
		
		Assert.assertTrue(movedFile.equals(latestPDF_fileName));
	}
	
	@Given("Pdf editor is toggled on")
	public void pdf_editor_is_toggled_on() throws InterruptedException {
	    
		filePreview.navigateToAdvanceSettings();
		filePreview.pdfEditorToggleOn();
		
	}
	
	@When("User Click Edit pdf icon")
	public void user_click_edit_pdf_icon() throws InterruptedException {
	
		filePreview.clickPDF_Icon();
	
	}
	
	@Then("File should be ready to edit")
	public void file_should_be_ready_to_edit() throws InterruptedException {
	
		Assert.assertTrue(filePreview.isPdfTronExist());
	}
	
	@Then("PDFtron toolbar buttons should be displayed")
	public void pd_ftron_toolbar_buttons_should_be_displayed(DataTable dataTable) {
	 
		List<String> expectedToolBarList =  dataTable.asList();
		System.out.println("Expected Tool Bar List: " + expectedToolBarList);
		
		List<String> actualToolBarList = filePreview.getPdfTronToolBarButtonsList();
		System.out.println("Actual Tool Bar List: " + actualToolBarList);
		
		Assert.assertTrue(expectedToolBarList.equals(actualToolBarList));
		
		
	}


}
