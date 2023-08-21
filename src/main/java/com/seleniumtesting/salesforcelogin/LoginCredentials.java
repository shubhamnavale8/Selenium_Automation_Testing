package com.seleniumtesting.salesforcelogin;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LoginCredentials {
	private static int loginNum;
	public LoginCredentials(int num){
		this.loginNum=num;
	}
	public static String username() {
		String username="",password="";		
		 try {
	            FileInputStream file = new FileInputStream(new File("C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\Login.xlsx"));
	            Workbook workbook = WorkbookFactory.create(file);
	            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
	            Row firstRow = sheet.getRow(loginNum); // Get the first row
	            if (firstRow != null) {
	                Cell usernameCell = firstRow.getCell(1); // Assuming username is in the second column (index 1)
	                Cell passwordCell = firstRow.getCell(2); // Assuming password is in the third column (index 2)
	                if (usernameCell != null && passwordCell != null) {
	                    username = usernameCell.getStringCellValue();
	                    password = passwordCell.getStringCellValue();
	                    //System.out.println("Username: " + username + ", Password: " + password);
	                }
	            }
	            workbook.close();
	            file.close();
	      } catch (Exception e) {
	            e.printStackTrace();
	      }
		 return username;
	}
	
	public static String password() {
		String username="",password="";		
		 try {
	            FileInputStream file = new FileInputStream(new File("C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\Login.xlsx"));
	            Workbook workbook = WorkbookFactory.create(file);
	            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
	            Row firstRow = sheet.getRow(loginNum); // Get the first row
	            if (firstRow != null) {
	                Cell usernameCell = firstRow.getCell(1); // Assuming username is in the second column (index 1)
	                Cell passwordCell = firstRow.getCell(2); // Assuming password is in the third column (index 2)
	                if (usernameCell != null && passwordCell != null) {
	                    username = usernameCell.getStringCellValue();
	                    password = passwordCell.getStringCellValue();
	                   // System.out.println("Username: " + username + ", Password: " + password);
	                }
	            }
	            workbook.close();
	            file.close();
	      } catch (Exception e) {
	            e.printStackTrace();
	      }
		 return password;
	}
}
