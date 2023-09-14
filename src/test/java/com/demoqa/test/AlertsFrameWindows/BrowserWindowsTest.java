package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.BrowserWindowsPage;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class BrowserWindowsTest extends BaseTest {
    BrowserWindowsPage browserWindowsPage;

    @BeforeMethod
    public void preconditions() {
        browserWindowsPage = new BrowserWindowsPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToAlertsFrameWindowsPage();
        adsFooter.deleteAds();
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
    public void validateOpenNewWindowMessage() {
        browserWindowsPage.openAndGoWindowMessage();
    }

}
