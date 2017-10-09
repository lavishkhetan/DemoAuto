package com.org.pageObject;

import static com.org.ishir.util.YamlReader.getYamlValue;
import static com.org.ishir.util.YamlReader.setYamlFilePath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.org.ishir.util.SeleniumWaitProvider;

public class HomePageObject extends BaseUI{

	public HomePageObject(WebDriver driver) {
		super(driver);
	}
	Actions action = new Actions(driver);
    String testFile = setYamlFilePath();
	SeleniumWaitProvider w = new SeleniumWaitProvider(driver);

//Company Tab Page Object and Mouse hover functionality	
	@FindBy(xpath="//a[contains(text(),'Company')]")
	private WebElement topNavigation_company_link;
	@FindBy(xpath="//a[contains(text(),'Company')]//following-sibling::ul//a")
	private WebElement topNavigation_company_ddl;
	@FindBy(css="#company h1")
	private WebElement whyIshir_label;
	
	public void selectCompanyLink() throws InterruptedException {
		action.moveToElement(topNavigation_company_link).moveToElement(topNavigation_company_ddl).click().build().perform();
	}
	public boolean validateTheAction() throws InterruptedException{
		String text;
		boolean flag = false;
		text= whyIshir_label.getText();
		if(text.equalsIgnoreCase(getYamlValue("validationTextForCompanyTag"))){
			flag=true;
		}
		return flag;
	}
	
//Dynamic panel of Home and its Page objects
	@FindBy(xpath="//ol[@class='carousel-indicators']/li[1]")
	private WebElement PageSlider_first;
	@FindBy(xpath="//ol[@class='carousel-indicators']/li[2]")
	private WebElement PageSlider_second;
	@FindBy(xpath="//ol[@class='carousel-indicators']/li[3]")
	private WebElement PageSlider_third;
	@FindBy(xpath="//ol[@class='carousel-indicators']/li[4]")
	private WebElement PageSlider_fourth;

		public void DynamicPanel() throws Exception{
		WebElement element = driver.findElement(By.xpath(".//*[@id='myCarousel']/div[1]/ol"));
	     	element.click();
	     	for(int i=1;i<4;i++);{
	     	        Thread.sleep(1000);
	     	        element.click();
	     	}
	    PageSlider_first.click();
	    Thread.sleep(1000);
	    Assert.assertEquals(getYamlValue("dynamicPage1"),driver.findElement(By.xpath("//div[@class='container']/h1")).getText());
	    System.out.println("Successfully clicked first button");
	    
	    PageSlider_second.click();
	    Thread.sleep(1000);
	    Assert.assertEquals(getYamlValue("dynamicPage2"),driver.findElement(By.xpath("//div[@class='homepageslider']/h4/span[2]")).getText());
	    System.out.println("Successfully clicked second button");
	    
	    PageSlider_third.click();
	    Thread.sleep(1000);
	    Assert.assertEquals(getYamlValue("dynamicPage3"),driver.findElement(By.xpath("//div[@class='homepageslider']/h5[1]/span[1]")).getText());
	    System.out.println("Successfully clicked third button");
	    
	    PageSlider_fourth.click();
	    Thread.sleep(1000);
	    Assert.assertEquals(getYamlValue("dynamicPage4"),driver.findElement(By.xpath("(//div[@class='homepageslider']//h5/span[1])[2]")).getText());
	    System.out.println("Successfully clicked fourth button");
	    }

// Page Object for Pricing Tab on Home Page
		
		@FindBy(xpath="//a[text()='Pricing']")
		private WebElement btn_pricing;
		
		public void pricing_tab(){
		btn_pricing.click();
		Assert.assertEquals(getYamlValue("pricing"),driver.findElement(By.xpath("//div[@class='static-banner']//h3[text()='Software Testing ']")).getText());
		}
}
