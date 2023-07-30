package com.demoqa.base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.demoqa.util.GetBrowserDriver.getBrowserDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties propF = new Properties();
	public static Properties propA = new Properties();
	public static Actions actions;

	public static void init() {
		// Dotenv dotenv = Dotenv.load();
		// String url = dotenv.get("url");
		// String browser = dotenv.get("browser");
		propF = init_properties("framework");
		propA = init_properties("aplication");
		driver = getBrowserDriver(propF.getProperty("browser"));
		driver.get(propA.getProperty("url"));
		driver.manage().window().maximize();
	}

	public static Properties init_properties(String name) {
		FileReader reader;
		try {
			reader = new FileReader(
					"./src/test/resources/config/" + name + ".properties");
			// prop = new Properties();
			prop.load(reader);
			return prop;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	// ----------------------------findElement(s)---------------------//
	private static WebElement findElement(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static WebElement findElementClickable(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static Boolean NoFindElement(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	protected static List<WebElement> findElements(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	protected static List<WebElement> findElementsXpath(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	// -----------------------------basicos---------------------------//
	public static void click(String locator) {
		// actions = new Actions(driver);
		try {
			(findElementClickable(locator)).click();
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

	public static int returnLengthXpath(String locator) {
		return findElementsXpath(locator).size();
	}

	public static List<WebElement> returnXpath(String locator) {
		return findElementsXpath(locator);
	}

	public static Boolean isSelected(String locator) {
		return findElement(locator).isSelected();
	}

	public Boolean NoFind(String locator) {
		return NoFindElement(locator);
	}

	public static Boolean isEnabled(String locator) {
		return findElement(locator).isEnabled();
	}

	public static Boolean isDisplayed(String locator) {
		return findElement(locator).isDisplayed();
	}

	public static void typeAndEnter(String locator, String text) {
		type(locator, text);
		findElement(locator).sendKeys(Keys.ENTER);
	}

	public static Boolean getPageSource(String locator) {
		if (driver.getPageSource().contains(locator)) {
			return true;
		}
		return false;
	}

	public static Boolean selectPerText(String locator, String text) {
		Select select = new Select(findElement(locator));
		select.selectByVisibleText(text);
		return select.getFirstSelectedOption().getAttribute("value").equals(text);
	}

	public static List<WebElement> selectGetOptions(String locator) {
		Select select = new Select(findElement(locator));
		return select.getOptions();
	}

	public String getAttributeId(String locator) {
		return findElement(locator).getAttribute("id");
	}

	public static void doubleClick(String locator) {
		actions = new Actions(driver);
		actions.doubleClick(findElementClickable(locator)).perform();
	}

	public static void rightClick(String locator) {
		actions = new Actions(driver);
		actions.contextClick(findElementClickable(locator)).perform();
	}
}
