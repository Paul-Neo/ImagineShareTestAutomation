package stepScenarios;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "@failedScenarios/failedScenarios.txt" }, 
		glue = {"stepScenarios"}, 
		tags = "@test",
		plugin = { "pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:failedScenarios/failedScenarios.txt"
				},
		
		monochrome = true
		)
public class RerunFailedScenario extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
