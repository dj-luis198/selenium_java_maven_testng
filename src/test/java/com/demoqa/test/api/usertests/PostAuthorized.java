package com.demoqa.test.api.usertests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.UserEndPoints;
import com.demoqa.baseapi.payload.User;
import com.demoqa.util.dataProvider.apiData;
import io.restassured.response.Response;

@Test(groups = "API")
public class PostAuthorized {

    @Test(dataProvider = "bookUsercol3Data", dataProviderClass = apiData.class)
    public void authUser(String userName, String pass, String token) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pass);
        Response response = UserEndPoints.authorizedUser(user, token);
        //response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }
}
