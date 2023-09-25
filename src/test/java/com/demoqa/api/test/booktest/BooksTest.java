package com.demoqa.api.test.booktest;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.api.endpoints.BooksEndPoints;
import com.demoqa.api.payload.Isbn;
import com.demoqa.api.payload.User;
import com.demoqa.api.payload.UserBook;
import com.demoqa.api.payload.UserBooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

@Test(groups = "API")
public class BooksTest {
    UserBook userBook;
    Isbn isbn;
    UserBooks userBooks;
    String sIsbn = "9781593275846";
    String nIsbn = "9781593277574";
    User user;
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRhbmllbGZmZiIsInBhc3N3b3JkIjoiQXoyNTI4OEAiLCJpYXQiOjE2OTQ5MDYyODd9.LH978rx7lovND1yDWokTRaRBNHWPKaofXl_pZvJ9Xew";
    String id = "ebbdf52e-bc00-425f-83df-d7d3e857fc6e";

    @Test
    public void putBook() {
        userBook = new UserBook();
        user = new User();
        user.setUserName("danielfff");
        user.setPassword("Az25288@");
        userBook.setUserId(id);
        userBook.setIsbn(sIsbn);
        Response response = BooksEndPoints.putBook(user, userBook, token, nIsbn);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void deleteBook() {
        userBook = new UserBook();
        user = new User();
        user.setUserName("danielfff");
        user.setPassword("Az25288@");
        userBook.setUserId(id);
        userBook.setIsbn(sIsbn);
        Response response = BooksEndPoints.deleteBook(user, userBook, token);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 204);
    }

    @Test
    public void getBook() {
        Response response = BooksEndPoints.getBook(nIsbn);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void deleteBooksUser() {
        user = new User();
        user.setUserName("danielfff");
        user.setPassword("Az25288@");
        Response response = BooksEndPoints.deleteBooks(user, token, id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 204);
    }

    @Test
    public void postBooksUser() throws JsonProcessingException {
        ArrayList<Isbn> list = new ArrayList<>();
        userBooks = new UserBooks();
        user = new User();
        userBooks = new UserBooks();
        isbn = new Isbn();
        user.setUserName("danielfff");
        user.setPassword("Az25288@");
        isbn.setIsbn(sIsbn);
        list.add(isbn);
        userBooks.setUserId(id);
        userBooks.setCollectionOfIsbns(list);
        Response response = BooksEndPoints.postBooks(user, userBooks, token);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void getBooks() {
        Response response = BooksEndPoints.getBooks();
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }
}
