package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.DynamicPropertiesPage;

public class DynamicPropertiesTest extends BaseTest {
    DynamicPropertiesPage dinamicPropertiesPage;

    @BeforeMethod
    public void preconditions() {
        dinamicPropertiesPage = new DynamicPropertiesPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToDynamicPropertiesPage();
        adsFooter.deleteAds();
    }

    @Test(description = "Valid Enable button After 5 Seg")
    public void validEnableAfter() {
        Assert.assertFalse(dinamicPropertiesPage.returnStatusEnabled());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(dinamicPropertiesPage.returnStatusEnabled());
    }

    @Test(description = "Valid button change color")
    public void validChangeColor() {
        if (dinamicPropertiesPage.returnColor().equals("rgba(255, 255, 255, 1)")
                || dinamicPropertiesPage.returnColor().equals("rgb(255, 255, 255)")) {
            Assert.assertTrue(true);
        } else
            Assert.assertTrue(false);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (dinamicPropertiesPage.returnColor().equals("rgba(220, 53, 69, 1)")
                || dinamicPropertiesPage.returnColor().equals("rgb(220, 53, 69)")) {
            Assert.assertTrue(true);
        } else
            Assert.assertTrue(false);
    }

    @Test(description = "Valid button is visible")
    public void validButtonIsVisible() {
        Assert.assertTrue(dinamicPropertiesPage.returnIsNoVisible());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(dinamicPropertiesPage.returnIsVisible());
    }

}
