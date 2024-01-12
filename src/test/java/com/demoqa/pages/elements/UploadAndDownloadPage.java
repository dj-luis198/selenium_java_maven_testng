package com.demoqa.pages.elements;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.demoqa.base.BaseClass;
import com.demoqa.pages.common.HomePage;

public class UploadAndDownloadPage extends BaseClass {
    private File file;
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
        String downloadPath = "files/downloadFiles";
        if(waitDownloadFile(expectedFileName,downloadPath,15)){
            clearFiles();
            return true;
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
        homePage = new HomePage();
        homePage.goToHome();
        homePage.goToUploadAndDownloadPage();
    }
}