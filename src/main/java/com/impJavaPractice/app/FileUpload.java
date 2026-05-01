package com.impJavaPractice.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		String path = System.getProperty("user.dir")+"/src/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.drive", path);
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost/orangehrm/login.php");
		driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='PIM']"));
		
		WebElement menu = driver.findElement(By.xpath("//span[normalize-space()='PIM']"));
		WebElement subMenu = driver.findElement(By.xpath("//span[normalize-space()='Employee List']"));
		
		//mouse hover event

		Actions actions = new Actions(driver);
		actions.moveToElement(menu)
		       .moveToElement(subMenu)
		       .click()
		       .build()
		       .perform();
          driver.switchTo().frame("rightMenu");
		  driver.findElement(By.xpath("//input[@value='Add'] ")).click();
		  driver.findElement(By.xpath("//input[@name='txtEmpLastName'] ")).sendKeys("Geetha");
		  
		  Thread.sleep(2000);
         //file upload
		WebElement fileUpload = driver.findElement(By.id("photofile"));
		 String filePath =  "C:/Users/yellu/OneDrive/Desktop/Logo15.png";

        // Upload the file (NO CLICK)
		fileUpload.sendKeys(filePath);

		}

}




