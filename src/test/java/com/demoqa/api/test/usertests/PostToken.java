package com.demoqa.api.test.usertests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.demoqa.api.endpoints.UserEndPoints;
import com.demoqa.api.payload.User;
import com.demoqa.util.XLUtility;
import com.demoqa.util.dataProvider.apiData;

import io.restassured.response.Response;

public class PostToken {
    String token;

    @Test(dataProvider = "bookUsercol2Data",dataProviderClass = apiData.class)
    public void getTokenUser(String userName, String pass) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pass);
        Response response = UserEndPoints.tokenUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        this.token = response.jsonPath().get("token");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        XLUtility excel= new XLUtility();
        int f = result.getMethod().getParameterInvocationCount();
        if (result.isSuccess()) {
            excel.setCellData("src/test/resources/excel/bookUserData.xlsx", f, 2, token);
        }
    }

}
