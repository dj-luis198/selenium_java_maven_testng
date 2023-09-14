package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.RadioButtonPage;
import com.demoqa.test.base.BaseTest;

public class RadioButtonTest extends BaseTest {
    AdsFooter adsFooter;
    HomePage homePage;
    RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void preconditions() {
        homePage = new HomePage();
        adsFooter = new AdsFooter();
        radioButtonPage = new RadioButtonPage();
        homePage.goToHome();
        homePage.goToRadioButtonPage();
        adsFooter.deleteAds();
    }

    @Test(description = "Validate selected Yes radio button")
    public void testSelectYes() {
        radioButtonPage.clickYes();
        Assert.assertTrue(radioButtonPage.statusYes());
        Assert.assertEquals(radioButtonPage.getTextSuccess(), "Yes");
    }

    @Test(description = "Validate selected Impressive radio button")
    public void testSelectImpressive() {
        radioButtonPage.clickImpressive();
        Assert.assertTrue(radioButtonPage.statusImpressive());
        Assert.assertEquals(radioButtonPage.getTextSuccess(), "Impressive");
    }

    @Test(description = "validate no selection radio button")
    public void testSelectNoRadio() {
        radioButtonPage.clickNoRadio();
        Assert.assertTrue(radioButtonPage.NoFindElementSuccess());
        Assert.assertFalse(radioButtonPage.statusNoRadio());
        Assert.assertTrue(radioButtonPage.NoFindElementSuccess());
    }
}
