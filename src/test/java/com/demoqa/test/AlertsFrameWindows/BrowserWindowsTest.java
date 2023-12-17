package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.BrowserWindowsPage;
import com.demoqa.pages.common.HomePage;

@Test(groups = "BrowserWindowsTest")
public class BrowserWindowsTest extends BaseTest {
    BrowserWindowsPage browserWindowsPage;
    HomePage homePage;

    @BeforeMethod
    public void preconditions() {
        try {
            browserWindowsPage = new BrowserWindowsPage();
            browserWindowsPage.goToBrowserWindows(homePage);
        } catch (Exception e) {
        System.out.println("Pre condiciones fallidas, iniciando setUp "+e);
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
