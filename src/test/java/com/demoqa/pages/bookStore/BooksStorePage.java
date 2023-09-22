package com.demoqa.pages.bookStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demoqa.base.BaseClass;

public class BooksStorePage extends BaseClass {
    private final String userNameLabel = "//label[@id='userName-value']";
    private final String titleBookSpan = "//div[@id='title-wrapper']//label[@id='userName-value']";
    private final String addToCollectionButton = "//div[@class='text-right fullButton']//button[@id='addNewRecordButton']";
    private final String textAlertAddBook = "Book added to your collection.";
    private final String backToBooksButton = "//div[@class='text-left fullButton']//button[@id='addNewRecordButton']";
    private final String profileButton = "//span[normalize-space()='Profile']";

    public void selectBooks(String books) {
        List<String> booksList = new ArrayList<String>(Arrays.asList(books.split(",")));
            for (String book : booksList) {
                    click("//a[contains(text(),\""+book+"\")]");
                    this.clickAddToYouCollection();
                    this.acceptAlert();
                    this.clickBackToBook();
            }
    }

    public void clickProfile() {
        click(profileButton);
    }

    public void clickBackToBook() {
        click(backToBooksButton);
    }

    public Boolean acceptAlert() {
        String text = acceptCommonAlert();
        if (text.equals(textAlertAddBook)) {
            return true;
        }
        return false;
    }

    public void clickAddToYouCollection() {
        click(addToCollectionButton);
    }

    public String returnBookName() {
        return getTextContent(titleBookSpan);
    }

    public String returnUserName() {
        return getTextContent(userNameLabel);
    }

    public void goToBooksStore() {
        irA("https://demoqa.com/books");
    }

}
