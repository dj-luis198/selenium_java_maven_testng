package com.demoqa.test.widgets;

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
    public void validateMenuBar() {
        menuPage.moveToItem1();
        softAssert.assertTrue(menuPage.verifyItem1());
        menuPage.moveToItem2();
        softAssert.assertTrue(menuPage.verifyItem2());
        menuPage.moveToSubItem1();
        softAssert.assertTrue(menuPage.verifySubItem1());
        menuPage.moveToSubItem2();
        softAssert.assertTrue(menuPage.verifySubItem2());
        menuPage.moveToSubSubList();
        softAssert.assertTrue(menuPage.verifySubSubList());
        menuPage.moveToSubSubItem1();
        softAssert.assertTrue(menuPage.verifySubSubItem1());
        menuPage.moveToSubSubItem2();
        softAssert.assertTrue(menuPage.verifySubSubItem2());
        menuPage.moveToItem3();
        softAssert.assertTrue(menuPage.verifyItem3());
        softAssert.assertAll();
    }
}
