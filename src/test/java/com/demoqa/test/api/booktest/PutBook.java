package com.demoqa.test.api.booktest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.BooksEndPoints;
import com.demoqa.baseapi.payload.User;
import com.demoqa.baseapi.payload.UserBook;
import com.demoqa.util.dataProvider.apiData;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

@Test(groups = "API")
public class PutBook {
    User user;
    UserBook userBook;

    @Test(dataProvider = "bookUserData", dataProviderClass = apiData.class)
    public void putBook(String userName, String pass, String token, String id, String book1, String book2) {
        userBook = new UserBook();
        user = new User();
        user.setUserName(userName);
        user.setPassword(pass);
        userBook.setUserId(id);
        userBook.setIsbn(book1);
        Response response = BooksEndPoints.putBook(user, userBook, token, book2);
        //response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("FUserSchema.json"));
    }
}
