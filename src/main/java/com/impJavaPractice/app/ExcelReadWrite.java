package com.impJavaPractice.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelReadWrite {
	public static void main(String args[]) throws IOException, InterruptedException {

		// identify location of .xlsx file

		Path path = Paths.get(System.getProperty("user.dir"), "src", "resource", "java", "DetailsStudent.xlsx");

		File f = path.toFile();

		// File f = new
		// File("C:\\Users\\yellu\\geetha_practice\\Practise\\src\\resource\\java\\DetailsStudent.xlsx");
		FileInputStream i = new FileInputStream(f);

		// instance of XSSFWorkbook
		XSSFWorkbook w = new XSSFWorkbook(i);

		// create sheet in XSSFWorkbook with name Details1
		XSSFSheet s = w.getSheet("Details");

		// Initiate the Webdriver

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// adding implicit wait of 15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Opening the webpage where we will identify elements
		driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");

		Thread.sleep(10000);

		// Identify elements for registration
		WebElement fname = driver.findElement(By.xpath("//*[@id='firstname']"));
		WebElement lname = driver.findElement(By.xpath("//*[@id='lastname']"));
		WebElement uname = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pass = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement btn = driver.findElement(By.xpath("//*[@id='signupForm']/div[5]/input"));

		int r = s.getLastRowNum();
		System.out.println("Total rows: " + r);

		for (int j = 1; j <= r; j++) {

			if (s.getRow(j) == null) {
				System.out.println("Skipping empty row: " + j);
				continue;
			}

			fname.clear();
			lname.clear();
			uname.clear();
			pass.clear();

			fname.sendKeys(s.getRow(j).getCell(0).getStringCellValue());
			lname.sendKeys(s.getRow(j).getCell(1).getStringCellValue());
			uname.sendKeys(s.getRow(j).getCell(2).getStringCellValue());
			pass.sendKeys(s.getRow(j).getCell(3).getStringCellValue());

			btn.click();

			String value = driver.findElement(By.id("firstname")).getAttribute("value");

			XSSFCell c = s.getRow(j).createCell(4);

			if (value.isEmpty()) {
				c.setCellValue("Test Case: PASS");
			} else {
				c.setCellValue("Test Case: FAIL");
			}

			// complete writing value in excel
			FileOutputStream o = new FileOutputStream(
					"C:\\Users\\yellu\\geetha_practice\\Practise\\src\\resource\\java\\DetailsStudent.xlsx");
			w.write(o);
		}

		// closing workbook object
		w.close();

		// Quitting browser
		// driver.quit();
	}
}