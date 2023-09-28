package com.demoqa.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.api.endpoints.UserEndPoints;
import com.demoqa.api.payload.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import io.restassured.response.Response;

public class UserTest {

    User user;
    String id = "678dfaa4-4d4f-41ec-9e2c-2dd3ad7cfb73";
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImxvZ2luMiIsInBhc3N3b3JkIjoiQXoyNTI4OEAiLCJpYXQiOjE2OTU4NDYwNjV9.U34RrMLjy_ufAbb2HooP6loJ_PkZSbiMmP85hBx71GI";

    @Test(priority = 1)
    public void createUser() throws JsonProcessingException {
        user = new User();
        user.setUserName("login2");
        user.setPassword("Az25288@");
        Response response = UserEndPoints.postUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 201);
        id = response.jsonPath().get("userID");
    }

    @Test(priority = 2)
    public void getTokenUser() {
        user = new User();
        user.setUserName("login2");
        user.setPassword("Az25288@");

        Response response = UserEndPoints.tokenUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        token = response.jsonPath().get("token");
    }

    @Test(priority = 3)
    public void authUser() {
        user = new User();
        user.setUserName("login2");
        user.setPassword("Az25288@");

        Response response = UserEndPoints.authorizedUser(user, token);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 4)
    public void getUser() {
        user = new User();
        user.setUserName("login2");
        user.setPassword("Az25288@");

        Response response = UserEndPoints.getUser(user, token, id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas\\FUserSchema.json"));
        Assert.assertEquals(response.body().jsonPath().get("username"), user.getUserName());
        Assert.assertEquals(response.body().jsonPath().get("userId"), id);
        Assert.assertEquals(response.body().jsonPath().get("books").toString(), "[]");
    }

    @Test(priority = 5)
    public void deleteUser() {
        user = new User();
        user.setUserName("login2");
        user.setPassword("Az25288@");
        Response response = UserEndPoints.deleteUser(user, token, id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 204);
    }

}
