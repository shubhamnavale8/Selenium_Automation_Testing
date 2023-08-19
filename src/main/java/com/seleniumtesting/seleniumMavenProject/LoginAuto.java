package com.seleniumtesting.seleniumMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.gurock.testrail.APIException;
import com.qa.testrailmanager.TestRailManager;

import java.lang.*;
import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class LoginAuto {
	
	protected static String testCaseId="1";
	protected static Boolean testStatus=false;
	
	
	public static Boolean salesforceLoginTest() {
		// TODO Auto-generated method stub
		 LoginCredentials ls=new LoginCredentials(1); // --->(1) first row from excel sheet
		 System.out.println(ls.username());
		 System.out.println(ls.password());
		 
		 
		 String TestLabel="Login with Salesforce";
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
		           testStatus=true;
		           
			 TestCaseStatus.changeStatus("Pass", filePath, TestLabel);
			 testStatus=true;
			 driver.quit();
			 return testStatus;
		 }
		 catch(Exception ex) {
			 testStatus=false;
			 TestCaseStatus.changeStatus("Fail", filePath, TestLabel);
			 
			 return testStatus;
		 }
		 
		 
		
	}
	
	

}
