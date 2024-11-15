package com.demoqa.test.gui.AlertsFrameWindows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.NestedFramesPages;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "NestedFramesTest", timeOut = 30000)
public class NestedFramesTest extends BaseTest {
    private NestedFramesPages nestedFramesPages;
    private static Logger logger= LogManager.getLogger(NestedFramesTest.class);


    @BeforeMethod
    public void preconditions() {
        try {
            nestedFramesPages = new NestedFramesPages();
            nestedFramesPages.goToNestedFrames();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
        }
    }

    @Test
    public void validateNestedFrames() {
        nestedFramesPages.goToParentFrame();
        Assert.assertTrue(nestedFramesPages.verifiTextParentFrame());
        nestedFramesPages.goToChildFrame();
        Assert.assertTrue(nestedFramesPages.verifiTextChildFrame());
        nestedFramesPages.returnToContent();
        Assert.assertTrue(nestedFramesPages.verifiTextDefaultContent());
    }
}
