package stepScenarios;

import org.junit.Assert;
import com.page.UploadPage;
import com.qa.factory.DriverFactory;
import com.qa.util.RenameUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadSteps {

	private UploadPage uploadPage = new UploadPage(DriverFactory.getDriver());
	private RenameUtil renameUtil = new RenameUtil(DriverFactory.getDriver());
	private String fileName;
	private String errorMsg;
	
	@When("User click upload new files button")
	public void user_click_upload_new_files_button() throws InterruptedException {
		
		fileName = "File12345";
		
//		uploadPage.renameFile(fileName);
		
		renameUtil.renameLatestPDF();
		uploadPage.uploadFiles();
		
	}

	@Then("A modal should be displayed with header message {string}")
	public void a_modal_should_be_displayed_with_header_message(String headerText) throws InterruptedException {
	
		String actualHeaderText = uploadPage.getHeaderText();
		
		System.out.println("Expected Header Text: "+ headerText);
		System.out.println("Actual Header Text: "+ actualHeaderText);
		
		Assert.assertTrue(headerText.equals(actualHeaderText));
	}

	@When("User upload a file {string}")
	public void user_upload_a_file(String fileName) {

		this.fileName = fileName;
		
		uploadPage.browseFile(fileName);
	}

	@When("Click upload & save button")
	public void click_upload_save_button() throws InterruptedException {

		uploadPage.clickSave();
	}

	@Then("The file should be uploaded")
	public void the_file_should_be_uploaded() {
	    
		Assert.assertTrue(uploadPage.isFileUploaded(this.fileName));
	}
	
	@When("User Rename a File with invalid character")
	public void user_rename_a_file_with_invalid_character() throws InterruptedException {
	    
		String actualErrorMessage = uploadPage.renameWithInvalidChar();
		
		errorMsg = actualErrorMessage;
	}
	
	@When("User Create a folder with Invalid Characters")
	public void user_create_a_folder_with_invalid_characters() throws InterruptedException {
	 
		String actualErrorMessage = uploadPage.createFolderWithInvalidChar();
		
		errorMsg = actualErrorMessage;
	}
	
	@Then("Warning message should be displayed {string}")
	public void warning_message_should_be_displayed(String msg) throws InterruptedException {
	 
		String expectedErrorMessage = msg + " / : * ? \" < > |";
		
		System.out.println("Expected Result " + expectedErrorMessage);
		System.out.println("Actual Result " + errorMsg);
		
		Assert.assertTrue(expectedErrorMessage.equals(errorMsg));
		
	}
	
	@Given("User set the defaul file upload {string}")
	public void user_set_the_defaul_file_upload(String fileUploadSetting) throws InterruptedException {
	   
		uploadPage.setDefaultFileUploads(fileUploadSetting);
	}
	
	
	@Then("File should be {string}")
	public void file_should_be(String expectedFileStatus) {
		
	  
		String actualFIleStatus = uploadPage.checkFileVisibilityStatus();
		
		Assert.assertTrue(expectedFileStatus.equals(actualFIleStatus));
		
	}
}
