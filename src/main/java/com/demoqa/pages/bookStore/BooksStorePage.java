package com.demoqa.pages.bookStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demoqa.base.BaseClass;

public class BooksStorePage extends BaseClass {
    private final String userNameLabel = "//label[@id='userName-value']";
    private final String titleBookSpan = "//div[@id='title-wrapper']//label[@id='userName-value']";
    private final String addToCollectionButton = "//div[@class='text-right fullButton']//button[@id='addNewRecordButton']";
    private final String backToBooksButton = "//div[@class='text-left fullButton']//button[@id='addNewRecordButton']";
    private final String profileButton = "//span[normalize-space()='Profile']";

    public void selectBooks(String books) {
        List<String> booksList = new ArrayList<String>(Arrays.asList(books.split(";")));
            for (String book : booksList) {
                    BaseClass.click("//a[contains(text(),\""+book+"\")]");
                    this.clickAddToYouCollection();
                    this.acceptAlert();
                    this.clickBackToBook();
            }
    }

    public void clickProfile() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BaseClass.click(profileButton);
    }

    public void clickBackToBook() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BaseClass.click(backToBooksButton);
    }

    public void acceptAlert() {
        String text= BaseClass.isAlertPresent();
        if(text.equals("Book added to your collection.")||text.equals("Book already present in the your collection!")){
        }
    }

    public void clickAddToYouCollection() {
         try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BaseClass.click(addToCollectionButton);
    }

    public String returnBookName() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return BaseClass.getTextContent(titleBookSpan);
    }

    public String returnUserName() {
        return BaseClass.getTextContent(userNameLabel);
    }

}
