package com.demoqa.test.api.usertests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.UserEndPoints;
import com.demoqa.baseapi.payload.User;
import com.demoqa.util.XLUtility;
import com.demoqa.until.dataProvider.apiData;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

@Test(groups = "API")
public class PostToken {
    String token;

    @Test(dataProvider = "bookUsercol2Data", dataProviderClass = apiData.class)
    public void getTokenUser(String userName, String pass) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pass);
        Response response = UserEndPoints.tokenUser(user);
        //response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("TokenSchema.json"));
        this.token = response.jsonPath().get("token");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        XLUtility excel = new XLUtility();
        int f = result.getMethod().getParameterInvocationCount();
        if (result.isSuccess()) {
            excel.setCellData("src/test/resources/excel/bookUserData.xlsx", f, 2, token);
        }
    }
}
