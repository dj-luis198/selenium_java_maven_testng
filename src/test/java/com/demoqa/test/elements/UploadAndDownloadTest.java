package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.UploadAndDownloadPage;
import com.demoqa.test.BaseTest;

public class UploadAndDownloadTest extends BaseTest {
    HomePage homePage;
    UploadAndDownloadPage uploadAndDownloadPage;

    @BeforeMethod
    public void preconditions() {
        homePage = new HomePage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
        homePage.goToUploadAndDownloadPage();
    }

    @Test
    public void validateUploadFile() {
        uploadAndDownloadPage.uploadFile();
        Assert.assertTrue(uploadAndDownloadPage.verifyuploadedFilePath());
    }

    @Test
    public void validateDownloadFile() {

    }
}
