package com.mercury.newtours;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mercury.newtours.pages.*;
import com.mercury.newtours.utils.*;

public class AppTest{
		public static String userName;
		public static String password;
		public static String title_expected="abc";
		@Test
	    public void main() throws IOException {
			InputStream inputStream = this.getClass().getResourceAsStream("/FlightDetails.xls");
            HSSFWorkbook myExcelBook = new HSSFWorkbook(inputStream);
            Sheet loginSheet = myExcelBook.getSheet("Sheet1");
            int rowCount = loginSheet.getLastRowNum()-loginSheet.getFirstRowNum();
            for (int i = 1; i <= rowCount; i++) {
            	String userName = myExcelBook.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue(); 
            	String password = myExcelBook.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
                WebDriver driver=Generics.preCondition();
    			Aruba_login login = new Aruba_login();
    			login.setUpMethod(driver,userName,password);
    			String title_Actual=driver.getTitle();
    			System.out.println(title_Actual);
    			Assert.assertEquals(title_Actual, title_expected);
    			Aruba_FlightSearch flightSearch= new Aruba_FlightSearch();
    			flightSearch.search_Flight(driver);
             }
		}
}