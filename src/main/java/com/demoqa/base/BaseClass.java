package com.demoqa.base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.demoqa.util.GetBrowserDriver.getBrowserDriver;

import io.github.cdimascio.dotenv.Dotenv;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	public static void init() {
		Dotenv dotenv = Dotenv.load();
		String url = dotenv.get("url");
		String browser = dotenv.get("browser");
		prop = init_properties();
		driver = getBrowserDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static Properties init_properties() {
		FileReader reader;
		try {
			reader = new FileReader(
					"C:\\Proyectos selenium\\selenium_java_maven_testng\\src\\test\\resources\\config\\framework.properties");
			prop = new Properties();
			prop.load(reader);
			return prop;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	// ----------------------------findElement(s)---------------------//
	private static WebElement findElement(String locator) {
		String time = prop.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static WebElement findElementClickable(String locator) {
		String time = prop.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	protected static List<WebElement> findElements(String locator) {
		String time = prop.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	// -----------------------------basicos---------------------------//
	public static void click(String locator) {
		try {
			findElementClickable(locator).click();
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", findElementClickable(locator));
		}
	}

	public static void quit() {
		driver.close();
	}

	public static String getText(String locator) {
		String text = findElement(locator).getAttribute("value");
		return text;
	}

	public static String getTextContent(String locator) {
		String text = findElement(locator).getAttribute("textContent");
		return text;
	}

	public static String getTitlePage() {
		return driver.getTitle();
	}

	public static void type(String locator, String text) {
		findElement(locator).clear();
		findElement(locator).sendKeys(text);
	}

	public static int returnLength(String locator) {
		return findElements(locator).size();
	}
}
