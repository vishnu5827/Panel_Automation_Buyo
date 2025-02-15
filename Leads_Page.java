package panel_script;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Leads_Page {

WebDriver driver; 
private static String lead_name;

	
	Leads_Page(WebDriver driver){
		this.driver= driver;
}
	By btn_lead=By.xpath("//div[@class='top-nav-wrapper']//ul//li[2]");
	By btn_create=By.xpath("//span[normalize-space()='Create Lead']");
	By btn_Lead_name=By.xpath("//input[@id='admin_name']");
	By btn_designation=By.xpath("//input[@id='admin_designation']");
	By btn_comapany=By.xpath("//input[@id='admin_companyName']");
	By btn_email=By.xpath("//input[@id='admin_emailAddress']");
	By btn_phone=By.xpath("//input[@id='admin_phoneNumber']");
	By btn_state=By.xpath("//input[@id='admin_state']");
	By btn_city=By.xpath("//input[@id='admin_city']");
	By btn_quantity=By.xpath("//input[@id='admin_quantity']");
	By btn_leads_type=By.xpath("//input[@id='admin_leadType']");
	By lead_type_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Buyer\"]");
	By btn_lead_source=By.xpath("//input[@id='admin_leadSource']");
	By btn_Person_handling=By.xpath("//input[@id='admin_handledBy']");
	By person_hand_value=By.xpath("//div[@class=\"rc-virtual-list\"]//div//div//div//div[@title=\"Vishnu_admin\"]//div");
	By btn_followup_handling=By.xpath("//input[@id='admin_followUpHandledBy']");
	By follow_hand_value=By.xpath("//div[@class=\"rc-virtual-list\"]//div//div//div//div[@title=\"M_Admin\"]//div");
	By btn_priority=By.xpath("//input[@id='admin_priority']");
	By priority_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"High\"]");
	By btn_submit=By.xpath("//button[@type='submit']//span[contains(text(),'Create Lead')]");
	
	
    public void click_lead_menu() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement lead_menu = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_lead));
	    lead_menu.click();
	    
    }
    
    public void click_create() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement lead_create = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_create));
        lead_create.click();
    }
    
    public void set_name(String name) throws InterruptedException {
    	lead_name=name;
    	System.out.println("Setting lead name: " +lead_name);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement lead_name= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Lead_name));
    	lead_name.sendKeys(name);
    	
    }
    
    public String get_lead_name() {
    	System.out.println("Getting lead name from lead list page :" + lead_name);
		return lead_name;
    	
    }
    public void set_designation(String designation) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement designation_text= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_designation));
        designation_text.sendKeys(designation);
    
    }

    public void set_company(String company) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement company_text = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_comapany));
    	company_text.sendKeys(company);
    	
    }

    public void set_email(String email) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement email_text= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_email));
        email_text.sendKeys(email);
    	
    }
    public void set_phone(String phone) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement phone_text= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_phone));
        phone_text.sendKeys(phone);
    	
    }
    public  void set_state() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement state_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_state));
     	Thread.sleep(2000);
    	state_field.sendKeys("Tamil nadu",Keys.ENTER);
    	
    }
    public void set_city () throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement city_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_city));
     	Thread.sleep(4000);
       city_field.sendKeys("coimbatore",Keys.ENTER);
        
    }
    
    public void set_quantity(String quantity) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement quantity_field= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_quantity));
        quantity_field.sendKeys(quantity);
    	
    }
    public void set_lead_type() throws InterruptedException {
    	WebElement lead1= driver.findElement(btn_leads_type);
    	lead1.click();
     	Thread.sleep(2000);
     	driver.findElement(lead_type_value).click();    	
    	
    }
    public void set_lead_source(String source) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement lead_source= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_lead_source));
        lead_source.sendKeys(source);
    	
    }
    public void set_person_handling() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement person_handle= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Person_handling));
    	person_handle.click();
    	person_handle.sendKeys("Vishnu_admin");
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement person_value= wait.until(ExpectedConditions.visibilityOfElementLocated(person_hand_value));
        person_value.click();
    	
    }	
    public void set_followup_handling() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement followup_handling= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_followup_handling));
        followup_handling.click();
    	followup_handling.sendKeys("m_admin");
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement follow_value= wait.until(ExpectedConditions.visibilityOfElementLocated(follow_hand_value));
    	follow_value.click();
    }
    public void set_priority() throws InterruptedException {
    	WebElement prior=driver.findElement(btn_priority);
    	prior.click();
        Thread.sleep(2000);
        driver.findElement(priority_value).click();
    
    	
    }   
    public void submit() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	WebElement submit= wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit));
        submit.click();   	
    }
}

class Lead_list_page extends Leads_Page{

	Lead_list_page(WebDriver driver) {
		super(driver);
	}
	
	By btn_saved_view=By.xpath("//div[@class=\"ant-row ant-row-space-between ant-row-center\"]//div[@class=\"ant-select-selector\"]//span//input[@type=\"search\"]");
	By btn_saved_value=By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]//div[@title=\"Lead_Automation\"]");
	By web_table_selection=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody");
	By web_table_row_selection=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr");
	By web_table_record_access=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]");
	By web_table_col_first=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[2]");
	By web_table_lead_status=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[6]");
	By web_table_lead_Added=By.xpath("//div[@class=\"ant-table-body\"]//table//tbody//tr[2]//td[7]");
	By web_tab_elements=By.xpath("//div[@class=\"table-radio-group\"]//div");
	By web_tabs_name=By.xpath("//div[@class=\"table-radio-group\"]//div//label//span//input");
	By name_search_icon=By.xpath("//table//thead//th[2]//div//span[@role=\"button\"]");
	By lead_name_input=By.xpath("//input[@placeholder='Search by Name']");
	
	
	public void click_saved_view(String save) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement saved_click = wait.until(ExpectedConditions.visibilityOfElementLocated(btn_saved_view));
		saved_click.click();
		saved_click.sendKeys(save);
		Thread.sleep(2000);
		driver.findElement(btn_saved_value).click();
		Thread.sleep(5000);
	}
	
	/*public void web_table_access() {
		WebElement table=driver.findElement(web_table_selection);
		List<WebElement> table_row=driver.findElements(web_table_row_selection);
		int size=table_row.size();
		size=size-1;
		System.out.println("The total count of lead in All-tab is : "+size);
	}*/
	
	/*public void record_fetching_data_accessing() throws InterruptedException {
        WebElement record_fetch=driver.findElement(web_table_record_access);
        WebElement lead_name=driver.findElement(web_table_col_first);
        WebElement added_by=driver.findElement(web_table_lead_Added);
        WebElement lead_status=driver.findElement(web_table_lead_status);
        System.out.println("Lead name : "+lead_name.getText()+ "\n" +"Lead Added By : "+added_by.getText() +"\n" +"Lead Status :"+lead_status.getText());
        Thread.sleep(5000);
    }*/
	
	public void name_search() throws InterruptedException {
		WebElement lead_search_icon=driver.findElement(name_search_icon);
		lead_search_icon.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement search_click = wait.until(ExpectedConditions.visibilityOfElementLocated(lead_name_input));
 	    search_click.click();
 	    String l_name=super.get_lead_name();
 	    System.out.println("Retrieved lead name: " +l_name);
 	    if (l_name != null && !l_name.isEmpty()) {
 		   search_click.sendKeys(l_name,Keys.ENTER);
 		   Thread.sleep(5000);
        } else {
            throw new IllegalStateException("Lead name is null or empty!");
        }
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
	    
	    WebElement status=driver.findElement(web_table_lead_status);
	    String e4= status.getText();
	    System.out.println("Check the status txt for button click event. :"+e4);
	    
	    List<WebElement>lead_buttons= driver.findElements(By.xpath("//label[contains(@class,\"ant-radio-button-wrapper\")]"));
	    
	    for(WebElement button:lead_buttons) {
	    	String tab_label=button.getText().trim();
	    	if(tab_label.contains(e4)) {
	    		button.click();
	    	}
	    
	    }
	}

}
	

