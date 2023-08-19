package com.seleniumtesting.seleniumMavenProject;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCaseStatus {
	public static void changeStatus(String status,String filePathUrl,String label) {
		
		String TestLabel=label;
		
		 String filePath = filePathUrl;

		 try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheetAt(0); // Assuming you're working with the first sheet

	            // Loop through rows and find the row with the specified condition
	            for (Row row : sheet) {
	                Cell cell = row.getCell(1); // Assuming column 2 is the second column (0-based index)
	                if (cell != null && cell.getCellType() == CellType.STRING) {
	                    String cellValue = cell.getStringCellValue();
	                    if (TestLabel.equals(cellValue)) {
	                        int lastColIndex = 6 ; // Get the index of the last column
	                        Cell lastCell = row.createCell(lastColIndex); // Create a cell in the last column
	                        lastCell.setCellValue(status); // Set the value
	                        break; // Exit the loop after the first match
	                    }
	                }
	            }

	            try (FileOutputStream fos = new FileOutputStream(filePath)) {
	                workbook.write(fos);
	            }

	            System.out.println("Data updated in existing Excel file.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
