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
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

public class PostUser {
  String id;

  @Test(dataProvider = "bookUsercol2Data", dataProviderClass = apiData.class)
  public void createUser(String userName, String pass) {
    User user = new User();
    user.setUserName(userName);
    user.setPassword(pass);
    Response response = UserEndPoints.postUser(user);
    response.then().log().all();
    Assert.assertEquals(response.statusCode(), 201);
    response.then().assertThat().body(matchesJsonSchemaInClasspath("UserSchema.json"));
    Assert.assertEquals(response.body().jsonPath().get("username"), user.getUserName());
    Assert.assertEquals(response.body().jsonPath().get("books").toString(), "[]");
    this.id = response.jsonPath().get("userID");
  }

  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
    XLUtility excel = new XLUtility();
    int f = result.getMethod().getParameterInvocationCount();
    if (result.isSuccess()) {
      excel.setCellData("src/test/resources/excel/bookUserData.xlsx", f, 3, id);
    }
  }
}
