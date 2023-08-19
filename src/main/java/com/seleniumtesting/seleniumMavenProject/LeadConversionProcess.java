package com.seleniumtesting.seleniumMavenProject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.lang.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class LeadConversionProcess {
	
	protected static String testCaseId="1";
	protected static Boolean testStatus=false;

	public static Boolean leadCoversionProcessTest()  {
		int LoginPasswordRow=1;
		int LeadRecordRow=6;
		String TestLabel="Lead Conversion Process";
		String filePath = "C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\TestCases.xlsx";
		
		 LoginCredentials ls=new LoginCredentials(1); // --->(1) first row from excel sheet
		 System.out.println(ls.username());
		 System.out.println(ls.password());
		 
		 FakeLeadData ld=new FakeLeadData(18);         // --->()insert the number of row of lead data from excel sheet
		 String firstName=ld.firstName(),lastName=ld.lastName(),company=ld.company(),email=ld.email(),phone=ld.phone();	 
		 System.out.println(ld.firstName());
		 System.out.println(ld.lastName());
		 System.out.println(ld.company());
		 System.out.println(ld.email());
		 System.out.println(ld.phone());
		 
		//----------------------------------------------- code start for Automation testing -------------------------------------------------
		 
		 try {
			 System.setProperty( "webdriver.chrome.driver","C:\\Users\\shubham.navale\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 		//Create a map to store  preferences 
		 		Map<String, Object> prefs = new HashMap<String, Object>();
		 		prefs.put("profile.default_content_setting_values.notifications", 2);
		 		ChromeOptions options = new ChromeOptions();
		 		options.setExperimentalOption("prefs", prefs);
		 		WebDriver driver = new ChromeDriver(options);
		 		
		        driver.manage().window().maximize();
		        driver.manage().deleteAllCookies();
		        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        driver.get("https://login.salesforce.com/?locale=in");
		        driver.findElement(By.id("username")).sendKeys(ls.username());
		        driver.findElement(By.id("password")).sendKeys(ls.password());
		        driver.findElement(By.id("Login")).click();
		        Thread.sleep(2000);

		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[1]/button")).click();//--> Click on App Launcher

		        Thread.sleep(3000);

		        WebElement searchApp = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[1]/div[2]/one-app-launcher-menu/div/one-app-launcher-search-bar/lightning-input"));

		           searchApp.sendKeys("Sales");//--> Enter text in app search bar

		           searchApp.sendKeys(Keys.ARROW_DOWN);

		           searchApp.sendKeys(Keys.ARROW_DOWN);

		           searchApp.sendKeys(Keys.ARROW_DOWN);

		           searchApp.sendKeys(Keys.ENTER);//-->On Sales App
		          
		     
		        Thread.sleep(500);
		        WebElement button = driver.findElement(By.xpath("//span[text()='Leads']/parent::a[contains(@href,'lightning/o/Lead/home')]"));
		        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", button);     //--->  select Lead Tag in navigation bar
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a")).click();
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[1]/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]/button")).click(); //--> New Button
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[2]/lightning-input/div/div/input")).sendKeys(firstName);  //--> firstName
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[3]/lightning-input/div[1]/div/input")).sendKeys(company);  //--> lastName")).sendKeys("TestLeadLastName");  //--> lastName
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[4]/slot/records-record-layout-item[2]/div/span/slot/lightning-input/div/div/input")).sendKeys(email);  //--> Email
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[1]/slot/records-record-layout-item[2]/div/span/slot/lightning-input/div/div/input")).sendKeys(phone);  //--> Phone
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[3]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys(company);  //--> Company 
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button")).click();  //--> Record Save Button
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-lead_-record_-page1___-lead___-v-i-e-w/forcegenerated-flexipage_lead_record_page1_lead__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_lead___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/button")).click();  //--> Convert Dropdown Button
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-lead_-record_-page1___-lead___-v-i-e-w/forcegenerated-flexipage_lead_record_page1_lead__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_lead___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/div/div/slot/runtime_platform_actions-action-renderer[7]/runtime_platform_actions-executor-aura-legacy/slot/slot/runtime_platform_actions-ribbon-menu-item/a/span")).click();  //--> Convert option click        
		      
		        Thread.sleep(5000);
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/span/button")).click();  //--> Convert  Button on model popup
		        		
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div/div/div[2]/div[2]/a")).click();  //--> Click on Opportunity on model popup

		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-opportunity_-record_-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]/a")).click();  //--> Click on Detail Page
		    
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-opportunity_-record_-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/button")).click();  //--> Click On dropdownbox at most top right corner below the navigation bar
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-opportunity_-record_-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/div/div/slot/runtime_platform_actions-action-renderer[5]/runtime_platform_actions-executor-page-reference/slot/slot/runtime_platform_actions-ribbon-menu-item/a")).click();  //--> Click On edit Option
		        
		        WebElement pickListValue=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___012000000000000aaa___full___edit___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[5]/slot/records-record-layout-item[2]/div/span/slot/sfa-input-stage-name/records-record-picklist/records-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]/button/span"));  //--> Click on Stage Field
		        pickListValue.click();
		        new Actions(driver)   //--->  Action on Keyboard And type Value key for select Value Proposition
		        .sendKeys("Value")
		        .perform();
		        
		        new Actions(driver)   //---->   Action on Keyboard And Enter the Button
		        .sendKeys(Keys.ENTER)
		        .perform();
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button")).click();  //--> Click Save Button
		       //=====================================================================================================================// 
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-opportunity_-record_-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[2]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2/slot/flexipage-component2/slot/lst-related-list-container/div/div[1]/lst-related-list-single-container/laf-progressive-container/slot/lst-related-list-single-aura-wrapper/div/div/article/div[1]/header/div[2]/h2/a")).click();  //--> Click on Releted Product 
		        
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[4]/div/div/div[1]/div[1]/div[2]/ul/li[1]/a")).click();  //-->Add Product  Button
		      
		        
		        WebElement searchBoxProduct= driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/label/div/div[1]/div[1]/div/input"));
		        searchBoxProduct.sendKeys("GenWatt Diesel 1000");  //--> Click on Mark As Current Stage  Button
		        Thread.sleep(2000);
		        new Actions(driver)   //---->   Action on Keyboard And Enter the Button
		        .sendKeys("kW")
		        .perform();

		        Thread.sleep(1000);

		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/label/div/div[1]/div[1]/div/div/div[2]/ul/li[1]/a/div[2]/div[1]")).click();  //--> Click On Product checkbox
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[2]")).click();  //--> Click Next  Button
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[2]/span/span[2]/button")).click();  //--> Click Quantity  Button
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[2]/div/div/div[1]/div/div/div/input")).sendKeys("1");  //--> Set Quantity 1  in input box
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]")).click();  //--> Click on Save  Button
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[4]/div/div/div[1]/div[1]/div[1]/div/div/lst-breadcrumbs/nav/ol/li[2]/a")).click();  //--> Click on Oppertunity Name on top of the page  
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-opportunity_-record_-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/button")).click();  //--> Click On dropdownbox at most top right corner below the navigation bar
		        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-opportunity_-record_-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/div/div/slot/runtime_platform_actions-action-renderer[5]/runtime_platform_actions-executor-page-reference/slot/slot/runtime_platform_actions-ribbon-menu-item/a")).click();  //--> Click On edit Option
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___012000000000000aaa___full___edit___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[5]/slot/records-record-layout-item[2]/div/span/slot/sfa-input-stage-name/records-record-picklist/records-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]/button/span")).click();  //--> Click on Stage Field
		        new Actions(driver)   //--->  Action on Keyboard And type Value key for select Value Proposition
		        .sendKeys("Closed Won")
		        .perform();
		        
		        new Actions(driver)   //---->   Action on Keyboard And Enter the Button
		        .sendKeys(Keys.ENTER)
		        .perform();

		        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button")).click();  //--> Click Save Button
		        TestCaseStatus.changeStatus("Pass", filePath, TestLabel);
		        testStatus=true;
				driver.quit();
				 return testStatus;	 
		 }
		 catch(Exception ex) {
			 TestCaseStatus.changeStatus("Fail", filePath, TestLabel);
			 testStatus=false;
			 return testStatus;
		 }	
	} 
}
