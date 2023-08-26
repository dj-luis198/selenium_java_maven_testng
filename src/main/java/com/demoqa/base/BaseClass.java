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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoqa.util.GetBrowserDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseClass {
	private static GetBrowserDriver getBrowser = new GetBrowserDriver();
	private static Properties prop = new Properties();
	private static Properties propF = new Properties();
	private static Properties propA = new Properties();
	private static Actions actions;

	protected static void init() {
		propF = init_properties("framework");
		propA = init_properties("aplication");
		getBrowser.setDriver(getBrowser.getBrowserDriver(propF.getProperty("browser")));
		getBrowser.getDriver().get(propA.getProperty("url"));
		getBrowser.getDriver().manage().window().maximize();
	}

	private static Properties init_properties(String name) {
		FileReader reader;
		try {
			reader = new FileReader(
					"./src/test/resources/config/" + name + ".properties");
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
			WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static WebElement findElementClickable(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static Boolean NoFindElement(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static List<WebElement> findElements(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static List<WebElement> findElementsXpath(String locator) {
		String time = propF.getProperty("timeOut");
		try {
			WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
			return ewait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	// -----------------------------basicos---------------------------//
	protected static void click(String locator) {
		// actions = new Actions(driver);
		try {
			(findElementClickable(locator)).click();
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
			jse.executeScript("arguments[0].click();", findElementClickable(locator));
		}
	}

	protected static void clickNewTab(String locator) {
		String time = propF.getProperty("timeOut");
		String originalTap = getBrowser.getDriver().getWindowHandle();
		try {
			(findElementClickable(locator)).click();
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
			jse.executeScript("arguments[0].click()", findElementClickable(locator));
		}
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
		ewait.until(numberOfWindowsToBe(2));
		for (String windowHandle : getBrowser.getDriver().getWindowHandles()) {
			if (!originalTap.contentEquals(windowHandle)) {
				getBrowser.getDriver().switchTo().window(windowHandle);
				break;
			}
		}
	}

	protected static void quit() {
		getBrowser.getDriver().quit();
	}

	protected static String getText(String locator) {
		String text = findElement(locator).getAttribute("value");
		return text;
	}

	protected static String getTextContent(String locator) {
		String text = findElement(locator).getAttribute("textContent");
		return text;
	}

	protected static String getTitlePage() {
		return getBrowser.getDriver().getTitle();
	}

	protected static String getURL() {
		return getBrowser.getDriver().getCurrentUrl();
	}

	protected static void type(String locator, String text) {
		findElement(locator).clear();
		findElement(locator).sendKeys(text);
	}

	protected static int returnLength(String locator) {
		return findElements(locator).size();
	}

	protected static int returnLengthXpath(String locator) {
		return findElementsXpath(locator).size();
	}

	protected static List<WebElement> returnXpath(String locator) {
		return findElementsXpath(locator);
	}

	protected static Boolean isSelected(String locator) {
		return findElement(locator).isSelected();
	}

	protected Boolean NoFind(String locator) {
		return NoFindElement(locator);
	}

	protected static Boolean isEnabled(String locator) {
		return findElement(locator).isEnabled();
	}

	protected static Boolean isDisplayed(String locator) {
		return findElement(locator).isDisplayed();
	}

	protected static void typeAndEnter(String locator, String text) {
		type(locator, text);
		findElement(locator).sendKeys(Keys.ENTER);
	}

	protected static Boolean getPageSource(String locator) {
		if (getBrowser.getDriver().getPageSource().contains(locator)) {
			return true;
		}
		return false;
	}

	protected static Boolean selectPerText(String locator, String text) {
		Select select = new Select(findElement(locator));
		select.selectByVisibleText(text);
		return select.getFirstSelectedOption().getAttribute("value").equals(text);
	}

	protected static List<WebElement> selectGetOptions(String locator) {
		Select select = new Select(findElement(locator));
		return select.getOptions();
	}

	protected String getAttributeDownload(String locator) {
		return findElement(locator).getAttribute("download");
	}

	protected String getAttributeId(String locator) {
		return findElement(locator).getAttribute("id");
	}

	protected String getAttributeElementNaturalH(WebElement element) {
		return element.getAttribute("naturalHeight");
	}

	protected String getAttributeElementSrcText(WebElement element) {
		return element.getAttribute("src");
	}

	protected String getAttributeElementHref(WebElement element) {
		return element.getAttribute("href");
	}

	protected static void doubleClick(String locator) {
		actions = new Actions(getBrowser.getDriver());
		actions.doubleClick(findElementClickable(locator)).perform();
	}

	protected static void rightClick(String locator) {
		actions = new Actions(getBrowser.getDriver());
		actions.contextClick(findElementClickable(locator)).perform();
	}

	protected static List<WebElement> returnElements(String locator) {
		return findElementsXpath(locator);
	}

	protected static void AdsCSSDisplayNone(String locator) {
		cSSDisplayNone(findElement(locator));
	}

	protected static void cSSDisplayNone(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
		jse.executeScript("arguments[0].style.display = 'none';", element);
	}

	protected static String returnCSSColor(String locator) {
		return findElement(locator).getCssValue("color");
	}
}
