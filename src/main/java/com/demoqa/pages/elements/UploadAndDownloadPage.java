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
        System.out.println("estoy comenzando verify ");
        String expectedFileName = getAttributeDownload(downloadButton);
        System.out.println("get atributo terminado ");
        folder = new File(downloadPath).getAbsoluteFile();
        System.out.println("verify- folder "+folder);
        System.out.println("asignacion folder terminada ");
        File[] listOfFiles = folder.listFiles();
        System.out.println("lista de file terminada ");
        for (File listOfFile : listOfFiles) {
            System.out.println("estoy en comenzando for");
            if (listOfFile.isFile()) {
                System.out.println("primer if ");
                System.out.println("Nombre esperado "+expectedFileName);
                String fileName = listOfFile.getName();
                System.out.println("Nombre actual "+expectedFileName);
                if (fileName.matches(expectedFileName)){
                   System.out.println("segundo if ");
                    return true;
                }
            }
        }
        System.out.println("return false ");
        return false;
    }
}