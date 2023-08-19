package com.seleniumtesting.seleniumMavenProject;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FakeLeadData {
	private static int leadDataNumber;
	FakeLeadData(int num){
		this.leadDataNumber=num;
	}
	
	private static String getCellValueAsString(Cell cell) {
	    if (cell == null) {
	        return "";
	    }
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            return String.valueOf(cell.getNumericCellValue());
	        default:
	            return "";
	    }
	}
	
	public static String firstName() {
		String firstName="";	
		 try {
	            FileInputStream file = new FileInputStream(new File("C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\LeadsTestData.xlsx"));
	            Workbook workbook = WorkbookFactory.create(file);
	            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
	            Row firstRow = sheet.getRow(leadDataNumber); // Get the first row
	            if (firstRow != null) {
	                Cell firstNameCell = firstRow.getCell(1); // Assuming username is in the second column (index 1)
	                if (firstNameCell != null  ) {
	                	firstName = firstNameCell.getStringCellValue();
	                 }
	            }
	            workbook.close();
	            file.close();
	     } catch (Exception e) {
	            e.printStackTrace();
	     }
		 return firstName;
	}
	public static String lastName() {
		String lastName="";
		try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\LeadsTestData.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
            Row firstRow = sheet.getRow(leadDataNumber); // Get the first row
            if (firstRow != null) {
                Cell lastNameCell = firstRow.getCell(2); // Assuming password is in the third column (index 2)
                if ( lastNameCell != null ) {
                	lastName = lastNameCell.getStringCellValue();
                }
            }
            workbook.close();
            file.close();
		} catch (Exception e) {
            e.printStackTrace();
		}
		return lastName;
	}
	public static String company() {
		String company="";
		try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\LeadsTestData.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
            Row firstRow = sheet.getRow(leadDataNumber); // Get the first row
            if (firstRow != null) {
                Cell companyCell = firstRow.getCell(3);
                if (companyCell != null ) {
                	company = companyCell.getStringCellValue();	
                }
            }
            workbook.close();
            file.close();
      } catch (Exception e) {
            e.printStackTrace();
      }
		return company;
	}
	public static String email() {
		String email="";
		try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\LeadsTestData.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
            Row firstRow = sheet.getRow(leadDataNumber); // Get the first row
            if (firstRow != null) { 
                Cell emailCell = firstRow.getCell(4); 
                if (emailCell != null) {
                	email = emailCell.getStringCellValue();	
                }
            }
            workbook.close();
            file.close();
		} catch (Exception e) {
            e.printStackTrace();
      	}
		return email;
	}
	public static String phone() {
		String phone="";
		try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\shubham.navale\\Desktop\\Salesforce_Automation_ExcelSheets\\LeadsTestData.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
            Row firstRow = sheet.getRow(leadDataNumber); // Get the first row
            if (firstRow != null) {
                Cell phoneCell = firstRow.getCell(5);
                if (phoneCell != null ) {
                	phone =  getCellValueAsString(phoneCell);
                }
            }
            workbook.close();
            file.close();
		} catch (Exception e) {
            e.printStackTrace();
		}
		return phone;
	}
}
