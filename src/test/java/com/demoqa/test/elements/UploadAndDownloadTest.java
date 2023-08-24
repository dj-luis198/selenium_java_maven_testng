package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.AdsFooter;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.UploadAndDownloadPage;
import com.demoqa.test.BaseTest;

public class UploadAndDownloadTest extends BaseTest {
    HomePage homePage;
    AdsFooter adsFooter;
    UploadAndDownloadPage uploadAndDownloadPage;

    @BeforeMethod
    public void preconditions() {
        adsFooter = new AdsFooter();
        homePage = new HomePage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
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
