package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class loginPage {

	WebDriver driver = null;
	
	String baseUrl = "https://careers.xenonstack.com/onboarding/login";
	private By EmailId = By.id("email");
	private By txt_password = By.id("password");
	private By btn_login	 = By.id("send-invite");
	private By Progress_color = By.xpath("//*[@id=\"root\"]/div/div[1]/div/main/div/section/div/div/div/div[1]/article/div[2]/ul/li[3]/div/button");
	private By btn_profile = By.xpath("//*[@id=\"navigation-bar\"]/div[2]/div[2]/ul/li[6]/div[1]");
	private By btn_logout = By.xpath("//*[@id=\"navigation-bar\"]/div[2]/div[2]/ul/li[6]/div[2]/div/div[2]/button");
	private By btn_Cnf_logout = By.xpath("//header/div[@id='logoutDialog']/div[1]/div[2]/div[2]/button[1]");
	
	
	public loginPage(WebDriver driver){
		this.driver = driver;
	}
	
//	Login Credentials 
	
	public void credentials(String email, String password) {

		driver.findElement(EmailId).sendKeys(email);

		driver.findElement(txt_password).sendKeys(password);
	}
	
//	Verify Credentials
	
	public void verifyCredentials() {
		String actualUrl="https://careers.xenonstack.com/onboarding/employee/modules";
        String expectedUrl= driver.getCurrentUrl();
        System.out.println(expectedUrl);
        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("Valid credentials");
        }
        else
        {
            System.out.println("Invalid credentials test failed");
            driver.close();
        }
	}
	
//	Click login button
	
	public void clickLogin() {
		driver.findElement(btn_login).click();
	    }
	
	
	@SuppressWarnings("deprecation")
	public void verifyProgress() throws InterruptedException {
		WebElement color = driver.findElement(Progress_color);
		String bg = color.getCssValue("background-color");
		String color1 = Color.fromString(bg).asHex();
		String expectedcolor = "#4ce076";
		Thread.sleep(2000);
		 if(color1.equalsIgnoreCase(expectedcolor))
	        {
	            System.out.println("Progress is 100%");
				driver.findElement(btn_profile).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(btn_logout).click();
				Thread.sleep(2000);
				driver.findElement(btn_Cnf_logout).click();
	        }
	        else
	        {
	            System.out.println("Progress is not 100%");
	            driver.close();
	        }
	}
}
	
//	public void loginValidUser(String Email, String password ) {
//		driver.findElement(EmailId).sendKeys(Email);
//		driver.findElement(txt_password).sendKeys(password);
//		driver.findElement(btn_login).click();
//	}
	

