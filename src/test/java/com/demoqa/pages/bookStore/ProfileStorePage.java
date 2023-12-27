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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(deleteAllButton);
    }

    public Boolean verifyBooksDelete(String text) {
        List<String> booksList = booksList(text);
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
        List<String> booksList = booksList(text);
        for (String book : booksList) {
            this.deleteBook(book);
            this.confirmSmallModal();
            this.acceptAlert();
        }
    }

    public Boolean verifyBooksList(String text) {
        List<String> booksList = booksList(text);
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

    public List<String> booksList(String text) {
        return new ArrayList<String>(Arrays.asList(text.split(";")));
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
        String text= isAlertPresent();
        if(text.equals("Book added to your collection.")||text.equals("Book already present in the your collection!")){
            System.out.println(text);
        }else {
            System.out.println(text);
        }
    }

    public void confirmSmallModal() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(smalModalOkButton);
    }

    public void deleteBook(String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(goToStoreButton);
    }

    public String returnUserName() {
        return getTextContent(userNameLabel);
    }

}
