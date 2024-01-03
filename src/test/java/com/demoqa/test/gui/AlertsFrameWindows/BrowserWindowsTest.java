package com.demoqa.test.gui.AlertsFrameWindows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.BrowserWindowsPage;
import com.demoqa.pages.common.HomePage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "BrowserWindowsTest", timeOut = 30000)
public class BrowserWindowsTest extends BaseTest {
    private BrowserWindowsPage browserWindowsPage;
    private HomePage homePage;

    private static Logger logger= LogManager.getLogger(BrowserWindowsTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            browserWindowsPage = new BrowserWindowsPage();
            browserWindowsPage.goToBrowserWindows(homePage);
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
        String browser= getBrowser();
        setUp(browser);
        browserWindowsPage = new BrowserWindowsPage();
            browserWindowsPage.goToBrowserWindows(homePage);
      }   
    }

    @Test
    public void validateOpenNewTab() {
        String url=browserWindowsPage.openAndGoTab();
        Assert.assertTrue(browserWindowsPage.verifyUrl(url));
    }

    @Test
    public void validateOpenNewWindow() {
        String url=browserWindowsPage.openAndGoWindow();
        Assert.assertTrue(browserWindowsPage.verifyUrl(url));
    }

    //@Test
    /*public void validateOpenNewWindowMessage() {
        browserWindowsPage.openAndGoWindowMessage();
    }*/

}
