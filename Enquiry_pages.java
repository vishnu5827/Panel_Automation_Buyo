package panel_script;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

 class Enquiry_pages {

	protected WebDriver driver;
	private static String buyer_value;
	public Enquiry_pages(WebDriver driver){
		this.driver=driver;
	}
	
	By btn_enquiry=By.xpath("//div[@class='top-nav-wrapper']//ul//li[5]");
	By btn_open_rfq=By.xpath("//div//div//ul[contains(@id,'Enquiries-popup')]//li[1]");
	By btn_create=By.xpath("//span[normalize-space()='Create Open RFQ']");
	By btn_buyer=By.xpath("(//input[@id='admin_buyer'])[1]");
	By buyer_value1=By.xpath("//div[@class=\"rc-virtual-list\"]//div//div//div//div[@title=\"Buyo_Buyer_Automation\"]");
	By btn_product=By.xpath("//input[@id='admin_product']");
	By prod_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title='UCO']");
	By btn_radio=By.xpath("//div[@class=\"ant-space-item\"]//label//span//input[@value=\"663e1090e95ace0d0ba71bad\"]");
	By btn_unit=By.xpath("//input[@id='admin_subUnit']");
	By unit_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"KG\"]");
	By btn_price=By.xpath("//input[@id='admin_price']");
	By btn_auto_price=By.xpath("//input[@value='true']");
	By btn_quantity_req=By.xpath("//input[@id='admin_fromQty']");
	By btn_delivery_freq=By.xpath("//input[@id='admin_frequency']");
	By frequency_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Daily\"]");
	By btn_delivery_add=By.xpath("//input[@id='admin_deliveryAddress']");
	By delivery_add_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@city=\"Chennai\"]//div//div//h5[text()=\"Buyo_Buyer_Automation\"]");
    By btn_delivery_by=By.xpath("//input[@id='admin_preferredDeliveryBy']");
	By btn_payment_term=By.xpath("//input[@id='admin_paymentTerms']");
	By pay_term_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"100% on delivery of the material.\"]");
	By btn_quality_test=By.xpath("//input[@id='admin_qualityTesting']");
	By btn_trail_quatity=By.xpath("//input[@id='admin_trialQuantity']");
	By btn_remark=By.xpath("//textarea[@id='admin_remark']");
	By btn_submit=By.xpath("//button[@type='submit']");
	By btn_confirm=By.xpath("(//div[@class=\"ant-modal-footer\"]//button)[2]");
	By table_view=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody");
	
	public void click_enquiry() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement enquiry_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_enquiry));
		enquiry_click.click();
	}
	
	public void click_rfq() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement rfq_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_open_rfq));
		rfq_click.click();
		
	}
	
	public void click_create() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement rfq_create = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create));
		rfq_create.click();
	
	}
	
	public void set_buyer(String buyer) throws InterruptedException {
		buyer_value=buyer;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement buyer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_buyer)); 
		buyer1.click();
		buyer1.sendKeys(buyer);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement buyer_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(buyer_value1));
		buyer_data.click();
	}
	
	public String get_buyer_name() {
		return buyer_value;
	}
	
	public void set_product() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement product_Value= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_product));
		product_Value.click();
		product_Value.sendKeys("uco");
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement prod_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(prod_value));
		prod_data.click();
	}
	
	public void set_unit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement ut = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_unit));
		ut.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement unit_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(unit_value));
		unit_data.click();
	}
	
	public void product_qty() throws InterruptedException {
 	    WebElement prod_qty= driver.findElement(btn_radio);
		prod_qty.click();
		Thread.sleep(2000);
		
	}
	
	public void set_price(String p) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement price= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_price));
	    price.sendKeys(p);
		
	}
	
	public void click_auto_price() throws InterruptedException {
 	    WebElement auto_price= driver.findElement(btn_auto_price);
		auto_price.click();
	    Thread.sleep(2000);
	}
	
	public void set_quantity_req(String qty) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement set_qty = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_quantity_req));
		set_qty.sendKeys(qty);
	}
	
	public void set_delivery_frq() throws InterruptedException {
 	    WebElement freq_field=driver.findElement(btn_delivery_freq);
		freq_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement freq_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(frequency_value));
		freq_data.click();
	}
	
	public void set_delivery_add() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement address_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_delivery_add));
		address_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement delivery_add_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(delivery_add_value));
		delivery_add_data.click();
	}
	
	public void set_delivery_by() throws InterruptedException {
		driver.findElement(btn_delivery_by).click();
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		int currentDay = currentDate.getDayOfMonth();
		System.out.println("The current date is :" + currentDate);
		WebElement currentDayElement = driver.findElement(By.xpath("//div[@class=\"ant-picker-body\"]//table//tbody//tr//td//div[text()='" + currentDay + "']"));
	    currentDayElement.click();
	    Thread.sleep(2000);
	}
	
	public void set_pay_term() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement pay_term_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_payment_term));
		pay_term_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement pay_term_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(pay_term_value));
		pay_term_data.click();
	}
	
	public void click_qty_test() throws InterruptedException {
 	    WebElement qty_field =driver.findElement(btn_quality_test);
		qty_field.click();
		Thread.sleep(2000);
	}
	
	public void click_trail() throws InterruptedException {
 	    WebElement trail_field =driver.findElement(btn_trail_quatity);
		trail_field.click();
		Thread.sleep(2000);
		
	}
	
	public void set_qty_remark(String qr) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement qty_remark= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_remark));
		qty_remark.sendKeys(qr);;
		
	}
	
	public void click_submit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement rfq_submit = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit));
		rfq_submit.click();
		Thread.sleep(3000);
	}
	
	public void confirm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement rfq_confirm= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_confirm));
		rfq_confirm.click();
		Thread.sleep(15000);
	}
}
 
 class rfq_list_page extends Enquiry_pages{

	public rfq_list_page(WebDriver driver) {
		super(driver);
		
	}
	
	By btn_rfq_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_rfq_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"rfq_automation\"]");
	By btn_buyer_filter_icon=By.xpath("(//div[@class=\"ant-table-filter-column\"])[3]//span[@role=\"button\"]");
	By btn_buyer_search_text=By.xpath("//div[@class=\"ant-select ant-select-multiple ant-select-show-search\"]//div//div//div");
	By btn_buyer_filter=By.xpath("(//div[@class=\"ant-space-item\"]//div//div//button[@type=\"button\"])[4]");
	By web_tabs_name=By.xpath("//div[@class=\"table-radio-group\"]//div//label//span//input");
	By web_table_lead_status=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[4]");
	
	
	 public void click_rfq_saved_view(String saved) throws InterruptedException {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 	    WebElement rfq_saved= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_rfq_saved_view));
	        rfq_saved.click();
			rfq_saved.sendKeys(saved);
			Thread.sleep(2000);   
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	 	    WebElement rfq_saved_value= wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_rfq_saved_value));
	 	    rfq_saved_value.click();
			
	    }
	 
	/* public void buyer_search() throws InterruptedException {
		 WebElement buyer_icon=driver.findElement(btn_buyer_filter_icon);
		 buyer_icon.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	    WebElement buyer_text_field = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_buyer_search_text));
	 	    buyer_text_field.click();
	 	    Thread.sleep(5000);
	 	    String buyer_value=super.get_buyer_name();
	 	   System.out.println("Retrieved PO Number: " +buyer_value);
	 	    if (buyer_value!= null && !buyer_value.isEmpty()) {
	 		   buyer_text_field.sendKeys(buyer_value);
	 		   Thread.sleep(10000);
	 		   driver.findElement(btn_buyer_filter).click();
	 		   Thread.sleep(8000);
	 		 }
      else {
         throw new IllegalStateException("Purchase Order Number is null or empty!");
     
 }
	 }*/
	 
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
		    
		    WebElement status=driver.findElement(web_table_lead_status);
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
	 
 }

class Open_listing extends Enquiry_pages
{

    private static String seller_value;
	public Open_listing(WebDriver driver) {
		super(driver);
		
	}

	By btn_enquiry=By.xpath("//div[@class='top-nav-wrapper']//ul//li[5]");
	By btn_open_listing=By.xpath("	");
	By btn_create_listing=By.xpath("//span[normalize-space()='Create Listing']");
	By btn_seller=By.xpath("//input[@id='admin_seller']");
	By btn_seller_value=By.xpath("//div[@class=\"rc-virtual-list\"]//div//div//div//div[@title=\"Buyo_Seller_Automation\"]");
	By btn_product=By.xpath("//input[@id='admin_product']");
	By prod_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title='UCO']");
	By btn_unit=By.xpath("//input[@id='admin_subUnit']");
	By unit_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"KG\"]");
	By btn_price=By.xpath("//input[@id='admin_price']");
	By btn_trade_price=By.xpath("//input[@id='admin_tradingPrice']");
	By btn_quantity=By.xpath("//input[@id='admin_quantity']");
	By btn_gst=By.xpath("//input[@id='admin_gst']");
	By gst_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"0% - GST Not Applied\"]");
	By btn_tranport=By.xpath("//input[@id='admin_transport']");
	By transport_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div//div[text()=\"Included\"]");
	By btn_delivery_freq=By.xpath("//input[@id='admin_frequency']");
	By delivery_freq_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Once\"]");
	By btn_pickup_add=By.xpath("//input[@id='admin_pickupAddress']");
	By pick_add_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@country=\"India\"]//div//div//h5[text()=\"Buyo_Seller_Automation\"]");
	By btn_delivery_by=By.xpath("//input[@id='admin_preferredDeliveryBy']");
	By btn_payment_term=By.xpath("//input[@id='admin_paymentTerms']");
	By pay_term_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"100% on delivery of the material.\"]");
	By btn_nego=By.xpath("//input[@id='admin_negotiable']");
	By btn_remark=By.xpath("//textarea[@id='admin_remark']");
	By btn_submit1=By.xpath("//button[@type='submit']");
	By btn_confirm1=By.xpath("(//div[@class=\"ant-modal-footer\"]//button)[2]");
	
	
	public void click_enquiry() throws InterruptedException {
		super.click_enquiry();
		Thread.sleep(3000);		
	}
	
	public void click_listing() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement listing_click= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_open_listing));
	    listing_click.click();	
	}
	
	public void click_create() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement listing_Create= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create_listing));
	    listing_Create.click();   
    }
	
	public void set_seller(String seller) throws InterruptedException {
		seller_value=seller;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement seller_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_seller));
		seller_field.click();
		Thread.sleep(2000);
	    seller_field.sendKeys(seller);
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement seller_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_seller_value));
		seller_data.click();
	}
	
	public String get_seller() {
		return seller_value;
	}
	
	public void set_product() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement prod_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_product));
		prod_field.click();
		Thread.sleep(2000);
		prod_field.sendKeys("uco");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement prod_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(prod_value));
		prod_data.click();
	}
	
	public void set_unit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement ut= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_unit));
	    ut.click();
	    Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement unit_data = wait1.until(ExpectedConditions.visibilityOfElementLocated(unit_value));
		unit_data.click();
    }
	
	public void set_pur_price(String pp) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement price= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_price));
		price.sendKeys(pp);
	
	}
	
	public void set_trade_price(String tp) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement trade_data= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_trade_price));
		trade_data.sendKeys(tp);
	}
	
	public void set_quantity(String qty) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement list_qty= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_quantity));
		list_qty.sendKeys(qty);
	}
	
	public void set_gst() throws InterruptedException {
		
 	    WebElement gst_field=driver.findElement(btn_gst);
		gst_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement gst_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(gst_value));
 	    gst_data.click();
	}
	
	public void set_trasport() throws InterruptedException {
	
 	    WebElement transport_field= driver.findElement(btn_tranport);
		transport_field.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement transport_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(transport_value));
		transport_data.click();
	}
	
	public void set_delivery_frq() throws InterruptedException {
		driver.findElement(btn_delivery_freq).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement freq_data= wait.until(ExpectedConditions.visibilityOfElementLocated(delivery_freq_value));
		freq_data.click();
	}
	
	public void set_pickup_add() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement delivery_add= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_pickup_add));
		delivery_add.click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement pick_add_data= wait1.until(ExpectedConditions.visibilityOfElementLocated(pick_add_value));
	    pick_add_data.click();
	}
	
	public void set_delivery_by() throws InterruptedException {
		driver.findElement(btn_delivery_by).click();
		Thread.sleep(4000);
		LocalDate currentDate = LocalDate.now();
		int currentDay = currentDate.getDayOfMonth();
		System.out.println("The current date is :" + currentDate);
		WebElement currentDayElement = driver.findElement(By.xpath("//div[@class=\"ant-picker-body\"]//table//tbody//tr//td//div[text()='" + currentDay + "']"));
	    currentDayElement.click();
	    Thread.sleep(5000);
	}
	
	public void action() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll down
		Thread.sleep(6000);
		}
	
	public void dummy_click() throws InterruptedException {
		 WebElement element = driver.findElement(By.id("admin_paymentTerm"));
         // Perform a click using Actions
	     Actions actions = new Actions(driver);
	     actions.moveToElement(element).click().perform();
	     Thread.sleep(4000);
	}
	
	public void set_pay_term() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    //WebElement pay_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_payment_term));
 	    //pay_field.click();
 	    //Thread.sleep(2000);
 	    driver.findElement(By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"100% on delivery of the material.\"]")).click();
	}
	
	public void click_negotialbe() throws InterruptedException {
		driver.findElement(btn_nego).click();;
		Thread.sleep(2000);
	}
	
	public void set_qty_remark(String qr) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement remark_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_remark));
		remark_field.sendKeys(qr);;
		
	}
	
	public void click_submit1() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement list_submit= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit1));
		list_submit.click();
		
	}
	
	public void confirm1() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 	    WebElement list_confirm= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_confirm1));
		list_confirm.click();
		Thread.sleep(10000);
	}
	
}

class listing_list_page extends Open_listing{

	public listing_list_page(WebDriver driver) {
		super(driver);
	}
	By btn_rfq_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_rfq_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"list_automation\"]");
	By web_tabs_name=By.xpath("//div[@class=\"table-radio-group\"]//div//label//span//input");
	By web_table_lead_status=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[4]");
	
	 public void click_listing_saved_view(String saved) throws InterruptedException {
	    	WebElement saved1= driver.findElement(btn_rfq_saved_view);
			saved1.click();
			saved1.sendKeys(saved);
			Thread.sleep(2000);
			driver.findElement(btn_rfq_saved_value).click();
			Thread.sleep(7000);
	 }
	 
	 
	 public void tab_switching() throws InterruptedException {
			//WebElement tab_list=driver.findElement(web_tab_elements);
			//int tab_size = tab_list.findElements(By.tagName("label")).size();
			//System.out.println("Total no.of tabs present in the leads menu :"+tab_size);
			
			WebElement tab_name2=driver.findElement(web_tabs_name);
		    List<WebElement>radio=driver.findElements(By.xpath("//input[@type='radio']"));
		     for(WebElement e:radio) {
				@SuppressWarnings("deprecation")
				String value1=e.getAttribute("value");
			    //System.out.println(value1);
			   }
		    
		    WebElement status=driver.findElement(web_table_lead_status);
		    String e4= status.getText();
		    System.out.println("Check the status txt for button click event. :"+e4);
		    
		    List<WebElement>lead_buttons= driver.findElements(By.xpath("//label[contains(@class,\"ant-radio-button-wrapper\")]"));
		    
		    for(WebElement button:lead_buttons) {
		    	String tab_label=button.getText().trim();
		    	if(tab_label.contains(e4)) {
		    		button.click();
		    	}
		    	//Thread.sleep(3000);
		    }
		}
	 
	 
	 
	 
	 
	 
	 
	 
}
