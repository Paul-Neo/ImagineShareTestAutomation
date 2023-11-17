package stepScenarios;

import static org.testng.Assert.assertTrue;

import java.util.List;

import com.page.CheckNotifSettingsPage;
import com.qa.factory.DriverFactory;


import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Then;

public class CheckNotifSettingSteps {

	private CheckNotifSettingsPage notifSettings = new CheckNotifSettingsPage(DriverFactory.getDriver());
	
	@Then("Notification settings should be displayed")
	public void notification_settings_should_be_displayed(DataTable dataTable) {
		
		List<String> expectedNotifNames =  dataTable.asList();
		System.out.println("Expected Notif Names: " + expectedNotifNames);
		
		List<String> actualNotifNames = notifSettings.getNotificationSettings();
		
		System.out.print("Actual Notif Names: " + actualNotifNames);
		
		assertTrue(expectedNotifNames.equals(actualNotifNames));
	}
}
