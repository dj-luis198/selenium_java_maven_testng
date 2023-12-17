package com.demoqa.pages.elements;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;

public class UploadAndDownloadPage extends BaseClass {
    private String downloadPath = "files/downloadFiles";
    private File file, folder;

    private final String uploadFileInput = "//input[@id='uploadFile']";
    private final String uploadedFilePath = "//p[@id='uploadedFilePath']";
    private final String downloadButton = "//a[@id='downloadButton']";

    public void clickDownloadButton() {
        click(downloadButton);
    }

    public void uploadFile() {
        file = new File("files/img.png");
        type(uploadFileInput, file.getAbsolutePath());
    }

    public Boolean verifyuploadedFilePath() {
        if (getTextContent(uploadedFilePath).contains(file.getName())) {
            return true;
        }
        return false;
    }

    public Boolean verifyDownloadedFilePath() {
        String expectedFileName = getAttributeDownload(downloadButton);
        folder = new File(downloadPath).getAbsoluteFile();
        File[] listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches(expectedFileName)) {
                    clearFiles();
                    return true;
                }
            }
        }
        clearFiles();
        return false;
    }

    public void clearFiles(){
         File file = new File("files/downloadFiles");
		try {
			FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void goToUploadAndDownload(HomePage homePage){
        AdsFooter adsFooter = new AdsFooter();
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToUploadAndDownloadPage();
        adsFooter.deleteAds();
    }
}