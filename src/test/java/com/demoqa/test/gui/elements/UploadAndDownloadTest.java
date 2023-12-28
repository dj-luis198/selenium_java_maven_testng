package com.demoqa.test.gui.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.UploadAndDownloadPage;

@Test(groups = "UploadAndDownloadTest")
public class UploadAndDownloadTest extends BaseTest {
    HomePage homePage;
    UploadAndDownloadPage uploadAndDownloadPage;

    @BeforeMethod
    public void preconditions() {
        try {
            uploadAndDownloadPage = new UploadAndDownloadPage();
            uploadAndDownloadPage.goToUploadAndDownload(homePage);
        } catch (Exception e) {
            System.out.println("Pre condiciones fallidas, iniciando setUp " + e);
            String browser = getBrowser();
            setUp(browser);
            uploadAndDownloadPage = new UploadAndDownloadPage();
            uploadAndDownloadPage.goToUploadAndDownload(homePage);
        }
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
