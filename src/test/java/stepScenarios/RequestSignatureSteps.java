package stepScenarios;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.page.RequestSignaturePage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestSignatureSteps {

	private RequestSignaturePage requestSignature = new RequestSignaturePage(DriverFactory.getDriver());
	private String expectedNotifiedSigner;

	@When("User Click a file in General Files {string}")
	public void user_click_a_file_in_general_files(String fileName) {

		requestSignature.clickFile(fileName);

	}

	@When("User Click Request Signature")
	public void click_request_signature() throws InterruptedException {

		requestSignature.clickRequestSignature();
	}
	
	@When("User Open E-signature from subtask menu")
	public void open_e_signature_from_subtask_menu() throws InterruptedException {
	 
		requestSignature.openSigReqFromSubtask();
		
		requestSignature.notificationToggleOff();
	}

	@Then("File Name should be {string}")
	public void file_name_should_be(String expectedFileName) {

		String actualFileName = requestSignature.getFileName();

		System.out.println("Expected File Name is: " + expectedFileName);
		System.out.println("Actual File Name is: " + actualFileName);

		Assert.assertTrue(expectedFileName.equals(actualFileName));
	}

	@When("Select a template {string}")
	public void select_a_template(String template) throws InterruptedException {

		requestSignature.selectTemplate(template);

	}

	@When("Enter Signer Details and Instructions")
	public void enter_signer_details_and_instructions(DataTable dataTable) {

		List<Map<String, String>> signersInfo = dataTable.asMaps(String.class, String.class);

		String firstName = signersInfo.get(0).get("First Name");
		String lastName = signersInfo.get(0).get("Last Name");
		String emailAddress = signersInfo.get(0).get("Email Address");
		String instruction = signersInfo.get(0).get("Instruction");

		requestSignature.enterSignerDetails(firstName, lastName, emailAddress, instruction);

		expectedNotifiedSigner = emailAddress;
	}

	@When("Click Prepare Request button")
	public void click_prepare_request_button() throws InterruptedException {

		requestSignature.clickPrepareRequestButton();
	}

	@Then("Signature Request Created")
	public void signature_request_created() {

		Assert.assertTrue(requestSignature.isSignatureReqCreated());
	}

	@Then("Signer should be notified")
	public void signer_should_be_notified() {

		String actualNotifiedSigner = requestSignature.notifiedSigner();

		Assert.assertTrue(expectedNotifiedSigner.equals(actualNotifiedSigner));
	}

	@Then("Workspace location should be {string}")
	public void workspace_location_should_be(String clientWorkspace) {

		System.out.println("Expected Location is: " + clientWorkspace);

		String location = requestSignature.getFileUploadLocationName();
		System.out.println("Actual Location is: " + location);

		Assert.assertTrue(location.equals(clientWorkspace));

	}

	@When("User enter first signer details")
	public void user_enter_first_signer_details(DataTable dataTable) {

		List<Map<String, String>> firstSigner = dataTable.asMaps(String.class, String.class);

		String firstname = firstSigner.get(0).get("First Name");
		String lastName = firstSigner.get(0).get("Last Name");
		String emailAddress = firstSigner.get(0).get("Email Address");

		requestSignature.enterSignerDetails(firstname, lastName, emailAddress);
		
		expectedNotifiedSigner = emailAddress;
	}

	@When("Enter second signer details")
	public void enter_second_signer_details(DataTable dataTable) {

		List<Map<String, String>> secondSigner = dataTable.asMaps(String.class, String.class);

		String firstname = secondSigner.get(0).get("First Name");
		String lastName = secondSigner.get(0).get("Last Name");
		String emailAddress = secondSigner.get(0).get("Email Address");

		requestSignature.enterSignerDetails(firstname, lastName, emailAddress);
		
		
	}
	
	@When("Selects a authentication")
	public void selects_a_authentication(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> individualAuthenticationInfo =  dataTable.asMaps(String.class, String.class);
		
		String question = individualAuthenticationInfo.get(0).get("Question");
		String answer = individualAuthenticationInfo.get(0).get("Answer");
		
		requestSignature.selectIndividualAuthentication(question, answer);
	}
}
