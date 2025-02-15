package panel_script;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class Order_page extends Purchase_Order_page {
		
	
	public Order_page(WebDriver driver) {
		super(driver);
		
	}
    	
	By btn_order=By.xpath("//div[@class='top-nav-wrapper']//ul//li[7]");
	By btn_order_create=By.xpath("//span[normalize-space()='Create Order Against PO']");
	By btn_buyer=By.xpath("//input[@id='admin_buyer']");
	By buyer_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Buyo_Buyer_Automation\"]");
	By btn_po_no=By.xpath("//div//div//div//div//div//span//input[@id=\"admin_purchaseOrder\"]");
	By po_value_click=By.xpath("//div[contains(@class,'ant-select-item ant-select-item-option ant-select-item-option-active')]//div[contains(@class,'ant-select-item-option-content')]//div");
	By btn_seller=By.xpath("//input[@id='admin_seller']");
	By seller_value=By.xpath("//div[@class=\"rc-virtual-list\"]//div//div//div//div[@title=\"Buyo_Seller_Automation\"]");
	By btn_skip_create=By.xpath("//div[@class=\"ant-modal-confirm-btns\"]//button[2]");
	By btn_order_date=By.xpath("//input[@id='admin_orderDate']");
	By btn_order_quantity=By.xpath("//input[@id='admin_qty']");
	By btn_pur_price=By.xpath("//input[@id='admin_purchasingPrice']");
	By btn_gst=By.xpath("//input[@id='admin_gst']");
	By gst_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"0% - GST Not Applied\"]");
	By btn_tranport=By.xpath("//input[@id='admin_transport']");
	By transport_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"Included\"]");
	By btn_pickup_add=By.xpath("//input[@id='admin_pickupAddressId']");
	By pickup_add_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@city=\"Ernakulam\"]//div//div//h5[text()=\"Buyo_Seller_Automation\"]");
	By btn_delivery_by=By.xpath("//input[@id='admin_deliveryOn']");
	By btn_payment_terms=By.xpath("//input[@id='admin_paymentTerms']");
	By btn_purcahse_credit=By.xpath("//input[@id='admin_purchaseCreditTerm']");
	By btn_remark=By.xpath("//textarea[@id='admin_remark']");
	By btn_add_order=By.xpath("//span[normalize-space()='Add Order']");
	By btn_confirm=By.xpath("//div[@class=\"ant-modal-footer\"]//button[2]");
	
	public void click_order() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement order_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_order));
        order_click.click();
			
	}
	
	public void create_order() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement create_click= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_order_create));
	    create_click.click();
			
	}
	
	public void set_buyer(String buy) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement buyer_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_buyer));
 	    buyer_field.click();
		buyer_field.sendKeys(buy);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement buyer_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(buyer_value));
 	    buyer_data.click();
		
    } 
	
	/*public void po_num() throws InterruptedException {
		WebElement po=driver.findElement(btn_po_no);
		po.click();
		Thread.sleep(2000);
		po.sendKeys("PON-QA-TEST-17/25");
		driver.findElement(By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@product=\"Acid Oils\"]")).click();
		Thread.sleep(3000);
	}*/
	
	public void set_po_number_order_page() throws InterruptedException {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   WebElement po_Field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_po_no));
	   po_Field.click();
	   String poNum=super.get_po();
	   System.out.println("Retrieved PO Number: " + poNum);
	   if (poNum != null && !poNum.isEmpty()) {
		   po_Field.sendKeys(poNum);
       } else {
           throw new IllegalStateException("Purchase Order Number is null or empty!");
       }

	   WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	   WebElement po_no_select = wait1.until(ExpectedConditions.visibilityOfElementLocated(po_value_click));
       po_no_select.click();
   }
	

	public void set_seller(String Sell) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement seller_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_seller));
		seller_field.click();
	    seller_field.sendKeys("Buyo_Seller_Automation");
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement seller_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(seller_value));
        seller_data.click();
		
	}
	
	public void click_skip_create() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement skip_existing = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_skip_create));
	    skip_existing.click();	
		}
	
	
	public void set_order_delivery_by_date() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement order_date_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_order_date));
		order_date_field.click();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		int currentDay = currentDate.getDayOfMonth();
		System.out.println("The current date is :" + currentDate);
		WebElement currentDayElement = driver.findElement(By.xpath("//div[@class=\"ant-picker-body\"]//table//tbody//tr//td//div[text()='" + currentDay + "']"));
	    currentDayElement.click();
	   
	}
	
	public void set_order_quantity(String o_qty) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement qty_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_order_quantity));
 	    qty_field.sendKeys(o_qty);
		
	}
	
	public void set_order_pur_price(String o_pp) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement pur_price_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_pur_price));
 	    pur_price_field.sendKeys(o_pp);
	}
	
	public void set_gst() throws InterruptedException {
		WebElement gst= driver.findElement(btn_gst);
		gst.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement gst_data= wait.until(ExpectedConditions.visibilityOfElementLocated(gst_value));
        gst_data.click();
	}
	
	public void set_trasport() throws InterruptedException {
 	    WebElement transport_field=driver.findElement(btn_tranport);
	    transport_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement transport_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(transport_value));
        transport_data.click();
		
	}
	
	public void action() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll down
		Thread.sleep(6000);
	}
	
	public void set_pickup_add() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement pick_up_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_pickup_add));
 	    pick_up_field.click();
 	    Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement pickup_add_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(pickup_add_value));
        pickup_add_data.click();
		Thread.sleep(3000);
	 }

    public void set_delivery_by() throws InterruptedException {
    
		WebElement delivery_date_field=driver.findElement(btn_delivery_by);
		delivery_date_field.click();
		delivery_date_field.sendKeys("25/01/2025",Keys.ENTER);
		Thread.sleep(2000);
		 
     }
	
	public void set_pay_term() throws InterruptedException {
		driver.findElement(btn_payment_terms).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"100% on delivery of the material.\"]")).click();
	}
	

	public void set_pur_credit_term(String pc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement purchase_credit_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_purcahse_credit));
 	    purchase_credit_field.sendKeys(pc);
	
	}
	
	public void set_qty_remark(String qr) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement qty_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_remark));
        qty_field.sendKeys(qr);
	}
	
	public void click_add_order() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement click_add_order= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_add_order));
        click_add_order.click();
		
	}
	
	public void confirm_order() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement click_comfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_confirm));
        click_comfirm.click();
        Thread.sleep(15000);
	}
	
}

class order_list_page extends Order_page {
	
	private static String Order_value;
	
	public order_list_page(WebDriver driver) {
		super(driver);
		
	}
	By btn_order_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_order_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"order_automation\"]");
	By btn_po_search=By.xpath("(//div[@class=\"ant-table-filter-column\"]//span[@role=\"button\"])[3]");
	By btn_search_input=By.xpath("//input[@placeholder='Search by Purchase Order No']");
	By web_tabs_name=By.xpath("//div[@class=\"table-radio-group\"]//div//label//span//input");
	By web_table_order_status=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[5]");
	By order_accept=By.xpath("(//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[6]//div//div//button[@type=\"button\"])[1]");
	By order_confirm_accept=By.xpath("//div[@class=\"ant-modal-body\"]//div[@class=\"ant-modal-confirm-btns\"]//button[2]");
	
	 public void click_order_saved_view(String saved) throws InterruptedException {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement saved_view_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_order_saved_view));
			saved_view_click.click();
			saved_view_click.sendKeys(saved);
			Thread.sleep(2000);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement saved_view_select = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_order_saved_value));
			saved_view_select.click();
		 }
	 
	 public void click_po_filter() throws InterruptedException {
		 WebElement order_icon_click=driver.findElement(btn_po_search);
		 order_icon_click.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement order_Field1 = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_search_input));
		 order_Field1.click();
		 String poNum=super.get_po();
	 	    System.out.println("Retrieved PO Number: " + poNum);
	 	    if (poNum != null && !poNum.isEmpty()) {
	 		   order_Field1.sendKeys(poNum,Keys.ENTER);
	 		   Thread.sleep(5000);
	        } else {
	            throw new IllegalStateException("Purchase Order Number is null or empty!");
	        }
	    } 
	 
	 public void capture_order_no() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement order_no=  wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@class='ant-table-body']//table//tbody//tr[2]//td[2]//a") ));
		 Order_value=order_no.getText();
		 System.out.println(Order_value);
	 }
	 
	 public String get_order_no() {
		 System.out.println("getting the order no :"+ Order_value);
		  return Order_value;
	 }
	 
	 public void tab_switching() throws InterruptedException {
			//WebElement tab_list=driver.findElement(web_tab_elements);
			//int tab_size = tab_list.findElements(By.tagName("label")).size();
			//System.out.println("Total no.of tabs present in the leads menu :"+tab_size);
			
			WebElement tab_name=driver.findElement(web_tabs_name);
		    List<WebElement>radio=driver.findElements(By.xpath("//input[@type='radio']"));
		     for(WebElement e:radio) {
				@SuppressWarnings("deprecation")
				String value=e.getAttribute("value");
			    //System.out.println(value);
			   }
		    
		    WebElement status=driver.findElement(web_table_order_status);
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
		}
	public void order_accept() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement order_accept_click = wait.until(ExpectedConditions.visibilityOfElementLocated(order_accept));
        order_accept_click.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement order_confirm_click = wait1.until(ExpectedConditions.visibilityOfElementLocated(order_confirm_accept));
		order_confirm_click.click();
		Thread.sleep(3000);
	
	}
	 
 
	 }
	
	
	





