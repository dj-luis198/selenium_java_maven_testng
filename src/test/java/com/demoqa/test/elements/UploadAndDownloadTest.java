package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.UploadAndDownloadPage;

public class UploadAndDownloadTest extends BaseTest {
    HomePage homePage;
    AdsFooter adsFooter;
    UploadAndDownloadPage uploadAndDownloadPage;

    @BeforeMethod
    public void preconditions() {
        adsFooter = new AdsFooter();
        homePage = new HomePage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
        homePage.goToHome();
        homePage.goToUploadAndDownloadPage();
        adsFooter.deleteAds();
    }

    @Test
    public void validateUploadFile() {
        uploadAndDownloadPage.uploadFile();
        Assert.assertTrue(uploadAndDownloadPage.verifyuploadedFilePath());
    }

    @Test
    public void validateDownloadFile() {
        uploadAndDownloadPage.clickDownloadButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(uploadAndDownloadPage.verifyDownloadedFilePath());
    }
}
