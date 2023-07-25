package com.demoqa.util;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetBrowserDriver {
	static WebDriver driver;
	
	public static WebDriver getBrowserDriver(String browser) {
		if(browser!=null) {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = setChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver = setFirefoxDriver();
				
			}
            else if(browser.equalsIgnoreCase("edge")) {
				driver = setEdgeDriver();
				
			}
		}return driver;
	}
	
	private static WebDriver setChromeDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.addArguments("--headless=old");
		driver= new ChromeDriver();
		return driver;
	}
	
	private static WebDriver setFirefoxDriver() {
		driver= new FirefoxDriver();
		return driver;
	}

    private static WebDriver setEdgeDriver() {
		driver= new EdgeDriver();
		return driver;
	}

}
