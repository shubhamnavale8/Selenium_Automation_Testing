package com.seleniumtesting.seleniumMavenProject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.lang.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class SalesforceTesting {
	protected static String testCaseId="1";
	protected static Boolean testStatus=false;
	
	public static Boolean recruitmentAppTest() {
		
		// TODO Auto-generated method stub
		String TestLabel="Recrutment app checking signup and loging functinality";
		String filePath = "C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\TestCases.xlsx";
		
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
	        appLuncher2.sendKeys("Recruitment");
	        
	        appLuncher2.sendKeys(Keys.ENTER);
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-lwc-field/div/flowruntime-radio-button-input-lwc/fieldset/div/span[1]/label/span[1]")).click();
	        
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button/button")).click();
	        
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("Tests123");
	        
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("Tests");
	        
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/lightning-input/div[1]/div/input")).sendKeys("test123@enzigma.com");
	        
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("Testpassword123");
	        
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("Testpassword123");
	        
	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/article/div/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[3]/flowruntime-record-field/div/flowruntime-record-field-impl/record_flexipage-record-field/div/span/slot/records-record-layout-base-input/lightning-input/div[1]/div/input")).sendKeys("testFirstName123");

	        
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
	        
//	        Thread.sleep(5);
//	        WebElement button = driver.findElement(By.xpath("//span[text()='Candidates']/parent::a[contains(@href,'lightning/o/Candidate__c/home')]"));
//	        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", button);
//	        
//	        
//	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div/div[1]/h1/span[2]")).click();
//	        
//	        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/ul/li[2]")).click();
//	        
//	        //driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/thead/tr/th[8]/div/a/span[2]")).click();
//	        WebElement searchBox= driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[2]/div[2]/force-list-view-manager-search-bar/div/lightning-input/div/div/input"));
//	        searchBox.sendKeys("TestsTests");
//	     
//	        searchBox.sendKeys(Keys.ENTER);
//	        ///html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/thead/tr/th[8]/div/a/span[2]
//	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")).click();
//	        
//	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___flexipage__default_rec_-l___-candidate__c___-v-i-e-w/forcegenerated-flexipage_default_rec_l_candidate__c__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_candidate__c___012000000000000aaa___full___view___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[4]/slot/records-record-layout-item[2]/div/div/div[2]/button")).click();
//	        WebElement lastNameInputBox= driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___flexipage__default_rec_-l___-candidate__c___-v-i-e-w/forcegenerated-flexipage_default_rec_l_candidate__c__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_candidate__c___012000000000000aaa___full___view___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[4]/slot/records-record-layout-item[2]/div/span/slot/records-record-layout-base-input/lightning-input/div/div/input"));
//	        lastNameInputBox.sendKeys("lastNameTest");
//	       
//	        //driver.findElement(By.name("Phone__c")).sendKeys("7972122788");
//	        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___flexipage__default_rec_-l___-candidate__c___-v-i-e-w/forcegenerated-flexipage_default_rec_l_candidate__c__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[2]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button")).click();
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
