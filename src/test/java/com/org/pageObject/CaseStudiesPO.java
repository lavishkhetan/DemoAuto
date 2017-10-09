package com.org.pageObject;

import static com.org.ishir.util.YamlReader.getYamlValue;
import static com.org.ishir.util.YamlReader.setYamlFilePath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.org.ishir.util.SeleniumWaitProvider;

public class CaseStudiesPO extends BaseUI {

	public CaseStudiesPO(WebDriver driver){
		super(driver);
		}
//	Actions action = new Actions(driver);
//  String testFile = setYamlFilePath();
//	SeleniumWaitProvider w = new SeleniumWaitProvider(driver);
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[5]")
	private WebElement tab_CaseStudies;	
	@FindBy(xpath="//div[@class='row']//div[contains(@class,'col-lg-8')]//a")
	private WebElement leftbtn_Download;
	
	public void btn_Download() throws Exception {
	tab_CaseStudies.click();
	Thread.sleep(1000);
	leftbtn_Download.click();
	String parentHandle = driver.getWindowHandle(); // get the current window handle
	for (String winHandle : driver.getWindowHandles())
	{	
		driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		Thread.sleep(1000);
	}
		Assert.assertEquals(getYamlValue("UrlVerification"),driver.getCurrentUrl());
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle);	
	}
//Page Object for Services tab
	@FindBy(xpath="//a[text()='Services']")
	private WebElement tab_services;
	
	public void btn_Services(){
	tab_services.click();
	Assert.assertEquals(getYamlValue("services"), driver.findElement(By.xpath("//h1[text()='services ']")).getText());
	}
}
