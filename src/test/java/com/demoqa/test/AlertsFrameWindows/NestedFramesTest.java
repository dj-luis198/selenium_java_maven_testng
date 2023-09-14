package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.NestedFramesPages;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class NestedFramesTest extends BaseTest {
    NestedFramesPages nestedFramesPages;

    @BeforeMethod
    public void preconditions() {
        nestedFramesPages = new NestedFramesPages();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToNestedFramesPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validateNestedFrames() {
        nestedFramesPages.goToParentFrame();
        Assert.assertTrue(nestedFramesPages.verifiTextParentFrame());
        nestedFramesPages.goToChildFrame();
        Assert.assertTrue(nestedFramesPages.verifiTextChildFrame());
        nestedFramesPages.returnToContent();
        Assert.assertTrue(nestedFramesPages.verifiTextDefaultContent());
    }
}
