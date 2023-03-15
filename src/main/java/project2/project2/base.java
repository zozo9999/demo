package project2.project2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class base {
	public String url = "";
	public static WebDriver driver;
	static Logger log = Logger.getLogger(Main.class.getName());
	String filePath = "D:\\Download\\Chrome Download\\";
	public base() {
		// TODO Auto-generated constructor stub
	}
	
	@Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void setupApplication(String browser) {
		if(browser.equalsIgnoreCase("chrome")){
			System.out.println("Chrome Driver is already defined.");
		}
		String url = "https://www.saucedemo.com/";
		Reporter.log("=====Browser Session Started===== Main class", true);
		System.out.println("run base class");
		
		PropertyConfigurator.configure("log4j.properties");
		
		// javascript authorization
		// http://admin:admin@website address.com/ this will be complete without asking
		// authrization.
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        
        driver = new ChromeDriver(options);
//		driver = new ChromeDriver();
		log.info("window maximinied");
		// BaseInit setup = new BaseInit(driver);
		log.info("Maximize window size");
		log.info("Information");
		driver.get(url);
		log.debug("opening webiste");
		log.debug("entring weight");

		BasicConfigurator.configure();
		Logger log = Logger.getLogger("devpinoyLogger");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
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
	
	public void FailedTestCase(String name) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
		try {
			FileUtils.copyFile(srcFile, new File(filePath + name + "_" + TimeStamp + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closeApplication()
	{
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);
		
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] {
				{ "standard_user", "secret_sauce" } /*
													 * , {"locked_out_user", "secret_sauce"} , {"problem_user",
													 * "secret_sauce"}, {"performance_glitch_user", "secret_sauce"}
													 */ };
	}
}
