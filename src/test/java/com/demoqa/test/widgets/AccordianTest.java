package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.AccordianPage;

@Test(groups = "AccordianTest")
public class AccordianTest extends BaseTest {
    AccordianPage accordianPage;

    @BeforeMethod
    public void preconditions() {
        try {
            accordianPage = new AccordianPage();
            accordianPage.goToAccordian();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            accordianPage = new AccordianPage();
            accordianPage.goToAccordian();
        }
    }

    @Test
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
