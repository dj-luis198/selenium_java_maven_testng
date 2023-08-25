package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.AdsFooter;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.DynamicPropertiesPage;
import com.demoqa.test.BaseTest;

public class DynamicPropertiesTest extends BaseTest {
    DynamicPropertiesPage dinamicPropertiesPage;

    @BeforeMethod
    public void preconditions() {
        dinamicPropertiesPage = new DynamicPropertiesPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
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
        Assert.assertEquals(dinamicPropertiesPage.returnColor(), "rgba(255, 255, 255, 1)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(dinamicPropertiesPage.returnColor(), "rgba(220, 53, 69, 1)");
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
