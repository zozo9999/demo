package project2.project2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Main2base {
	public String url = "";
	public static WebDriver driver;
	static Logger log = Logger.getLogger(Main.class.getName());

	public Main2base() {
		// TODO Auto-generated constructor stub
//		driver = this.driver;
//		base(WebDriver driver);
	}

	@BeforeMethod
	public void setupApplication() {

		Reporter.log("=====Browser Session Started=====", true);
		PropertyConfigurator.configure("log4j.properties");

		// javascript authorization
		// http://admin:admin@website address.com/ this will be complete without asking
		// authrization.
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		// chromeoption - headless = not opening browser.
		log.info("window maximinied");
		// BaseInit setup = new BaseInit(driver);
		String url = "https://www.saucedemo.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("Maximize window size");
		log.info("Information");
		driver.get(url);
		log.debug("opening webiste");
		log.debug("entring weight");

		System.out.println("BaseClass");
		Reporter.log("=====Application Started=====", true);
	}

//	public static WebDriver getdriver() throws IOException {
//		Properties prop = new Properties();
//		FileInputStream fi = new FileInputStream(
//				"C:\\Users\\Junghwan Shin\\Git\\project1\\mavenProject\\src\\test\\java\\StepDefinitions\\globalvariable");
//		prop.load(fi);
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(prop.getProperty("url"));
//		return driver;
//	}

	@AfterMethod
	public void closeApplication() {
		System.out.println("After method");
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);

	}
}
