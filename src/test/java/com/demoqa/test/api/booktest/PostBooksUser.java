package com.demoqa.test.api.booktest;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.BooksEndPoints;
import com.demoqa.baseapi.payload.Isbn;
import com.demoqa.baseapi.payload.User;
import com.demoqa.baseapi.payload.UserBooks;
import com.demoqa.until.dataProvider.apiData;
import io.restassured.response.Response;

@Test(groups = "API")
public class PostBooksUser {
    User user;
    UserBooks userBooks;
    Isbn isbn, isbn2;

    @Test(dataProvider = "bookUserData", dataProviderClass = apiData.class)
    public void postBooksUser(String userName, String pass, String token, String id, String book1, String book2) {
        ArrayList<Isbn> list = new ArrayList<>();
        userBooks = new UserBooks();
        user = new User();
        userBooks = new UserBooks();
        isbn = new Isbn();
        isbn2 = new Isbn();
        user.setUserName(userName);
        user.setPassword(pass);
        isbn2.setIsbn(book2);
        isbn.setIsbn(book1);
        list.add(isbn);
        list.add(isbn2);
        userBooks.setUserId(id);
        userBooks.setCollectionOfIsbns(list);
        Response response = BooksEndPoints.postBooks(user, userBooks, token);
        //response.then().log().all();
        Assert.assertEquals(response.statusCode(), 201);
    }
}
