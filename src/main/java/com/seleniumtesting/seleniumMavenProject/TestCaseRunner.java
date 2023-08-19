package com.seleniumtesting.seleniumMavenProject;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gurock.testrail.APIException;
import com.qa.testrailmanager.TestRailManager;

public class TestCaseRunner {

	public static void main(String[] args) throws MalformedURLException, IOException, APIException {
		String testCaseId ;Boolean testStatus;
		testCaseId="1";
		testStatus=LeadConversionProcess.leadCoversionProcessTest();
		addResultsToTestRail(testStatus,testCaseId);
		testCaseId="2";
		testStatus=LoginAuto.salesforceLoginTest();
		addResultsToTestRail(testStatus,testCaseId);
		testCaseId="3";
		testStatus= SalesforceTesting.recruitmentAppTest();
		addResultsToTestRail(testStatus,testCaseId);
	}
	public static void addResultsToTestRail(Boolean testStatus,String testCaseId) throws MalformedURLException, IOException, APIException {	
		if(testStatus) {
			System.out.println(testCaseId+" --> This Test Case is Pass");
			TestRailManager.addResultsForTestCase(testCaseId, TestRailManager.TEST_CASE_PASS_STATUS, "");
		}
		else{
			System.out.println(testCaseId+" --> This Test Case is Fail");
			TestRailManager.addResultsForTestCase(testCaseId, TestRailManager.TEST_CASE_FAIL_STATUS, "");
		}
		
	}

}
