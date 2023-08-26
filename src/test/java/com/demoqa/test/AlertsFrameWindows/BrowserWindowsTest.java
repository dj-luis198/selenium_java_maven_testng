package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.AlertsFrameWindows.BrowserWindowsPage;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.test.base.BaseTest;

public class BrowserWindowsTest extends BaseTest {
    BrowserWindowsPage browserWindowsPage;

    @BeforeMethod
    public void preconditions() {
        browserWindowsPage = new BrowserWindowsPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToAlertsFrameWindowsPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validateOpenNewTab() {
        browserWindowsPage.openAndGoTab();
        Assert.assertTrue(browserWindowsPage.verifyUrl());
    }

    @Test
    public void validateOpenNewWindow() {
        browserWindowsPage.openAndGoWindow();
        Assert.assertTrue(browserWindowsPage.verifyUrl());
    }

    @Test
    public void validateOpenNewWindowMessage() {
        browserWindowsPage.openAndGoWindowMessage();
    }

}
