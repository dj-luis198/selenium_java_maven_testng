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
        System.out.println("comienzan precondiciones");
        booksStore = new BooksStorePage();
        loginStorePage = new LoginStorePage();
        profileStorePage = new ProfileStorePage();
        homePage= new HomePage();
        adsFooter= new AdsFooter();
        homePage.goToLoginPage();
        System.out.println("go to login page");
        adsFooter.deleteAds();
        System.out.println("delete ads");
    }

    @Test(dataProvider = "bookStoreE2E", dataProviderClass = bookStoreE2EData.class)
    public void booksStoreE2ETest(String userName, String pass, String books) {
        loginStorePage.LoginUser(userName, pass);
        System.out.println("ingrese datos de login");
        adsFooter.deleteAds();
        System.out.println("delete ads");
        Assert.assertEquals(profileStorePage.returnUserName(), userName);
        profileStorePage.clickGoToBookStoreButton();
        System.out.println("ir a book store");
        adsFooter.deleteAds();
        System.out.println("delete ads");
        Assert.assertEquals(booksStore.returnUserName(), userName);
        booksStore.selectBooks(books);
        System.out.println("selecciona los libros");
        booksStore.clickProfile();
        System.out.println("ir a profile");
        adsFooter.deleteAds();
        System.out.println("delete ads");
        Assert.assertTrue(profileStorePage.verifyBooksList(books));
        profileStorePage.deleteBooks(books);
        System.out.println("elimina libros");
        Assert.assertTrue(profileStorePage.verifyBooksDelete(books));
        profileStorePage.clickGoToBookStoreButton();
        System.out.println("ir a bookstore por segunda vez");
        adsFooter.deleteAds();
        System.out.println("delete ads");
        booksStore.selectBooks(books);
        System.out.println("select segunda camada de libros");
        booksStore.clickProfile();
        System.out.println("ir a profile");
        adsFooter.deleteAds();
        System.out.println("delete ads");
        profileStorePage.clickDeleteAllBooks();
        System.out.println("elimino todos los libros");
        profileStorePage.confirmSmallModal();
        System.out.println("confirma modal");
        profileStorePage.acceptAlertDeleteAll();
        System.out.println("asepto alerta");
        Assert.assertTrue(profileStorePage.verifyDeleteAllBooks());
    }

    @AfterMethod
    public void deleteBooks(){
        booksStore.clickProfile();
        System.out.println("after comienza... voy a profile");
        adsFooter.deleteAds();
        System.out.println("delete ads");
        profileStorePage.clickDeleteAllBooks();
        System.out.println("delete todos los libros");
        profileStorePage.confirmSmallModal();
        System.out.println("confirm modal");
        profileStorePage.acceptAlertDeleteAll();
        System.out.println("confirm alert");
        profileStorePage.clickLogOut();
        System.out.println("logout");
        homePage.goToHome();
        System.out.println("ir a home");
        System.out.println("delete ads y fin after.......");
    }
}
