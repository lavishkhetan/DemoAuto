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

public class LetsTalkPageObject extends BaseUI {

	String Actualtext;
	public LetsTalkPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	Actions action = new Actions(driver);
    String testFile = setYamlFilePath();
	SeleniumWaitProvider w = new SeleniumWaitProvider(driver);
	
	@FindBy(xpath="//input[@name='nameform']")
	private WebElement nameField;
	@FindBy(xpath="//input[@name='emailform']")
	private WebElement emailField;
	@FindBy(xpath="//input[@name='phonenoform']")
	private WebElement phoneField;
	@FindBy(xpath="(//input[@name='website'])[1]")
	private WebElement websiteField;
	@FindBy(xpath="//textarea[@name='messageform']")
	private WebElement messageField;
	@FindBy(id="submitcontactForm")
	private WebElement submit;

	public void LetsTalk_FormField() throws Exception{
		WebElement btn_letstalk = driver.findElement(By.xpath("//a[@class='page-scroll letstalk']"));
		btn_letstalk.click();
		Thread.sleep(2000);
		
		nameField.sendKeys("lavish");
		emailField.sendKeys("lkhetan@ishir.com");
		phoneField.sendKeys("9999999999");
		websiteField.sendKeys("lavishkhetan@ishir.com");
		messageField.sendKeys("AutomationTest");
		submit.click();
		Thread.sleep(1000);
		
		Assert.assertEquals(getYamlValue("SubmitLetsTalk"),driver.findElement(By.xpath(".//*[@id='about']/div/div/div[1]/p")).getText());
	    System.out.println("Successfully Submitted the form");				
	}
}
