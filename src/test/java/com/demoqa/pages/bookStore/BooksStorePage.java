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
        System.out.println("Select books ........ paso string a array");
        List<String> booksList = new ArrayList<String>(Arrays.asList(books.split(";")));
        System.out.println("comienza for");
            for (String book : booksList) {
                    click("//a[contains(text(),\""+book+"\")]");
                    System.out.println("click a "+book);
                    this.clickAddToYouCollection();
                    System.out.println("click add colecction");
                    this.acceptAlert();
                    System.out.println("acept alert");
                    this.clickBackToBook();
                    System.out.println("click back to book");
            }
    }

    public void clickProfile() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(profileButton);
    }

    public void clickBackToBook() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(backToBooksButton);
    }

    public void acceptAlert() {
        String text= isAlertPresent();
        if(text.equals("Book added to your collection.")||text.equals("Book already present in the your collection!")){
            System.out.println(text);
        }else {
            System.out.println(text);
        }
    }

    public void clickAddToYouCollection() {
        click(addToCollectionButton);
    }

    public String returnBookName() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getTextContent(titleBookSpan);
    }

    public String returnUserName() {
        return getTextContent(userNameLabel);
    }

}
