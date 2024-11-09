package com.demoqa.test.api.booktest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.BooksEndPoints;
import com.demoqa.baseapi.payload.User;
import com.demoqa.baseapi.payload.UserBook;
import com.demoqa.until.dataProvider.apiData;
import io.restassured.response.Response;

@Test(groups = "API")
public class DeleteBook {
    User user;
    UserBook userBook;

    @Test(dataProvider = "bookUsercol5Data", dataProviderClass = apiData.class)
    public void deleteBook(String userName, String pass, String token, String id, String book1) {
        userBook = new UserBook();
        user = new User();
        user.setUserName(userName);
        user.setPassword(pass);
        userBook.setUserId(id);
        userBook.setIsbn(book1);
        Response response = BooksEndPoints.deleteBook(user, userBook, token);
        //response.then().log().all();
        Assert.assertEquals(response.statusCode(), 204);
    }
}
