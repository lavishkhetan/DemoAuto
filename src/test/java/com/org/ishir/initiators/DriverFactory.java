package com.org.ishir.initiators;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private static String browser;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    //public WebDriver getDriver(String browserName) {
    public WebDriver getDriver(String browserName) {    
    browser = browserName;
  
            if (browser.equalsIgnoreCase("firefox")) {
                return getFirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
            	System.out.println("Browser chosen:: Chrome");
            	return getChromeDriver("C:\\Users\\lkhetan\\Downloads\\Framework_ishir\\Framework\\ishirqa\\src\\test\\resources\\drivers\\chromedriver.exe");
               
            } else if ((browser.equalsIgnoreCase("ie"))
                    || (browser.equalsIgnoreCase("internetexplorer"))
                    || (browser.equalsIgnoreCase("internet explorer"))) {
            	System.out.println("Browser chosen:: IE");
            	return getInternetExplorerDriver(System.getProperty("user.dir") + File.separator+"internetExplorerDriver.exe");
            }
           
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver(String driverpath) {
        System.setProperty("webdriver.chrome.driver", driverpath);
        capabilities.setJavascriptEnabled(true);
        return new ChromeDriver(capabilities);
    }

    private static WebDriver getInternetExplorerDriver(String driverpath) {
        System.setProperty("webdriver.ie.driver", driverpath);
        capabilities.setCapability("ignoreZoomSetting", true);
        return new InternetExplorerDriver(capabilities);
    }
  
    private static WebDriver getFirefoxDriver() {
        return new FirefoxDriver();
    }
    
    public WebDriver setRemoteDriver(String browser) {
        DesiredCapabilities cap = null;
        DriverFactory.browser = browser;
        if (browser.equalsIgnoreCase("firefox")) {
            cap = DesiredCapabilities.firefox();
        } else if (browser.equalsIgnoreCase("chrome")) {
            cap = DesiredCapabilities.chrome();
        } else if (browser.equalsIgnoreCase("Safari")) {
            cap = DesiredCapabilities.safari();
        } else if ((browser.equalsIgnoreCase("ie"))
                || (browser.equalsIgnoreCase("internetexplorer"))
                || (browser.equalsIgnoreCase("internet explorer"))) {
            cap = DesiredCapabilities.internetExplorer();
        }
        String seleniuhubaddress = "http://172.16.3.173:6666/wd/hub";
        URL selserverhost = null;
        try {
            selserverhost = new URL(seleniuhubaddress);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        cap.setJavascriptEnabled(true);
        return new RemoteWebDriver(selserverhost, cap);
    }
}