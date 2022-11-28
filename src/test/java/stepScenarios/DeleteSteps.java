package stepScenarios;

import org.junit.Assert;

import com.page.DeletePage;
import com.page.UploadPage;
import com.qa.factory.DriverFactory;
import com.qa.util.NavigateUtil;
import com.qa.util.RenameUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteSteps {
	
	private UploadPage uploadPage = new UploadPage(DriverFactory.getDriver());
	private NavigateUtil nav = new NavigateUtil(DriverFactory.getDriver());
	private RenameUtil rename = new RenameUtil(DriverFactory.getDriver());
	private DeletePage deletePage = new DeletePage(DriverFactory.getDriver());;
	private String fileName;
	private String folderName;

	@Given("User Uploaded a file in General Files {string}")
	public void user_uploaded_a_file_in_general_files(String fileName) throws InterruptedException {
	   
		nav.generalFolder();
		rename.renameLatestPDF();
		deletePage =  uploadPage.doFileUpload(fileName);
		Assert.assertTrue(deletePage.isFileUploaded(fileName));
		System.out.println("Upload Successfully!!");
		this.fileName = fileName;
	}
	
	@Given("User Uploaded a file {string} in Client Workspace {string}")
	public void user_uploaded_a_file_in_client_workspace(String fileName, String clientWorkspace) throws InterruptedException {
		
		System.out.println("File name is: "+fileName);
		System.out.println("Client workspace is: "+clientWorkspace);
		
		deletePage.navigateToClientWorkspace(clientWorkspace);
		uploadPage.doFileUpload(fileName);
		
		this.fileName = fileName;
		
	}
	
	@Given("User is created a folder {string} on Client Workspace {string}")
	public void user_is_created_a_folder_on_client_workspace(String folderName, String clientWorkspace) throws InterruptedException {
	 
		deletePage.navigateToClientWorkspace(clientWorkspace);
		deletePage.createNewFolder(folderName);
		this.folderName = folderName;
	}
	
	@When("User selects a folder")
	public void user_selects_a_folder() throws InterruptedException {
	  	
		String actualLatestFolderName = deletePage.getLatestFolderName();
		
		System.out.println("Expected Folder Name: " + this.folderName);
		System.out.println("Actual Folder Name: " + actualLatestFolderName);
		
		Assert.assertTrue(actualLatestFolderName.contains(this.folderName));
		
		deletePage.clickLatestFolderCB();
		
		
	}
	
	@When("User Selects the uploaded file")
	public void user_selects_a_file_in_general_files() {
	    
		System.out.println("Clicking Latest PDF File");
		deletePage.clickLatestPDF_CB();
		
	}

	@When("Click Archive")
	public void click_archive() throws InterruptedException {
	   
		deletePage.clickArchive();
	   
	}

	@Then("File should be moved to arhived files list")
	public void file_should_be_moved_to_arhived_files_list() throws InterruptedException  {
	    
		deletePage.navToArchivedFiles();
		
		String expectedResult_fileName = this.fileName;
		String actualResult_fileName = deletePage.getLatestArchivedFile();
		
		String expectedResult_folderName = this.folderName;
		String actualResult_folderName = deletePage.getLatestArchivedFile();
		
		
		
		if(this.fileName != null){
		
		System.out.println("Expected File Name: " + expectedResult_fileName);
		System.out.println("Actual File Name: " + actualResult_fileName);
		
		Assert.assertEquals(expectedResult_fileName, actualResult_fileName);
		
		}else if (this.folderName != null){
			
			System.out.println("Expected folder Name: " + expectedResult_folderName);
			System.out.println("Actual folder Name: " + actualResult_folderName);
			
			Assert.assertEquals(expectedResult_folderName, actualResult_folderName);
			
		}
		
	}

	@When("User Selects a file in archived files list")
	public void user_selects_a_file_in_archived_files_list() {

		deletePage.clickLatestArchvied_CB();
	}

	@When("Click Delete")
	public void c_lick_delete() throws InterruptedException {
	 
		deletePage.delete();
	}

	@Then("File should be deleted")
	public void file_should_be_deleted() {
	
		deletePage.refresh();
	}
	
	
}
