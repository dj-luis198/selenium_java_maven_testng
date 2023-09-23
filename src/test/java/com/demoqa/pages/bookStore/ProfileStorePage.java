package com.demoqa.pages.bookStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.demoqa.base.BaseClass;

public class ProfileStorePage extends BaseClass {

    private final String userNameLabel = "//label[@id='userName-value']";
    private final String goToStoreButton = "//button[@id='gotoStore']";
    private final String booksGrid = "//span[contains(@id,'see-book-')]";
    private final String smalModalOkButton = "//button[@id='closeSmallModal-ok']";
    private final String deleteAllButton = "//div[@class='text-right button di']//button[@id='submit']";
    private final String logOut = "//button[contains(text(),'Log out')]";

    public void acceptAlertDeleteAll() {
        acceptCommonAlert();
    }

    public void clickLogOut() {
        click(logOut);
    }

    public Boolean verifyDeleteAllBooks() {
        if (NoFindElements(booksGrid)) {
            return true;
        }
        return false;
    }

    public void clickDeleteAllBooks() {
        click(deleteAllButton);
    }

    public Boolean verifyBooksDelete(String text) {
        List<String> booksList = new ArrayList<String>(Arrays.asList(text.split(",")));
        if (!NoFindElements(booksGrid)) {
            List<WebElement> books = returnElements(booksGrid);
            if (books.size() > 0) {
                for (WebElement book : books) {
                    for (String bookName : booksList) {
                        if (getAttributeElementContent(book).equals(bookName)) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    public void deleteBooks(String text) {
        List<String> booksList = new ArrayList<String>(Arrays.asList(text.split(",")));
        for (String book : booksList) {
            this.deleteBook(book);
            this.confirmSmallModal();
            this.acceptAlert();
        }
    }

    public Boolean verifyBooksList(String text) {
        List<String> booksList = new ArrayList<String>(Arrays.asList(text.split(",")));
        List<WebElement> books = returnElements(booksGrid);
        if (books.size() >= booksList.size()) {
            for (WebElement book : books) {
                for (String bookName : booksList) {
                    if (getAttributeElementContent(book).equals(bookName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean VerifyBookDelete(String text) {
        if (!NoFindElements(booksGrid)) {
            List<WebElement> books = returnElements(booksGrid);
            if (books.size() > 0) {
                for (WebElement book : books) {
                    if (getAttributeElementContent(book).equals(text)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void acceptAlert() {
        confirmAlertOk();
    }

    public void confirmSmallModal() {
        click(smalModalOkButton);
    }

    public void deleteBook(String text) {
        click("(//span[contains(@id,\"" + text
                + "\")]/parent::div/parent::div/following-sibling::div)[3]/child::div/child::span[@id='delete-record-undefined']");
    }

    public Boolean verifyBooks(String text) {
        List<WebElement> books = returnElements(booksGrid);
        if (books.size() > 0) {
            for (WebElement book : books) {
                if (getAttributeElementContent(book).equals(text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clickGoToBookStoreButton() {
        click(goToStoreButton);
    }

    public String returnUserName() {
        return getTextContent(userNameLabel);
    }

}
