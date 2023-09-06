package com.demoqa.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoqa.util.GetBrowserDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class BaseClass {
	private static GetBrowserDriver getBrowser = new GetBrowserDriver();
	private static Properties prop = new Properties();
	private static Properties propF = new Properties();
	private static Properties propA = new Properties();
	private static Actions actions;

	public static WebDriver getDriver() {
		return getBrowser.getDriver();
	}

	protected static void init() {
		propF = init_properties("framework");
		propA = init_properties("aplication");
		getBrowser.setDriver(getBrowser.getBrowserDriver(propF.getProperty("browser")));
		// getBrowser.getDriver().manage().window().maximize();
		getBrowser.getDriver().manage().window().fullscreen();
		getBrowser.getDriver().get(propA.getProperty("url"));

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

	protected static String takesScreenshot(String testName, WebDriver driver) throws IOException {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/ExtentReports/Screenshots/" + testName + ".jpg");
		FileUtils.copyFile(sourceFile, destFile);
		return destFile.getAbsolutePath();
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

	// -------------------------Basic--------------------------//

	protected static void quit() {
		getBrowser.getDriver().quit();
	}

	protected static void close() {
		getBrowser.getDriver().close();
	}

	protected static String getTitlePage() {
		return getBrowser.getDriver().getTitle();
	}

	protected static String getURL() {
		return getBrowser.getDriver().getCurrentUrl();
	}

	protected static Boolean isSelected(String locator) {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return findElement(locator).isSelected();
	}

	protected static Boolean isEnabled(String locator) {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return findElement(locator).isEnabled();
	}

	protected static Boolean isDisplayed(String locator) {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return findElement(locator).isDisplayed();
	}

	protected Boolean NoFind(String locator) {
		return NoFindElement(locator);
	}

	protected static Boolean getPageSource(String locator) {
		if (getBrowser.getDriver().getPageSource().contains(locator)) {
			return true;
		}
		return false;
	}

	protected static void printPageSource() {
		System.out.println(getBrowser.getDriver().getPageSource());
	}

	// -----------------------------Type---------------------------//

	protected static void type(String locator, String text) {
		findElement(locator).clear();
		findElement(locator).sendKeys(text);
	}

	protected static void typeDatePicker(String locator, String text) {
		findElement(locator).sendKeys(Keys.CONTROL + "a");
		findElement(locator).sendKeys(Keys.DELETE);
		findElement(locator).sendKeys(text);
	}

	protected static void typeAndEnter(String locator, String text) {
		type(locator, text);
		findElement(locator).sendKeys(Keys.ENTER);
	}

	// -----------------------------Return size---------------------------//

	protected static int returnLength(String locator) {
		return findElements(locator).size();
	}

	protected static int returnLengthXpath(String locator) {
		return findElementsXpath(locator).size();
	}

	// ------------------------Return List<WebElement>---------------------//

	protected static List<WebElement> returnElements(String locator) {
		return findElementsXpath(locator);
	}

	// ----------------------------------Select--------------------------------------//
	protected static void selectPerText(String locator, String text) {
		Select select = new Select(findElement(locator));
		select.selectByVisibleText(text);
	}

	protected static String isSelectValue(String locator) {
		Select select = new Select(findElement(locator));
		return select.getFirstSelectedOption().getAttribute("value");
	}

	protected static String isSelectInnerText(String locator) {
		Select select = new Select(findElement(locator));
		return select.getFirstSelectedOption().getAttribute("innerText");
	}

	protected static List<WebElement> selectGetOptions(String locator) {
		Select select = new Select(findElement(locator));
		return select.getOptions();
	}
	// ----------------------------------getAtribute--------------------------------------//

	protected static String getText(String locator) {
		String text = findElement(locator).getAttribute("value");
		return text;
	}

	protected static String getTextContent(String locator) {
		String text = findElement(locator).getAttribute("textContent");
		return text;
	}

	protected static String getAttributeInnerText(String locator) {
		String text = findElement(locator).getAttribute("innerText");
		return text;
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

	protected static String getAttributeElementContent(WebElement element) {
		return element.getAttribute("textContent");
	}

	protected String getAttributeDefaultValue(String locator) {
		return findElement(locator).getAttribute("defaultValue");
	}

	protected String getAttributeAriaSelected(String locator) {
		return findElement(locator).getAttribute("ariaSelected");
	}

	protected String getAttributeAriaDisabled(String locator) {
		return findElement(locator).getAttribute("ariaDisabled");
	}

	// ----------------------------------click--------------------------------------//

	protected static void click(String locator) {
		// actions = new Actions(driver);
		try {
			(findElementClickable(locator)).click();
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
			jse.executeScript("arguments[0].click();", findElementClickable(locator));
		}
	}

	protected static void clickJS(String locator) {
		JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
		jse.executeScript("arguments[0].click();", findElement(locator));
	}

	protected static void clickElementJS(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
		jse.executeScript("arguments[0].click();", element);
	}

	protected static void clickElement(WebElement element) {
		// actions = new Actions(driver);
		try {
			element.click();
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
			jse.executeScript("arguments[0].click();", element);
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
		// ewait.until(titleIs(title));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected static void doubleClick(String locator) {
		actions = new Actions(getBrowser.getDriver());
		actions.doubleClick(findElementClickable(locator)).perform();
	}

	protected static void rightClick(String locator) {
		actions = new Actions(getBrowser.getDriver());
		actions.contextClick(findElementClickable(locator)).perform();
	}

	// ----------------------------------CSS--------------------------------------//

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

	protected static String returnCSSBackground(String locator) {
		return findElement(locator).getCssValue("background-color");
	}

	// --------------------------------Alert------------------------------------//

	protected static String acceptCommonAlert() {
		String time = propF.getProperty("timeOut");
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
		Alert alert = ewait.until(ExpectedConditions.alertIsPresent());
		String text = alert.getText();
		alert.accept();
		return text;
	}

	protected static void confirmAlertOk() {
		String time = propF.getProperty("timeOut");
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
		ewait.until(ExpectedConditions.alertIsPresent());
		Alert alert = getBrowser.getDriver().switchTo().alert();
		alert.accept();
	}

	protected static void confirmAlertCancel() {
		String time = propF.getProperty("timeOut");
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
		ewait.until(ExpectedConditions.alertIsPresent());
		Alert alert = getBrowser.getDriver().switchTo().alert();
		alert.dismiss();
	}

	protected static void promptAlert(String text) {
		String time = propF.getProperty("timeOut");
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
		Alert alert = ewait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys(text);
		alert.accept();
	}

	// -------------------------------Frame-------------------------------------//

	protected static void switchToTheFrame(String locator) {
		WebElement iframe = findElement(locator);
		getBrowser.getDriver().switchTo().frame(iframe);
	}

	protected static void returnDefaultContent() {
		getBrowser.getDriver().switchTo().defaultContent();
	}

	// ------------------------------Actions------------------------------------//

	protected static void dragAndDropBy(String locator, int x, int y) {
		actions = new Actions(getBrowser.getDriver());
		actions.dragAndDropBy(findElement(locator), x, y).perform();
	}

	protected static void scrollToElement(String locator) {
		actions = new Actions(getBrowser.getDriver());
		actions.scrollToElement(findElement(locator)).pause(Duration.ofSeconds(1)).perform();
	}

	protected static void scrollToElementJS(String locator) {
		JavascriptExecutor executor = (JavascriptExecutor) getBrowser.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", findElement(locator));
	}

	protected static void moveToElement(String locator) {
		actions = new Actions(getBrowser.getDriver());
		actions.moveToElement(findElement(locator)).pause(Duration.ofSeconds(1)).perform();
	}

	protected static void moveToElements(String locator1, String locator2, String locator3) {
		actions = new Actions(getBrowser.getDriver());
		actions.moveToElement(findElement(locator1)).pause(Duration.ofSeconds(2)).moveToElement(findElement(locator2))
				.pause(Duration.ofSeconds(2)).moveToElement(findElement(locator3)).pause(Duration.ofSeconds(2))
				.perform();
	}

	protected static void clearActions() {
		((RemoteWebDriver) getBrowser.getDriver()).resetInputState();
	}

	protected static void scrollToElementJs(String locator) {
		((JavascriptExecutor) getBrowser.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				findElement(locator));
		waitVisibilityOf(locator);
	}

	// -------------------------------wait-------------------------------------//

	protected static Boolean waitProgressBar(String locator) {
		String time = propF.getProperty("timeOut");
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(Long.parseLong(time)));
		return ewait.until(ExpectedConditions.attributeToBe(findElement(locator), "aria-valuenow", "100"));
	}

	protected static void waitVisibilityOf(String locator) {
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(3));
		ewait.until(ExpectedConditions.visibilityOf(findElement(locator)));
	}

	protected static void waitElementToBeClickable(String locator) {
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(3));
		ewait.until(ExpectedConditions.elementToBeClickable(findElement(locator)));
	}
}
