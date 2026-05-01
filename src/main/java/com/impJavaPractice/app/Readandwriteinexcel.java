package com.impJavaPractice.app;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

class Read {

	public static void main(String[] args) throws IOException {

		// Path of Excel file
		String excelPath = System.getProperty("user.dir") + "\\src\\resource\\java\\DetailsStudent.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);

		// Create Workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Get first sheet
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate rows
		for (Row row : sheet) {

			// Iterate cells
			for (Cell cell : row) {

				// Print cell value
				System.out.print(cell.toString() + "   ");

			}
			System.out.println();
		}

		workbook.close();
		fis.close();
	}
}

class WriteExcel {
	
	void write() throws IOException {
		// Create workbook
				XSSFWorkbook workbook = new XSSFWorkbook();

				// Create sheet
				XSSFSheet sheet = workbook.createSheet("EmployeeData");

				// Create header row
				XSSFRow headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("Name");
				headerRow.createCell(1).setCellValue("Age");
				headerRow.createCell(2).setCellValue("City");

				// Create data row 1
				XSSFRow row1 = sheet.createRow(1);
				row1.createCell(0).setCellValue("Anil");
				row1.createCell(1).setCellValue(28);
				row1.createCell(2).setCellValue("Hyderabad");

				// Create data row 2
				XSSFRow row2 = sheet.createRow(2);
				row2.createCell(0).setCellValue("Ravi");
				row2.createCell(1).setCellValue(30);
				row2.createCell(2).setCellValue("Bangalore");

				// Write to Excel file
				FileOutputStream fos = new FileOutputStream("output.xlsx");
				workbook.write(fos);

				// Close resources
				fos.close();
				workbook.close();

				System.out.println("Excel file written successfully!");
			}
	

		
}

public class Readandwriteinexcel {

	public static void main(String[] args) throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\resource\\java\\DetailsStudent.xlsx";
		FileInputStream fis = new FileInputStream(new File(excelPath));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("EmployeeData");

		// Get row count
		int rowCount = sheet.getLastRowNum();

		// Read data and write result
		for (int i = 1; i <= rowCount; i++) { // skip header
			Row row = sheet.getRow(i);

			String name = row.getCell(0).getStringCellValue();
			int age = (int) row.getCell(1).getNumericCellValue();

			String city = row.getCell(2).getStringCellValue();

			System.out.println(name + " - " + age + "  " + city);

			// Write result in column 2
			Cell resultCell = row.createCell(3);
			resultCell.setCellValue("PASS");
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		fos.close();
		workbook.close();
		System.out.println("Read and write operation completed!");
	}
}
