package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.ToolTipsPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "ToolTipsTest", timeOut = 30000)
public class ToolTipsTest extends BaseTest {
    private ToolTipsPage toolTipsPage;
    private SoftAssert softAssert;

    private static Logger logger= LogManager.getLogger(ToolTipsTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            softAssert = new SoftAssert();
            toolTipsPage = new ToolTipsPage();
            toolTipsPage.goToToolTips();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
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
