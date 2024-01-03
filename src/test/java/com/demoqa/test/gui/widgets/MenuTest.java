package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "MenuTest", timeOut = 30000)
public class MenuTest extends BaseTest {
    private MenuPage menuPage;

    private static Logger logger= LogManager.getLogger(MenuTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            menuPage = new MenuPage();
            menuPage.goToMenu();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
            String browser = getBrowser();
            setUp(browser);
            menuPage = new MenuPage();
            menuPage.goToMenu();
        }
    }

    @Test
    public void validateMenuBarItem1() {
        menuPage.moveToItem1();
        Assert.assertTrue(menuPage.verifyItem1());
    }

    @Test
    public void validateMenuBarItem3() {
        menuPage.moveToItem3();
        Assert.assertTrue(menuPage.verifyItem3());
    }

    @Test
    public void validateMenuBarItem2() {
        menuPage.moveToItem2();
        Assert.assertTrue(menuPage.verifyItem2());
    }

    @Test
    public void validateMenuBarSubItem1() {
        menuPage.moveToItem2();
        menuPage.moveToSubItem1();
        Assert.assertTrue(menuPage.verifySubItem1());
    }

    @Test
    public void validateMenuBarSubItem2() {
        menuPage.moveToItem2();
        menuPage.moveToSubItem2();
        Assert.assertTrue(menuPage.verifySubItem2());
    }

    @Test
    public void validateMenuBarSubSubList() {
        menuPage.moveToItem2();
        menuPage.moveToSubSubList();
        Assert.assertTrue(menuPage.verifySubSubList());
    }

    @Test
    public void validateMenuBarSubSubItem1() {
        menuPage.moveToItem2();
        menuPage.moveToSubSubList();
        menuPage.moveToSubItem1();
        Assert.assertTrue(menuPage.verifySubSubItem1());
    }

    @Test
    public void validateMenuBarSubSubItem2() {
        menuPage.moveToItem2();
        menuPage.moveToSubSubList();
        menuPage.moveToSubItem2();
        Assert.assertTrue(menuPage.verifySubSubItem2());
    }
}
