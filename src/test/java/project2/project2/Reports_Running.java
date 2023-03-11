package project2.project2;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@Listeners(WBListen.class)
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Features", glue= {"project2.project2"},
monochrome = true,

plugin = {"pretty", "junit:target/junit/report3.xml",
		"html:target/html/HtmlReports3",
		"json:target/JSONReports/report3.json"},
tags="@Login and @Sorting2"
		)

public class Reports_Running {

	public Reports_Running() {
		// TODO Auto-generated constructor stub
	}

}
