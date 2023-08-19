package com.seleniumtesting.salesforcelogin;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SalesforceLogin {
     public static WebDriver selesforceLoginWebDriver(int index) throws InterruptedException{
        String filePath,TestLabel,testCaseId;
        WebDriver driver;
        LoginCredentials ls=new LoginCredentials(index); // --->(1) first row from excel sheet
		System.out.println(ls.username());
		System.out.println(ls.password());
        System.setProperty( "webdriver.chrome.driver","C:\\Users\\shubham.navale\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);

        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.id("username")).sendKeys(ls.username());
		driver.findElement(By.id("password")).sendKeys(ls.password());
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
        return driver;
    }
}
