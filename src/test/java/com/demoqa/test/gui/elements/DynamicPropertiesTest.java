package com.demoqa.test.gui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.DynamicPropertiesPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "DynamicPropertiesTest", timeOut = 30000)
public class DynamicPropertiesTest extends BaseTest {
    private HomePage homePage;
    private DynamicPropertiesPage dinamicPropertiesPage;

    private static Logger logger= LogManager.getLogger(DynamicPropertiesTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            dinamicPropertiesPage = new DynamicPropertiesPage();
            dinamicPropertiesPage.goToDynamicProperties(homePage);
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
        }
    }

    @Test(description = "Valid Enable button After 5 Seg")
    public void validEnableAfter() {
        Assert.assertFalse(dinamicPropertiesPage.returnStatusEnabled());
        Assert.assertTrue(dinamicPropertiesPage.returnStatusChangeToEnabled());
    }

    @Test(description = "Valid button change color")
    public void validChangeColor() {
            Assert.assertTrue(dinamicPropertiesPage.returnColor());
    }

    @Test(description = "Valid button is visible")
    public void validButtonIsVisible() {
        Assert.assertTrue(dinamicPropertiesPage.returnIsNoVisible());
        Assert.assertTrue(dinamicPropertiesPage.returnIsVisible());
    }

}
