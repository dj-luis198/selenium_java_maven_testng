package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.SelectMenuPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "SelectMenuTest", timeOut = 30000)
public class SelectMenuTest extends BaseTest {
    private SelectMenuPage selectMenuPage;

    private static Logger logger= LogManager.getLogger(SelectMenuTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            selectMenuPage = new SelectMenuPage();
            selectMenuPage.goToSelectMenu();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
        }
    }

    @Test
    public void validateSelectValue() {
        selectMenuPage.clickSelectValue();
        selectMenuPage.selectG1Opt1();
        Assert.assertTrue(selectMenuPage.verifySelectG1Opt1());
    }

    @Test
    public void validateSelectOne() {
        selectMenuPage.clickSelectOne();
        selectMenuPage.selectOpt2();
        Assert.assertTrue(selectMenuPage.verifySelectOpt2());
    }

    @Test
    public void validateOldSelectMenu() {
        selectMenuPage.selectOldMenu("Red");
        Assert.assertTrue(selectMenuPage.verifySelectText("Red"));
    }

}
