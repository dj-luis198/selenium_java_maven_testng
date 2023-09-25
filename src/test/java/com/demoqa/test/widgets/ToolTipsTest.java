package com.demoqa.test.widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.widgets.ToolTipsPage;

@Test(groups = "ToolTipsTest")
public class ToolTipsTest extends BaseTest {
    ToolTipsPage toolTipsPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void preconditions() {
        softAssert= new SoftAssert();
        toolTipsPage = new ToolTipsPage();
        HomePage homePage = new HomePage();
        AdsFooter adsFooter = new AdsFooter();
        homePage.goToHome();
        homePage.goToToolTipsPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validateToolTipsButton() {
        toolTipsPage.moveMouseTOButton();
        softAssert.assertTrue(toolTipsPage.verifyToolTipButton());
        toolTipsPage.moveMouseTOTextField();
        softAssert.assertTrue(toolTipsPage.verifyToolTipTextField());
        toolTipsPage.moveMouseTOContraryLink();
        softAssert.assertTrue(toolTipsPage.verifyToolTipContraryLink());
        toolTipsPage.moveMouseTO11032Link();
        softAssert.assertTrue(toolTipsPage.verifyToolTip11032Link());
        softAssert.assertAll();
    }

}
