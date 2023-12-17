package com.demoqa.test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.ProgressBarPage;

@Test(groups = "ProgressBarTest")
public class ProgressBarTest extends BaseTest {
    ProgressBarPage progressBarPage;

    @BeforeMethod
    public void preconditions() {
        try {
            progressBarPage = new ProgressBarPage();
            progressBarPage.goToProgressBar();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            progressBarPage = new ProgressBarPage();
            progressBarPage.goToProgressBar();
        }
    }

    @Test
    public void validateProgressBar() {
        progressBarPage.clickStartButton();
        Assert.assertTrue(progressBarPage.verifyProgressBar());
        Assert.assertTrue(progressBarPage.verifyResetButton());
    }
}
