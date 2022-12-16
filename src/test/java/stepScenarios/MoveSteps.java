package stepScenarios;

import org.junit.Assert;
import com.page.MovePage;
import com.qa.factory.DriverFactory;
import com.qa.util.FileFinderUtil;
import com.qa.util.NavigateUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoveSteps {

	private MovePage movePage = new MovePage(DriverFactory.getDriver());
	private NavigateUtil navigate = new NavigateUtil(DriverFactory.getDriver());
	private FileFinderUtil fileFinder = new FileFinderUtil(DriverFactory.getDriver());
	private String personalFile;
	private String fileName;

	@When("User Selects a file {string}")
	public void user_selects_a_file_in_general_files(String fileName) throws InterruptedException {

		movePage.sleep(2000);

		fileFinder.clickaCheckbox(fileName);
		
		this.fileName = fileName;
	}

	@When("Click Move")
	public void click_move() throws InterruptedException {

		movePage.clickMove();
	}

	@Then("Move window should be displayed")
	public void move_window_should_be_displayed() {

		String expectedText = "Move files";
		String actualText = movePage.getMoveWindowText();

		Assert.assertTrue(actualText.contains(expectedText));

	}

	@When("User Selects {string}")
	public void user_selects(String destination) {

		personalFile = destination;
		movePage.selectDestination(destination);

	}

	@When("Click Save")
	public void click_save() throws InterruptedException {

		movePage.clickSave();
		Thread.sleep(2000);
	}

	@Then("File should be gone in General Files and moved in Personal Files {string}")
	public void file_should_be_moved_in_personal_files(String personalFolder) throws InterruptedException {

		System.out.println("Personal File is: " + personalFile);
		System.out.println("Expected File Name is: " + this.fileName);

		navigate.navigateToPersonalFolder(personalFolder);
		String latestFileName = movePage.findMovedFile();

		System.out.println("Latest File Name is: " + latestFileName);

		Assert.assertTrue(this.fileName.equals(latestFileName));
	}

	@Given("User is on Personal File {string}")
	public void user_is_on_personal_file(String personalFolder) throws InterruptedException {

		navigate.navigateToPersonalFolder(personalFolder);
	}

	@Then("File should be gone in Personal Files and moved in General Files")
	public void file_should_be_gone_in_personal_files_and_moved_in_general_files() throws InterruptedException {

		navigate.navigateToGeneralFolder();
		System.out.println("Expected File Name is: " + this.fileName);

		String actualFileName = movePage.findMovedFile();
		System.out.println("Actual File Name is: " + actualFileName);

		Assert.assertTrue(this.fileName.equals(actualFileName));

	}

}
