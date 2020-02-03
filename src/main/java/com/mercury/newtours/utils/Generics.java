package com.mercury.newtours.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class Generics {   
            public static WebDriver driver;
            @BeforeClass
            public static WebDriver preCondition()
            {
            	System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");
            	driver = new ChromeDriver();
            	driver.get("http://demo.guru99.com/test/newtours/");
        	//	driver.get("http://newtours.demoaut.com/");
        		driver.manage().window().maximize();
        		return driver;
            }
            
            @AfterClass
            public void postCondition() throws InterruptedException
            {
                        Thread.sleep(5000);
                        driver.quit();
            }	    
            
            public void fetchData(String userName, String password) throws Exception {
            	 FileInputStream inputStream = new FileInputStream("C:\\Users\\Hasher\\Desktop\\FlightDetails.xls");
                 HSSFWorkbook myExcelBook = new HSSFWorkbook(inputStream);
                 Sheet loginSheet = myExcelBook.getSheet("Sheet1");
                 int rowCount = loginSheet.getLastRowNum()-loginSheet.getFirstRowNum();
                 for (int i = 1; i < rowCount+1; i++) {
                    Row row = loginSheet.getRow(i);
                    for (int j1 = 0; j1 < row.getLastCellNum(); j1++) {
                        System.out.print(row.getCell(j1).getStringCellValue()+"|| ");
                        System.out.println();       
            }
                 }
            }
}
//=====================================================================================================================================
/*
 * public void navigateToURL(String URL) { System.out.println("Navigating to: "
 * + URL); System.out.println("Thread id = " + Thread.currentThread().getId());
 * 
 * try { _driver.navigate().to(URL); } catch (Exception e) {
 * System.out.println("URL did not load: " + URL); throw new
 * TestException("URL did not load"); } }
 * 
 * public String getPageTitle() { try {
 * System.out.print(String.format("The title of the page is: %s\n\n",
 * _driver.getTitle())); return _driver.getTitle(); } catch (Exception e) {
 * throw new TestException(String.format("Current page title is: %s",
 * _driver.getTitle())); } }
 * 
 * public WebElement getElement(By selector) { try { return
 * _driver.findElement(selector); } catch (Exception e) {
 * System.out.println(String.format("Element %s does not exist - proceeding",
 * selector)); } return null; }
 * 
 * public void sendKeys(By selector, String value) { WebElement element =
 * getElement(selector); clearField(element); try { element.sendKeys(value); }
 * catch (Exception e) { throw new TestException(String.
 * format("Error in sending [%s] to the following element: [%s]", value,
 * selector.toString())); } }
 * 
 * public void clearField(WebElement element) { try { element.clear(); } catch
 * (Exception e) { System.out.print(String.
 * format("The following element could not be cleared: [%s]",
 * element.getText())); } }
 * 
 * public void click(By selector) { WebElement element = getElement(selector);
 * try { element.click(); } catch (Exception e) { throw new
 * TestException(String.format("The following element is not clickable: [%s]",
 * selector)); } } }
 */
