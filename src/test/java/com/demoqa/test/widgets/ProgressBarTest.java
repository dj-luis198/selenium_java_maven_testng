package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.ProgressBarPage;

@Test(groups = "ProgressBarTest")
public class ProgressBarTest extends BaseTest {
    ProgressBarPage progressBarPage;

    @BeforeMethod
    public void preconditions() {
        progressBarPage = new ProgressBarPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToProgressBarPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validateProgressBar() {
        progressBarPage.clickStartButton();
        Assert.assertTrue(progressBarPage.verifyProgressBar());
        Assert.assertTrue(progressBarPage.verifyResetButton());
    }
}
