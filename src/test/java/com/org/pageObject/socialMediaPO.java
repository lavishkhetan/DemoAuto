package com.org.pageObject;

import static com.org.ishir.util.YamlReader.getYamlValue;
import static com.org.ishir.util.YamlReader.setYamlFilePath;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import com.org.ishir.util.SeleniumWaitProvider;

public class socialMediaPO extends BaseUI{

	public socialMediaPO(WebDriver driver) {
		super(driver);}
	
	String testFile = setYamlFilePath();
	
	@FindBy(css=".social>li:nth-child(1)")
	private WebElement social_icon_fb;
	
	@FindBy(css=".social>li:nth-child(2)")
	private WebElement social_icon_twitter;
	
	@FindBy(css=".social>li:nth-child(3)")
	private WebElement social_icon_linkedIn;
	
	@FindBy(css=".social>li:nth-child(4)")
	private WebElement social_icon_Gplus;
	
	@FindBy(xpath="//div[@class='join-linkedin-promo']/h3")
	private WebElement LinkedIn_HEad_label;
	
	 public void changeWindow() throws Exception {

		 		social_icon_fb.click();							    
			    String parentHandle1 = driver.getWindowHandle(); // get the current window handle
			    for (String winHandle : driver.getWindowHandles())
			    {
			    driver.switchTo().window(winHandle); 
			    }
			    Thread.sleep(1000);			
			   
			    Assert.assertTrue( driver.getPageSource().contains(getYamlValue("facebookValidation")));
			    System.out.println("Successfully Navigated to Facebook");
			    driver.close(); // close newly opened window when done with it
			    driver.switchTo().window(parentHandle1);
			    Thread.sleep(1000);
			    
			    social_icon_twitter.click();		    
			    String parentHandle2 = driver.getWindowHandle(); // get the current window handle
			    for (String winHandle : driver.getWindowHandles())
			    {
			    driver.switchTo().window(winHandle); 
			    }
			    Thread.sleep(1000);
			    Assert.assertEquals(getYamlValue("twitterValidation"),driver.getTitle());
			    System.out.println("Successfully Navigated to Twitter");
			    driver.close(); // close newly opened window when done with it
			    driver.switchTo().window(parentHandle2);
			    Thread.sleep(1000);
			    
			    social_icon_linkedIn.click();		    
			    String parentHandle3 = driver.getWindowHandle(); // get the current window handle
			    for (String winHandle : driver.getWindowHandles())
			    {
			    driver.switchTo().window(winHandle); 
			    }
			    Thread.sleep(1000);
			    String Actualtext = LinkedIn_HEad_label.getText();
		     	Assert.assertEquals(Actualtext, getYamlValue("linkedInValidation"));
		     	System.out.println("Successfully Navigated to Linkedin");
			    driver.close(); // close newly opened window when done with it
			    driver.switchTo().window(parentHandle3);
			    Thread.sleep(1000);
			    
			    social_icon_Gplus.click();		    
			    String parentHandle4 = driver.getWindowHandle(); // get the current window handle
			    for (String winHandle : driver.getWindowHandles())
			    {
			    driver.switchTo().window(winHandle); 
			    }
			    Thread.sleep(1000);
			    Assert.assertEquals(getYamlValue("gPlusValidation"),driver.getTitle());
			    System.out.println("Successfully Navigated to Google Plus");
			    driver.close(); // close newly opened window when done with it
			    driver.switchTo().window(parentHandle4);
			    
	 			}	
}
