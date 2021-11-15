package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginSteps {
	WebDriver driver = null;
//	loginPage login = new loginPage(driver);
	
	@Given("This is a blank test")
	public void blank_test() {
		System.out.println("Function test pass");
	}
	
	
	@SuppressWarnings("deprecation")
	@Given("I launch Chrome browser")
	public void Launch_browser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		driver= new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@When("I open xenonstack career homepage")
	public void launch_homepage() throws InterruptedException {
		driver.get("https://careers.xenonstack.com/onboarding/login");
		Thread.sleep(2000);
	}
	
	
	@And("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_credentials(String user, String pwd) throws Throwable{
		loginPage login = new loginPage(driver);
		login.credentials(user, pwd);

	}
	
	
	@And("click on login button")
	public void login_button() throws InterruptedException {
		loginPage login = new loginPage(driver);
		login.clickLogin();
		Thread.sleep(2000);
	}
	
	
	@And("Verify Is credentials are valid or not")
	public void verifyCredentials() throws InterruptedException {
		loginPage login = new loginPage(driver);
		login.verifyCredentials();
		Thread.sleep(2000);
	}
	
	
	@And("Check the progress")
	public void start_button() throws InterruptedException {
		loginPage login = new loginPage(driver);
		login.verifyProgress();
		Thread.sleep(2000);
	}

	
	@Then("Process completed")
	public void select_move() {
		System.out.println("Process completed");
		driver.close();
		driver.quit();

	}
}
