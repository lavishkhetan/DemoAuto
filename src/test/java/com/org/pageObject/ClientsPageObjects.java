package com.org.pageObject;

import static com.org.ishir.util.YamlReader.setYamlFilePath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.ishir.util.SeleniumWaitProvider;

public class ClientsPageObjects extends BaseUI{

	public ClientsPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String testFile = setYamlFilePath();
	SeleniumWaitProvider w = new SeleniumWaitProvider(driver);
	
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyname']")
	private WebElement cs_name;
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyemail']")
	private WebElement cs_email; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyphone']")
	private WebElement cs_phone; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyzcode']")
	private WebElement cs_zipcode; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applybname']")
	private WebElement cs_business; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyemp']")
	private WebElement cs_emp; 
	@FindBy(xpath="//form[@id='applyForm']//input[@name='applyproname']") 
	private WebElement cs_product;
	@FindBy(xpath="//form[@id='applyForm']//input[@name='website']")
	private WebElement cs_website;
	@FindBy(xpath="//form[@id='applyForm']/div[12]/textarea")
	private WebElement cs_description;

	public void Applynow() throws Exception{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000)", "");
		driver.findElement(By.id("learnmore")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("applynow")).click();
	}
	public void ApplyToday(String username, String useremail, String userphone, String usercode,
			String business, String empno, String prodname, String url, String Descrip ){
		cs_name.sendKeys(username);
		cs_email.sendKeys(useremail);
		cs_phone.sendKeys(userphone);
		cs_zipcode.sendKeys(usercode);
		cs_business.sendKeys(business);
		cs_emp.sendKeys(empno);
		cs_product.sendKeys(prodname);
		cs_website.sendKeys(url);
		cs_description.sendKeys(Descrip);
	}
}


