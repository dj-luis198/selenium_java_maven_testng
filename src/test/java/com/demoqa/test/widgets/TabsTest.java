package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.TabsPage;
import com.demoqa.test.base.BaseTest;

public class TabsTest extends BaseTest {
    TabsPage tabsPage;

    @BeforeMethod
    public void preconditions() {
        tabsPage = new TabsPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToTabsPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validateTabWhat() {
        tabsPage.clickTabWhat();
        Assert.assertTrue(tabsPage.verifyTabWhat());
    }

    @Test
    public void validateTabOrigin() {
        tabsPage.clickTabOrigin();
        Assert.assertTrue(tabsPage.verifyTabOrigin());
    }

    @Test
    public void validateTabUse() {
        tabsPage.clickTabUse();
        Assert.assertTrue(tabsPage.verifyTabUse());
    }

    @Test
    public void validateTabMore() {
        tabsPage.clickTabMore();
        Assert.assertTrue(tabsPage.verifyTabMore());
    }
}
