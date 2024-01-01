package com.demoqa.test.gui.AlertsFrameWindows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.ModalDialogsPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "ModalDialogsTest", timeOut = 30000)
public class ModalDialogsTest extends BaseTest {
    ModalDialogsPage modalDialogsPage;
    
    private static Logger logger= LogManager.getLogger(ModalDialogsTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            modalDialogsPage = new ModalDialogsPage();
            modalDialogsPage.goToModalDialogs();
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
            String browser = getBrowser();
            setUp(browser);
            modalDialogsPage = new ModalDialogsPage();
            modalDialogsPage.goToModalDialogs();
        }
    }

    @Test
    public void ValidateSmallModal() {
        modalDialogsPage.clickShowSmallModalButton();
        Assert.assertTrue(modalDialogsPage.verifyFadeModalBackdropIsVisible());
        Assert.assertTrue(modalDialogsPage.verifyDialogModalIsVisible());
        Assert.assertTrue(modalDialogsPage.verifyTitleSmallModal());
        Assert.assertTrue(modalDialogsPage.verifyTextBodySmallModal());
        modalDialogsPage.closeSmallModal();
        Assert.assertFalse(modalDialogsPage.verifyFadeModalBackdropIsNoVisible());
        Assert.assertFalse(modalDialogsPage.verifyDialogModalIsNoVisible());
    }

    @Test
    public void ValidateLargeModal() {
        modalDialogsPage.clickShowLargeModalButton();
        Assert.assertTrue(modalDialogsPage.verifyFadeModalBackdropIsVisible());
        Assert.assertTrue(modalDialogsPage.verifyDialogModalIsVisible());
        Assert.assertTrue(modalDialogsPage.verifyTitleLargeModal());
        Assert.assertTrue(modalDialogsPage.verifyTextBodyLargeModal());
        modalDialogsPage.closeLargeModal();
        Assert.assertFalse(modalDialogsPage.verifyFadeModalBackdropIsNoVisible());
        Assert.assertFalse(modalDialogsPage.verifyDialogModalIsNoVisible());
    }

}
