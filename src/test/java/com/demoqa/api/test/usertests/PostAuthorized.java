package com.demoqa.api.test.usertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.api.endpoints.UserEndPoints;
import com.demoqa.api.payload.User;
import com.demoqa.util.dataProvider.apiData;

import io.restassured.response.Response;

public class PostAuthorized {

    @Test(dataProvider = "bookUsercol3Data",dataProviderClass = apiData.class)
    public void authUser(String userName, String pass, String token){
        User user= new User();
        user.setUserName(userName);
        user.setPassword(pass);
        Response response= UserEndPoints.authorizedUser(user,token);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
    }
}
