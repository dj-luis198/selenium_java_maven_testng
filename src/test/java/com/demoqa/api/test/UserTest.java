package com.demoqa.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.api.endpoints.UserEndPoints;
import com.demoqa.api.payload.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.response.Response;

public class UserTest {

    User user;

    String id="27b1987a-bdf6-4bec-86b7-9cc02cdbf935";
    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRhbmllbDVmIiwicGFzc3dvcmQiOiJBejI1Mjg4QCIsImlhdCI6MTY5NDk3NzMwMH0.DBLujC5-cUxulIZmDmBbfj1K3HkEYqM-gvjP7JZdeEo";

    @Test(priority = 1)
    public void createUser() throws JsonProcessingException{
        user= new User();
        user.setUserName("daniel5f");
        user.setPassword("Az25288@");
        Response response= UserEndPoints.postUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),201);
        id=response.jsonPath().get("userID");
    }

    @Test(priority = 2)
    public void getTokenUser(){
        user= new User();
        user.setUserName("daniel5f");
        user.setPassword("Az25288@");
        Response response= UserEndPoints.tokenUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
        token=response.jsonPath().get("token");
    }

    @Test(priority = 3)
    public void authUser(){
        user= new User();
        user.setUserName("daniel5f");
        user.setPassword("Az25288@");
        Response response= UserEndPoints.authorizedUser(user,token);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 4)
    public void getUser(){
        user= new User();
        user.setUserName("daniel5f");
        user.setPassword("Az25288@");
        Response response= UserEndPoints.getUser(user,token,id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 5)
    public void deleteUser(){
         user= new User();
        user.setUserName("danielfff");
        user.setPassword("Az25288@");
        Response response= UserEndPoints.deleteUser(user,token,id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),204);
    }
    
}
