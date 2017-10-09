package com.org.ishir.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitProvider{

	WebDriver driver;
	WebDriverWait wait;
	int Ajax_Wait = 30;
	
	public SeleniumWaitProvider(WebDriver driver){
		this.driver = driver;
	}

	public WebElement explicitWaitForElement(WebElement element){
		wait = new WebDriverWait(driver, Ajax_Wait);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}

