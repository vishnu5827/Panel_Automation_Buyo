package panel_script;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.devtools.v131.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Purchase_Order_page{
    
	private static String po_num;
    protected WebDriver driver;
	
	public Purchase_Order_page(WebDriver driver) {
		this.driver=driver;
}
		
	By btn_Purchase_order=By.xpath("//div[@class='top-nav-wrapper']//ul//li[6]");
	By btn_create=By.xpath("//span[normalize-space()='Create Purchase Order']");
	By btn_po_no=By.xpath("//input[@id='admin_purchaseOrderNo']");
	By btn_po_date=By.xpath("//input[@id='admin_purchaseOrderDate']");
	By btn_buyer=By.xpath("//input[@id='admin_buyer']");
	By buyer_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Buyo_Buyer_Automation\"]//div");
	By btn_product=By.xpath("//input[@id='admin_product']");
	By product_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"Acid Oils\"]");
	By btn_unit=By.xpath("//input[@id='admin_subUnit']");
	By unit_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"KL\"]");
	By btn_sourcing_handler=By.xpath("//input[@id='admin_sourcingHandler']");
	By source_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"Vishnu_admin\"]");
	By btn_quantity=By.xpath("//input[@id='admin_fromQty']");
	By btn_trading_price=By.xpath("//input[@id='admin_price']");
	By btn_delivery_address=By.xpath("//input[@id='admin_deliveryAddressId']");
	By delivery_add_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div//div//h5[text()=\"Buyo_Buyer_Automation\"]");
	By btn_purchasing_price=By.xpath("//input[@id='admin_purchasingPrice']");
	By btn_transport_charges=By.xpath("//input[@id='admin_transportCharges']");
	By btn_unloading_charges=By.xpath("//input[@id='admin_unloadingCharges']");
	By btn_miscellenious_charges=By.xpath("//input[@id='admin_miscCharges']");
	By btn_paymetn_terms=By.xpath("//input[@id='admin_paymentTerm']");
	By btn_sales_credit=By.xpath("//input[@id='admin_salesCreditTerm']");
	By btn_quality_test=By.xpath("//input[@id='admin_qualityTesting']");
	By btn_quality_remark=By.xpath("//textarea[@id='admin_remark']");
	By btn_submit=By.xpath("//button[@type='submit' and contains(span, 'Create Purchase Order')]");
	By btn_confirmation=By.xpath("//div[@class=\"ant-modal-footer\"]//button[2]");
	
	
	
	
	public void click_purhase_order() throws InterruptedException  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement purchase_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Purchase_order));
	    purchase_click.click();
	    //Thread.sleep(10000);
	    
	}
	
	public void click_create() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement purchase_create = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create));
 	    purchase_create.click();
	
	}

	public void set_po_number(String po) throws InterruptedException {
		po_num=po;
		System.out.println("Setting PO Number: " +po_num);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement po_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_po_no));
 	    po_field.sendKeys(po);
		
	}
	
	public String get_po() {
		System.out.println("Getting PO Number from pur.order page :" + po_num);
		return po_num;
	}

	
	public void set_po_date() throws InterruptedException {
	//here below script capture the current date from the field
		driver.findElement(btn_po_date).click();
		Thread.sleep(5000);
		LocalDate currentDate = LocalDate.now();
		int currentDay = currentDate.getDayOfMonth();
		//System.out.println("The current date is :" + currentDate);
		WebElement currentDayElement = driver.findElement(By.xpath("//div[@class=\"ant-picker-body\"]//table//tbody//tr//td//div[text()='" + currentDay + "']"));
	    currentDayElement.click();
	    Thread.sleep(3000);
	}
	
	public void set_buyer(String buy) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement buyer_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_buyer));
		buyer_field.click();
		Thread.sleep(2000);
		buyer_field.sendKeys(buy);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement buyer_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(buyer_value));
        buyer_data.click();	
	}
	
	public void set_product() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement product_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_product));
 	    product_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement product_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(product_value));
        product_data.click();
		}
	
	public void set_unit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement unit_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_unit));
        unit_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement unit_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(unit_value));
        unit_data.click();
		} 
	
	
	public void set_source() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement source_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_sourcing_handler));
 	    source_field.click();
	    source_field.sendKeys("Vishnu_admin");
	    Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement source_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(source_value));
 	    source_data.click();
		}
	
	public void set_quantity(String qty) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement qty_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_quantity));
 	    qty_field.sendKeys(qty);
	    }
	
	public void set_trade_price(String tp) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement trade_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_trading_price));
        trade_field.sendKeys(tp);
	    }
	
	public void set_delivery_add() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement delivery_add_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_delivery_address));
        delivery_add_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement delivery_add_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(delivery_add_value));
        delivery_add_data.click();
		}
	
	public void set_purchase_price(String pp) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement purcahse_price_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_purchasing_price));
        purcahse_price_field.sendKeys(pp);
		
	    }
	
	public void set_transport_charges(String tc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement transport_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_transport_charges));
 	    transport_field.sendKeys(tc);
	    }
	
	public void set_unload_charges(String uc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement unload_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_unloading_charges));
 	    unload_field.sendKeys(uc);
	    }
	
	public void set_miscel_charges(String mc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement miscel_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_miscellenious_charges));
        miscel_field.sendKeys(mc);
	    }
	
	public void set_pay_term() throws InterruptedException {
		driver.findElement(btn_paymetn_terms).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"100% on delivery of the material.\"]")).click();
	    }
	
	public void set_sale_credit(String sc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement sales_credit_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_sales_credit));
        sales_credit_field.sendKeys(sc);
	    }
	
	public void click_quality() throws InterruptedException {
		driver.findElement(btn_quality_test).click();
		Thread.sleep(2000);
	    }
	
	public void set_quality_remark(String qr) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement qty_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_quality_remark));
        qty_field.sendKeys(qr);
	    }
	
	public void action() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll down
		Thread.sleep(3000);
	}
	
	public void click_submit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement submit_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit));
 	    submit_click.click();}
		
   public void click_confirm() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement confirm_click = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_confirmation));
        confirm_click.click();
        Thread.sleep(15000);
   }	
		
  }


class listpage extends Purchase_Order_page{

	public listpage(WebDriver driver) {
		super(driver);
	 }
	
	By btn_po_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_po_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"po_automation\"]");
	By btn_po_num_search_icon=By.xpath("(//div[@class=\"ant-table-filter-column\"]//span[@role=\"button\"])[1]");
	By btn_po_num_search=By.xpath("//input[@placeholder='Search by Purchase Order No']");
	By web_table_row_selection=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr");
	By web_table_firstrecord_access=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]");
	By web_tabs_name=By.xpath("//div[@class=\"table-radio-group\"]//div//label//span//input");
	By web_table_po_status=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[6]");
	
	
    public void click_po_saved_view(String saved) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement saved_view_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_po_saved_view));
		saved_view_click.click();
		saved_view_click.sendKeys(saved);
	
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement saved_view_select = wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_po_saved_value));
		saved_view_select.click();
		Thread.sleep(8000);
    	
    }
    
    public void select_po() throws InterruptedException {
    	WebElement po_search=driver.findElement(btn_po_num_search_icon);
    	po_search.click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement po_Field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_po_num_search));
 	    po_Field.click();
 	    po_Field.sendKeys("PON-QA-TEST-25/30",Keys.ENTER);
 	    Thread.sleep(5000);
    }
    
    public void click_po_search() throws InterruptedException {
    	WebElement po_search=driver.findElement(btn_po_num_search_icon);
    	po_search.click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement po_Field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_po_num_search));
 	    po_Field.click();
 	    String poNum=super.get_po();
 	    System.out.println("Retrieved PO Number: " + poNum);
 	    if (poNum != null && !poNum.isEmpty()) {
 		   po_Field.sendKeys(poNum,Keys.ENTER);
 		   Thread.sleep(5000);
        } else {
            throw new IllegalStateException("Purchase Order Number is null or empty!");
        }
 	    Thread.sleep(8000);
    }
    
    public void tab_switching() throws InterruptedException {
		//WebElement tab_list=driver.findElement(web_tab_elements);
		//int tab_size = tab_list.findElements(By.tagName("label")).size();
		//System.out.println("Total no.of tabs present in the leads menu :"+tab_size);
		
		/*WebElement tab_name=driver.findElement(web_tabs_name);
	    List<WebElement>radio=driver.findElements(By.xpath("//input[@type='radio']"));
	     for(WebElement e:radio) {
			@SuppressWarnings("deprecation")
			String value=e.getAttribute("value");
		    //System.out.println(value);
		   }*/
	    
	    WebElement status=driver.findElement(web_table_po_status);
	    String e4= status.getText();
	    System.out.println("Check the status txt for button click event. :"+e4);
	    
	    List<WebElement>lead_buttons= driver.findElements(By.xpath("//label[contains(@class,\"ant-radio-button-wrapper\")]"));
	    
	    for(WebElement button:lead_buttons) {
	    	String tab_label=button.getText().trim();
	    	if(tab_label.contains(e4)) {
	    		button.click();
	    	}
	    }Thread.sleep(7000);
	   
    }
} 

class create_order_po extends Purchase_Order_page{

	public create_order_po(WebDriver driver) {
		super(driver);
		
	}
	
	By web_table_row_po_selection=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr");
	By web_table_record_po_access=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]");
    By web_table_record_po_order_create=By.xpath("(//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[7]//div//div)[1]");
    By btn_seller=By.xpath("//input[@id='admin_seller']");
	By seller_value=By.xpath("//div[@class=\"rc-virtual-list\"]//div//div//div//div[@title=\"Buyo_Seller_Automation\"]");
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
	By btn_remark=By.xpath("//div[@class=\"ant-form-item-control-input-content\"]//textarea[@id=\"admin_remark\"]");
	By btn_add_order=By.xpath("//span[normalize-space()='Add Order']");
	By btn_confirm1=By.xpath("(//div[@class=\"ant-modal-footer\"]//button)[2]");

	
    public void click_order_create() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 	    WebElement order_click = wait.until(ExpectedConditions.visibilityOfElementLocated(web_table_record_po_order_create));
	    order_click.click();
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
	    Thread.sleep(3000);
	}
	
	public void set_order_quantity(String o_qty) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement qty_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_order_quantity));
 	    qty_field.sendKeys(o_qty);
 	  
	}
	
	public void set_pur_price(String pp) throws InterruptedException {
	  WebElement pur_price=driver.findElement(By.xpath("(//div[@class=\"ant-input-number\"]//input[@id=\"admin_purchasingPrice\"])[2]"));
	  pur_price.click();
	  pur_price.sendKeys(pp);
	  Thread.sleep(3000);
	}
	
	public void set_gst() throws InterruptedException {
		WebElement gst= driver.findElement(btn_gst);
		gst.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement gst_data= wait.until(ExpectedConditions.visibilityOfElementLocated(gst_value));
        gst_data.click();
        Thread.sleep(3000);
	}
	
	public void set_trasport() throws InterruptedException {
 	    WebElement transport_field=driver.findElement(btn_tranport);
	    transport_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement transport_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(transport_value));
        transport_data.click();
        Thread.sleep(3000);
		
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
		delivery_date_field.sendKeys("31/01/2025",Keys.ENTER);
		Thread.sleep(2000);
		 
     }
	
	public void set_pay_term() throws InterruptedException {
		driver.findElement(btn_payment_terms).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"100% on delivery of the material.\"]")).click();
		Thread.sleep(3000);
	}
	

	public void set_pur_credit_term(String pc) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement purchase_credit_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_purcahse_credit));
 	    purchase_credit_field.sendKeys(pc);
	
	}
	
	public void set_qty_remark(String qr) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement qty_field=wait.until(ExpectedConditions.visibilityOfElementLocated (btn_remark));
        qty_field.sendKeys(qr);
        Thread.sleep(3000);
	}
	
	public void click_add_order() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement click_add_order= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_add_order));
        click_add_order.click();
        Thread.sleep(5000);
		
	}
	
	public void confirm_order() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Confirm Order']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();Thread.sleep(10000);
		// The above mentioned condition is used only when you find any alert as "element not interactable."
	}
	
}
		

