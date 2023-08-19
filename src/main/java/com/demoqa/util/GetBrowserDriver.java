package com.demoqa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GetBrowserDriver {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	
	public WebDriver getDriver() {
		return this.driver.get();
	}
	
	public WebDriver getBrowserDriver(String browser) {
		if(browser!=null) {
			if(browser.equalsIgnoreCase("chrome")) {
				ChromeOptions chromeOptions = new ChromeOptions();
		    	chromeOptions.addArguments("--headless=old");
				setDriver(new ChromeDriver(chromeOptions));
			}
			/*else if(browser.equalsIgnoreCase("firefox")) {
				driver = setFirefoxDriver();
				
			}
            else if(browser.equalsIgnoreCase("edge")) {
				driver = setEdgeDriver();
				
			}*/
		}return getDriver();
	}
	
	/*private WebDriver setChromeDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
    	//chromeOptions.addArguments("--headless=old");
		setDriver(new ChromeDriver(chromeOptions));
		return driver;
	}
	
	private WebDriver setFirefoxDriver() {
		driver= new FirefoxDriver();
		return driver;
	}

    private WebDriver setEdgeDriver() {
		driver= new EdgeDriver();
		return driver;
	}*/

}
