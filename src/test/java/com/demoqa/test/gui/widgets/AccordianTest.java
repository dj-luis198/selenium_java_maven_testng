package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.AccordianPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "AccordianTest", timeOut = 30000)
public class AccordianTest extends BaseTest {
    private AccordianPage accordianPage;

    private static Logger logger= LogManager.getLogger(AccordianTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            accordianPage = new AccordianPage();
            accordianPage.goToAccordian();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
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
