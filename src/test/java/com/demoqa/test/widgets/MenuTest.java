package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.test.base.BaseTest;

public class MenuTest extends BaseTest {
    MenuPage menuPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void preconditions() {
        softAssert = new SoftAssert();
        menuPage = new MenuPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToMenuPage();
        adsFooter.deleteAds();
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
        menuPage.moveToSubSubItem1();
        Assert.assertTrue(menuPage.verifySubSubItem1());
    }

    @Test
    public void validateMenuBarSubSubItem2() {
        menuPage.moveToItem2();
        menuPage.moveToSubSubList();
        menuPage.moveToSubSubItem2();
        Assert.assertTrue(menuPage.verifySubSubItem2());
    }
}
