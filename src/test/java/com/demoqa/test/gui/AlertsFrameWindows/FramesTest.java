package com.demoqa.test.gui.AlertsFrameWindows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.FramesPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "FramesTest", timeOut = 30000)
public class FramesTest extends BaseTest {
    FramesPage framesPage;

    private static Logger logger = LogManager.getLogger(FramesTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            framesPage = new FramesPage();
            framesPage.goToFrames();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n" + e));
            String browser = getBrowser();
            setUp(browser);
            framesPage = new FramesPage();
            framesPage.goToFrames();
        }
    }

    @Test
    public void validateFrames1() {
        framesPage.goToFrame1();
        Assert.assertTrue(framesPage.verifiTextFrame());
        framesPage.returnToContent();
        Assert.assertTrue(framesPage.verifiTextDefaultContent());
    }

    @Test
    public void validateFrames2() {
        framesPage.goToFrame2();
        Assert.assertTrue(framesPage.verifiTextFrame());
        framesPage.returnToContent();
        Assert.assertTrue(framesPage.verifiTextDefaultContent());
    }
}
