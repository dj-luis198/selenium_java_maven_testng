package com.demoqa.test.gui.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.DynamicPropertiesPage;

@Test(groups = "DynamicPropertiesTest", timeOut = 30000)
public class DynamicPropertiesTest extends BaseTest {
    HomePage homePage;
    DynamicPropertiesPage dinamicPropertiesPage;

    @BeforeMethod
    public void preconditions() {
        try {
            dinamicPropertiesPage = new DynamicPropertiesPage();
            dinamicPropertiesPage.goToDynamicProperties(homePage);
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            dinamicPropertiesPage = new DynamicPropertiesPage();
            dinamicPropertiesPage.goToDynamicProperties(homePage);
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
