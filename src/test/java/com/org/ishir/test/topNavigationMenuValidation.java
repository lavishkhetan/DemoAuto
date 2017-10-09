package com.org.ishir.test;

import org.testng.annotations.Test;
import com.org.ishir.initiators.Initializer;
import com.org.ishir.util.DataReadWrite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.ITestResult;
import java.lang.reflect.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class topNavigationMenuValidation {
	Initializer test;
  
	@BeforeClass
	public void Start_Test_Session(){
		test = new Initializer(DataReadWrite.getProperty("browser"));
	}
	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	@Test
	public void launchTheApplication(){
		test.launchApplication();
	}
//Social Media Validation for fb/twitter/G+/Linkdin(socialMediaPO)
	@Test(priority=1,dependsOnMethods = { "launchTheApplication" })
	public void Validate_SocialMediaIcons() throws Exception{
		test.socialMedia.changeWindow();
		System.out.println("***** Validation Completed *****");
	}
//Dynamic Home page named Home and page object is same in (HomePageObject)  	
	@Test(priority=2,dependsOnMethods = { "Validate_SocialMediaIcons" })
	public void Validate_DynamicPanel() throws Exception{
		test.homePage.DynamicPanel();
		System.out.println("***** Validation Completed for DynamicPanel ****");
	}
//Mouse Hover Functionality on Home page(HomePageObject)	
	@Test(priority=3,dependsOnMethods = { "Validate_DynamicPanel" })
	public void Validate_Company_Link() throws Exception{
		test.homePage.selectCompanyLink();
		Assert.assertTrue(test.homePage.validateTheAction(), "Validation was unsuccessful");
		System.out.println("***** First Function Successfully Passed *****");
	}
//Pricing Tab on Home Page(HomePageObject)
	@Test(priority = 4, dependsOnMethods ={ "Validate_Company_Link" })
	public void Validate_PricingTab() throws Exception{
		test.homePage.pricing_tab();
		System.out.println("***** Validation Completed Pricing");
	}
// Services Tab Functionality (CaseStudiesPO)
	@Test(priority=5, dependsOnMethods={ "Validate_PricingTab" })
	public void Validate_ServicesTab(){
		test.Download.btn_Services();
		System.out.println("***** Validation Completed for Services");
	}	
//	Download Functionality for case Studies(CaseStudiesPO)
	@Test(priority=6,dependsOnMethods = { "Validate_ServicesTab" })
	public void Validate_DownloadBtn() throws Exception{
		test.Download.btn_Download();
		System.out.println("***** Validation Completed for URl *****");
	}
//	LetsTalk Functionality on Home page(LetsTalkPageObject)	
	@Test(priority=7,dependsOnMethods = { "Validate_DownloadBtn" })
	public void Validate_LetsTalk() throws Exception {
		test.LetsTalk.LetsTalk_FormField();
		System.out.println("***** Validation Completed LetsTalk *****");
	}
//	@AfterMethod
//	public void take_screenshot_on_failure(ITestResult result) {
//		test.takescreenshot.takeScreenShotOnException(result);
//	}	
	
	@AfterClass
	public void close_Test_Session() throws InterruptedException{
		test.homePage.closeBrowser();
	}
}
