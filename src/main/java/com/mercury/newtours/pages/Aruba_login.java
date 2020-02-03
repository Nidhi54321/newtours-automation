package com.mercury.newtours.pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Aruba_login 
{
    @Test
    public void setUpMethod(WebDriver driver,String userName,String password)
    {
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();				
    }
}


