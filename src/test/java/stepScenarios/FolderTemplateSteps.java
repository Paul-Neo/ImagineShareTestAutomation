package stepScenarios;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.FolderTemplatePage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FolderTemplateSteps {

	private FolderTemplatePage folderTemplatePage = new FolderTemplatePage(DriverFactory.getDriver());
	private String expectedTemplateFolderName;
	private int expectedFoldersCount;
	private int actualFoldesCount;

	@When("Click New Template button")
	public void click_new_template_button() throws InterruptedException {

		folderTemplatePage.clickNewTemplateButton();
	}

	@Then("Create Template window should be displayed with header message {string}")
	public void create_template_window_should_be_displayed_with_header_message(String expectedMessage)
			throws InterruptedException {

		System.out.println("Expected Header Message is: " + expectedMessage);

		String actualMessage = folderTemplatePage.getHeaderMessage();
		System.out.println("Actual Header Message is: " + actualMessage);

		Assert.assertTrue(expectedMessage.equals(actualMessage));
	}

	@When("User Enters Template info")
	public void user_enters_template_info(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> templateInfo = dataTable.asMaps(String.class, String.class);

		
		String description = templateInfo.get(0).get("Description");
		String delegatedAdmin = templateInfo.get(0).get("Delegated Admin");
		
		String name = folderTemplatePage.setFolderTemplateName();
		folderTemplatePage.setFolderTemplateDescription(description);
		folderTemplatePage.setFolderTemplateDelegatedAdmin(delegatedAdmin);
		
		
		expectedTemplateFolderName = name;
	
	}

	@When("Click create template")
	public void click_create_template() throws InterruptedException {

		folderTemplatePage.clickCreateTemplate();
		actualFoldesCount = folderTemplatePage.getTemplateFolderCount();

	}
	

	@Then("New template should be added on the list")
	public void new_template_should_be_added_on_the_list() throws InterruptedException {

		System.out.println("Expected Folder Template Name: " + expectedTemplateFolderName);
		
		String actualFolderTemplateName = folderTemplatePage.getFolderTemplateName();
		System.out.println("Actual Folder Template Name: " + actualFolderTemplateName);
		
		Assert.assertTrue(expectedTemplateFolderName.equals(actualFolderTemplateName));
		
		
		
		folderTemplatePage.clickCancelBtn();
	}

	@When("User Select a Folder Template")
	public void select_a_folder_template() throws InterruptedException {

		folderTemplatePage.openFolderTemplateSettings();
		
		
	}

	@When("Choose Delete from ellipis menu")
	public void choose_delete() throws InterruptedException {

		folderTemplatePage.chooseDelete();
	}

	@Then("Alert Message should be displayed with header message {string}")
	public void alert_message_should_be_displayed_with_header_message(String headerMessage) {

		folderTemplatePage.getAlertBoxHeader(headerMessage);
	}

	@Then("Template name should be correct")
	public void template_name_should_be() {

		System.out.println("Expected Template Name: " + expectedTemplateFolderName);

		String actualTemplateName = folderTemplatePage.getSelectedTemplateNameForDeletion();
		System.out.println("Actual Template Name: " + actualTemplateName);

		Assert.assertTrue(expectedTemplateFolderName.equals(actualTemplateName));

	}

	@When("User Click Ok")
	public void user_click_ok() throws InterruptedException {

		
		folderTemplatePage.clickOkBtn();
	
	}

	@Then("Template should be deleted from the list")
	public void template_should_be_deleted_from_the_list() {

		//get template count
		int newCount = actualFoldesCount - 1;
		expectedFoldersCount = folderTemplatePage.getTemplateFolderCount();
		
		System.out.println("New Count: " + newCount);
		System.out.println("Expected Folders Count: " + expectedFoldersCount);
		
		Assert.assertEquals(newCount, expectedFoldersCount);
	}
	
	@When("User Select Apply folder template")
	public void user_select_apply_folder_template() throws InterruptedException {
	
		folderTemplatePage.selectApplyFolderTemplate();
		
	}
	
	@When("User Click Select folder template button")
	public void user_click_select_folder_template_button() {
	 
		folderTemplatePage.clickSelectFolderTemplateBtn();
	}
	
	@When("User selects {string}")
	public void user_selects(String templateName) throws InterruptedException {
	 
		int foldersCount = folderTemplatePage.selectTemplate(templateName);
		System.out.println("Expected Folders Count is: " + foldersCount);
		
		expectedFoldersCount = foldersCount;
		
		expectedTemplateFolderName = templateName;
	}
	
	@When("Click Done")
	public void click_done() {
	    
		folderTemplatePage.clickDone();
	}
	
	@Then("Selected template should be ready to apply")
	public void selected_template_should_be_ready_to_apply() {
	
		Assert.assertTrue(folderTemplatePage.isTemplateReadyToApply());
	}
	
	@When("User click Apply Template button")
	public void user_click_apply_template_button() throws InterruptedException {
	 
		folderTemplatePage.clickApplyTemplateBtn();
	}
	
	@Then("Folder template should be applied")
	public void folder_template_should_be_applied() {
	  
		System.out.println("Expected Template Name: " + expectedTemplateFolderName);
		
		String latestTemplateName = folderTemplatePage.getLatestAppliedTemplate();
		System.out.println("Latest Template Name: " + latestTemplateName);
		
		Assert.assertTrue(expectedTemplateFolderName.equals(latestTemplateName));
	}
	
	@Then("Folders count should be correct")
	public void folders_count_should_be() throws InterruptedException {
	    
		System.out.println("Expected Folders Count: " + expectedFoldersCount);
		
		int actualFoldersCount = folderTemplatePage.getAppliedTemplateFoldersCount();
		System.out.println("Actual Folders Count: " + actualFoldersCount);
		
		Assert.assertEquals(expectedFoldersCount, actualFoldersCount);
	}
	
	
}
