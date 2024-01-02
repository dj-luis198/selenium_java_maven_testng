package com.demoqa.util;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class GetBrowserDriver {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public void setDriver(WebDriver webDriver) {
		driver.set(webDriver);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void quitDriver() {
		try {
			WebDriver webDriver = driver.get();
			if (webDriver != null) {
				webDriver.quit();
			}
		} finally {
			driver.remove();
		}
	}

	public WebDriver getBrowserDriver(String browser) {
		File file = new File("files/downloadFiles");
		if (browser != null) {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> pref = new HashMap<String, Object>();
				pref.put("download.prompt_for_download", false);
				pref.put("download.default_directory", file.getAbsolutePath());
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				options.addArguments("--start-fullscreen");
				options.addArguments("--no-proxy-server");
				options.addArguments("--ignore-certificate-errors");
				options.setExperimentalOption("prefs", pref);
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				//options.setScriptTimeout(Duration.ofSeconds(10));
				setDriver(new ChromeDriver(options));
			}

			else if (browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions options = new FirefoxOptions();
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("pdfjs.disabled", true);
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/jpeg");
				profile.setPreference("browser.download.dir", file.getAbsolutePath());
				profile.setPreference("browser.download.folderList", 2);
				options.addArguments("--headless");
				options.setProfile(profile);
				options.setScriptTimeout(Duration.ofSeconds(10));
				setDriver(new FirefoxDriver(options));
				getDriver().manage().window().fullscreen();
			}

			else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions options = new EdgeOptions();
				Map<String, Object> pref = new HashMap<String, Object>();
				pref.put("download.prompt_for_download", false);
				pref.put("download.default_directory", file.getAbsolutePath());
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				options.addArguments("--start-fullscreen");
				options.setExperimentalOption("prefs", pref);
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				options.setScriptTimeout(Duration.ofSeconds(10));
				setDriver(new EdgeDriver(options));
			}

		}
		return getDriver();
	}
}
