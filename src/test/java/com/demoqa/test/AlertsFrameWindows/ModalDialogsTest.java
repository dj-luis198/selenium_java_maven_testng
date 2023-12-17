package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.AlertsFrameWindows.ModalDialogsPage;

@Test(groups = "ModalDialogsTest")
public class ModalDialogsTest extends BaseTest {
    ModalDialogsPage modalDialogsPage;

    @BeforeMethod
    public void preconditions() {
        try {
            modalDialogsPage = new ModalDialogsPage();
            modalDialogsPage.goToModalDialogs();
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
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
