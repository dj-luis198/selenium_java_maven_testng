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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GetBrowserDriver {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public WebDriver getDriver() {
		return this.driver.get();
	}

	public WebDriver getBrowserDriver(String browser) throws IOException {
		File file = new File("files/downloadFiles").getAbsoluteFile();
		FileUtils.cleanDirectory(file);
		if (browser != null) {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> pref = new HashMap<String, Object>();
				pref.put("download.prompt_for_download", false);
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
			 * else if(browser.equalsIgnoreCase("edge")) {
			 * setDriver(new EdgeDriver());
			 * 
			 * }
			 */
		}
		return getDriver();
	}
}
