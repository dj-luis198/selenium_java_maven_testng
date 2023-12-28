package com.demoqa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoqa.util.GetBrowserDriver;

public class BaseClass {
	private static GetBrowserDriver getBrowser = new GetBrowserDriver();
	private static Properties prop = new Properties();
	private static String timeout;
	private static String url;
	private static WebDriverWait wait;
	public static WebDriver getDriver() {
		return getBrowser.getDriver();
	}

	protected void init(String browser) {
		Properties propF = new Properties();
		Properties propA = new Properties();
		propF = init_properties("framework");
		propA = init_properties("aplication");
		timeout = propF.getProperty("timeOut");
		url = propA.getProperty("url");
		WebDriver driver = getBrowser.getBrowserDriver(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
		driver.get(url);
	}

	protected static Properties init_properties(String name) {
		try (FileInputStream fis = new FileInputStream("./src/test/resources/config/" + name + ".properties")) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	protected static String takesScreenshot(String testName, WebDriver driver) throws IOException {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/ExtentReports/Screenshots/" + testName + ".png");
		FileUtils.copyFile(sourceFile, destFile);
		return "Screenshots/" + destFile.getName();
	}

	private static WebElement findElement(String locator) {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static boolean findElementClickableBoolean(String locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			return true;
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	private static WebElement findElementClickable(String locator) {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static boolean noFindElement(String locator) {
		try {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println(e);
			return false;
		}
	}

	private static boolean noFindElements(String locator) {
		try {
			return wait.until(ExpectedConditions
					.invisibilityOfAllElements(getBrowser.getDriver().findElements(By.xpath(locator))));
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println(e);
			return false;
		}
	}

	private static List<WebElement> findElements(String locator) {
		try {
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locator)));
		} catch (TimeoutException | NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	private static List<WebElement> findElementsXpath(String locator) {
		try {
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
		} catch (TimeoutException | NoSuchElementException e) {
			throw new Error("El locator " + locator + " no fue encontrado");
		}
	}

	// -------------------------Basic--------------------------//

	protected static void goTo() {
		getBrowser.getDriver().get(url);
	}

	protected String getBrowser() {
		WebDriver driver = getDriver();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String browserName;
		if (capabilities.getBrowserName().equals("MicrosoftEdge")) {
			browserName = "edge";
		} else {
			if (capabilities.getBrowserName().equals("chrome")) {
				browserName = "chrome";
			} else {
				browserName = "firefox";
			}
		}
		return browserName;
	}

	protected static void quit() {
		getBrowser.quitDriver();
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

	protected static Boolean isSelected(WebElement element) {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element.isSelected();
	}

	protected static Boolean isEnabled(String locator) {
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

	protected static Boolean NoFind(String locator) {
		return noFindElement(locator);
	}

	protected static Boolean NoFindElements(String locator) {
		return noFindElements(locator);
	}

	protected static boolean serchLocator(String locator) {
		return findElementClickableBoolean(locator);
	}

	protected static boolean getPageSource(String locator) {
		try {
			return wait.until(driver -> getBrowser.getDriver().getPageSource().contains(locator));
		} catch (TimeoutException e) {
			return false;
		}
	}

	protected static void printPageSource() {
		System.out.println(getBrowser.getDriver().getPageSource());
	}

	// -----------------------------Type---------------------------//

	// Limpia y Escribe texto
	protected static void type(String locator, String text) {
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	// Escribe sin limpiar
	protected static void typeSimple(String locator, String text) {
		findElement(locator).sendKeys(text);
	}

	// limpia y escribe en data picker
	protected static void typeDatePicker(String locator, String text) {
		WebElement element = findElement(locator);
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys(text);
	}

	// limpia, escribe y da a enter
	protected static void typeAndEnter(String locator, String text) {
		type(locator, text);
		findElement(locator).sendKeys(Keys.ENTER);
	}

	// -----------------------------Return size---------------------------//

	// retorna el tamanio de una lista de elementos
	protected static int returnLength(String locator) {
		return findElements(locator).size();
	}

	// retorna el tamanio de una lista de elementos (por Xpath)
	protected static int returnLengthXpath(String locator) {
		return findElementsXpath(locator).size();
	}

	// ------------------------Return List<WebElement>---------------------//

	// Retorna una lista de elementos a partir de un locator (por Xpath)
	protected static List<WebElement> returnElements(String locator) {
		return findElementsXpath(locator);
	}

	// ----------------------------------Select--------------------------------------//

	// selecciona una opcion del select por texto
	protected static void selectOptionByText(String locator, String text) {
		WebElement element = findElement(locator);
		Select select = new Select(element);
		if (!select.getFirstSelectedOption().getText().equals(text)) {
			select.selectByVisibleText(text);
		}
	}

	// devuelve el texto de la opcion seleccionada (value)
	protected static String isSelectValue(String locator) {
		Select select = new Select(findElement(locator));
		return select.getFirstSelectedOption().getAttribute("value");
	}

	// devuelve el texto de la opcion seleccionada (innerText)
	protected static String isSelectInnerText(String locator) {
		Select select = new Select(findElement(locator));
		return select.getFirstSelectedOption().getAttribute("innerText");
	}

	// devuelve todas las opciones disponibles en el select
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

	protected static String getAttributeDownload(String locator) {
		return findElement(locator).getAttribute("download");
	}

	protected static String getAttributeId(String locator) {
		return findElement(locator).getAttribute("id");
	}

	protected static String getAttributeElementNaturalH(WebElement element) {
		return element.getAttribute("naturalHeight");
	}

	protected static String getAttributeElementSrcText(WebElement element) {
		return element.getAttribute("src");
	}

	protected static String getAttributeElementHref(WebElement element) {
		return element.getAttribute("href");
	}

	protected static String getAttributeElementContent(WebElement element) {
		return element.getAttribute("textContent");
	}

	protected static String getAttributeElementOuterText(WebElement element) {
		return element.getAttribute("outerText");
	}

	protected static String getAttributeDefaultValue(String locator) {
		return findElement(locator).getAttribute("defaultValue");
	}

	protected static String getAttributeDefaultValue(WebElement element) {
		return element.getAttribute("defaultValue");
	}

	protected static String getAttributeAriaSelected(String locator) {
		return findElement(locator).getAttribute("ariaSelected");
	}

	protected static String getAttributeAriaDisabled(String locator) {
		return findElement(locator).getAttribute("ariaDisabled");
	}

	// ----------------------------------click--------------------------------------//

	protected static void click(String locator) {
		try {
			WebElement element = findElementClickable(locator);
			element.click();
		} catch (Exception e) {
			try {
				clickJS(locator);
			} catch (Exception ex) {
				throw new Error("No se pudo hacer clic en el elemento: " + locator + " : " + ex.getMessage());
			}
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
		try {
			element.click();
		} catch (Exception e) {
			try {
				clickElementJS(element);
			} catch (Exception ex) {
				throw new Error("No se pudo hacer clic en el elemento: " + element + " : " + ex.getMessage());
			}
		}
	}

	protected static String openNewTabAndSwitch(String locator) {
		String originalURL = getURL();
		String originalTab = getBrowser.getDriver().getWindowHandle();
		WebElement element = findElementClickable(locator);
		try {
			element.click();
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
			jse.executeScript("arguments[0].click()", element);
		}
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for (String windowHandle : getBrowser.getDriver().getWindowHandles()) {
			if (!originalTab.equals(windowHandle)) {
				getBrowser.getDriver().switchTo().window(windowHandle);
				break;
			}
		}
		wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(originalURL)));
		String url = getURL();
		getBrowser.getDriver().close();
		getBrowser.getDriver().switchTo().window(originalTab);
		return url;
	}

	protected static void doubleClick(String locator) {
		Actions actions = new Actions(getBrowser.getDriver());
		actions.doubleClick(findElementClickable(locator)).perform();
	}

	protected static void rightClick(String locator) {
		Actions actions = new Actions(getBrowser.getDriver());
		WebElement element = findElementClickable(locator);
		try {
			actions.contextClick(element).perform();
		} catch (Exception e) {
			try {
				JavascriptExecutor jse = (JavascriptExecutor) getBrowser.getDriver();
				String rightClickScript = "var ev = document.createEvent('MouseEvent');"
						+ "ev.initMouseEvent('contextmenu', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, 2, null);"
						+ "arguments[0].dispatchEvent(ev);";
				jse.executeScript(rightClickScript, element);
			} catch (Exception ex) {
				throw new Error("No se pudo hacer clic derecho en el elemento: " + locator + " : " + ex.getMessage());
			}
		}
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

	protected static String isAlertPresent() {
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(), Duration.ofSeconds(3));
		try {
			ewait.until(ExpectedConditions.alertIsPresent());
			Alert alert = getBrowser.getDriver().switchTo().alert();
			String text = alert.getText();
			alert.accept();
			return text;
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("algo paso no se encontro alerta");
		}
		return "no hay alerta";
	}

	protected static String acceptCommonAlert() {
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(),
				Duration.ofSeconds(Long.parseLong(timeout) * 2));
		try {
			Alert alert = ewait.until(ExpectedConditions.alertIsPresent());
			String text = alert.getText();
			alert.accept();
			return text;
		} catch (org.openqa.selenium.TimeoutException e) {
		}
		return "no hay alerta";
	}

	protected static void confirmAlertOk() {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = getBrowser.getDriver().switchTo().alert();
		alert.accept();
	}

	protected static void confirmAlertCancel() {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = getBrowser.getDriver().switchTo().alert();
		alert.dismiss();
	}

	protected static void promptAlert(String text) {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
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
		WebElement element = findElement(locator);
		new Actions(getBrowser.getDriver())
				.dragAndDropBy(element, x, y)
				.perform();
	}

	protected static void scrollToElement(String locator) {
		Actions actions = new Actions(getBrowser.getDriver());
		actions.scrollToElement(findElement(locator)).pause(Duration.ofSeconds(1)).perform();
	}

	protected static void scrollToElementJS(String locator) {
		JavascriptExecutor executor = (JavascriptExecutor) getBrowser.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", findElement(locator));
	}

	protected static void moveToElement(String locator) {
		Actions actions = new Actions(getBrowser.getDriver());
		actions.moveToElement(findElement(locator)).pause(Duration.ofSeconds(1)).perform();
	}

	protected static void moveToElements(String locator1, String locator2, String locator3) {
		Actions actions = new Actions(getBrowser.getDriver());
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
		WebDriverWait ewait = new WebDriverWait(getBrowser.getDriver(),
				Duration.ofSeconds(Long.parseLong(timeout) * 5));
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

	protected static void irA(String url) {
		getBrowser.getDriver().get(url);
	}
}
