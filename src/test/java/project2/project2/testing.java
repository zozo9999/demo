package project2.project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testing {
	public WebDriver driver;
	Login login;
	Sorting sort;
	CheckOut checkout; // check out
	public testing() throws Throwable {
		this.driver = COB_sorting_2.check_if_brwoser_is_started();
		// TODO Auto-generated constructor stub
	}
	@Given("Login {string}, Sorting tab is seen")
    public void login_sorting_tab_is_seen (String username) throws Throwable {
		login = new Login(driver);
//		System.out.println(username);
		
		login.enter_username(username);
		
//		if(username.equals("performance_glitch_user")) {
//			login.enter_username(username);
//			login.enter_password("secret_sauce");
//			login.click_login();
//			Thread.sleep(5000);
//		} else {
//			
//			
//		}
//		login.enter_username(username);
//		login.enter_password("secret_sauce");
//		login.click_login();
//		Thread.sleep(500);
//		String n =driver.findElement(By.cssSelector("error-message-container error")).getAttribute("class");
//		System.out.println(n);
//		if(n.equalsIgnoreCase("error-message-container error")) {
//			driver.quit();
//		}
    }
	
	@Given("^Enter \"([^\"]*)\" in password$")
	public void showing_the_list_when_a_user_clicks_the_tab(String str) {
		login = new Login(driver);
		login.enter_password(str);
		login.click_login();
	}
	

	@When("click {string} is clicked.")
    public void click_is_clicked(String string) {
		sort = new Sorting(driver);
		sort.click_list_sort(string);
    }
	
	@Then("^Vertify_A_to_Z$")
	public void Vertify_A_to_Z() throws Throwable {
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Sauce Labs Fleece Jacket");
		AssertJUnit.assertEquals(last_product, "Test.allTheThings() T-Shirt (Red)");
		
    }
	
	
}
