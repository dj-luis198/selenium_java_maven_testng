package com.demoqa.test.bookStore;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.bookStore.BooksStorePage;
import com.demoqa.pages.bookStore.LoginStorePage;
import com.demoqa.pages.bookStore.ProfileStorePage;
import com.demoqa.pages.common.AdsFooter;
import com.demoqa.pages.common.HomePage;
import com.demoqa.util.dataProvider.bookStoreE2EData;

public class BookStoreTest extends BaseTest{
    HomePage homePage;
    BooksStorePage booksStore;
    LoginStorePage loginStorePage;
    ProfileStorePage profileStorePage;
    AdsFooter adsFooter;

    @BeforeMethod
    public void preconditions(){
        booksStore = new BooksStorePage();
        loginStorePage = new LoginStorePage();
        profileStorePage = new ProfileStorePage();
        homePage= new HomePage();
        adsFooter= new AdsFooter();
        homePage.goToLoginPage();
        adsFooter.deleteAds();
    }

    @Test(dataProvider = "bookStoreE2E", dataProviderClass = bookStoreE2EData.class)
    public void booksStoreE2ETest(String userName, String pass, String books) {
        loginStorePage.LoginUser(userName, pass);
        adsFooter.deleteAds();
        Assert.assertEquals(profileStorePage.returnUserName(), userName);
        profileStorePage.clickGoToBookStoreButton();
        adsFooter.deleteAds();
        Assert.assertEquals(booksStore.returnUserName(), userName);
        booksStore.selectBooks(books);
        booksStore.clickProfile();
        adsFooter.deleteAds();
        Assert.assertTrue(profileStorePage.verifyBooksList(books));
        profileStorePage.deleteBooks(books);
        Assert.assertTrue(profileStorePage.verifyBooksDelete(books));
        profileStorePage.clickGoToBookStoreButton();
        adsFooter.deleteAds();
        booksStore.selectBooks(books);
        booksStore.clickProfile();
        adsFooter.deleteAds();
        profileStorePage.clickDeleteAllBooks();
        profileStorePage.confirmSmallModal();
        profileStorePage.acceptAlertDeleteAll();
        Assert.assertTrue(profileStorePage.verifyDeleteAllBooks());
    }

    @AfterMethod
    public void deleteBooks(){
        booksStore.clickProfile();
        adsFooter.deleteAds();
        profileStorePage.clickDeleteAllBooks();
        profileStorePage.confirmSmallModal();
        profileStorePage.acceptAlertDeleteAll();
        profileStorePage.clickLogOut();
        homePage.goToHome();
        adsFooter.deleteAds();
    }
}
