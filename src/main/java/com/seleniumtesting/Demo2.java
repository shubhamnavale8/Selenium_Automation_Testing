package com.seleniumtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumtesting.seleniumMavenProject.Demo1;

public class Demo2 {
    
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver=Demo1.selesforceLoginWebDriver(1);

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[1]/button")).click();//--> Click on App Launcher
		Thread.sleep(3000);

        WebElement searchApp = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[1]/div[2]/one-app-launcher-menu/div/one-app-launcher-search-bar/lightning-input"));
		
		searchApp.sendKeys("Sales");//--> Enter text in app search bar
		searchApp.sendKeys(Keys.ARROW_DOWN);
		searchApp.sendKeys(Keys.ARROW_DOWN);
		searchApp.sendKeys(Keys.ARROW_DOWN);
		searchApp.sendKeys(Keys.ENTER);//-->On Sales App
    }
}
