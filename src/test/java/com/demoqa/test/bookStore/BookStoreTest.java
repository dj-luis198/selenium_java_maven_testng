package com.demoqa.test.bookStore;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.base.BaseTestMethod;
import com.demoqa.pages.bookStore.BooksStorePage;
import com.demoqa.pages.bookStore.LoginStorePage;
import com.demoqa.pages.bookStore.ProfileStorePage;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.util.dataProvider.bookStoreE2EData;

public class BookStoreTest extends BaseTestMethod {
    BooksStorePage booksStore;
    LoginStorePage loginStorePage;
    ProfileStorePage profileStorePage;
    AdsFooter adsFooter;

    @BeforeMethod
    public void preconditions(){
    booksStore = new BooksStorePage();
    loginStorePage = new LoginStorePage();
    profileStorePage = new ProfileStorePage();
    adsFooter = new AdsFooter();
    }

    @Test(dataProvider = "bookStoreE2E", dataProviderClass = bookStoreE2EData.class)
    public void booksStoreE2E(String userName, String pass, String books) {
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
        booksStore.selectBooks(books);
        booksStore.clickProfile();
        Assert.assertTrue(profileStorePage.verifyBooksList(books));
        profileStorePage.deleteBooks(books);
        Assert.assertTrue(profileStorePage.verifyBooksDelete(books));
        profileStorePage.clickGoToBookStoreButton();
        adsFooter.deleteAds();
        booksStore.selectBooks(books);
        booksStore.clickProfile();
        profileStorePage.clickDeleteAllBooks();
        profileStorePage.confirmSmallModal();
        profileStorePage.acceptAlertDeleteAll();
        Assert.assertTrue(profileStorePage.verifyDeleteAllBooks());
        profileStorePage.clickLogOut();
    }
}
