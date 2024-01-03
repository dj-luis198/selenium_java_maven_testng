package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.TabsPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "TabsTest", timeOut = 30000)
public class TabsTest extends BaseTest {
    private TabsPage tabsPage;

    private static Logger logger= LogManager.getLogger(TabsTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            tabsPage = new TabsPage();
            tabsPage.goToTabs();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
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
