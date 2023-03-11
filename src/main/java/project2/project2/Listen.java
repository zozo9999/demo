package project2.project2;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listen extends base implements ITestListener{
//	ExtentTest test;	
//	ExtentReports extent = ExtentReporterNG.getReportObject();
//	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	String filePath = "D:\\Download\\Chrome Download";
	WebDriver driver;
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started, " + result.getName());
//		test = extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test);
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Successfully Finished, " + result.getName());
//		extentTest.get().log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed, " + result.getName());
//		extentTest.get().fail(result.getThrowable());
		
		try {
			FailedTestCase(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		String methodName=result.getName().toString().trim();
//        ITestContext context = result.getTestContext();
//        driver = (WebDriver)context.getAttribute("driver");
//    	takeScreenShot(methodName, driver);
		//get screenshot if failure caught.
//		try {
//			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped, " + result.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed but within success percentage, " + result.getName());
	}
 	public void onStart(ITestContext context) {
		System.out.println("This is on Start method------- Main class, " + context.getOutputDirectory());
	}
 	public void onFinish(ITestContext context) {
		System.out.println("This is on Finish method, " + context.getPassedTests());
//		extent.flush();
	}
 	
 	public void takeScreenShot(String methodName, WebDriver driver) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + "_" + timeStamp + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
