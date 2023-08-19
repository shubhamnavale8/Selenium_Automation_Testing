package com.seleniumtesting.seleniumMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AccountSobject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
        driver.findElement(By.id("username"));
        WebElement username=driver.findElement(By.id("username"));
        driver.findElement(By.id("password"));
        WebElement password=driver.findElement(By.id("password"));
        username.sendKeys("shubham@enzigma.in");
        password.sendKeys("Salesforce@8308775266");
        driver.findElement(By.id("Login")).click();
        WebElement appLuncher=driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[2]/div/div/ul[2]/li[3]/a"));
        appLuncher.click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/header/div[2]/span/div[2]/ul/li[6]/div/div/div[1]/div/div/a/div/lightning-icon/span/lightning-primitive-icon")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[1]/button")).click();
        WebElement appLuncher2=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/div[1]/div[2]/one-app-launcher-menu/div/one-app-launcher-search-bar/lightning-input/div/div/input"));
        appLuncher2.sendKeys("Sales Console");
        appLuncher2.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div[3]/div/button/lightning-primitive-icon")).click();
        
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div[3]/div/section/div/div/ul/li[3]/div/a/span[2]/span")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li/div/div/div/div/a")).click();

        
        driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[1]/a")).click();
         
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("New Account");

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[1]/div/div/section/div/div[2]/div/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button")).click();
        
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-account_-record_-page1___-account___-v-i-e-w/forcegenerated-flexipage_account_record_page1_account__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]/a")).click();
       // driver.switchTo().newWindow(WindowType.TAB);
        WebElement strvalue = driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-account_-record_-page1___-account___-v-i-e-w/forcegenerated-flexipage_account_record_page1_account__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_account___012000000000000aaa___full___view___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/div/div[2]/span/slot[1]/lightning-formatted-text"));
        String expected = "New Account";
        String actual = strvalue.getText();
        System.out.println(actual);
        if(expected.equals(actual)) {
        	System.out.println("actual="+actual+"  expected="+expected+" --> Pass");
        }
        else {
        	System.out.println("actual="+actual+"  expected="+expected+" --> fail");
        }
        
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div[3]/div/button/lightning-primitive-icon")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div[3]/div/section/div/div/ul/li[4]/div/a/span[2]/span")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li/div/div/div/div/a")).click();
        driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[1]/a")).click();

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[2]/div/div/section/div/div[2]/div/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_contact___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[2]/lightning-input/div/div/input")).sendKeys("SeleniumContactFirstName");
        
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[2]/div/div/section/div/div[2]/div/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_contact___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[3]/lightning-input/div[1]/div/input")).sendKeys("SeleniumContactLastName");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[2]/div/div/section/div/div[2]/div/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_contact___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[2]/lightning-input/div/div/input")).sendKeys("New Account");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[2]/div/div/section/div/div[2]/div/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_contact___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[3]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div/div/lightning-base-combobox/div/div[2]/ul/li[2]")).click();
	}

}
