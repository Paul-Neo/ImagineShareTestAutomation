package stepScenarios;

import org.junit.Assert;

import com.page.DownloadPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DownloadSteps {
	
	private DownloadPage downloadPage = new DownloadPage(DriverFactory.getDriver());
	
	@When("User enters file name on search box {string}")
	public void user_enters_file_name_on_search_box(String fileName) {
	  
		downloadPage.enterFileName(fileName);
		
	}

	@When("User click download button")
	public void user_click_download_button() {
	    
		downloadPage.clickFilePreviewButton();
	}
	
	@Given("User is on Client Workspace {string}")
	public void user_is_on_client_workspace(String clientName) throws InterruptedException {
	  
		downloadPage.navigateToWorkspaceFiles(clientName);
	}

	@When("User download {string} folder")
	public void user_download_folder(String folderName) {
	 
		System.out.println("Expected Folder Name is: "+folderName);
		
		String actualFolderName = downloadPage.getFolderName(folderName);
		System.out.println("Actual Folder Name is: "+actualFolderName);
		
		Assert.assertTrue(folderName.equals(actualFolderName));
		
		downloadPage.clickFolderName(folderName);
		
	}
	
	@When("User tick all checkbox")
	public void user_tick_all_checkbox() throws InterruptedException {
	  
		downloadPage.tickCheckBoxForAllFiles();
	}

	@When("Click download button")
	public void click_download_button() throws InterruptedException {
	   
		downloadPage.clickToolBarButton();
	}

	@Then("Files should be downloaded as zip file")
	public void files_should_be_downloaded_as_zip_file() {
	
	}

	@Then("folder should be downloaded as zip file")
	public void folder_should_be_downloaded_as_zip_file() {
	   
	}

	@Then("File should be downloaded")
	public void file_should_be_downloaded() {
	  
	}

}
