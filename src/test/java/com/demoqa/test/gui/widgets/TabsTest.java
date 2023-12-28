package com.demoqa.test.gui.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.TabsPage;

@Test(groups = "TabsTest", timeOut = 30000)
public class TabsTest extends BaseTest {
    TabsPage tabsPage;

    @BeforeMethod
    public void preconditions() {
        try {
            tabsPage = new TabsPage();
            tabsPage.goToTabs();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            tabsPage = new TabsPage();
            tabsPage.goToTabs();
        }
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
