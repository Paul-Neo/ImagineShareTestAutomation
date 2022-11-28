package stepScenarios;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(value = "@skip", order = 0)
	public void skipScenario(Scenario scenario){
		System.out.println("SKIPPED SCENARIO is: "+scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order = 0)
	public void getProperty() {
	
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take a screenshot
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] soucePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(soucePath, "image/png", screenShotName);
		}
		
	}
	
}
