package stepScenarios;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		features = {"src/test/resources/stepScenarios"}, 
		glue = {"stepScenarios"},
		tags = "@RegressionTest",
		plugin = { "pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:failedScenarios/failedScenarios.txt"
				},
		
		//test 123

		monochrome = true
)

public class MyTestRunnerNG extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
}