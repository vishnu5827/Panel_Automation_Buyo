package panel_script;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Business_page {


    WebDriver driver; 
    
	public Business_page(WebDriver driver) {
	this.driver  = driver;	
}
	By btn_business=By.xpath("//div[@class='top-nav-wrapper']//ul//li[4]");
	By btn_create_business=By.xpath("//span[normalize-space()='Create Business']");
	By btn_business_name=By.xpath("//input[@id='admin_businessname']");
	By btn_gst=By.xpath("//div[@id='admin_gstNumber']//input[@type='text']");
	By btn_msme_no=By.xpath("//input[@value='false']");
	By btn_verify_gst=By.xpath("//span[normalize-space()='Verify GST']");
	By btn_gst_confirm=By.xpath("//span[normalize-space()='Confirm']");
	By btn_business_type=By.xpath("//input[@id='admin_businessType']");
	By business_type_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"Manufacturer\"]");
	By btn_business_mail=By.xpath("//input[@id='admin_businessemail']");
	By btn_business_phone=By.xpath("//input[@id='admin_businessphone']");
	By btn_same_mail_phone=By.xpath("//span[@class='ant-checkbox ant-checkbox-disabled']//input[@type='checkbox']");
	By btn_address_line1=By.xpath("//input[@id='admin_line1']");
	By btn_address_line2=By.xpath("//input[@id='admin_line2']");	
	By btn_country=By.xpath("//span[@class='ant-select-selection-item']");
	By btn_state=By.xpath("//span[@class='ant-select-selection-item']");
	By btn_city=By.xpath("//span[@class='ant-select-selection-item']");
	By btn_pincode=By.xpath("//input[@id='admin_pincode']");
	By btn_zone=By.xpath("//input[@id='admin_zone']");
	By btn_customer_name=By.xpath("//input[@id='admin_username']");
	By btn_customer_email=By.xpath("//input[@id='admin_useremail']");
	By btn_customer_phone=By.xpath("//input[@id='admin_userphone']");
	By btn_customer_designation=By.xpath("//input[@id='admin_designation']");
	By btn_prod_buy=By.xpath("//div[@class=\"ant-select-selection-search\"]//input[@id=\"admin_buying\"]");
	By btn_prod_sell=By.xpath("//div[@class=\"ant-select-selection-search\"]//input[@id=\"admin_selling\"]");
	By otp_field=By.xpath("//div[@class=\"ant-form-item-control-input-content\"]//input[@id=\"admin_otp\"]");
	
	public void click_business() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement busines_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_business));
        busines_click.click();
		
	}
	
	public void create_business() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement create_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create_business));
		create_click.click();
	}
	
	public void set_business_name(String bn) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement business_name= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_business_name));
		business_name.sendKeys(bn);
	
	}
	
	public void set_business_gst(String gst) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement gst1= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_gst));
		gst1.sendKeys(gst);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement gst_verify= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_verify_gst));
		gst_verify.click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement gst_confirm= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_gst_confirm));
		gst_confirm.click();
		Thread.sleep(2000);
	}
	
	public void click_msme() throws InterruptedException {
		WebElement msme=driver.findElement(btn_msme_no);
		msme.click();
		Thread.sleep(2000);

	}
	
	public void set_business_type() throws InterruptedException {
		
 	    WebElement business_type= driver.findElement(btn_business_type);
		business_type.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement type_value=wait.until(ExpectedConditions.visibilityOfElementLocated(business_type_value));
 	    type_value.click();
		
	}
	
	public void set_business_mail(String mail) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement business_mail= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_business_mail));
		business_mail.sendKeys(mail);
		
	}
	
	public void set_business_phone(String phone) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement business_phone= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_business_phone));
		business_phone.sendKeys(phone);
		Thread.sleep(3000);
	}
	
	public void click_same_check_box() throws InterruptedException {
 	    WebElement same_as_click = driver.findElement(btn_same_mail_phone);
		same_as_click.click();
		Thread.sleep(2000);
	}
	
	public void set_business_add1(String add_1) throws InterruptedException {
		WebElement text_add1=driver.findElement(btn_address_line1);
		//@SuppressWarnings("deprecation")
	    String add1=text_add1.getAttribute("value");
	    Thread.sleep(3000);
		if(add1==null||add1.isEmpty()) {
		text_add1.sendKeys(add_1);	
		}
		Thread.sleep(2000);
	}
	
	public void set_business_add2(String add_2) throws InterruptedException {
		WebElement text_add2= driver.findElement(btn_address_line2);
		//@SuppressWarnings("deprecation")
	    String add2=text_add2.getAttribute("value");
		if(add2==null||add2.isEmpty()) {
		text_add2.sendKeys(add_2);	
		}
		Thread.sleep(2000);
	}
	
	public void set_country() throws InterruptedException {
		WebElement country_field= driver.findElement(btn_country);
		@SuppressWarnings("deprecation")
		String country=country_field.getAttribute("title");
		if(country==null||country.isEmpty()) {
			country_field.click();
			Thread.sleep(3000);
			country_field.sendKeys("India");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"India\"]")).click();
			Thread.sleep(2000);	
		}
		
	}
	
	public void set_state() throws InterruptedException {
		WebElement State_field=driver.findElement(btn_state);
		@SuppressWarnings("deprecation")
		String state=State_field.getAttribute("title");
		if(state==null||state.isEmpty()) {
			State_field.click();
			Thread.sleep(3000);
			State_field.sendKeys("Tamil Nadu",Keys.ENTER);
			
		}
	}
	
	public void set_city() throws InterruptedException {
		WebElement city_field=driver.findElement(btn_city);
		@SuppressWarnings("deprecation")
		String city=city_field.getAttribute("title");
		if(city==null||city.isEmpty()) {
			city_field.click();
			Thread.sleep(3000);
			city_field.sendKeys("Coimbatore",Keys.ENTER);
			
		}
		
	}
	
	public void set_pincode(String pin) throws InterruptedException {
		WebElement pin_field=driver.findElement(btn_pincode);
		@SuppressWarnings("deprecation")
		String pincode=pin_field.getAttribute("value");
		if(pincode==null||pincode.isEmpty()) {
			pin_field.sendKeys(pin);
		}
		Thread.sleep(2000);
	}
	

	public void set_zone() throws InterruptedException {
 	    WebElement business_zone=driver.findElement(btn_zone);
		business_zone.click();
		Thread.sleep(2000);
		
	}
	

	public void set_cust_name(String c_name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement cus_name= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_customer_name));
		cus_name.sendKeys(c_name);
		
	}
	
	public void set_cust_mail(String c_mail) throws InterruptedException {
		WebElement customer_mail=driver.findElement(btn_customer_email);
		String mail=customer_mail.getAttribute("value");
		if(mail==null||mail.isEmpty()) {
			customer_mail.sendKeys(c_mail);
		}
		Thread.sleep(2000);
	}
	
	public void set_cust_phone(String c_phone) throws InterruptedException {
		WebElement customer_phone= driver.findElement(btn_customer_phone);
		String phone=customer_phone.getAttribute("value");
		if(phone==null||phone.isEmpty()) {
			customer_phone.sendKeys(c_phone);
		}
		Thread.sleep(2000);
	}
	
	public void set_cust_designation(String c_dgn) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement cus_designation= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_customer_designation));
	    cus_designation.sendKeys(c_dgn);
		
	}
	
	public void action() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll down
		Thread.sleep(6000);
	}
	
	public void select_product(String prod1,String prod2,String prod3,String prod4) throws InterruptedException {
		WebElement prod_buying= driver.findElement(btn_prod_buy);
		prod_buying.click();
		prod_buying.sendKeys(prod1);
		prod_buying.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		prod_buying.sendKeys(prod2);
		prod_buying.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		prod_buying.sendKeys(prod3);
		prod_buying.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		prod_buying.sendKeys(prod4);
		prod_buying.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	
		WebElement prod_selling=driver.findElement(btn_prod_sell);
		prod_buying.click();
		prod_selling.sendKeys(prod1);
		prod_selling.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		prod_selling.sendKeys(prod2);
		prod_selling.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		prod_selling.sendKeys(prod3);
		prod_selling.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		prod_selling.sendKeys(prod4);
		prod_selling.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	
	}
	 }
