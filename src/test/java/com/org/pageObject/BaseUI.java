
package com.org.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.org.ishir.util.SeleniumWaitProvider;

public class BaseUI {
	
	WebDriver driver;
	SeleniumWaitProvider wait;

	public BaseUI(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new SeleniumWaitProvider(driver);
	}
	
	public void closeBrowser() throws InterruptedException{
		Thread.sleep(3000);
		driver.close();
	}
	
	
}
