package com.demoqa.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
		File file = new File("files/downloadFiles");
		try {
			FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (browser != null) {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> pref = new HashMap<String, Object>();
				pref.put("download.prompt_for_download", false);
				System.out.println("get browser, getAbsolutePath" + file.getAbsolutePath());
				pref.put("download.default_directory", file.getAbsolutePath());
				options.addArguments("--headless=old");
				options.setExperimentalOption("prefs", pref);
				setDriver(new ChromeDriver(options));
			}
			/*
			 * else if(browser.equalsIgnoreCase("firefox")) {
			 * setDriver(new FirefoxDriver());
			 * 
			 * }
			 */
			else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions options = new EdgeOptions();
				Map<String, Object> pref = new HashMap<String, Object>();
				pref.put("download.prompt_for_download", false);
				System.out.println("get browser, getAbsolutePath" + file.getAbsolutePath());
				pref.put("download.default_directory", file.getAbsolutePath());
				options.addArguments("--headless=old");
				options.setExperimentalOption("prefs", pref);
				setDriver(new EdgeDriver(options));
			}

		}
		return getDriver();
	}
}
