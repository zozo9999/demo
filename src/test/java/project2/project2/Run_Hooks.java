package project2.project2;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Run_Hooks   {
//	WebDriver driver;
	public Run_Hooks() {
		// TODO Auto-generated constructor stub
//		this.driver = driver;
	}

	@Before
	public void bf() {
		System.out.println("cucumber hook before");
	}
	
	@After // Cucumber After hook with order 0
	public  void quitDriver() throws Exception {
		System.out.println("cucumber hook after");	
	}
//	@After(order = 1) // Cucumber After Hook with order 1
//	public void takeScreenShotOnFailedScenario(Scenario scenario) {
//
//		System.out.println("This is from After hook, order=1");
//		if ((scenario.isFailed())) {
//			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", scenario.getName());
//		}
//	}

	
}
//This prerequisite can be anything from:
//
//Starting a webdriver
//Setting up DB connections
//Setting up test data
//Setting up browser cookies
//Navigating to certain page
//or anything before the test
//In the same way, there are always after steps as well of the tests like:
//
//Killing the webdriver
//Closing DB connections
//Clearing the test data
//Clearing browser cookies
//Logging out from the application
//Printing reports or logs
//Taking screenshots on error
//or anything after the test