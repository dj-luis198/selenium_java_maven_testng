package com.demoqa.test.gui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.common.HomePage;
import com.demoqa.pages.elements.UploadAndDownloadPage;
import com.demoqa.util.AnsiColorUtils;

@Test(groups = "UploadAndDownloadTest")
public class UploadAndDownloadTest extends BaseTest {
    private HomePage homePage;
    private UploadAndDownloadPage uploadAndDownloadPage;

    private static Logger logger= LogManager.getLogger(UploadAndDownloadTest.class);

    @BeforeMethod
    public void preconditions() {
        try {
            uploadAndDownloadPage = new UploadAndDownloadPage();
            uploadAndDownloadPage.goToUploadAndDownload(homePage);
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error(AnsiColorUtils.applyRed("Pre condiciones fallidas, iniciando setUp \n"+e));
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
        Assert.assertTrue(uploadAndDownloadPage.verifyDownloadedFilePath());
    }
}
