package com.demoqa.pages.elements;

import java.io.File;

import com.demoqa.base.BaseClass;

public class UploadAndDownloadPage extends BaseClass {
    private File file;

    private final String uploadFileInput = "//input[@id='uploadFile']";
    private final String uploadedFilePath = "//p[@id='uploadedFilePath']";

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

}