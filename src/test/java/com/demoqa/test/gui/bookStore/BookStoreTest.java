package com.demoqa.test.gui.bookStore;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.bookStore.BooksStorePage;
import com.demoqa.pages.bookStore.LoginStorePage;
import com.demoqa.pages.bookStore.ProfileStorePage;
import com.demoqa.pages.common.HomePage;
import com.demoqa.util.dataProvider.bookStoreE2EData;

@Test(groups = "BookStoreTest")
public class BookStoreTest extends BaseTest{
    private HomePage homePage;
    private BooksStorePage booksStore;
    private LoginStorePage loginStorePage;
    private ProfileStorePage profileStorePage;

    @BeforeMethod
    public void preconditions(){
        booksStore = new BooksStorePage();
        loginStorePage = new LoginStorePage();
        profileStorePage = new ProfileStorePage();
        homePage= new HomePage();
        homePage.goToLoginPage();
    }

    @Test(dataProvider = "bookStoreE2E", dataProviderClass = bookStoreE2EData.class)
    public void booksStoreE2ETest(String userName, String pass, String books) {
        loginStorePage.LoginUser(userName, pass);
        Assert.assertEquals(profileStorePage.returnUserName(), userName);
        profileStorePage.clickGoToBookStoreButton();
        Assert.assertEquals(booksStore.returnUserName(), userName);
        booksStore.selectBooks(books);
        booksStore.clickProfile();
        Assert.assertTrue(profileStorePage.verifyBooksList(books));
        profileStorePage.deleteBooks(books);
        Assert.assertTrue(profileStorePage.verifyBooksDelete(books));
    }

    @AfterMethod
    public void deleteBooks(){
        booksStore.clickProfile();
        profileStorePage.clickDeleteAllBooks();
        profileStorePage.confirmSmallModal();
        profileStorePage.acceptAlertDeleteAll();
        //Assert.assertTrue(profileStorePage.verifyDeleteAllBooks());
        profileStorePage.clickLogOut();
        homePage.goToHome();
    }
}
