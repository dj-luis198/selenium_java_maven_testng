package com.demoqa.test.AlertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.AlertsFrameWindows.ModalDialogsPage;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.test.base.BaseTest;

public class ModalDialogsTest extends BaseTest{
    ModalDialogsPage modalDialogsPage;

    @BeforeMethod
    public void preconditions(){
        modalDialogsPage = new ModalDialogsPage();
        HomePage homePage= new HomePage();
        AdsFooter adsFooter=new AdsFooter();
        homePage.goToModalDialogsPage();
        adsFooter.deleteAds(); 
    }

    @Test
    public void ValidateSmallModal(){
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
    public void ValidateLargeModal(){
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
