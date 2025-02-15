	package panel_script;
	
	import java.awt.AWTException;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class Base_BuyoTest {
	
		private static final String enabled = null;
		private static final String priority = null;
		WebDriver driver; 
		
		 
	  @BeforeClass
	  void setup() throws InterruptedException {
		 //System.setProperty("Webdriver.chromedriver","T:\\Vg_Selenium\\Driver\\chromerdriver.exe");
		 WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 driver.get("https://panel.buyofuel.dev/auth/login");
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
	  }
	
	  @Test(priority = 1)
	  void test_login() throws InterruptedException {
		 Login_Page lp =new Login_Page(driver);
		 Thread.sleep(2000);
		 lp.set_username("vishnugeethan@buyofuel.com");
		 lp.set_password("demo123#");
		 lp.click_signup();
		 Thread.sleep(5000);
	  }
	  
	 @Test(priority=2,enabled=true)
	  void test_lead() throws InterruptedException{
		 Leads_Page ld=new Leads_Page(driver);
		 Lead_list_page llp=new Lead_list_page(driver);
		 ld.click_lead_menu();
		 ld.click_create();
		 ld.set_name("Buyo Automation 17");
		 // while running entire test update new lead name.
		 ld.get_lead_name();
		 ld.set_designation("Auto_buyo engineer");
		 ld.set_company("veegee buyo");
		 ld.set_email("vishnugeethan261997@gmail.com");
		 ld.set_phone("9688687009");
		 ld.set_state();
		 ld.set_city();
		 ld.set_quantity("125");
		 ld.set_lead_type();
		 ld.set_lead_source("Walk-in from campaign");
		 ld.set_person_handling();
		 ld.set_followup_handling();
		 ld.set_priority();
		 ld.submit();
		 Thread.sleep(5000);
		 //Here list page access object-call is processed.
		 llp.click_saved_view("Lead_Automation");
		 //llp.web_table_access();
		 //llp.record_fetching_data_accessing();
		 llp.name_search();
		 llp.tab_switching();
		}
	 
	 @Test(priority=3,enabled=true)
	 void test_business_page() throws InterruptedException {
		 Business_page bp=new Business_page(driver);
		 bp.click_business();
		 Thread.sleep(4000);
		 bp.create_business();
		 bp.set_business_name("Auto_Test_business 2");
		 bp.set_business_gst("09AAACH7409R1ZZ");
		 bp.set_business_type();
		 bp.set_business_mail("auto@gmail.com");
		 bp.set_business_phone("9633224400");
		 //bp.click_same_check_box();
		 bp.set_business_add1("Gandhi nagar , 2nd cross");
		 bp.set_business_add2("ganapathy");
		 bp.set_country();
		 bp.set_state();
		 bp.set_city();
		 bp.set_pincode("641106");
		 bp.set_zone();
		 bp.set_cust_name("veegee");
		 bp.set_cust_mail("veegee@gmail.com");
		 bp.set_cust_phone("8877445522");
		 bp.set_cust_designation("Regional Manager");
		 driver.navigate().refresh();
		 Thread.sleep(5000);
		 // disabling the check box for address same fields.
	 }

	 
	 @Test(priority=4,enabled=true)
		 void test_enquiry_pages() throws InterruptedException {
		 Enquiry_pages ep=new Enquiry_pages(driver);
		 rfq_list_page rlp=new rfq_list_page(driver);
		 Open_listing ep1=new Open_listing(driver);
		 listing_list_page llp=new listing_list_page(driver);
		 ep.click_enquiry();
		 ep.click_rfq();
		 ep.click_create();
		 ep.set_buyer("Buyo_Buyer_Automation");
		 ep.get_buyer_name();
		 ep.set_product();
		 ep.set_unit();
		 ep.product_qty();
		 ep.set_price("8500");
		 ep.click_auto_price();
		 ep.set_quantity_req("125");
		 ep.set_delivery_frq();
		 ep.set_delivery_add();
		 ep.set_delivery_by();
		 ep.set_pay_term();
		 ep.click_qty_test();
		 ep.click_trail();
		 ep.set_qty_remark("Rfq added by automation");
		 ep.click_submit();
		 ep.confirm();

		 //Here handling list page from rfq-menu.
		 rlp.click_rfq_saved_view("rfq_automation");
		 //rlp.buyer_search();
		 rlp.tab_switching();
		 
		 //here listing page automation
		 ep1.click_enquiry();
		 ep1.click_listing();
		 ep1.click_create();
		 ep1.set_seller("Buyo_Seller_Automation");
		 ep1.set_product();
		 ep1.set_unit();
		 ep1.set_pur_price("8.1");
		 ep1.set_trade_price("9.1");
		 ep1.set_quantity("95");
		 ep1.set_gst();
		 ep1.set_trasport();
		 ep1.set_delivery_frq();
		 ep1.set_pickup_add();
		 ep1.set_delivery_by();
		 ep1.action();
		 ep1.dummy_click();
		 ep1.set_pay_term();
		 ep1.click_negotialbe();
		 ep1.set_qty_remark("Listing added by automation");
		 ep1.click_submit1();
		 ep1.confirm1();
		 //here listing list page accessing
		 llp.click_listing_saved_view("list_automation");
		 llp.tab_switching();
		 
			 }
	
	 @Test(priority=5,enabled=true)
	 
	 void test_purchase_order() throws InterruptedException {
		 Purchase_Order_page po= new Purchase_Order_page(driver);
		 listpage pol=new listpage(driver);
		 create_order_po cop=new create_order_po(driver);
		 po.click_purhase_order();
		 Thread.sleep(5000);
		 po.click_create();
		 Thread.sleep(2000);
		 po.set_po_number("PON-QA-TEST-04/25");
		 System.out.println("Getting PO from Purchase_Order_page before get: " + po.get_po());
		 po.get_po();
		 po.set_po_date();
		 po.set_buyer("Buyo_Buyer_Automation");
		 po.set_product();
		 po.set_unit();
		 po.set_source();
		 po.set_quantity("85");
		 po.set_trade_price("9900");
		 po.set_delivery_add();
		 po.set_purchase_price("8200");
		 po.set_transport_charges("75");	
		 po.set_unload_charges("25");
		 po.set_miscel_charges("14");
		 po.set_pay_term();
		 po.set_sale_credit("2");
		 po.click_quality();
		 po.set_quality_remark("PO detail are entered through automation");
		 po.action();
		 po.click_submit();
		 po.click_confirm();
		 
		 //here access the list page or PO.
		 pol.click_po_saved_view("po_automation");
		 //pol.select_po();
		 pol.click_po_search();
		 pol.tab_switching();
		 
		//Here will be creating order in PO page.
        cop.click_order_create();
        cop.set_seller("Buyo_Seller_Automation");
		cop.set_order_delivery_by_date();
		cop.set_order_quantity("105");
		cop.set_pur_price("8100");
		cop.set_gst();
		cop.set_trasport();
		cop.action();
		cop.set_pickup_add(); 
		cop.set_delivery_by();
		cop.set_pay_term();
		cop.set_pur_credit_term("2");
		//cop.set_qty_remark("Create Order in PO added by automation");
		cop.click_add_order();
		cop.confirm_order();
	}
	 
	 @Test(priority=6,enabled=true)
	 
	 void test_order_page() throws InterruptedException {
		 Order_page op=new Order_page(driver);
		 order_list_page olp=new order_list_page(driver);
		 op.click_order();
		 op.create_order();
		 op.set_buyer("Buyo_Buyer_Automation");
		 //op.po_num();
		 op.set_po_number_order_page();
		 op.set_seller("Buyo_Seller_Automation");
		 op.click_skip_create();
		 op.set_order_delivery_by_date();
		 op.set_order_quantity("125");
		 op.set_order_pur_price("8000");
		 op.set_gst();
		 op.set_trasport();
		 op.action();
		 op.set_pickup_add(); 
		 op.set_delivery_by();
		 op.set_pay_term();
		 op.set_pur_credit_term("2");
		 op.set_qty_remark("Create Order against PO added by automation");
		 op.click_add_order();
		 op.confirm_order();
		 
		 //here access the list page of order
		 olp.click_order_saved_view("order_automation");
		 olp.click_po_filter();
		 olp.capture_order_no();
		 olp.get_order_no();
		 olp.tab_switching();
		 olp.order_accept();
		 
		 		 
		 
	 }
	
	 @Test(priority=7,enabled=true)
	 
	 void test_dispatch_pages() throws InterruptedException, AWTException   {
		 Dispatch_pages dp=new Dispatch_pages(driver);
		 transit_list_page tlp=new transit_list_page(driver);
		 Supplier_payment sp=new Supplier_payment(driver);
		 supplier_list_page slp=new supplier_list_page(driver);
		 Schedule sh=new Schedule(driver);
		 schedule_list_page slp1=new schedule_list_page(driver);
		 
		 dp.click_dispatch();
		 dp.click_intransit();
		 dp.create_dispatch();
		 dp.set_buyer("Buyo_Buyer_Automation");
		 dp.set_order_no();
		 dp.set_purchase_bill("AUT0/12/24");
		 dp.set_dispatch_qty("45");
		 dp.set_dispatch_date();
		 dp.set_transit_status();
		 dp.set_vehicle_number("TN 66 AQ 5202");
		 dp.set_dispatch_from("641006");
		 dp.set_additional_info("Dispatch added by automation");
		 dp.click_submit();
		 dp.click_confirm();
		 
		 //Handling list page of transit dispatch
		 tlp.click_transit_saved_view("transit_automation");
		 tlp.click_order_filter();
		
		 //Handling Supplier payment
		 sp.click_dispatch();
		 sp.click_supplier_pay();
		 /*sp.create_dispatch();
		 sp.set_buyer("Buyo_Buyer_Automation");
		 sp.set_order_no();
		 sp.set_purchase_bill("AUTO/2/1124");
		 sp.set_dispatch_qty("35");
		 sp.set_dispatch_date();
		 sp.set_transit_status();
		 sp.set_vehicle_number("TN 38 CH 5827");
		 sp.set_dispatch_from("641005");
		 sp.set_additonal_info("Supplier payment added by automation");
		 sp.click_submit2();
		 sp.click_confirm2();*/
		 
		 //handling payable list page
		 //slp.click_dispatch();
		// slp.click_supplier_pay();
		 slp.click_payable_saved_view("payable_automation");
		 //slp.search_order_no();
		 slp.click_order_filter();
		 slp.capture_dispatch_no();
		 slp.get_dispatch_no();
		 slp.click_clear_for_payment();
		 slp.received_qty("15");
		 slp.click_submit5();
		 
		 //handling dispatch schedule 
		 sh.click_dispatch();
		 sh.click_schedule();
		 sh.create_schedule();
		 sh.set_buyer("Buyo_Buyer_Automation");
		 sh.set_purchase_order_num();
		 //sh.schedule_mode();
		 sh.set_schedule_date();
		 sh.set_sch_commitment("125");
		 sh.click_submit3();
		 sh.click_confirm3();
		 
		 //here we handle list page of schedule
		slp1.click_schedule_saved_view("schedule_automation");
		slp1.click_po_search3();
		//slp1.tab_switching();
		
		
	 }
	 
	 @Test(priority=8,enabled=true)
	 
	 void test_payment_pages() throws InterruptedException{
		 Payment_pages pp=new Payment_pages(driver);
		 payment_list_page plp=new payment_list_page(driver);
		 Affiliate ap=new Affiliate(driver);
		 affiliate_list_page alp=new affiliate_list_page(driver);
		 
		 pp.click_payment();
		 pp.click_payment1();
		 pp.create_payment();
		 pp.set_dispatch_no();
		 pp.set_pay_type();
		 pp.set_amount("20000");
		 pp.set_pay_mode();
		 pp.set_txn_ref("AUTO/111224");
		 pp.set_pay_date();
		 pp.click_submit4();
		 pp.click_confirm4();
		 
		 //here we access list page of payment page.
		 plp.click_payment_saved_view("payment_automation");
		 plp.click_dispatch_no_filter();
		 
		 //Here handling affliate payment page
		
		ap.click_payment();
		ap.click_affiliate();
		ap.create_affiliate();
		ap.set_affiliate();
		ap.set_amount("35000");
		ap.set_pay_mode();
		ap.set_txn_ref("AUTO/AFF/111224");
		ap.set_pay_date();
		ap.click_submit5();
		
		// here we will be handling the list page of affliate
		
		alp.click_affiliate_saved_view("aff_automation");
		
	 }
	 
	/*@Test(enabled=false)
	void demo_test() throws InterruptedException, AWTException {
		dummy_test_class dc=new dummy_test_class(driver);
		dc.click_dispatch();
		dc.click_supplier_pay();
		dc.click_payable_saved_view3("payable_automation");
		dc.search_order_no();
		dc.click_clear_for_payment();
		dc.received_qty("15");
	}*/
	
	// i have disabled the demo_test method as well. to check git diff command.
		
		
	 
	 
	  @AfterClass
	  void close () {
		  driver.quit();
	  }
	}
