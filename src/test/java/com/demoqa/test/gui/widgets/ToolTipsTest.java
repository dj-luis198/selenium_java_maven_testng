package com.demoqa.test.gui.widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.ToolTipsPage;

@Test(groups = "ToolTipsTest")
public class ToolTipsTest extends BaseTest {
    ToolTipsPage toolTipsPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void preconditions() {
        try {
            softAssert = new SoftAssert();
            toolTipsPage = new ToolTipsPage();
            toolTipsPage.goToToolTips();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            softAssert = new SoftAssert();
            toolTipsPage = new ToolTipsPage();
            toolTipsPage.goToToolTips();
        }
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
