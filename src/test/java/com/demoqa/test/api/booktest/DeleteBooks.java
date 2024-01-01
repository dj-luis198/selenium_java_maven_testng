package com.demoqa.test.api.booktest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.BooksEndPoints;
import com.demoqa.baseapi.payload.User;
import com.demoqa.util.dataProvider.apiData;
import io.restassured.response.Response;

@Test(groups = "API")
public class DeleteBooks {
    User user;

    @Test(dataProvider = "bookUsercol4Data", dataProviderClass = apiData.class)
    public void deleteBooksUser(String userName, String pass, String token, String id) {
        user = new User();
        user.setUserName(userName);
        user.setPassword(pass);
        Response response = BooksEndPoints.deleteBooks(user, token, id);
        //response.then().log().all();
        Assert.assertEquals(response.statusCode(), 204);
    }
}
