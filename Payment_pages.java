package panel_script;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment_pages extends supplier_list_page {

	public Payment_pages(WebDriver driver) {
		super(driver);
			}

	By btn_payment=By.xpath("//div[@class='top-nav-wrapper']//ul//li[10]");
	By btn_payment1=By.xpath("//div//div//ul[contains(@id,'Payments-popup')]//li[1]");
	By btn_create=By.xpath("//span[normalize-space()='Create Payment']");
    By btn_dispatch=By.xpath("//input[@id='admin_dispatch']");
	By btn_payment_type=By.xpath("//input[@id='admin_paymentType']");
	By pay_type_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Purchase\"]");
	By btn_amount=By.xpath("//input[@id='admin_amount']");
	By btn_pay_mode=By.xpath("//input[@id='admin_paymentMode']");
	By pay_mode_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Cash\"]");
	By btn_transaction_ref=By.xpath("//input[@id='admin_transactionRefNo']");
	By btn_payment_date=By.xpath("//input[@id='admin_paymentDate']");
	By btn_submit=By.xpath("//button[@type='submit']//span[contains(text(),'Create Payment')]");
	By btn_confirm=By.xpath("//div[@class=\"ant-modal-footer\"]//button[2]");

	
	
	public void click_payment() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement payment_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_payment));
		payment_click.click();
		
	}
	
	public void click_payment1() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement payment_click1 = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_payment1));
		payment_click1.click();
		
	}
	
	public void create_payment() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement payment_create = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create));
		payment_create.click();
	}
	
	public void set_dispatch_no() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement dispatch_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_dispatch));
 	    dispatch_field.click();
 	    String dispatch_Num=super.get_dispatch_no();
 	    System.out.println("Retrieved dispatch Number: " + dispatch_Num);
 	    if (dispatch_Num != null && !dispatch_Num.isEmpty()) {
 		   dispatch_field.sendKeys(dispatch_Num);
 		   Thread.sleep(5000);
 		   dispatch_field.sendKeys(Keys.ENTER);
        } else {
            throw new IllegalStateException("Dispatch Number is null or empty!");
	}
	}
	
	public void set_pay_type() throws InterruptedException {
 	    WebElement pay_type=driver.findElement(btn_payment_type);
		pay_type.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement pay_type_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(pay_type_value));
		pay_type_data.click();
	}
	
	public void set_amount(String amount) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement amount_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_amount));
		amount_field.sendKeys(amount);
	
	}
	
	public void set_pay_mode() throws InterruptedException {
 	    WebElement pay_mode =driver.findElement(btn_pay_mode);
		pay_mode.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement pay_mode_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(pay_mode_value));
	    pay_mode_data.click();
	}
	
	public void set_txn_ref(String txn) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement txn_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_transaction_ref));
		txn_field.sendKeys(txn);
	}
	
	public void set_pay_date() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement pay_data = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_payment_date));
		pay_data.click();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		int currentDay = currentDate.getDayOfMonth();
		System.out.println("The current date is :" + currentDate);
		WebElement currentDayElement = driver.findElement(By.xpath("//div[@class=\"ant-picker-body\"]//table//tbody//tr//td//div[text()='" + currentDay + "']"));
	    currentDayElement.click();
	}
	
	public void click_submit4() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement submit_click= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit));
		submit_click.click();
		
	}
	
	public void click_confirm4() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement confirm_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_confirm));
		confirm_click.click();
		Thread.sleep(7000);
	}
}

class payment_list_page extends Payment_pages{

	public payment_list_page(WebDriver driver) {
		super(driver);
	}
	
	By btn_payment_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_payment_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"payment_automation\"]");
	By btn_payment_search_icon=By.xpath("(//div[@class=\"ant-table-filter-column\"]//span[@role=\"button\"])[2]");
	By btn_payment_search_input=By.xpath("//input[@placeholder='Search by Dispatch No']");
		
	public void click_payment_saved_view(String saved) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement saved_view_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_payment_saved_view));
		saved_view_click.click();
		saved_view_click.sendKeys(saved);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement saved_view_select = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_payment_saved_value));
		saved_view_select.click();
    }
	
	public void click_dispatch_no_filter() throws InterruptedException {
		driver.findElement(btn_payment_search_icon).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement dispatch_Field2 = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_payment_search_input));
		 dispatch_Field2.click();
		 String dispatch_Num1=super.get_dispatch_no();
	 	    System.out.println("Retrieved order Number in transit page: " + dispatch_Num1);
	 	    if (dispatch_Num1!= null && !dispatch_Num1.isEmpty()) {
	 		   dispatch_Field2.sendKeys(dispatch_Num1,Keys.ENTER);
	 		   Thread.sleep(5000);
	        } else {
	            throw new IllegalStateException("Order Number is null or empty!");
	        }
	    }
	}
	
	


class Affiliate extends Payment_pages{

	Affiliate(WebDriver driver) {
		super(driver);
		
	}
	 
	By btn_affilaite=By.xpath("//div//div//ul[contains(@id,'Payments-popup')]//li[5]");
	By btn_create=By.xpath("//span[normalize-space()='Create Affiliate Payment']");
	By btn_affilaite1 =By.xpath("//input[@id='admin_affiliateBy']");
	By aff_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"mary1\"]");
    By btn_amount=By.xpath("//input[@id='admin_amount']");
	By btn_pay_mode=By.xpath("//input[@id='admin_paymentMode']");
	By btn_txn_ref=By.xpath("//input[@id='admin_transactionRefNo']");
	By btn_payment_date=By.xpath("//input[@id='admin_paymentDate']");
	
	
	public void click_payment() throws InterruptedException {
		super.click_payment();
		Thread.sleep(2000);
	}
	
	public void click_affiliate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement aff_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_affilaite));
		aff_click.click();
	}
	
	public void create_affiliate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement aff_create = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create));
		aff_create.click();
	}
	
	public void set_affiliate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement aff_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_affilaite1));
		aff_field.click();
		aff_field.sendKeys("mary1");
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement aff_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(aff_value));
		aff_data.click();
	}
	
	public void set_amount(String aa) throws InterruptedException {
		super.set_amount(aa);
	}
	
	public void set_pay_mode() throws InterruptedException {
		super.set_pay_mode();
		Thread.sleep(2000);
	}
	
	public void set_txn_ref(String txn1) throws InterruptedException {
		super.set_txn_ref(txn1);
		Thread.sleep(2000);
	}
	
	public void pay_date() throws InterruptedException {
		super.set_pay_date();
		Thread.sleep(2000);
	}
	
	public void click_submit5() throws InterruptedException {
		super.click_submit4();
		Thread.sleep(7000);
	}	
}

class affiliate_list_page extends Affiliate{
	
	affiliate_list_page(WebDriver driver) {
		super(driver);
	}
	
	By btn_affiliate_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_affiliate_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"aff_automation\"]");
	
public void click_affiliate_saved_view(String saved) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement saved_view_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_affiliate_saved_view));
		saved_view_click.click();
		saved_view_click.sendKeys(saved);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement saved_view_select = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_affiliate_saved_value));
		saved_view_select.click();
		Thread.sleep(3000);
}
}