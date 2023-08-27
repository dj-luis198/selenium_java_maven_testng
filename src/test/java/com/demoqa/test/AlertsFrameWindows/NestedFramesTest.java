package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.AlertsFrameWindows.NestedFramesPages;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.test.base.BaseTest;

public class NestedFramesTest extends BaseTest {
    NestedFramesPages nestedFramesPages;

    @BeforeMethod
    public void preconditions() {
        nestedFramesPages = new NestedFramesPages();
        HomePage homepage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homepage.goToNestedFramesPage();
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
