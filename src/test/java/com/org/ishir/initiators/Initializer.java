package com.org.ishir.initiators;

import static com.org.ishir.util.YamlReader.getYamlValue;
import static com.org.ishir.util.YamlReader.setYamlFilePath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.org.ishir.util.TakeScreenshot;
import com.org.pageObject.CaseStudiesPO;
import com.org.pageObject.ClientsPageObjects;
import com.org.pageObject.HomePageObject;
import com.org.pageObject.LetsTalkPageObject;
import com.org.pageObject.socialMediaPO;

public class Initializer {

	private WebDriver driver;
	private DriverFactory drFactory;
	public HomePageObject homePage;
	public TakeScreenshot takescreenshot;
	public socialMediaPO socialMedia;
	public LetsTalkPageObject LetsTalk;
	public CaseStudiesPO Download;
	public ClientsPageObjects startups;
	
	public Initializer(String browser){
		drFactory = new DriverFactory();
		_startBrowser(browser);
		_initPageObject();
	}
	
	private void _startBrowser(String browser){
		driver = drFactory.getDriver(browser);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	private void _initPageObject(){
//ishir
		homePage = new HomePageObject(driver); 
		socialMedia=new socialMediaPO(driver);
		LetsTalk = new LetsTalkPageObject(driver);
		Download = new CaseStudiesPO(driver);
		startups = new ClientsPageObjects(driver);
		
	}
	public void stepStartMessage(String testStepName) {		
		Reporter.log(" ", true);
		Reporter.log("***** STARTING TEST STEP:- " + testStepName.toUpperCase() + " *****", true);
		Reporter.log(" ", true);
	}
	
	public void launchApplication() {
		setYamlFilePath();
		driver.get(getYamlValue("baseUrl"));
	}
}
