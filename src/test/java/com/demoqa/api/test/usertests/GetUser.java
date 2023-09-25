package com.demoqa.api.test.usertests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.api.endpoints.UserEndPoints;
import com.demoqa.api.payload.User;
import com.demoqa.util.dataProvider.apiData;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

@Test(groups = "API")
public class GetUser {

    @Test(dataProvider = "bookUsercol4Data", dataProviderClass = apiData.class)
    public void getUser(String userName, String pass, String token, String id) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pass);
        Response response = UserEndPoints.getUser(user, token, id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("FUserSchema.json"));
        Assert.assertEquals(response.body().jsonPath().get("username"), user.getUserName());
        Assert.assertEquals(response.body().jsonPath().get("userId"), id);
        Assert.assertEquals(response.body().jsonPath().get("books").toString(), "[]");
    }
}
