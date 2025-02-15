package panel_script;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {
	
	WebDriver driver; // declaring as a "class variable" so that we can access in multiple action methods.
	
	Login_Page(WebDriver driver){
		this.driver  = driver;
		
		/*Here we have used local variable as webdriver driver but we have used same for class variable as well. So we are using "this" in driver assigning 
		in constructor. Also for local variable we will pass driver from the test case*/
	}
	
	By txt_username=By.xpath("(//input[@id='login-form_email'])[1]");
	By txt_password=By.xpath("(//input[@id='login-form_password'])[1]");
	By btn_sign_in=By.xpath("(//button[@type='submit'])[1]");
	
    public  void set_username(String user){
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement user_name= wait.until(ExpectedConditions.visibilityOfElementLocated(txt_username));
        user_name.sendKeys(user);
    
     }
    
    public  void set_password(String pwd){
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement user_pass= wait.until(ExpectedConditions.visibilityOfElementLocated(txt_password));
         user_pass.sendKeys(pwd);
       
     }
 
    public  void click_signup() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement submit= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_sign_in));
        submit.click();
        
     }

    
    
	}

