package com.demoqa.pages.elements;

import java.io.File;

import com.demoqa.base.BaseClass;

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
                    return true;
                }
            }
        }
        return false;
    }
}