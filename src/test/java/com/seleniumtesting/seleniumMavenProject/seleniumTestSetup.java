package com.seleniumtesting.seleniumMavenProject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.gurock.testrail.APIException;
import com.qa.testrailmanager.TestRailManager;
import com.seleniumtesting.salesforcelogin.SalesforceLogin;

public class seleniumTestSetup {
    String filePath,TestLabel,testCaseId;
    int TestNo;
    seleniumTestSetup(){
        this.TestNo=0;
    }
    
    @BeforeMethod
    public void loginToTheSalesforce() throws InterruptedException{
        TestNo++;
        System.out.println("Test Number "+TestNo+" Started");
    }

    @AfterMethod
    public void logoutFromSalesforce(ITestResult result) throws MalformedURLException, IOException, APIException{

        if(result.getStatus() == ITestResult.SUCCESS){
            TestCaseStatus.changeStatus("Pass", filePath, TestLabel);
            TestRailManager.addResultsForTestCase(testCaseId, TestRailManager.TEST_CASE_PASS_STATUS, "");
        }
        else{
            TestCaseStatus.changeStatus("Fail", filePath, TestLabel);
            TestRailManager.addResultsForTestCase(testCaseId, TestRailManager.TEST_CASE_FAIL_STATUS, "");
        }
        
    }

}
