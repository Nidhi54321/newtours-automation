package com.mercury.newtours.pages;

import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Aruba_FlightSearch {
	WebDriver driver;
	@Test
	public void search_Flight(WebDriver driver) {
	driver.findElement(By.xpath("//*[@name='tripType'][@value='roundtrip']")).click();
	driver.findElement(By.xpath("//select[@name=\"passCount\"]//option[2]")).click();
	driver.findElement(By.xpath("//select[@name=\"fromPort\"]//option[contains(text(),'London')]")).click();
	driver.findElement(By.xpath("//select[@name=\"fromMonth\"]//option[contains(text(),'February')]")).click();
	driver.findElement(By.xpath("//select[@name=\"fromDay\"]//option[contains(text(),'12')]")).click();
	driver.findElement(By.xpath("//select[@name=\"toPort\"]//option[contains(text(),'New York')]")).click();
	driver.findElement(By.xpath("//select[@name=\"toMonth\"]//option[contains(text(),'February')]")).click();
	driver.findElement(By.xpath("//select[@name=\"toDay\"]//option[contains(text(),'15')]")).click();
	driver.findElement(By.xpath("//input[@name=\"servClass\"][contains(@value,'Business')]")).click();
	driver.findElement(By.xpath("//input[@name=\"findFlights\"]")).click();	
	}
}
