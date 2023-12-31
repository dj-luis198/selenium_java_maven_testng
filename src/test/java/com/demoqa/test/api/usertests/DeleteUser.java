package com.demoqa.test.api.usertests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.UserEndPoints;
import com.demoqa.baseapi.payload.User;
import com.demoqa.util.dataProvider.apiData;
import io.restassured.response.Response;

@Test(groups = "API")
public class DeleteUser {

    @Test(dataProvider = "bookUsercol4Data", dataProviderClass = apiData.class)
    public void deleteUser(String userName, String pass, String token, String id) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pass);
        Response response = UserEndPoints.deleteUser(user, token, id);
        //response.then().log().all();
        Assert.assertEquals(response.statusCode(), 204);
    }
}
