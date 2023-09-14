package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.FramesPage;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class FramesTest extends BaseTest {
    FramesPage framesPage;

    @BeforeMethod
    public void preconditions() {
        framesPage = new FramesPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToFramesPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validateFrames1() {
        framesPage.goToFrame1();
        Assert.assertTrue(framesPage.verifiTextFrame());
        framesPage.returnToContent();
        Assert.assertTrue(framesPage.verifiTextDefaultContent());
    }

    @Test
    public void validateFrames2() {
        framesPage.goToFrame2();
        Assert.assertTrue(framesPage.verifiTextFrame());
        framesPage.returnToContent();
        Assert.assertTrue(framesPage.verifiTextDefaultContent());
    }
}
