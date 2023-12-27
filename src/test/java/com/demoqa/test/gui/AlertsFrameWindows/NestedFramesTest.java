package com.demoqa.test.gui.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.NestedFramesPages;

@Test(groups = "NestedFramesTest")
public class NestedFramesTest extends BaseTest {
    NestedFramesPages nestedFramesPages;

    @BeforeMethod
    public void preconditions() {
        try {
            nestedFramesPages = new NestedFramesPages();
            nestedFramesPages.goToNestedFrames();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            nestedFramesPages = new NestedFramesPages();
            nestedFramesPages.goToNestedFrames();
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
