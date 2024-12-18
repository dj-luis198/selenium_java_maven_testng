package com.demoqa.test.gui.widgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.ProgressBarPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "ProgressBarTest", timeOut = 40000)
public class ProgressBarTest extends BaseTest {
    private ProgressBarPage progressBarPage;

    private static Logger logger= LogManager.getLogger(ProgressBarTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            progressBarPage = new ProgressBarPage();
            progressBarPage.goToProgressBar();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas\n"+e));
            Assert.fail();
        }
    }

    @Test
    public void validateProgressBar() {
        progressBarPage.clickStartButton();
        Assert.assertTrue(progressBarPage.verifyProgressBar());
        Assert.assertTrue(progressBarPage.verifyResetButton());
    }
}
