package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.FramesPage;

@Test(groups = "FramesTest")
public class FramesTest extends BaseTest {
    FramesPage framesPage;

    @BeforeMethod
    public void preconditions() {
        try {
            framesPage = new FramesPage();
            framesPage.goToFrames();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
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
