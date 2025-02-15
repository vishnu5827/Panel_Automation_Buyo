package panel_script;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dispatch_pages extends order_list_page {
	
	public Dispatch_pages(WebDriver driver) {
		super(driver);
		
	}

	By btn_dispatch=By.xpath("//div[@class='top-nav-wrapper']//ul//li[8]");
	By btn_transit=By.xpath("//div//div//ul[contains(@id,'Dispatches-popup')]//li[1]");
	By btn_create_dispatch=By.xpath("//span[normalize-space()='Create Dispatch']");
	By btn_buyer=By.xpath("//input[@id='admin_buyer']");
	By buyer_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Buyo_Buyer_Automation\"]");
	By btn_order_no=By.xpath("//input[@id='admin_order']");
	By btn_pur_bill=By.xpath("//input[@id='admin_purchaseBillNo']");
	By btn_dispatch_qty=By.xpath("//input[@id='admin_dispatchedQty']");
	By btn_dispatch_date=By.xpath("//input[@id='admin_dispatchedOn']");
	By btn_transit_status=By.xpath("//input[@id='admin_transitStatus']");
	By transit_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"Awaiting Loading\"]");
	By btn_vehicle_number=By.xpath("//input[@id='admin_vehicleNo']");
	By btn_dispatch_from=By.xpath("//input[@id='admin_dispatchFrom']");
	By btn_addtional_info=By.xpath("//textarea[@id='admin_notes']");
	By btn_submit=By.xpath("//button[@type='submit']//span[contains(text(),'Create Dispatch')]");
	By btn_confirm=By.xpath("//div[@class=\"ant-modal-footer\"]//button[2]");
	
	public void click_dispatch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement dispatch_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_dispatch));
		dispatch_click.click();
	}
	
	public void click_intransit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement transit_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_transit));
		transit_click.click();
	}
	
	public void create_dispatch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement dispatch_create= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create_dispatch));
	    dispatch_create.click();
	}
	
	public void set_buyer(String buyer) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement buyer_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_buyer));
		buyer_field.click();
		buyer_field.sendKeys(buyer);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement buyer_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(buyer_value));
		buyer_data.click();
	}
	
	
	
	public void set_order_no() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement order_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_order_no));
 	    order_field.click();
 	    String order_Num=super.get_order_no();
 	    System.out.println("Retrieved PO Number: " + order_Num);
 	    if (order_Num != null && !order_Num.isEmpty()) {
 		   order_field.sendKeys(order_Num);
 		   Thread.sleep(5000);
 		   order_field.sendKeys(Keys.ENTER);
        } else {
            throw new IllegalStateException("Purchase Order Number is null or empty!");
        }
	}
	
	public void set_purchase_bill(String pb) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement purchase_bill_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_pur_bill));
	    purchase_bill_field.sendKeys(pb);	
	}
	
	public void set_dispatch_qty(String dq) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement dispatch_qty_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_dispatch_qty));
	    dispatch_qty_field.sendKeys(dq);
		Thread.sleep(2000);		
	}
	
	public void set_dispatch_date() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement dispatch_date_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_dispatch_date));
		dispatch_date_field.click();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		int currentDay = currentDate.getDayOfMonth();
		System.out.println("The current date is :" + currentDate);
		WebElement currentDayElement = driver.findElement(By.xpath("//div[@class=\"ant-picker-body\"]//table//tbody//tr//td//div[text()='" + currentDay + "']"));
	    currentDayElement.click();
	   
	}
	
	public void set_transit_status() throws InterruptedException {
 	    WebElement transit_field=driver.findElement(btn_transit_status);
	    transit_field.click();
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement transit_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(transit_value));
		transit_data.click();

	}

	public void set_vehicle_number(String vn) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement vehicle_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_vehicle_number));
	    vehicle_field.sendKeys(vn);
			
	}
	
	public void set_dispatch_from(String df) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement dispatch_frm_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_dispatch_from));
	    dispatch_frm_field.sendKeys(df);
			
	}
	
	public void set_additional_info(String ai) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement info_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_addtional_info));
	    info_field.sendKeys(ai);	
	}
	
	public void click_submit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement submit_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit));
		submit_click.click();
	}
	
	public void click_confirm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement confirm_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_confirm));
		confirm_click.click();
		Thread.sleep(7000);
	}
}

class transit_list_page extends order_list_page {

	public transit_list_page(WebDriver driver) {
		super(driver);
	}
	
	By btn_transit_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_transit_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"transit_automation\"]");
	By btn_order_search_icon=By.xpath("(//div[@class=\"ant-table-filter-column\"]//span[@role=\"button\"])[2]");
	By btn_order_search_input=By.xpath("//input[@placeholder='Search by Order No']");

	
	public void click_transit_saved_view(String saved) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement saved_view_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_transit_saved_view));
		saved_view_click.click();
		saved_view_click.sendKeys(saved);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement saved_view_select = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_transit_saved_value));
		saved_view_select.click();
		Thread.sleep(3000);
    }
	
	public void click_order_filter() throws InterruptedException {
		driver.findElement(btn_order_search_icon).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement order_Field2 = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_order_search_input));
		 order_Field2.click();
		 String order_Num1=super.get_order_no();
	 	    System.out.println("Retrieved order Number in transit page: " + order_Num1);
	 	    if (order_Num1!= null && !order_Num1.isEmpty()) {
	 		   order_Field2.sendKeys(order_Num1,Keys.ENTER);
	 		   Thread.sleep(5000);
	        } else {
	            throw new IllegalStateException("Order Number is null or empty!");
	        }
	 	    Thread.sleep(10000);
	    }
	 
	}
	
 class Supplier_payment extends Dispatch_pages{

	Supplier_payment(WebDriver driver) {
		super(driver);
	
	}
	
	By btn_supplier_payment=By.xpath("//div//div//ul[contains(@id,'Dispatches-popup')]//li[2]");
	
	public void click_dispatch() throws InterruptedException {
		super.click_dispatch();
		Thread.sleep(5000);
	}
	
	public void click_supplier_pay() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement supplier_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_supplier_payment));
		supplier_click.click();
		Thread.sleep(8000);
		
	}
	
	public void create_dispatch() throws InterruptedException {
		super.create_dispatch();
	}
	
	public void set_buyer(String buyer) throws InterruptedException {
		super.set_buyer(buyer);
	}
	
	public void set_order_no() throws InterruptedException {
		super.set_order_no();
	}
	
	public void set_purchase_bill(String pb1) throws InterruptedException {
		super.set_purchase_bill(pb1);
	}
	
	public void  set_dispatch_quantity(String dq1) throws InterruptedException {
		super.set_dispatch_qty(dq1);
	}
	
	public void set_dispatch_date() throws InterruptedException {
		super.set_dispatch_date();
	}
	
	public void set_transit_status() throws InterruptedException {
		super.set_transit_status();
	}
	
	public void set_vehicle_number(String vn1) throws InterruptedException {
	    super.set_vehicle_number(vn1);
	}
	
	public void set_dispatch_from(String df1) throws InterruptedException {
		super.set_dispatch_from(df1);
	}
	
	public void set_additonal_info(String ai1) throws InterruptedException {
		super.set_additional_info(ai1);
	}
	
	public void click_submit2() throws InterruptedException {
		super.click_submit();
	}
	
	public void click_confirm2() throws InterruptedException {
		super.click_confirm();
	}
}
 
 class supplier_list_page extends order_list_page {
   
	  public supplier_list_page(WebDriver driver) {
		  super(driver);
	  }
	 
	private static String dispatch_value;
	 
		
	By btn_dispatch=By.xpath("//div[@class='top-nav-wrapper']//ul//li[8]");
	By btn_supplier_payment=By.xpath("//div//div//ul[contains(@id,'Dispatches-popup')]//li[2]");
	By btn_payable_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_payable_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"payable_automation\"]");
	By btn_order_search_icon1=By.xpath("(//div[@class=\"ant-table-filter-column\"]//span[@role=\"button\"])[2]");
	By btn_order_search_input1=By.xpath("//input[@placeholder='Search by Order No']");
	By btn_clear_for_payment=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[6]//div[2]//button[@type=\"button\"]");
	By btn_grn_upload=By.xpath("(//div[@class=\"ant-upload ant-upload-select ant-upload-select-text\"]//span//button//span[text()=\"Click to Upload\"])[7]");	
	By btn_received_qty=By.xpath("//input[@id='admin_receivedQty']");
	By btn_submit=By.xpath("//div[@class=\"ant-form-item-control-input\"]//div//button[@type=\"submit\"]");
	
	/*public void click_dispatch() throws InterruptedException {
		driver.findElement(btn_dispatch).click();
		Thread.sleep(3000);
	}
	
	public void click_supplier_pay() throws InterruptedException {
		driver.findElement(btn_supplier_payment).click();
		Thread.sleep(3000);
	}*/
	
	
	public void click_payable_saved_view(String saved) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement saved_view_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_payable_saved_view));
		saved_view_click.click();
		saved_view_click.sendKeys(saved);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement saved_view_select = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_payable_saved_value));
		saved_view_select.click();
		Thread.sleep(5000);
    }

	/* public void search_order_no() throws InterruptedException {
			driver.findElement(btn_order_search_icon1).click();
			Thread.sleep(2000);
		    WebElement order_field= driver.findElement(btn_order_search_input1);
		    order_field.sendKeys("BF2511",Keys.ENTER);
		    Thread.sleep(3000);
		} */

	public void click_order_filter() throws InterruptedException {
		WebElement order_search_icon= driver.findElement(btn_order_search_icon1);
		order_search_icon.click();
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		 WebElement order_Field3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_order_search_input1));
		 order_Field3.click();
		 String order_Num1=super.get_order_no();
	 	    System.out.println("Retrieved dispatch Number in transit page: " + order_Num1);
	 	    if (order_Num1!= null && !order_Num1.isEmpty()) {
	 		   order_Field3.sendKeys(order_Num1,Keys.ENTER);
	        } else {
	            throw new IllegalStateException("Dispatch Number is null or empty!");
	        }
	 	    Thread.sleep(3000);
	    }
	 public void capture_dispatch_no() {
			
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement dispatch_no=  wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@class='ant-table-body']//table//tbody//tr[2]//td[2]//a") ));
		 dispatch_value=dispatch_no.getText();
		 System.out.println(dispatch_value);
	 }
	 
	 public String get_dispatch_no() {
		 System.out.println("getting the dispatch no :"+ dispatch_value);
		  return dispatch_value	; 
}
		
	public void click_clear_for_payment() throws InterruptedException, AWTException {
	    WebElement clear_pay_click=driver.findElement(btn_clear_for_payment);
		clear_pay_click.click();
		Thread.sleep(3000);
		
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.querySelector(\"#admin > div.ant-card.ant-card-bordered\").scrollTop=1200");
	    Thread.sleep(5000);
		
	     WebElement click_upload = driver.findElement(By.xpath("(//div[@class='ant-upload ant-upload-select ant-upload-select-text']//span//button//span[text()='Click to Upload'])[7]"));
	     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", click_upload);
	     click_upload.click();
	    
	    Thread.sleep(5000);
	    
	    StringSelection selection = new StringSelection("T:\\Vg_Selenium\\files\\uploadTest");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	    Robot robot = new Robot();
	    robot.delay(2000); 
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(3000);
	    // Press Enter
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	    Thread.sleep(5000);
	}
	
	public void received_qty(String rq) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement received_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_received_qty));
		received_field.sendKeys(rq);
	}

	public void click_submit5() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement submit_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit));
	    submit_click.click();
	    Thread.sleep(7000);
	}

}
 

class Schedule extends Purchase_Order_page
{

	Schedule(WebDriver driver) {
		super(driver);
		
	}
	By btn_dispatch=By.xpath("//div[@class='top-nav-wrapper']//ul//li[8]");
    By btn_supplier_payment=By.xpath("//div//div//ul[contains(@id,'Dispatches-popup')]//li[3]");
	By btn_create_schedule=By.xpath("//div//div//button[@type=\"button\"]//span[text()=\"Add Schedule\"]");
    By btn_purchase_order=By.xpath("//input[@id='admin_purchaseOrder']");
    //By btn_schedule_mode=By.xpath("//div[@class=\"ant-select-selector\"]//span//input[@id=\"admin_scheduleMode\"]");
	By btn_schedule_date=By.xpath("//div[@class='ant-picker ant-picker-range']");
	By btn_total_commitment=By.xpath("//div[@class=\"ant-card-body\"]//div[@class=\"ant-input-number-input-wrap\"]//input[@id=\"admin_totalCommitment\"][1]");
	By btn_submit3=By.xpath("//button[@type='submit']//span[contains(text(),'Add Schedule')]");
	By btn_confirm3=By.xpath("//div[@class=\"ant-modal-footer\"]//button[2]");

	
	public void click_dispatch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dispatch_field1= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_dispatch));
		dispatch_field1.click();
			
		
	}
	
	public void click_schedule() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement schedule_click= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_supplier_payment));
		schedule_click.click();
	}
	
	public void create_schedule() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement create_click= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create_schedule));
		create_click.click();
	}
	
	public void set_buyer(String buyer) throws InterruptedException {
		super.set_buyer(buyer);
		Thread.sleep(2000);
	}
	
	public void set_purchase_order_num() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement po_sch_Field2 = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_purchase_order));
        po_sch_Field2.click();
        Thread.sleep(3000);
        String poNum=super.get_po();
 	    System.out.println("Retrieved PO Number: " + poNum);
 	    if (poNum != null && !poNum.isEmpty()) {
 		   po_sch_Field2.sendKeys(poNum,Keys.ENTER);
 		   Thread.sleep(5000);
        } else {
            throw new IllegalStateException("Purchase Order Number is null or empty!");
        }
    } 
	
	/*public void schedule_mode() throws InterruptedException {
		WebElement schedule= driver.findElement(btn_schedule_mode);
		schedule.click();
		Thread.sleep(3000);	
	}*/
	
	public void set_schedule_date () throws InterruptedException {
		driver.findElement(btn_schedule_date).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"ant-picker-footer\"]//ul//li[1]")).click();
	}
	
	public void set_sch_commitment(String tc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement commit_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_total_commitment));
		driver.findElement(btn_total_commitment).sendKeys(tc);
		Thread.sleep(3000);
	}
	
	public void click_submit3() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement submit_click3= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit3));
		submit_click3.click();
	}
	
	public void click_confirm3() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement confirm_click3= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_confirm3));
		confirm_click3.click();
		Thread.sleep(5000);
	}
	
}

class schedule_list_page extends Schedule{

	schedule_list_page(WebDriver driver) {
		super(driver);
	}
	
	By btn_schedule_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_schedule_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"schedule_automation\"]");
	By btn_po_num_search_icon=By.xpath("(//div[@class=\"ant-table-filter-column\"]//span[@role=\"button\"])[1]");
	By btn_po_num_search=By.xpath("//input[@placeholder='Search by Purchase Order No']");
	By web_table_status=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[5]");

	
	public void click_schedule_saved_view(String saved) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement saved_view_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_schedule_saved_view));
		saved_view_click.click();
		saved_view_click.sendKeys(saved);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement saved_view_select = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_schedule_saved_value));
		saved_view_select.click();
		Thread.sleep(3000);
    }
	
	public void click_po_search3() throws InterruptedException {
    	WebElement po_search=driver.findElement(btn_po_num_search_icon);
    	po_search.click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement po_Field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_po_num_search));
 	    po_Field.click();
 	    String poNum=super.get_po();
 	    System.out.println("Retrieved PO Number: " + poNum);
 	    if (poNum != null && !poNum.isEmpty()) {
 		   po_Field.sendKeys(poNum,Keys.ENTER);
 		   Thread.sleep(8000);
        } else {
            throw new IllegalStateException("Purchase Order Number is null or empty!");
        }
    }
	
   /* public void tab_switching() throws InterruptedException {
			    
	    WebElement status=driver.findElement(web_table_status);
	    String e4= status.getText();
	    System.out.println("Check the status txt for button click event. :"+e4);
	    
	    List<WebElement>lead_buttons= driver.findElements(By.xpath("//label[contains(@class,\"ant-radio-button-wrapper\")]"));
	    
	    for(WebElement button:lead_buttons) {
	    	String tab_label=button.getText().trim();
	    	if(tab_label.contains(e4)) {
	    		button.click();
	    	}
	    	Thread.sleep(3000);
	    }
	}*/

}	
	

	
	
