package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.AccordianPage;
import com.demoqa.test.base.BaseTest;

public class AccordianTest extends BaseTest {
    AccordianPage accordianPage;

    @BeforeMethod
    public void preconditions() {
        accordianPage = new AccordianPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToAccordianPage();
        adsFooter.deleteAds();
    }

    @Test(dataProviderDynamicClass = "")
    public void validateSection1Accordian() {
        Assert.assertTrue(accordianPage.isDisplayedSection1());
        Assert.assertFalse(accordianPage.isDisplayedSection2());
        Assert.assertFalse(accordianPage.isDisplayedSection3());
        accordianPage.clickSection1();
        Assert.assertFalse(accordianPage.isDisplayedSection1());
        Assert.assertFalse(accordianPage.isDisplayedSection2());
        Assert.assertFalse(accordianPage.isDisplayedSection3());
    }

    @Test
    public void validateSection2Accordian() {
        Assert.assertTrue(accordianPage.isDisplayedSection1());
        Assert.assertFalse(accordianPage.isDisplayedSection2());
        Assert.assertFalse(accordianPage.isDisplayedSection3());
        accordianPage.clickSection2();
        Assert.assertTrue(accordianPage.isDisplayedSection2());
        Assert.assertFalse(accordianPage.isDisplayedSection1());
        Assert.assertFalse(accordianPage.isDisplayedSection3());
        accordianPage.clickSection2();
        Assert.assertFalse(accordianPage.isDisplayedSection2());
        Assert.assertFalse(accordianPage.isDisplayedSection1());
        Assert.assertFalse(accordianPage.isDisplayedSection3());
    }

    @Test
    public void validateSection3Accordian() {
        Assert.assertTrue(accordianPage.isDisplayedSection1());
        Assert.assertFalse(accordianPage.isDisplayedSection2());
        Assert.assertFalse(accordianPage.isDisplayedSection3());
        accordianPage.clickSection3();
        Assert.assertTrue(accordianPage.isDisplayedSection3());
        Assert.assertFalse(accordianPage.isDisplayedSection1());
        Assert.assertFalse(accordianPage.isDisplayedSection2());
        accordianPage.clickSection3();
        Assert.assertFalse(accordianPage.isDisplayedSection2());
        Assert.assertFalse(accordianPage.isDisplayedSection1());
        Assert.assertFalse(accordianPage.isDisplayedSection3());
    }

}
