package com.demoqa.test.bookStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.bookStore.BooksStorePage;
import com.demoqa.pages.bookStore.LoginStorePage;
import com.demoqa.pages.bookStore.ProfileStorePage;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.util.dataProvider.bookStoreE2EData;

public class BookStoreTest extends BaseTest {
    BooksStorePage booksStore = new BooksStorePage();
    LoginStorePage loginStorePage = new LoginStorePage();
    ProfileStorePage profileStorePage = new ProfileStorePage();
    AdsFooter adsFooter = new AdsFooter();

    @Test(dataProvider = "bookStoreE2E",dataProviderClass = bookStoreE2EData.class)
    public void booksStoreE2E(String userName, String pass, String books) {
        List<String> booksList = new ArrayList<String>(Arrays.asList(books.split(",")));
        loginStorePage.goToLoginStore();
        adsFooter.deleteAds();
        loginStorePage.typeUserName(userName);
        loginStorePage.typeUserPass(pass);
        loginStorePage.clickLoginButton();
        adsFooter.deleteAds();
        Assert.assertEquals(profileStorePage.returnUserName(), userName);
        profileStorePage.clickGoToBookStoreButton();
        adsFooter.deleteAds();
        Assert.assertEquals(booksStore.returnUserName(), userName);
        for (String book : booksList) {
            booksStore.selectBooks(book);
        }
        booksStore.clickProfile();
        Assert.assertTrue(profileStorePage.verifyBooksList(books));
        profileStorePage.deleteBooks(books);
        Assert.assertTrue(profileStorePage.verifyBooksDelete(books));
        profileStorePage.clickGoToBookStoreButton();
        adsFooter.deleteAds();
        for (String book : booksList) {
            booksStore.selectBooks(book);
        }
        booksStore.clickProfile();
        profileStorePage.clickDeleteAllBooks();
        profileStorePage.confirmSmallModal();
        profileStorePage.acceptAlertDeleteAll();
        Assert.assertTrue(profileStorePage.verifyDeleteAllBooks());
        profileStorePage.clickLogOut();
    }
}
