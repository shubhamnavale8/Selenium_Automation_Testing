package com.seleniumtesting.seleniumMavenProject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.gurock.testrail.APIException;
import com.qa.testrailmanager.TestRailManager;
import com.seleniumtesting.salesforcelogin.SalesforceLogin;

import dev.failsafe.internal.util.Assert;

public class seleniumTestDemo extends seleniumTestSetup{
   

    @Test
    public void leadConversionProcess() throws InterruptedException{
        WebDriver driver=SalesforceLogin.selesforceLoginWebDriver(1);
        testCaseId="1";
        TestLabel="Lead Conversion Process";
		filePath = "C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\TestCases.xlsx";
        FakeLeadData ld=new FakeLeadData(30);
        String firstName=ld.firstName(),lastName=ld.lastName(),company=ld.company(),email=ld.email(),phone=ld.phone();	 
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
		Thread.sleep(5000);
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
		driver.quit();
    }


    @Test
    public void openSalesApp()throws InterruptedException{
        WebDriver driver=SalesforceLogin.selesforceLoginWebDriver(1);
        testCaseId="2";
        TestLabel="Login with Salesforce";
		filePath = "C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\TestCases.xlsx";
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[1]/button")).click();//--> Click on App Launcher
		Thread.sleep(3000);

		WebElement searchApp = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[1]/div[2]/one-app-launcher-menu/div/one-app-launcher-search-bar/lightning-input"));
		
		searchApp.sendKeys("Sales");//--> Enter text in app search bar
		searchApp.sendKeys(Keys.ARROW_DOWN);
		searchApp.sendKeys(Keys.ARROW_DOWN);
		searchApp.sendKeys(Keys.ARROW_DOWN);
		searchApp.sendKeys(Keys.ENTER);//-->On Sales App
        driver.quit();

    }


    @Test
    public void recruitmentSignupLoginProcess() throws InterruptedException{
        WebDriver driver=SalesforceLogin.selesforceLoginWebDriver(1);
        testCaseId="3";
        WebElement appLuncher=driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[2]/div/div/ul[2]/li[3]/a"));
	    appLuncher.click();
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/header/div[2]/span/div[2]/ul/li[6]/div/div/div[1]/div/div/a/div/lightning-icon/span/lightning-primitive-icon")).click();
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[1]/button")).click();
	    WebElement appLuncher2=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/div[1]/div[2]/one-app-launcher-menu/div/one-app-launcher-search-bar/lightning-input/div/div/input"));
	    appLuncher2.sendKeys("Recruitment");	        
	    appLuncher2.sendKeys(Keys.ENTER);
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-lwc-field/div/flowruntime-radio-button-input-lwc/fieldset/div/span[1]/label/span[1]")).click();	        
                                                    
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button/button")).click();	        
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("asdfgh1");	        
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("hjkl");	        
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/lightning-input/div[1]/div/input")).sendKeys("asdfghj1@enzigma.com");	        
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("asdfghhj109123");	        
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("asdfghhj109123");	        
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[3]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("jhhgfds1a");
	        
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button[2]/button")).click();
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button[2]/button")).click();
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-lwc-field/div/flowruntime-radio-button-input-lwc/fieldset/div/span[2]/label/span[1]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button/button")).click();
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[3]/flowruntime-lwc-field/div/flowruntime-flow-screen-input/flowruntime-input-wrapper2/div/lightning-input/div[1]/div/input")).sendKeys("TestsTests");
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[4]/flowruntime-lwc-field/div/flowruntime-flow-screen-input/flowruntime-input-wrapper2/div/lightning-input/div[1]/div/input")).sendKeys("Testpassword");	 
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button[2]/button")).click();	        
	        
	    WebElement strvalue = driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-lwc-field/div/flowruntime-display-text-lwc/lightning-formatted-rich-text/span/p"));
	    String expected = "Username: TestsTests";
	    String actual = strvalue.getText();
	    System.out.println(actual);
        
	    if(expected.equals(actual)) {
	    	System.out.println("actual="+actual+"  expected="+expected+" --> Pass");
	    }
	    else {
	    	System.out.println("actual="+actual+"  expected="+expected+" --> fail");
	    }
        driver.quit();
    }
  
}
